package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;

public class Controller {
    private int count = 0;

    @FXML
    private Label lb2;
    @FXML
    private SVGPath img1;
    @FXML
    private SVGPath img2;

    @FXML
    private void addPoints() {
        count++;
        img1.setFill(Paint.valueOf("#FC5C5C"));
        img2.setFill(Paint.valueOf("#00000000"));
        updatePts();
    }

    //
    @FXML
    private void rmvPoints() {
        if (count > 0) {
            count--;
            img1.setFill(Paint.valueOf("#FC5C5C00"));
            img2.setFill(Paint.valueOf("#000000"));
            updatePts();
        }
    }

    //
    private void updatePts() {
        lb2.setText(String.format("Résultat : %d", count));
    }
}
