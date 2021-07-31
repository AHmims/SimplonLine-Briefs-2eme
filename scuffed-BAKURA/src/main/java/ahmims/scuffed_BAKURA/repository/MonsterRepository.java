package ahmims.scuffed_BAKURA.repository;

import ahmims.scuffed_BAKURA.model.Monster;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository("MonsterRepository")
public interface MonsterRepository extends JpaRepository<Monster, String> {
}
