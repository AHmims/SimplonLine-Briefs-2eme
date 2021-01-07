package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Controller {
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
    private void test(){
        try {
            Pane content = FXMLLoader.load(getClass().getResource("apprenant_comp.fxml"));
            root.getChildren().setAll(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
