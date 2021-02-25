package dao;

import dao.api.DaoRendezVous;
import model.RendezVous;

import java.util.ArrayList;

public class RendezVousDao implements DaoRendezVous {
    @Override
    public RendezVous get(String idRendezVous) {
        return null;
    }

    @Override
    public ArrayList<RendezVous> getAll() {
        return null;
    }

    @Override
    public int insert(RendezVous rendezVous) {
        return 0;
    }

    @Override
    public boolean update(RendezVous rendezVous) {
        return false;
    }

    @Override
    public boolean delete(RendezVous rendezVous) {
        return false;
    }
}
