package ahmims.scuffed_BAKURA.validator;

import org.springframework.stereotype.Repository;

@Repository
public interface ImageValidator {
    boolean isValidImageLink(String url);

    boolean isValidLocalImageLink(String path);
}
