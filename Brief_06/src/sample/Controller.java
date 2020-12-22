package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class Controller {
    @FXML
    Button btnStart;
    @FXML
    VBox container;
    @FXML
    GridPane root;
    //
    @FXML public void startQuiz(){
        //DIR HNA TRAITMENT DYLK
        //MN B3D N'AFFICHIW L'FORM
        nextScene();
    }
    //FUNCTION kdir l'appele l fichier .fxml li fih la form mn b3d knchdo dik l form wkan7otoha fl fenetre li fiha 7na dba
    public void nextScene(){
        try {
            VBox content = FXMLLoader.load(getClass().getResource("form.fxml"));
            root.getChildren().setAll(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
