package sample.interfaces.formateur;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import sample.daoAPI.AbsenceDao;
import sample.daoAPI.AdministrateurDao;
import sample.daoAPI.ApprenantDao;
import sample.daoAPI.SeanceDao;
import sample.domainClasses.Absence;
import sample.domainClasses.Apprenant;
import sample.domainClasses.Seance;
import sample.helpers.Session;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutionException;

public class GestionAbsense implements Initializable {
    private ArrayList<Apprenant> list_apprenants = new ArrayList<>();
    private ArrayList<Pane> components_apprenants = new ArrayList<>();
    private ArrayList<Pane> selected_apprenants = new ArrayList<>();
    //
    private ArrayList<Seance> list_seances = new ArrayList<>();
    private ArrayList<Pane> components_seances = new ArrayList<>();
    private Pane selected_seance = null;
    //
    @FXML
    HBox cont_apprenants;
    @FXML
    TextField srch_apprenant;
    @FXML
    HBox cont_seances;
    @FXML
    ToggleGroup abs_type;
    @FXML
    RadioButton abs_opt1;
    @FXML
    TextField abs_duration;

    //
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayLearners();
        displayClasses();
    }

    @FXML
    public void radio_selected() {
        if (abs_type.getSelectedToggle().equals(abs_opt1)) {
            abs_duration.setDisable(true);
        } else {
            abs_duration.setDisable(false);
        }
    }

    @FXML
    public void search() {
        String query = srch_apprenant.getText().toLowerCase();
        //
        for (int i = 0; i < list_apprenants.size(); i++) {
            Apprenant apprenant = list_apprenants.get(i);
            //
            boolean exists = false;
            //
            if (apprenant.getNom().toLowerCase().contains(query) || apprenant.getPrenom().toLowerCase().contains(query) || apprenant.getCne().toLowerCase().contains(query) || apprenant.getGroupe().toLowerCase().equals(query) || (apprenant.getNiveau() + "").equals(query)) {
                exists = true;
            }
            //
            components_apprenants.get(i).setVisible(exists);
            components_apprenants.get(i).setManaged(exists);
        }

    }

    @FXML
    public void add() {
        try {
            if (selected_apprenants.size() == 0)
                throw new Exception("1");
            if (selected_seance == null)
                throw new Exception("2");
            if (!abs_type.getSelectedToggle().equals(abs_opt1) && abs_duration.getText().equals(""))
                throw new Exception("3");
            //
            for (Pane comp_apprenant : selected_apprenants) {
                int pos_apprenant = Integer.parseInt(comp_apprenant.getProperties().get("index_app").toString());
                Apprenant apprenant = list_apprenants.get(pos_apprenant);
                int pos_seance = Integer.parseInt(selected_seance.getProperties().get("index_app").toString());
                Seance seance = list_seances.get(pos_seance);
                //
                Calendar h_abs = Calendar.getInstance();
                Double retard = -1.0;
                Double absence = -1.0;
                //
                if (abs_type.getSelectedToggle().equals(abs_opt1))
                    absence = 0.0;
                else
                    retard = Double.parseDouble(abs_duration.getText());
                //
                AbsenceDao absenceDao = new AbsenceDao();
                boolean insert_res = absenceDao.save(new Absence(h_abs, apprenant.getCin(), seance.getDateSeance(), false, retard, absence));
                if (!insert_res) {
                    System.out.println("Not saved");
                    new Alert(Alert.AlertType.ERROR, "Les données n'ont pas été sauvegardées").showAndWait();
                } else {
                    System.out.println("Saved");
                    new Alert(Alert.AlertType.INFORMATION, "Les données ont été sauvegardées").showAndWait();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            switch (e.getMessage()) {
                case "1":
                    new Alert(Alert.AlertType.ERROR, "Veuillez sélectionner au moins 1 apprenant").showAndWait();
                    break;
                case "2":
                    new Alert(Alert.AlertType.ERROR, "Merci de sélectionner une seance").showAndWait();
                    break;
                case "3":
                    new Alert(Alert.AlertType.ERROR, "La durée ne peut pas être vide").showAndWait();
                    break;
                default:
                    new Alert(Alert.AlertType.ERROR, "Erreur inconnue").showAndWait();
            }
        }
    }

    //
    private void displayLearners() {
        try {
            list_apprenants.clear();
            components_apprenants.clear();
            cont_apprenants.getChildren().clear();
            //
            ApprenantDao apprenantDao = new ApprenantDao();
            list_apprenants = apprenantDao.getAllByFormateur(Session.cin);
            if (list_apprenants != null) {
                if (list_apprenants.size() > 0) {
                    for (Apprenant apprenant : list_apprenants) {
                        cont_apprenants.getChildren().add(make_apprenant(apprenant));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Erreur inconnue").showAndWait();
        }
    }

    private Pane make_apprenant(Apprenant apprenant) {
        Pane container = new Pane();
        container.getStyleClass().add("apprenant_card");
        //
        //
        VBox cont_data = new VBox();
        cont_data.getStyleClass().add("inner_cont");
        //
        Label nom = new Label(String.format("%s %s", apprenant.getNom(), apprenant.getPrenom()));
        nom.getStyleClass().add("nom");
        Label cne = new Label(apprenant.getCne());
        Label grp_niv = new Label(String.format("Groupe: %s | Niveau: %s", apprenant.getGroupe(), apprenant.getNiveau()));
        //
        cont_data.getChildren().addAll(nom, cne, grp_niv);
        //
        //
        Circle indicator = new Circle();
        indicator.setRadius(10);
        indicator.getStyleClass().add("indicator");
        //
        container.getChildren().addAll(cont_data, indicator);
        container.getProperties().put("index_app", components_apprenants.size());
        //
        container.setOnMouseClicked(e -> {
            if (container.getStyleClass().contains("apprenant_card_active")) {
                selected_apprenants.remove(container);
                container.getStyleClass().remove("apprenant_card_active");
            } else {
                container.getStyleClass().add("apprenant_card_active");
                selected_apprenants.add(container);
            }
        });
        //
        //container.managedProperty().bind(container.visibleProperty());
        components_apprenants.add(container);
        return container;
    }

    private void displayClasses() {
        try {
            list_seances.clear();
            components_seances.clear();
            cont_seances.getChildren().clear();
            //
            SeanceDao seanceDao = new SeanceDao();
            list_seances = seanceDao.getAllByFormateur(Session.cin);
            if (list_seances != null) {
                if (list_seances.size() > 0) {
                    for (Seance seance : list_seances) {
                        cont_seances.getChildren().add(make_seance(seance));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Erreur inconnue").showAndWait();
        }
    }

    private Pane make_seance(Seance seance) {
        Pane container = new Pane();
        container.getStyleClass().add("seance_card");
        //
        //
        VBox cont_data = new VBox();
        cont_data.getStyleClass().add("inner_cont");
        //
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm dd/MM/yyyy");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
        Label dateS = new Label(sdf.format(seance.getDateSeance().getTime()));
        dateS.getStyleClass().add("dateS");
        Label groupe = new Label(String.format("Groupe: %s", seance.getGroupe()));
        Label date_h_f = new Label(String.format("%s -> %s", sdf2.format(seance.getHeureDebut().getTime()), sdf2.format(seance.getHeureFin().getTime())));
        //
        cont_data.getChildren().addAll(dateS, groupe, date_h_f);
        //
        //
        Circle indicator = new Circle();
        indicator.setRadius(10);
        indicator.getStyleClass().add("indicator");
        //
        container.getChildren().addAll(cont_data, indicator);
        container.getProperties().put("index_app", components_seances.size());
        //
        container.setOnMouseClicked(e -> {
            if (container.getStyleClass().contains("seance_card_active")) {
                selected_seance = null;
                container.getStyleClass().remove("seance_card_active");
            } else {
                for (Pane p_s : components_seances) {
                    p_s.getStyleClass().remove("seance_card_active");
                }
                container.getStyleClass().add("seance_card_active");
                selected_seance = container;
            }
        });
        //
        //container.managedProperty().bind(container.visibleProperty());
        components_seances.add(container);
        return container;
    }
}
