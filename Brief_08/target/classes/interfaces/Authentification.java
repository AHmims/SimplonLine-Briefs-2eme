package interfaces;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.daoAPI.api.Dao;
import sample.domainClasses.Administrateur;
import sample.domainClasses.Utilisateur;
import sample.helpers.Session;

import java.io.IOException;

public class Authentification {
    private Dao<Administrateur> administrateurDao;
    //
    @FXML
    Pane root;
    @FXML
    TextField input_email;
    @FXML
    PasswordField input_pass;
    @FXML
    Button btn_login;

    //
    @FXML
    public void login() {
        /* Toast t = new Toast(root);
        t.normal("qlj qjs iqjs hqj kqjhkjhk hkjh"); */

        new Thread(() -> {
            try {
                final String nom = input_email.getText();
                final String prenom = input_pass.getText();
                //
                if (!nom.equals("") && !prenom.equals("")) {
                    Utilisateur user = Dao.login(nom, prenom);
                    if (user != null) {
                        // CREATE A USER INSTANCE
                        Session.setSession(user);
                        // UPDATE scene_name FOR OTHERINTERFACES WHEN MADE
                        String scene_name = "";
                        switch (user.getClass().getSimpleName()) {
                            case "Administrateur":
                                scene_name = "admin";
                                break;
                            case "Secretaire":
                                scene_name = "";
                                break;
                            case "Formateur":
                                scene_name = "formateur";
                                break;
                            case "Apprenant":
                                scene_name = "";
                                break;
                            default:
                                System.out.println("Class unknown");
                        }
                        //
                        if (!scene_name.equals("")) {
                            switchScene(scene_name);
                        }
                    } else {
                        System.out.println("User not found");
                    }
                } else {
                    System.out.println("Inputs can't be empty");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    //Method called when user authenticates successfully
    private void switchScene(String scene_name) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(String.format("%s.fxml", scene_name)));
            Stage stage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            Platform.runLater(() -> stage.setScene(scene));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
