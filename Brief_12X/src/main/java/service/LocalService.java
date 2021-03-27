package service;

import dao.LocalDao;
import model.Local;
import service.api.ServiceLocal;

import java.util.List;

public class LocalService implements ServiceLocal {
    @Override
    public List<Local> getAll() {
        try {
            LocalDao localDao = new LocalDao();
            return localDao.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
