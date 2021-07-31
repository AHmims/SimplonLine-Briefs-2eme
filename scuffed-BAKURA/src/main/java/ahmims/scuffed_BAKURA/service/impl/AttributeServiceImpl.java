package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.repository.AttributeRepository;
import ahmims.scuffed_BAKURA.service.AttributeService;
import org.springframework.stereotype.Service;

@Service("AttributeService")
public class AttributeServiceImpl implements AttributeService {
    //#region
    private final AttributeRepository attributeRepository;

    public AttributeServiceImpl(AttributeRepository attributeRepository) {
        this.attributeRepository = attributeRepository;
    }

    //#endregion
}
