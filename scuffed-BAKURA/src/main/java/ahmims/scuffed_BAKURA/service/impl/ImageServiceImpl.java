package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.repository.ImageRepository;
import ahmims.scuffed_BAKURA.service.ImageService;
import ahmims.scuffed_BAKURA.validator.ImageValidator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ahmims.scuffed_BAKURA.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

@Service("ImageService")
public class ImageServiceImpl implements ImageService {
    //#region
    @Value("${images.upload-dir}")
    private String uploadDir;
    @Value("${images.serve-endpoint}")
    private String serveEndpoint;
    private final ImageRepository imageRepository;
    private final ImageValidator imageValidator;

    public ImageServiceImpl(ImageRepository imageRepository, ImageValidator imageValidator) {
        this.imageRepository = imageRepository;
        this.imageValidator = imageValidator;
    }
    //#endregion

    @Override
    public Image insertSingle(String url) {
        boolean isValid = imageValidator.isValidImageLink(url);
        if (!isValid)
            throw new RequestException("Invalid image link", HttpStatus.UNPROCESSABLE_ENTITY);
        //
        Image image = imageRepository.save(new Image(url));
        return image.getIdImage() != null ? image : null;
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
            if (fileName.contains(serveEndpoint)) {
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

                Image image = imageRepository.save(new Image(String.format("%s/%s", serveEndpoint, imageName)));

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


    //
    //

    private String uploadSingle(MultipartFile image) {
        String originalFileName = Optional.ofNullable(image.getOriginalFilename()).orElse("");
        String newFileName = UUID.randomUUID().toString().replace("-", "");
        String extension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String fileName = newFileName.concat(extension);

        try {
            InputStream fileContent = image.getInputStream();

            Files.createDirectories(Paths.get(uploadDir));
            //
            File uploads = new File(uploadDir);
            File file = new File(uploadDir, fileName);
            try (InputStream input = fileContent) {
                Files.copy(input, file.toPath());
            }

            if (!imageValidator.isValidLocalImageLink(toAbsolutePath(String.format("%s/%s", uploadDir, fileName)))) {
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
            Path path = Paths.get(String.format("%s/%s", uploadDir, imageName));
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
