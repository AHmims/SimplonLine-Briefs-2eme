package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.CategorieDao;
import ahmims.BasmaOnlineStore.dao.ProduitDao;
import ahmims.BasmaOnlineStore.dto.ProduitFormData;
import ahmims.BasmaOnlineStore.exception.RequestException;
import ahmims.BasmaOnlineStore.model.Categorie;
import ahmims.BasmaOnlineStore.model.Image;
import ahmims.BasmaOnlineStore.model.Produit;
import ahmims.BasmaOnlineStore.repository.ProduitRepository;
import ahmims.BasmaOnlineStore.service.ImageService;
import ahmims.BasmaOnlineStore.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("ProduitService")
public class ProduitServiceImpl implements ProduitService {
    //#region
    private final ProduitDao produitDao;
    private final CategorieDao categorieDao;
    private final ImageService imageService;
    private final ProduitRepository produitRepository;

    public ProduitServiceImpl(ProduitDao produitDao, CategorieDao categorieDao, ImageService imageService, ProduitRepository produitRepository) {
        this.produitDao = produitDao;
        this.categorieDao = categorieDao;
        this.imageService = imageService;
        this.produitRepository = produitRepository;
    }

    //#endregion
    @Override
    public Produit insert(Produit produit) {
        if (produit != null && produit.isInsertable()) {
            Produit existingProduit = produitRepository.findTopByLibelleProduit(produit.getLibelleProduit());
            if (existingProduit == null || (existingProduit.getIdProduit() == null && existingProduit.getIdProduit().length() == 0)) {
                produit = produitDao.save(produit);
                return produit.getIdProduit() != null ? produit : null;
            } else
                throw new RequestException("There is a product that already exists with the same name", HttpStatus.BAD_REQUEST);
        } else
            throw new RequestException("Some of the product's main data is missing", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    public Produit insert(ProduitFormData pfd) {
        if (pfd != null && pfd.isInsertable()) {
            Optional<Categorie> categorie = categorieDao.findById(pfd.getCategorie());
            if (categorie.isPresent()) {
                List<Image> images = imageService.insertMultiple(pfd.getImages());
                if (images != null) {
                    return insert(new Produit(pfd.getLibelle(), pfd.getDescription(), pfd.getPrix(), categorie.get(), images));
                }
                throw new RequestException("Error while saving product, try again later", HttpStatus.INTERNAL_SERVER_ERROR);
            } else throw new RequestException("Categorie doesn't exist", HttpStatus.NOT_FOUND);
        } else
            throw new RequestException("Some of the product's main data is missing or malformatted", HttpStatus.UNPROCESSABLE_ENTITY);
    }
}
