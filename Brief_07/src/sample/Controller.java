package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    private void login() {
        SimplonLine sl = new SimplonLine();
        int login_res = sl.login(input_email.getText(), input_pass.getText());
        if (login_res == 1) {
            System.out.println("In");
            //DO SOMETHING HERE
        } else {
            if (login_res == 0) System.out.println("INVALID CREDENTIALS");
            else System.out.printf("code : %d, FUNCTION : login()\n", login_res);
        }
        //switchScene();
    }

    //Method called when user authenticates successfully
    private void switchScene() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("apprenant_comp.fxml"));
            Stage stage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
