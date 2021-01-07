package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class ApprenantComp implements Initializable {
    @FXML
    Circle img_avatar;
    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setAvatar();
    }
    //Set current user profile image
    private void setAvatar(){
        //Default image
        Image avatar = new Image(getClass().getResourceAsStream("res/test_img.jpg"));
        img_avatar.setFill(new ImagePattern(avatar));
    }
}
