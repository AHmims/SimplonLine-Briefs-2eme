package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.model.Attribute;
import ahmims.scuffed_BAKURA.model.Image;
import ahmims.scuffed_BAKURA.repository.AttributeRepository;
import ahmims.scuffed_BAKURA.service.AttributeService;
import ahmims.scuffed_BAKURA.service.ImageService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("AttributeService")
public class AttributeServiceImpl implements AttributeService {
    //#region
    private final AttributeRepository attributeRepository;
    private final ImageService imageService;

    public AttributeServiceImpl(AttributeRepository attributeRepository, ImageService imageService) {
        this.attributeRepository = attributeRepository;
        this.imageService = imageService;
    }

    //#endregion

    @Override
    public boolean insertAttribute(String attributeName, String attributeImageId) {
        try {
            Image attributeImage = this.imageService.assertImage(new Image(attributeImageId, null));
            Attribute attribute = this.attributeRepository.save(new Attribute(attributeName, attributeImage));

            return attribute.getIdAttribute() != null;
        } catch (Exception e) {
            throw new RequestException("Error while saving attribute", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Attribute getAttributeByName(String attributeName) {
        try {
            return this.attributeRepository.findTopByLibelleAttribute(attributeName);
        } catch (Exception e) {
            throw new RequestException("Error while getting attribute", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
