package ahmims.BasmaOnlineStore.dao;

import ahmims.BasmaOnlineStore.model.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ImageDao")
public interface ImageDao extends CrudRepository<Image, String> {
}
