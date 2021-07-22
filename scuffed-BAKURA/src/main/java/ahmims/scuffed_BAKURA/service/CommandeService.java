package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.dto.CommandeMin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeService {
    List<CommandeMin> getByUser(String idUser);
}
