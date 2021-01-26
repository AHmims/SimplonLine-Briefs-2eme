package sample.interfaces;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.helpers.Session;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Formateur implements Initializable {
    @FXML
    HBox formateur_root;
    @FXML
    Text nomUser;
    @FXML
    Pane formateur_content;

    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nomUser.setText(Session.nom.toUpperCase().substring(0, 1) + Session.prenom.toUpperCase().substring(0, 1));
        switchCntent("gestionAbsense");
    }

    @FXML
    public void afficherForm() {
        switchCntent("gestionAbsense");
    }
    @FXML
    public void logOut(){
        Session.clearSession();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("authentification.fxml"));
            Stage stage = (Stage) formateur_root.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            Platform.runLater(() -> stage.setScene(scene));
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Erreur lors du chargement de la vue").showAndWait();
        }
    }

    //
    private void switchCntent(String filename) {
        try {
            VBox content = FXMLLoader.load(getClass().getResource(String.format("formateur/%s.fxml", filename)));
            formateur_content.getChildren().setAll(content);
        } catch (IOException e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Erreur lors du chargement de la vue").showAndWait();
        }
    }
}