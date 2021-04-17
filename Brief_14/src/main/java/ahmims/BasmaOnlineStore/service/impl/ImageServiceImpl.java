package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.ImageDao;
import ahmims.BasmaOnlineStore.exception.RequestException;
import ahmims.BasmaOnlineStore.model.Categorie;
import ahmims.BasmaOnlineStore.model.Image;
import ahmims.BasmaOnlineStore.model.Produit;
import ahmims.BasmaOnlineStore.service.ImageService;
import ahmims.BasmaOnlineStore.validator.ImageValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("ImageService")
public class ImageServiceImpl implements ImageService {
    //#region
    private final ImageDao imageDao;
    private final ImageValidator imageValidator;

    public ImageServiceImpl(ImageDao imageDao, ImageValidator imageValidator) {
        this.imageDao = imageDao;
        this.imageValidator = imageValidator;
    }
    //#endregion

    @Override
    public Image insertSingle(String url) {
        boolean isValid = imageValidator.isValidImageLink(url);
        if (!isValid)
            throw new RequestException("Invalid image link", HttpStatus.UNPROCESSABLE_ENTITY);
        //
        Image image = imageDao.save(new Image(url));
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
                Image image = imageDao.save(new Image(url));
                images.add(image.getIdImage() != null ? image : null);
            }
            //
            return images.contains(null) ? null : images;
        } else throw new RequestException("The number of images required is between 4 & 8", HttpStatus.BAD_REQUEST);
    }

    @Override
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
    }

    @Override
    public boolean delete(Image image) {
        try {
            imageDao.delete(image);
            Optional<Image> imgDlt = imageDao.findById(image.getIdImage());
            return imgDlt.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }
    //
    //
}
