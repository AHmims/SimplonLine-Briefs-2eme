package ahmims.BasmaOnlineStore.service.impl;

import ahmims.BasmaOnlineStore.dao.CategorieDao;
import ahmims.BasmaOnlineStore.dao.ProduitDao;
import ahmims.BasmaOnlineStore.dto.*;
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

import java.util.ArrayList;
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
    public ProduitMin insert(Produit produit) {
        if (produit != null && produit.isInsertable()) {
            Produit existingProduit = produitRepository.findTopByLibelleProduit(produit.getLibelleProduit());
            if (existingProduit == null || (existingProduit.getIdProduit() == null && existingProduit.getIdProduit().length() == 0)) {
                produit = produitDao.save(produit);
                return produit.getIdProduit() != null ? new ProduitMin(produit) : null;
            } else
                throw new RequestException("There is a product that already exists with the same name", HttpStatus.BAD_REQUEST);
        } else
            throw new RequestException("Some of the product's main data is missing", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    public ProduitMin insert(ProduitFormData pfd) {
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

    @Override
    public ProduitMin edit(ProduitFormData produitFormData) {
        if (produitFormData == null) return null;
        //
        if (produitFormData.getId() == null || produitFormData.getId().length() == 0)
            throw new RequestException("Produit Id isn't valid", HttpStatus.UNPROCESSABLE_ENTITY);
        else {
            Optional<Produit> optionalProduit = produitDao.findById(produitFormData.getId());
            if (optionalProduit.isPresent()) {
                Produit produit = optionalProduit.get();
                //
                if (produitFormData.getLibelle() != null && produitFormData.getLibelle().length() > 0) {
                    Produit existingProduit = produitRepository.findTopByLibelleProduit(produitFormData.getLibelle());
                    if (existingProduit == null) produit.setLibelleProduit(produitFormData.getLibelle());
                    else throw new RequestException("Produit name already exists", HttpStatus.BAD_REQUEST);
                }
                //
                if (produitFormData.getDescription() != null && produitFormData.getDescription().length() > 0) {
                    produit.setDescriptionProduit(produitFormData.getDescription());
                }
                //
                if (produitFormData.getPrix() > 0) {
                    produit.setPrixProduit(produitFormData.getPrix());
                }
                //
                if (produitFormData.getCategorie() != null && produitFormData.getCategorie().length() > 0) {
                    Optional<Categorie> optionalCategorie = categorieDao.findById(produitFormData.getCategorie());
                    if (optionalCategorie.isPresent()) {
                        produit.setCategorie(optionalCategorie.get());
                    } else throw new RequestException("Categorie doesn't exist", HttpStatus.NOT_FOUND);
                }
                //
                if (produitFormData.getImages() != null) {
                    if (produitFormData.getImages().size() >= 4 && produitFormData.getImages().size() <= 8) {
                        List<Image> images = imageService.insertMultiple(produit, produitFormData.getImages());
                        if (images != null) {
                            for (Image preImage : produit.getImages()) {
                                imageService.delete(preImage);
                            }
                            produit.setImages(null);
                        }
                        throw new RequestException("Error while saving product, try again later", HttpStatus.INTERNAL_SERVER_ERROR);
                    } else throw new RequestException("Images invalid", HttpStatus.UNPROCESSABLE_ENTITY);
                }
                //
                return new ProduitMin(produitDao.save(produit));
            } else throw new RequestException("No produit exists with the given Id", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public DeleteRes delete(String idProduit) {
        if (idProduit != null && idProduit.length() > 0) {
            Optional<Produit> optionalProduit = produitDao.findById(idProduit);
            if (optionalProduit.isPresent()) {
                produitDao.delete(optionalProduit.get());
                if ((produitDao.findById(idProduit)).isPresent())
                    throw new RequestException("Produit not deleted", HttpStatus.INTERNAL_SERVER_ERROR);
                return new DeleteRes(1, optionalProduit.get().getIdProduit(), Produit.class.getSimpleName());
            }
        }
        throw new RequestException("Please provide a valid produit Id", HttpStatus.UNPROCESSABLE_ENTITY);
    }

    @Override
    public List<ProduitMin> getAll() {
        List<ProduitMin> produits = new ArrayList<>();
        for (Produit produit : produitDao.findAll()) {
            List<ImageMin> images = new ArrayList<>();
            for (Image image : produit.getImages()) {
                images.add(new ImageMin(image.getLienImage()));
            }
            produits.add(new ProduitMin(produit.getLibelleProduit(), produit.getDescriptionProduit(), produit.getPrixProduit(), new CategorieMin(produit.getCategorie().getLibelleCategorie(), new ImageMin(produit.getCategorie().getImage().getLienImage())), images, produit.getDateCreation()));
        }
        //
        return produits.size() > 0 ? produits : null;
    }

    @Override
    public ProduitMin get(String idProduit) {
        if (idProduit != null && idProduit.length() > 0) {
            Optional<Produit> optionalProduit = produitDao.findById(idProduit);
            if (optionalProduit.isPresent()) {
                Produit produit = optionalProduit.get();
                List<ImageMin> images = new ArrayList<>();
                for (Image image : produit.getImages()) {
                    images.add(new ImageMin(image.getLienImage()));
                }
                return new ProduitMin(produit.getLibelleProduit(), produit.getDescriptionProduit(), produit.getPrixProduit(), new CategorieMin(produit.getCategorie().getLibelleCategorie(), new ImageMin(produit.getCategorie().getImage().getLienImage())), images, produit.getDateCreation());
            } else throw new RequestException("No produit exists with the given Id", HttpStatus.BAD_REQUEST);
        }
        throw new RequestException("Please provide a valid Produit Id", HttpStatus.UNPROCESSABLE_ENTITY);
    }

}
