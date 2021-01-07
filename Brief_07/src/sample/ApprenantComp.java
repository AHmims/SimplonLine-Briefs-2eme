package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class ApprenantComp implements Initializable {
    @FXML
    Circle img_avatar;
    @FXML
    Text lb_nom;
    @FXML
    ChoiceBox<String> cb_promo;
    @FXML
    SVGPath btn_logout;
    @FXML
    Button btn_validate;
    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setAvatar();
        fillPromo();
    }
    //Set current user profile image
    private void setAvatar(){
        //Default image
        Image avatar = new Image(getClass().getResourceAsStream("res/img/test_img.jpg"));
        img_avatar.setFill(new ImagePattern(avatar));
    }
    //Fill the choicebox with the curretn user's available promos
    private void fillPromo(){
        //test data
        cb_promo.getItems().addAll("ff","gg");
        cb_promo.getSelectionModel().selectFirst();
    }
}
