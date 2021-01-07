package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    SVGPath btn_logout;
    @FXML
    Button btn_validate;
    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setAvatar();
    }
    //Set current user profile image
    private void setAvatar(){
        //Default image
        Image avatar = new Image(getClass().getResourceAsStream("res/img/test_img.jpg"));
        img_avatar.setFill(new ImagePattern(avatar));
    }
}
