package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.model.Categorie;
import ahmims.BasmaOnlineStore.model.Image;
import ahmims.BasmaOnlineStore.model.Produit;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageService {
    Image insertSingle(String url);

    List<Image> insertMultiple(List<String> urls);

    List<Image> insertMultiple(Produit produit, List<String> urls);

    boolean delete(Image image);
}
