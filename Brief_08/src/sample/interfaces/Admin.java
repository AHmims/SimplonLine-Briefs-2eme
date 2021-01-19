package sample.interfaces;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Admin implements Initializable {
    @FXML
    Pane admin_content;

    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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
