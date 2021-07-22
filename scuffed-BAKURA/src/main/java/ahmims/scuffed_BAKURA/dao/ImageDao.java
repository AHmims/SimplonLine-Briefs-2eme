package ahmims.scuffed_BAKURA.dao;

import ahmims.scuffed_BAKURA.model.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("ImageDao")
public interface ImageDao extends CrudRepository<Image, String> {
}
