package ahmims.BasmaOnlineStore.service;

import ahmims.BasmaOnlineStore.model.Image;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageService {
    Image insertSingle(String url);
    List<Image> insertMultiple(List<String> urls);
}
