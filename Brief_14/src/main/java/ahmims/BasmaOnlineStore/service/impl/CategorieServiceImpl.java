package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.CategorieDao;
import ahmims.BasmaOnlineStore.dto.CategorieFormData;
import ahmims.BasmaOnlineStore.exception.RequestException;
import ahmims.BasmaOnlineStore.model.Categorie;
import ahmims.BasmaOnlineStore.model.Image;
import ahmims.BasmaOnlineStore.repository.CategorieRepository;
import ahmims.BasmaOnlineStore.service.CategorieService;
import ahmims.BasmaOnlineStore.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("CategorieService")
public class CategorieServiceImpl implements CategorieService {
    //#region
    private final CategorieRepository categorieRepository;
    private final ImageService imageService;
    private final CategorieDao categorieDao;

    public CategorieServiceImpl(CategorieRepository categorieRepository, ImageService imageService, CategorieDao categorieDao) {
        this.categorieRepository = categorieRepository;
        this.imageService = imageService;
        this.categorieDao = categorieDao;
    }

    //#endregion
    @Override
    public Categorie insert(Categorie categorie) {
        if (categorie == null) return null;
        //
        if (categorie.getLibelleCategorie() == null || categorie.getLibelleCategorie().length() == 0)
            throw new RequestException("Categorie name is invalide", HttpStatus.UNPROCESSABLE_ENTITY);
        //
        Categorie existingCategorie = categorieRepository.findTopByLibelleCategorie(categorie.getLibelleCategorie());
        if (existingCategorie == null) {
            if (categorie.getImage() != null) {
                Image image = imageService.insertSingle(categorie.getImage().getLienImage());
                if (image != null) {
                    categorie = categorieDao.save(categorie);
                    if (categorie.getIdCategorie() != null) return categorie;
                }
                throw new RequestException("Server error while inserting categorie, try again later", HttpStatus.INTERNAL_SERVER_ERROR);
            } else throw new RequestException("No image provided", HttpStatus.BAD_REQUEST);
        } else throw new RequestException("Categorie name already exists", HttpStatus.BAD_REQUEST);
    }

    @Override
    public Categorie insert(CategorieFormData categorieFormData) {
        return null;
    }

    @Override
    public Categorie edit(Categorie categorie) {
        return null;
    }
}
