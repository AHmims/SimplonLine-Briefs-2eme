package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository("ImageRepository")
public interface ImageRepository extends JpaRepository<Image, String> {
}
