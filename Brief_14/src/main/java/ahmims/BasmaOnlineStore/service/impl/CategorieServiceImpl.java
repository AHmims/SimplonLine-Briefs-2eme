package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.CategorieDao;
import ahmims.BasmaOnlineStore.dto.CategorieFormData;
import ahmims.BasmaOnlineStore.dto.CategorieMin;
import ahmims.BasmaOnlineStore.dto.DeleteRes;
import ahmims.BasmaOnlineStore.dto.ImageMin;
import ahmims.BasmaOnlineStore.exception.RequestException;
import ahmims.BasmaOnlineStore.model.Categorie;
import ahmims.BasmaOnlineStore.model.Image;
import ahmims.BasmaOnlineStore.repository.CategorieRepository;
import ahmims.BasmaOnlineStore.service.CategorieService;
import ahmims.BasmaOnlineStore.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
    public CategorieMin insert(Categorie categorie) {
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
                    categorie.setImage(image);
                    categorie = categorieDao.save(categorie);
                    if (categorie.getIdCategorie() != null) return new CategorieMin(categorie);
                }
                throw new RequestException("Server error while inserting categorie, try again later", HttpStatus.INTERNAL_SERVER_ERROR);
            } else throw new RequestException("No image provided", HttpStatus.BAD_REQUEST);
        } else throw new RequestException("Categorie name already exists", HttpStatus.BAD_REQUEST);
    }

    @Override
    public CategorieMin insert(CategorieFormData categorieFormData) {
        return insert(new Categorie(categorieFormData.getLibelle(), new Image(categorieFormData.getImage())));
    }

    @Override
    public CategorieMin edit(CategorieFormData categorieFormData) {
        if (categorieFormData == null) return null;
        //
        if (categorieFormData.getId() == null || categorieFormData.getId().length() == 0)
            throw new RequestException("Categorie Id isn't valid", HttpStatus.UNPROCESSABLE_ENTITY);
        else {
            Optional<Categorie> optionalCategorie = categorieDao.findById(categorieFormData.getId());
            if (optionalCategorie.isPresent()) {
                Categorie categorie = optionalCategorie.get();
                //Categorie originalCategorie = categorie;
                //
                if (categorieFormData.getLibelle() != null && categorieFormData.getLibelle().length() > 0) {
                    Categorie existingCategorie = categorieRepository.findTopByLibelleCategorie(categorieFormData.getLibelle());
                    if (existingCategorie == null) categorie.setLibelleCategorie(categorieFormData.getLibelle());
                    else throw new RequestException("Categorie name already exists", HttpStatus.BAD_REQUEST);
                }
                //
                if (categorieFormData.getImage() != null && categorieFormData.getImage().length() > 0) {
                    Image image = imageService.insertSingle(categorieFormData.getImage());
                    if (image != null) {
                        Image previousImage = categorie.getImage();
                        categorie.setImage(null);
                        categorieDao.save(categorie);
                        categorie.setImage(image);
                        boolean resDlt = imageService.delete(previousImage);
                        if (!resDlt)
                            throw new RequestException("Server error while erasing previous image, try again later", HttpStatus.INTERNAL_SERVER_ERROR);
                    } else
                        throw new RequestException("Server error while saving image, try again later", HttpStatus.BAD_REQUEST);
                }
                //
                //if (!originalCategorie.getImage().equals(categorie.getImage()) || !originalCategorie.getLibelleCategorie().equals(categorie.getLibelleCategorie())) {
                return new CategorieMin(categorieDao.save(categorie));
                //}
            } else throw new RequestException("No categorie exists with the given id", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public DeleteRes delete(String idCategorie) {
        if (idCategorie != null && idCategorie.length() > 0) {
            Optional<Categorie> categorie = categorieDao.findById(idCategorie);
            //categorie.ifPresent(categorieDao::delete);
            if (categorie.isPresent()) {
                categorieDao.delete(categorie.get());
                if ((categorieDao.findById(idCategorie)).isPresent())
                    throw new RequestException("Categorie not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
                return new DeleteRes(1, categorie.get().getIdCategorie(), Categorie.class.getSimpleName());
            }
        }
        throw new RequestException("Please provide a valid Categorie Id", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    public List<CategorieMin> getAll() {
        List<CategorieMin> categories = new ArrayList<>();
        for (Categorie categorie : categorieDao.findAll()) {
            categories.add(new CategorieMin(categorie.getLibelleCategorie(), new ImageMin(categorie.getImage().getLienImage())));
        }
        //
        return categories.size() > 0 ? categories : null;
    }

    @Override
    public CategorieMin get(String idCategorie) {
        if (idCategorie != null && idCategorie.length() > 0) {
            Optional<Categorie> optionalCategorie = categorieDao.findById(idCategorie);
            if (optionalCategorie.isPresent()) {
                Categorie categorie = optionalCategorie.get();
                return new CategorieMin(categorie.getLibelleCategorie(), new ImageMin(categorie.getImage().getLienImage()));
            } else throw new RequestException("No categorie exists with the given id", HttpStatus.BAD_REQUEST);
        }
        throw new RequestException("Please provide a valid Categorie Id", HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
