package dao.api;

import model.RendezVous;
import model.Utilisateur;

import java.util.ArrayList;

public interface DaoRendezVous {
    RendezVous get(String idRendezVous);

    ArrayList<RendezVous> getAll();

    boolean insert(RendezVous rendezVous);

    boolean update(RendezVous rendezVous);

    boolean delete(RendezVous rendezVous);
}
