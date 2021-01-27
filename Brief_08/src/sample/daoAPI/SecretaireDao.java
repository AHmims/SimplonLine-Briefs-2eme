package sample.daoAPI;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Optional;

import sample.daoAPI.api.Dao;
 
import sample.domainClasses.Secretaire;
import sample.helpers.Connexion;

public class SecretaireDao implements Dao<Secretaire>{

	public Optional<Secretaire> get(String pk) {
		// TODO Auto-generated method stub
		return null;
	}

	public Optional<Secretaire> get(Calendar pk) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Secretaire> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean save(Secretaire sec) {
		 
		 try {
             Connection con = Connexion.db_connect();
             if (con == null)
                 throw new Exception("Connection error");
             //
             PreparedStatement statement = con.prepareStatement("INSERT INTO `Secretaire` (`matricule`) VALUES (?)");
           
             statement.setString(1, sec.getMatricule());
              
             //
             boolean res = statement.executeUpdate() >= 1;
             con.close();
             return res;
         } catch (Exception e) {
             e.printStackTrace();
             return false;
         }
	}

	 

	public boolean update(Secretaire t) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(Secretaire t) {
		// TODO Auto-generated method stub
		return false;
	}

}
