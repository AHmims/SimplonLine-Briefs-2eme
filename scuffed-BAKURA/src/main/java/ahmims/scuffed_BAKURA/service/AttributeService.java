package ahmims.scuffed_BAKURA.service;

import org.springframework.stereotype.Repository;

@Repository
public interface AttributeService {
    public boolean insertAttribute(String attributeName, String attributeImageId);
}
