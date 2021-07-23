package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.model.Image;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;

@Repository
public interface ImageService {
    Image insertSingle(String url);

    List<Image> insertMultiple(List<String> urls);

    //List<Image> insertMultiple(Produit produit, List<String> urls);

    boolean delete(Image image);

    List<Image> uploadMultiple(MultipartFile[] images);

    File getLocalImage(String imageName);
}
