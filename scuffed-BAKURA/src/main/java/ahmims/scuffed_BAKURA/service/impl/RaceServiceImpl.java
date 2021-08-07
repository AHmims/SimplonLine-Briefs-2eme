package ahmims.scuffed_BAKURA.service.impl;

import ahmims.scuffed_BAKURA.exception.RequestException;
import ahmims.scuffed_BAKURA.model.Image;
import ahmims.scuffed_BAKURA.model.Race;
import ahmims.scuffed_BAKURA.repository.RaceRepository;
import ahmims.scuffed_BAKURA.service.ImageService;
import ahmims.scuffed_BAKURA.service.RaceService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service("RaceService")
public class RaceServiceImpl implements RaceService {
    //#region
    private final RaceRepository raceRepository;
    private final ImageService imageService;

    public RaceServiceImpl(RaceRepository raceRepository, ImageService imageService) {
        this.raceRepository = raceRepository;
        this.imageService = imageService;
    }

    //#endregion

    @Override
    public boolean insertRace(String raceName, String raceImageId) {
        try {
            Image raceImage = this.imageService.assertImage(new Image(raceImageId, null));
            Race race = this.raceRepository.save(new Race(raceName, raceImage));

            return race.getIdRace() != null;
        } catch (Exception e) {
            throw new RequestException("Error while saving race", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public Race getRaceByName(String raceName) {
        try {
            return this.raceRepository.findTopByLibelleRace(raceName);
        } catch (Exception e) {
            throw new RequestException("Error while getting race", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
