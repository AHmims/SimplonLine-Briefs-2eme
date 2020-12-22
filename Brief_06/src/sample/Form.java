package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;

import javax.swing.*;

public class Form {
    private boolean musiqueState = true;
    private musiquePlayer player;
    //
    private int attemptsCount = 2;
    private int lvlCount = 1;
    //@FXML Button btnTest ;
    @FXML
    SVGPath btnMusique;
    @FXML
    Button btnDebut;
    @FXML
    Label lbNbt, lbNiv, lbComp, lbNom;

    //
    //on page load
    public Form() {
        //play music
        player = new musiquePlayer("quiz-show.mp3");
        //System.out.println("slm");
    }

    //Validate the form
    @FXML
    public void validateForm() {
        boolean valide = false;
        //Code de validation ici
        //
        //traitment apres validation
        if (valide) {
            //next level
        } else {
            if (attemptsCount > 0) {
                attemptsCount--;
                lbNbt.setText(String.format("Tentatives : %d", attemptsCount));
            } else {
                final ImageIcon icon = new ImageIcon("lose.gif");
                //JOptionPane.showMessageDialog(null,invisibleChar, "YOU LOST HAHAHAH", JOptionPane.INFORMATION_MESSAGE, icon);
                //JOptionPane.showMessageDialog(null, "GAME OVER\nNombre de tentatives a atteint 0.", "GAME OVER", JOptionPane.INFORMATION_MESSAGE, icon);
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("GAME OVER");
                alert.setHeaderText("Vous avez échoué le quiz");
                alert.setContentText("Nombre de tentatives a atteint 0!");
                alert.showAndWait();
            }
        }
    }

    //on_click de button de volume
    @FXML
    public void musiqueController() {
        if (musiqueState) {
            btnMusique.setContent("M9.383 3.076A1 1 0 0110 4v12a1 1 0 01-1.707.707L4.586 13H2a1 1 0 01-1-1V8a1 1 0 011-1h2.586l3.707-3.707a1 1 0 011.09-.217zM12.293 7.293a1 1 0 011.414 0L15 8.586l1.293-1.293a1 1 0 111.414 1.414L16.414 10l1.293 1.293a1 1 0 01-1.414 1.414L15 11.414l-1.293 1.293a1 1 0 01-1.414-1.414L13.586 10l-1.293-1.293a1 1 0 010-1.414z");
        } else {
            btnMusique.setContent("M9.383 3.076A1 1 0 0110 4v12a1 1 0 01-1.707.707L4.586 13H2a1 1 0 01-1-1V8a1 1 0 011-1h2.586l3.707-3.707a1 1 0 011.09-.217zM14.657 2.929a1 1 0 011.414 0A9.972 9.972 0 0119 10a9.972 9.972 0 01-2.929 7.071 1 1 0 01-1.414-1.414A7.971 7.971 0 0017 10c0-2.21-.894-4.208-2.343-5.657a1 1 0 010-1.414zm-2.829 2.828a1 1 0 011.415 0A5.983 5.983 0 0115 10a5.984 5.984 0 01-1.757 4.243 1 1 0 01-1.415-1.415A3.984 3.984 0 0013 10a3.983 3.983 0 00-1.172-2.828 1 1 0 010-1.415z");
        }
        musiqueState = !musiqueState;
        player.volumeControll(musiqueState);
    }
    //
}
