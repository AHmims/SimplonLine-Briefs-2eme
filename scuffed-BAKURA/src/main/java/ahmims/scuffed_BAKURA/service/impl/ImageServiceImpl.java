package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.model.Image;
import ahmims.scuffed_BAKURA.repository.ImageRepository;
import ahmims.scuffed_BAKURA.service.ImageService;
import ahmims.scuffed_BAKURA.validator.ImageValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Service("ImageService")
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    private final ImageValidator imageValidator;
    //#region
    @Value("${images.upload-dir}")
    private String uploadDir;
    @Value("${images.serve-endpoint}")
    private String serveEndpoint;

    public ImageServiceImpl(ImageRepository imageRepository, ImageValidator imageValidator) {
        this.imageRepository = imageRepository;
        this.imageValidator = imageValidator;
    }
    //#endregion

    @Override
    public Image insertSingle(String url) {
        try (InputStream input = new URL(url).openStream()) {
            String originalFileName = url.substring(url.lastIndexOf("/"));
            String newFileName = UUID.randomUUID().toString().replace("-", "");
            String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
            String fileName = newFileName.concat(extension);

            Files.createDirectories(Paths.get(this.uploadDir));
            //
            File uploads = new File(this.uploadDir);
            File file = new File(this.uploadDir, fileName);

            Files.copy(input, file.toPath());

            if (!imageValidator.isValidLocalImageLink(toAbsolutePath(String.format("%s/%s", this.uploadDir, fileName)))) {
                deleteSingleImage(fileName);
                return null;
            }

            Image image = imageRepository.save(new Image(String.format("%s/%s", this.serveEndpoint, fileName)));

            if (image.getIdImage() == null) {
                deleteSingleImage(fileName);

                throw new RequestException(String.format("Error while uploading images, error at: %s", fileName), HttpStatus.BAD_REQUEST);
            } else {
                return image;
            }
        } catch (IOException e) {
            throw new RequestException("Invalid image link", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public List<Image> insertMultiple(List<String> urls) {
        if (urls != null) {
            for (String url : urls) {
                if (!imageValidator.isValidImageLink(url))
                    throw new RequestException("Invalid image link", HttpStatus.UNPROCESSABLE_ENTITY);
            }
            //
            List<Image> images = new ArrayList<>();
            for (String url : urls) {
                Image image = imageRepository.save(new Image(url));
                images.add(image.getIdImage() != null ? image : null);
            }
            //
            return images.contains(null) ? null : images;
        } else throw new RequestException("Please provide valid images", HttpStatus.BAD_REQUEST);
    }

    @Override
    public boolean deleteImages(Image[] images) {
        for (Image image : images) {
            if (!this.delete(image)) {
                throw new RequestException("Error while deleting image", HttpStatus.UNPROCESSABLE_ENTITY);
            }
        }

        return true;
    }

    /*@Override
    public List<Image> insertMultiple(Produit produit, List<String> urls) {
        if (urls != null && urls.size() >= 4 && urls.size() <= 8) {
            for (String url : urls) {
                if (!imageValidator.isValidImageLink(url))
                    throw new RequestException("Invalid image link", HttpStatus.UNPROCESSABLE_ENTITY);
            }
            //
            List<Image> images = new ArrayList<>();
            for (String url : urls) {
                Image image = imageDao.save(new Image(url, produit));
                images.add(image.getIdImage() != null ? image : null);
            }
            //
            return images.contains(null) ? null : images;
        } else throw new RequestException("The number of images required is between 4 & 8", HttpStatus.BAD_REQUEST);
    }*/


    @Override
    public boolean delete(Image image) {
        try {
            imageRepository.delete(image);

            String fileName = image.getLienImage();
            if (fileName.contains(this.serveEndpoint)) {
                deleteSingleImage(fileName.substring(fileName.lastIndexOf('/') + 1));
            }

            Optional<Image> imgDlt = imageRepository.findById(image.getIdImage());
            return imgDlt.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<Image> uploadMultiple(MultipartFile[] images) {
        ArrayList<Image> savedImages = new ArrayList<>();

        Arrays.stream(images).forEach(imageFile -> {
            if (!imageFile.isEmpty()) {
                String imageName = uploadSingle(imageFile);
                if (imageName == null) {
                    throw new RequestException("Error while saving image", HttpStatus.INTERNAL_SERVER_ERROR);
                }

                Image image = imageRepository.save(new Image(String.format("%s/%s", this.serveEndpoint, imageName)));

                if (image.getIdImage() == null) {
                    deleteSingleImage(imageName);
                    savedImages.forEach(toDeleteImage -> {
                        deleteSingleImage(toDeleteImage.getLienImage().substring(toDeleteImage.getLienImage().lastIndexOf('/') + 1));
                    });

                    throw new RequestException(String.format("Error while uploading images, error at: %s", imageFile.getOriginalFilename()), HttpStatus.BAD_REQUEST);
                } else {
                    savedImages.add(image);
                }
            }
        });

        return savedImages;
    }

    @Override
    public File getLocalImage(String imageName) {
        try {
            return new File(toAbsolutePath(String.format("%s/%s", uploadDir, imageName)));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Image assertImage(Image image) {
        try {
            if (image != null) {
                Optional<Image> optionalImage = imageRepository.findById(image.getIdImage());
                if (optionalImage.isPresent()) {
                    return optionalImage.get();
                }
            }
        } catch (Exception ignored) {
        }

        return null;
    }

    @Override
    public List<Image> getImagesById(List<String> imagesIds) {
        try {
            List<Image> images = new ArrayList<>();

            for (String imageId : imagesIds) {
                Optional<Image> optionalImage = this.imageRepository.findById(imageId);
                optionalImage.ifPresent(images::add);
            }

            return images;
        } catch (Exception e) {
            throw new RequestException("Error while getting avatars", HttpStatus.BAD_REQUEST);
        }
    }


    //
    //

    private String uploadSingle(MultipartFile image) {
        String originalFileName = Optional.ofNullable(image.getOriginalFilename()).orElse("");
        String newFileName = UUID.randomUUID().toString().replace("-", "");
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String fileName = newFileName.concat(extension);

        try {
            InputStream fileContent = image.getInputStream();

            Files.createDirectories(Paths.get(this.uploadDir));
            //
            File uploads = new File(this.uploadDir);
            File file = new File(this.uploadDir, fileName);
            try (InputStream input = fileContent) {
                Files.copy(input, file.toPath());
            }

            if (!imageValidator.isValidLocalImageLink(toAbsolutePath(String.format("%s/%s", this.uploadDir, fileName)))) {
                deleteSingleImage(fileName);
                return null;
            }

            return fileName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean deleteSingleImage(String imageName) {
        try {
            Path path = Paths.get(String.format("%s/%s", this.uploadDir, imageName));
            Files.delete(path);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private String toAbsolutePath(String relativePath) {
        return FileSystems.getDefault().getPath(relativePath).normalize().toAbsolutePath().toString();
    }
}
