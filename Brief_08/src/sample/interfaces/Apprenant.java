package sample.interfaces;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import sample.helpers.Session;

public class Apprenant implements Initializable {
	@FXML
	Text nomUser;
    @FXML
    HBox formateur_root;
    @FXML
    Pane formateur_content;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        switchCntent("fichePresence");
        nomUser.setText(Session.nom.toUpperCase().substring(0, 1) + Session.prenom.toUpperCase().substring(0, 1));

    }

    @FXML
    public void afficherForm() {
        switchCntent("fichePresence");
    }

    //
    private void switchCntent(String filename) {
        try {
            VBox content = FXMLLoader.load(getClass().getResource(String.format("apprenant/%s.fxml", filename)));
            formateur_content.getChildren().setAll(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
}
