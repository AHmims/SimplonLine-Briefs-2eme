package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Button btnStart;
    @FXML
    VBox container;
    @FXML
    Label lblerror;
    @FXML
    GridPane root;
    @FXML
    TextField txt_nom, txt_prenom, txt_age;
    static String name;
    static String prenom;
    static String age;
    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {}
    //
    @FXML
    public void startQuiz() {
        //DIR HNA TRAITMENT DYLK
        //MN B3D N'AFFICHIW L'FORM
        name = txt_nom.getText();
        prenom = txt_prenom.getText();
        age = txt_age.getText();
        if (!name.equals("") && !prenom.equals("") && !age.equals("")) {
            nextScene();
        } else {
            lblerror.setText("Error");
        }
    }
    //FUNCTION kdir l'appele l fichier .fxml li fih la form mn b3d knchdo dik l form wkan7otoha fl fenetre li fiha 7na dba
    public void nextScene() {
        try {
            VBox content = FXMLLoader.load(getClass().getResource("form.fxml"));
            root.getChildren().setAll(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}