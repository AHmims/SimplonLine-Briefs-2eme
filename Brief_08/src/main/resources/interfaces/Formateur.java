package interfaces;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Formateur implements Initializable {
    @FXML
    HBox formateur_root;
    @FXML
    Pane formateur_content;
    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        switchCntent("gestionAbsense");
    }
    @FXML
    public void afficherForm(){
        switchCntent("gestionAbsense");
    }
    //
    private void switchCntent(String filename) {
        try {
            VBox content = FXMLLoader.load(getClass().getResource(String.format("formateur/%s.fxml", filename)));
            formateur_content.getChildren().setAll(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
