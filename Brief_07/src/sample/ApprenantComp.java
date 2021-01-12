package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import sample.db_classes.Competence;
import sample.db_classes.NiveauCompetence;
import sample.db_classes.Promo;
import sample.db_classes.Specialite;
import sample.helpers.Connexion;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ApprenantComp implements Initializable {
    private ArrayList<Promo> promos;
    //
    @FXML
    VBox root;
    @FXML
    Circle img_avatar;
    @FXML
    Text lb_nom;
    @FXML
    ChoiceBox<String> cb_promo;
    @FXML
    SVGPath btn_logout;
    @FXML
    VBox skills_container;
    @FXML
    Button btn_validate;

    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setUser();
        fillPromo();
        //
        cb_promo.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                changeDisplayedSkills();
            }
        });
    }

    //Set current user profile image
    private void setUser() {
        lb_nom.setText(Connexion.nom);
        //
        Image avatar;
        if (Connexion.avatar != null)
            avatar = new Image(Connexion.avatar);
        else
            avatar = new Image(getClass().getResourceAsStream("res/img/test_img.jpg"));
        img_avatar.setFill(new ImagePattern(avatar));
    }

    //Fill the choicebox with the curretn user's available promos
    private void fillPromo() {
        Connexion db_con = new Connexion();
        promos = db_con.getPromo_byUser(Connexion.userId);
        if (promos != null) {
            for (Promo promo : promos) {
                cb_promo.getItems().add(promo.getTitrePromo());
            }
            cb_promo.getSelectionModel().selectFirst();
            changeDisplayedSkills();
        }
    }

    //
    private void changeDisplayedSkills() {
        Connexion db_con = new Connexion();
        //Find the selected Promo
        for (Promo promo : promos) {
            if (promo.getTitrePromo().equals(cb_promo.getValue())) {
                //EMPTY CONTAINER
                skills_container.getChildren().clear();
                //GET LIST OS SKILLS(COMPETENCES) GROUPED BY FRAMEWORK(SPECIALITE) FOR CURRENT CLASSROOM(PROMO)
                ArrayList<Specialite> specialites = db_con.getSpecialite_byPromo(promo.getIdPromo());
                for (Specialite specialite : specialites) {
                    VBox setContainer = new VBox();
                    Label setTitleText = new Label(String.format("%s :", specialite.getTitreSpecialite()));
                    setTitleText.getStyleClass().add("sp-title");
                    //
                    ArrayList<Competence> competences = db_con.getCompetences_bySpecialite(specialite.getIdSpecialite());
                    if (competences.size() >= 2) {
                        for (int i = 0; i < competences.size() / 2; i++) {
                            HBox row = new HBox();
                            row.setSpacing(10);
                            row.setAlignment(Pos.TOP_LEFT);
                            for (int j = 0; j < 2; j++) {
                                if (competences.size() - 1 >= i + j) {
                                    Competence competence = competences.get(i + j);
                                    //
                                    VBox column = new VBox();
                                    column.setSpacing(5);
                                    VBox.setVgrow(column, Priority.ALWAYS);
                                    //
                                    Label competence_title = new Label(competence.getTitreCompetence());
                                    column.getChildren().add(competence_title);
                                    //
                                    ToggleGroup choices = new ToggleGroup();
                                    HBox btnGroup = new HBox();
                                    HBox.setHgrow(btnGroup, Priority.ALWAYS);
                                    int x = 0;
                                    for (NiveauCompetence niveau : competence.getNiveauCompetences()) {
                                        ToggleButton btn_niveau = new ToggleButton(String.format("Niveau %d", niveau.getNumNiveauCompetence()));
                                        HBox.setHgrow(btn_niveau, Priority.ALWAYS);
                                        btn_niveau.setMaxWidth(Double.MAX_VALUE);
                                        choices.getToggles().add(btn_niveau);
                                        //
                                        if (competence.getNiveauCompetences().size() == 3) {
                                            btn_niveau.getStyleClass().clear();
                                            btn_niveau.getStyleClass().addAll("btn_niveau_inactive");
                                            if (x == 0)
                                                btn_niveau.getStyleClass().add("btn_niveau_left");
                                            else if (x == 1)
                                                btn_niveau.getStyleClass().add("btn_niveau_middle");
                                            else
                                                btn_niveau.getStyleClass().add("btn_niveau_right");
                                        }
                                        btnGroup.getChildren().add(btn_niveau);
                                        x++;
                                    }
                                    //
                                    column.getChildren().add(btnGroup);
                                    row.getChildren().add(column);
                                }
                            }
                            skills_container.getChildren().add(row);
                        }
                    } else {

                    }
                    //
                    setContainer.getChildren().add(setTitleText);
                    skills_container.getChildren().add(setContainer);
                }
            }
        }
    }
}
