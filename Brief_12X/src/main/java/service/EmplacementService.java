package service;

import dao.EmplacementDao;
import model.Emplacement;
import service.api.ServiceEmplacement;

import java.util.List;

public class EmplacementService implements ServiceEmplacement {
    @Override
    public List<Emplacement> getAll() {
        try {
            EmplacementDao emplacementDao = new EmplacementDao();
            return emplacementDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
