package sample.interfaces;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.helpers.Session;
import sample.helpers.Toast;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Admin implements Initializable {
    @FXML
    HBox admin_root;
    @FXML
    Pane admin_content;

    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Toast t = new Toast(admin_root);
        //t.normal("qlj qjs iqjs hqj kqjhkjhk hkjh");
        switchCntent("Utilisateurs");
    }

    //
    @FXML
    public void afficherUtilisateurs() {
        switchCntent("Utilisateurs");
    }

    @FXML
    public void afficherAjouterUtilisateurs() {
        switchCntent("Ajouter");
    }
    @FXML
    public void logOut(){
        Session.clearSession();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("authentification.fxml"));
            Stage stage = (Stage) admin_root.getScene().getWindow();
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
            VBox content = FXMLLoader.load(getClass().getResource(String.format("admin/%s.fxml", filename)));
            admin_content.getChildren().setAll(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
