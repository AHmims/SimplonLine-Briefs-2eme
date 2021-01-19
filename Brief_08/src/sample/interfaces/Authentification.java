package sample.interfaces;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Authentification {
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
    public void login(){
        switchScene();
    }
    //Method called when user authenticates successfully
    private void switchScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("admin.fxml"));
            Stage stage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
