package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository("AttributeRepository")
public interface AttributeRepository extends JpaRepository<Attribute, String> {
}
