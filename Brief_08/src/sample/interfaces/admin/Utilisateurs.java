package sample.interfaces.admin;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import sample.daoAPI.ApprenantDao;
import sample.daoAPI.UtilisateurDao;
import sample.domainClasses.Apprenant;
import sample.domainClasses.Utilisateur;
import sample.helpers.Session;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Utilisateurs implements Initializable {
    @FXML
    TilePane skills_container;

    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayLearners();
    }

    //
    private void displayLearners() {
        try {
            skills_container.getChildren().clear();
            UtilisateurDao utilisateurDao = new UtilisateurDao();
            ArrayList<Utilisateur> list_utilisateurs = utilisateurDao.getAll();
            if (list_utilisateurs != null) {
                if (list_utilisateurs.size() > 0) {
                    for (Utilisateur utilisateur : list_utilisateurs) {
                        skills_container.getChildren().add(make_user(utilisateur));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Erreur inconnue").showAndWait();
        }
    }

    private VBox make_user(Utilisateur utilisateur) {
        VBox container = new VBox();
        container.getStyleClass().add("user_card");
        container.setSpacing(5.0);
        //
        //
        HBox cont_data_1 = new HBox();
        cont_data_1.setSpacing(10.0);
        VBox.setVgrow(cont_data_1, Priority.ALWAYS);
        //
        Label nom = new Label(String.format("%s %s", utilisateur.getNom(), utilisateur.getPrenom()));
        nom.getStyleClass().add("card_name");
        Label role = new Label();
        role.setMinWidth(Double.NEGATIVE_INFINITY);
        role.setMinHeight(Double.NEGATIVE_INFINITY);
        role.getStyleClass().add("card_role");
        switch (utilisateur.getNivDroit()) {
            case 0:
                role.setText("Apprenant");
                role.getStyleClass().add("card_role_apprenant");
                break;
            case 1:
                role.setText("Secretaire");
                role.getStyleClass().add("card_role_secret");
                break;
            case 2:
                role.setText("Formateur");
                role.getStyleClass().add("card_role_formateur");
                break;
            case 3:
                role.setText("Admin");
                role.getStyleClass().add("card_role_admin");
                break;
        }
        //
        cont_data_1.getChildren().addAll(nom, role);
        //
        //
        Label cin = new Label(utilisateur.getCin());
        cin.getStyleClass().add("card_text");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Label dateN = new Label(sdf.format(utilisateur.getDateNaissance().getTime()));
        dateN.getStyleClass().add("card_text");
        //
        //
        HBox cont_data_2 = new HBox();
        cont_data_2.setSpacing(10.0);
        //
        Label username_lb = new Label("Username :");
        username_lb.getStyleClass().add("card_text");
        Label username = new Label(utilisateur.getUser());
        username.getStyleClass().add("card_text");
        //
        cont_data_2.getChildren().addAll(username_lb, username);
        //
        //
        container.getChildren().addAll(cont_data_1, cin, dateN, cont_data_2);
        //
        return container;
    }
}
