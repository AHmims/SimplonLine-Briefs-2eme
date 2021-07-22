package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.repository.ImageRepository;
import ahmims.scuffed_BAKURA.service.ImageService;
import ahmims.scuffed_BAKURA.validator.ImageValidator;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ahmims.scuffed_BAKURA.model.Image;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("ImageService")
public class ImageServiceImpl implements ImageService {
    //#region
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
        if (urls != null && urls.size() >= 4 && urls.size() <= 8) {
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
        } else throw new RequestException("The number of images required is between 4 & 8", HttpStatus.BAD_REQUEST);
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
            Optional<Image> imgDlt = imageRepository.findById(image.getIdImage());
            return imgDlt.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
    //
    //
}
