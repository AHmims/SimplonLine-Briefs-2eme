package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Text;
import sample.db_classes.*;
import sample.helpers.Connexion;

import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;

public class ApprenantComp implements Initializable {
    private ArrayList<Promo> promos;
    private ArrayList<Button> ui_levels = new ArrayList<>();
    private ArrayList<Button> changed_levels = new ArrayList<>();
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
    ProgressIndicator progress_circle;
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

    @FXML
    public void updateSkills() {
        try {
            Connexion db_con = new Connexion();
            if (changed_levels.size() > 0) {
                for (Button btn_niveau : changed_levels) {
                    String idNiveauCompetence = btn_niveau.getProperties().get("idNiveauCompetence").toString();
                    boolean already_validated = db_con.isSkillValidated(Connexion.userId, idNiveauCompetence);
                    if (btn_niveau.getStyleClass().contains("btn_niveau_active")) {
                        if (!already_validated) {
                            Random rndm = new Random();
                            boolean insert_res = db_con.addNiveauCompetenceApprenant(new NiveauCompetenceApprenant(String.format("my-id_%d", rndm.nextInt(10000000)), idNiveauCompetence, Connexion.userId));
                            if (!insert_res)
                                throw new Exception("Skill validation not inserted");
                        }
                    } else {
                        if (already_validated) {
                            boolean dlt_res = db_con.removeSkillValidation(Connexion.userId, idNiveauCompetence);
                            if (!dlt_res)
                                throw new Exception("Skill Validation not removed");
                        }
                    }
                }
                changed_levels.clear();
                System.out.println("Done !");
            } else
                System.out.println("No changes were made");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error !!");
        }
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
                ui_levels.clear();
                //EMPTY CONTAINER
                skills_container.getChildren().clear();
                //GET LIST OS SKILLS(COMPETENCES) GROUPED BY FRAMEWORK(SPECIALITE) FOR CURRENT CLASSROOM(PROMO)
                ArrayList<Specialite> specialites = db_con.getSpecialite_byPromo(promo.getIdPromo());
                for (Specialite specialite : specialites) {
                    VBox setContainer = new VBox();
                    setContainer.setSpacing(10);
                    Label setTitleText = new Label(String.format("%s :", specialite.getTitreSpecialite()));
                    setTitleText.getStyleClass().add("sp-title");
                    setContainer.getChildren().add(setTitleText);
                    HBox.setHgrow(setContainer, Priority.ALWAYS);
                    //
                    ArrayList<Competence> competences = db_con.getCompetences_bySpecialite(specialite.getIdSpecialite(), Connexion.userId);
                    if (competences.size() >= 2) {
                        for (int i = 0; i < competences.size(); i = i + 2) {
                            HBox row = new HBox();
                            VBox.setVgrow(row, Priority.ALWAYS);
                            row.setSpacing(10);
                            row.setAlignment(Pos.BOTTOM_LEFT);
                            for (int j = 0; j < 2; j++) {
                                if (competences.size() - 1 >= i + j) {
                                    Competence competence = competences.get(i + j);
                                    //
                                    VBox column = new VBox();
                                    column.setSpacing(5);
                                    HBox.setHgrow(column, Priority.ALWAYS);
                                    column.setPrefWidth(100);
                                    column.setMaxWidth(Double.MAX_VALUE);
                                    column.setMaxHeight(Double.NEGATIVE_INFINITY);
                                    //column.setMinWidth(Double.MAX_VALUE);
                                    //
                                    Label competence_title = new Label(competence.getTitreCompetence());
                                    competence_title.setWrapText(true);
                                    //Label competence_title = new Label("Label");
                                    column.getChildren().add(competence_title);
                                    //
                                    //ToggleGroup choices = new ToggleGroup();
                                    HBox btnGroup = new HBox();
                                    VBox.setVgrow(btnGroup, Priority.ALWAYS);
                                    int x = 0;
                                    for (NiveauCompetence niveau : competence.getNiveauCompetences()) {
                                        Button btn_niveau = new Button(String.format("Niveau %d", niveau.getNumNiveauCompetence()));
                                        HBox.setHgrow(btn_niveau, Priority.ALWAYS);
                                        btn_niveau.setMaxWidth(Double.MAX_VALUE);
                                        //choices.getToggles().add(btn_niveau);
                                        btn_niveau.getProperties().put("idNiveauCompetence", niveau.getIdNiveauCompetence());
                                        //
                                        if (competence.getNiveauCompetences().size() == 3) {
                                            //btn_niveau.getStyleClass().clear();
                                            btn_niveau.getStyleClass().add("btn_niveau_inactive");
                                            if (niveau.isValidated()) {
                                                //btn_niveau.getStyleClass().remove("btn_niveau_inactive");
                                                btn_niveau.getStyleClass().add("btn_niveau_active");
                                            }
                                            //
                                            if (x == 0)
                                                btn_niveau.getStyleClass().add("btn_niveau_left");
                                            else if (x == 1)
                                                btn_niveau.getStyleClass().add("btn_niveau_middle");
                                            else
                                                btn_niveau.getStyleClass().add("btn_niveau_right");
                                        }
                                        //
                                        btn_niveau.setOnAction(e -> {
                                            if (changed_levels.contains(btn_niveau))
                                                changed_levels.remove(btn_niveau);
                                            else
                                                changed_levels.add(btn_niveau);
                                            //
                                            //System.out.println(btn_niveau.getStyleClass());
                                            if (btn_niveau.getStyleClass().contains("btn_niveau_active"))
                                                btn_niveau.getStyleClass().remove("btn_niveau_active");
                                            else
                                                btn_niveau.getStyleClass().add("btn_niveau_active");
                                            //
                                            update_progress();
                                        });
                                        //
                                        ui_levels.add(btn_niveau);
                                        btnGroup.getChildren().add(btn_niveau);
                                        x++;
                                    }
                                    //
                                    column.getChildren().add(btnGroup);
                                    row.getChildren().add(column);
                                }
                            }
                            setContainer.getChildren().add(row);
                        }
                    } else {
                        //DO IT, OR DON'T IDK :3
                    }
                    //
                    skills_container.getChildren().add(setContainer);
                }
                //
                update_progress();
            }
        }
    }

    //
    private void update_progress() {
        progress_circle.setProgress(0);
        float step = 1 / (float) ui_levels.size();
        //System.out.println(step);
        for (Button button : ui_levels) {
            float current_progress = (float) progress_circle.getProgress();
            if (button.getStyleClass().contains("btn_niveau_active")) {
                if (current_progress + step <= (float) 1)
                    progress_circle.setProgress(current_progress + step);
                else
                    progress_circle.setProgress(1);
            } else {
                if (current_progress - step > (float) 0)
                    progress_circle.setProgress(current_progress - step);
                else
                    progress_circle.setProgress(0);
            }
            //System.out.println("--" + progress_circle.getProgress());
        }
        /* System.out.println("---");
        System.out.println(progress_circle.getProgress());
        System.out.println(step); */
    }
}
