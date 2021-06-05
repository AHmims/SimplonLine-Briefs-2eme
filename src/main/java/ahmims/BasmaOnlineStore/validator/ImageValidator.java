package ahmims.BasmaOnlineStore.validator;

import org.springframework.stereotype.Repository;

@Repository
public interface ImageValidator {
    boolean isValidImageLink(String url);
}
