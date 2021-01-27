package sample.interfaces.admin;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.scene.control.PasswordField;

import javafx.scene.layout.VBox;
import sample.daoAPI.AdministrateurDao;
import sample.daoAPI.ApprenantDao;
import sample.daoAPI.FormateurDao;
import sample.daoAPI.SecretaireDao;
import sample.daoAPI.UtilisateurDao;
import sample.domainClasses.Administrateur;
import sample.domainClasses.Apprenant;
import sample.domainClasses.Formateur;
import sample.domainClasses.Secretaire;
import sample.domainClasses.Utilisateur;
import sample.helpers.Connexion;
import javafx.scene.control.DatePicker;

import javafx.scene.control.ChoiceBox;

public class Ajouter implements Initializable {
    @FXML
    private VBox root_ajouter;
    @FXML
    private VBox form_add;
    @FXML
    private TextField idNom;
    @FXML
    private TextField idPrenom;
    @FXML
    private TextField idCin;
    @FXML
    private DatePicker idDateNaissance;
    @FXML
    private TextField idLogin;
    @FXML
    private PasswordField idPassword;
    @FXML
    private ChoiceBox<String> idRole;
    @FXML
    private VBox idVboxAdmin;
    @FXML
    private TextField idMatricule;
    @FXML
    private DatePicker idDateEmbauche;
    @FXML
    private TextField idService;
    @FXML
    private VBox idVboxApprenant;
    @FXML
    private TextField idCne;
    @FXML
    private TextField idPromotion;
    @FXML
    private TextField idNomTuteur;
    @FXML
    private TextField idPrenomTuteur;
    @FXML
    private TextField idNiveau;
    @FXML
    private TextField idGroupe;
    @FXML
    private Button btn_add;
    Boolean admin, apprenant, sectretaire, formateur;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        admin = apprenant = sectretaire = formateur = false;
        chargeCmbRole();


    }


    public void chargeCmbRole() {
        idRole.getItems().add("Administrateur");
        idRole.getItems().add("Formateur");
        idRole.getItems().add("Secretaire");
        idRole.getItems().add("Apprenant");
        idRole.setOnAction(eventRole);
        btn_add.setOnAction(eventAdd);
        idRole.getSelectionModel().select(0);
        ;

    }

    public void showAndHideSection() {
        if (idRole.getValue().equals("Apprenant")) {
            apprenant = true;
            admin = sectretaire = formateur = false;
            idVboxApprenant.setVisible(true);
            idVboxAdmin.setVisible(false);
            idVboxApprenant.managedProperty().bind(idVboxApprenant.visibleProperty());
            idVboxAdmin.managedProperty().bind(idVboxAdmin.visibleProperty());

        } else if (idRole.getValue().equals("Formateur")) {
            formateur = true;
            admin = apprenant = sectretaire = false;
            idVboxApprenant.setVisible(false);
            idVboxAdmin.setVisible(true);
            idVboxApprenant.managedProperty().bind(idVboxApprenant.visibleProperty());
            idVboxAdmin.managedProperty().bind(idVboxAdmin.visibleProperty());

        } else if (idRole.getValue().equals("Secretaire")) {
            sectretaire = true;
            admin = apprenant = formateur = false;
            idVboxApprenant.setVisible(false);
            idVboxAdmin.setVisible(true);
            idVboxApprenant.managedProperty().bind(idVboxApprenant.visibleProperty());
            idVboxAdmin.managedProperty().bind(idVboxAdmin.visibleProperty());


        } else if (idRole.getValue().equals("Administrateur")) {
            admin = true;
            apprenant = sectretaire = formateur = false;
            idVboxApprenant.setVisible(false);
            idVboxAdmin.setVisible(true);
            idVboxApprenant.managedProperty().bind(idVboxApprenant.visibleProperty());
            idVboxAdmin.managedProperty().bind(idVboxAdmin.visibleProperty());
        }
    }

    // Selectionner un role event


    EventHandler<ActionEvent> eventRole =
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    showAndHideSection();
                }
            };
    EventHandler<ActionEvent> eventAdd =
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    ajouterUtilisateur();
                }
            };

    public void ajouterUtilisateur() {
        if (existe("cin", idCin.getText()) || existe("user", idLogin.getText())) {
            System.out.println(" cin ou login existant !!");
        } else {
            Calendar date = Calendar.getInstance();
            date.setTime(Date.from(idDateNaissance.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));


            if (apprenant) {

                UtilisateurDao ud = new UtilisateurDao();
                ApprenantDao ad = new ApprenantDao();


                Utilisateur u = new Utilisateur(idCin.getText(), idNom.getText(), idPrenom.getText(), date, idLogin.getText(), idPassword.getText(), 0);
                ud.save(u);

                Apprenant a = new Apprenant(idCin.getText(), idNom.getText(), idPrenom.getText(), date, idLogin.getText(), idPassword.getText(), 0, idCne.getText(), idPromotion.getText(), idNomTuteur.getText(), idPrenomTuteur.getText(), Integer.parseInt(idNiveau.getText()), idGroupe.getText());


                if (ad.save(a)) {
                    System.out.println("Apprenant added successfully !");
                }


            } else if (admin) {
                Calendar dateEmbauche = Calendar.getInstance();
                dateEmbauche.setTime(Date.from(idDateEmbauche.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));

                UtilisateurDao ud = new UtilisateurDao();


                Utilisateur u = new Utilisateur(idCin.getText(), idNom.getText(), idPrenom.getText(), date, idLogin.getText(), idPassword.getText(), 3);
                ud.save(u);
                AdministrateurDao ad = new AdministrateurDao();
                Administrateur adm = new Administrateur(idCin.getText(), idNom.getText(), idPrenom.getText(), date, idLogin.getText(), idPassword.getText(), 3, idMatricule.getText(), dateEmbauche, idService.getText());

                if (ad.save(adm)) {
                    System.out.println("Admin added successfully !");
                }


            } else if (formateur) {
                Calendar dateEmbauche = Calendar.getInstance();
                dateEmbauche.setTime(Date.from(idDateEmbauche.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                UtilisateurDao ud = new UtilisateurDao();
                FormateurDao fd = new FormateurDao();

                Utilisateur u = new Utilisateur(idCin.getText(), idNom.getText(), idPrenom.getText(), date, idLogin.getText(), idPassword.getText(), 2);
                ud.save(u);

                Formateur f = new Formateur(idCin.getText(), idNom.getText(), idPrenom.getText(), date, idLogin.getText(), idPassword.getText(), 2, idMatricule.getText(), dateEmbauche, idService.getText());

                if (fd.save(f)) {
                    System.out.println("Formateur added successfully !");
                }


            } else if (sectretaire) {
                Calendar dateEmbauche = Calendar.getInstance();
                dateEmbauche.setTime(Date.from(idDateEmbauche.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                UtilisateurDao ud = new UtilisateurDao();
                SecretaireDao sd = new SecretaireDao();


                Utilisateur u = new Utilisateur(idCin.getText(), idNom.getText(), idPrenom.getText(), date, idLogin.getText(), idPassword.getText(), 1);
                ud.save(u);
                Secretaire s = new Secretaire(idCin.getText(), idNom.getText(), idPrenom.getText(), date, idLogin.getText(), idPassword.getText(), 1, idMatricule.getText(), dateEmbauche, idService.getText());

                if (sd.save(s)) {
                    System.out.println("Secretaire added successfully !");
                }

            }


        }


    }

    public Boolean existe(String det, String id) {
        String query = "";

        if (det == "cin") {
            query = "select * from Utilisateur where cin ='" + id + "'";
        } else {
            query = "select * from Utilisateur where user ='" + id + "'";
        }


        return executeQueryCheck(query);

    }

    private Boolean executeQueryCheck(String query) {
        Boolean res = false;
        Connection con = Connexion.db_connect();

        Statement st;

        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {
                res = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;

    }

    private Boolean executeQuery(String query) {
        Boolean res = false;
        Connection con = Connexion.db_connect();
        Statement st;

        try {
            st = con.createStatement();
            st.executeUpdate(query);
            res = true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return res;

    }


}
