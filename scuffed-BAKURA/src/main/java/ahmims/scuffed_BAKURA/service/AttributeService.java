package ahmims.scuffed_BAKURA.service;

import ahmims.scuffed_BAKURA.model.Attribute;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeService {
    boolean insertAttribute(String attributeName, String attributeImageId);

    Attribute getAttributeByName(String attributeName);
}
