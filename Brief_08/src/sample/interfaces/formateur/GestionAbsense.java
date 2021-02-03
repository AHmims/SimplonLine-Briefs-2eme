package sample.interfaces.formateur;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import sample.daoAPI.*;
import sample.domainClasses.*;
import sample.helpers.Session;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutionException;

public class GestionAbsense implements Initializable {
    private String last_select = "";
    //
    private ArrayList<Apprenant> list_apprenants = new ArrayList<>();
    private ArrayList<Pane> components_apprenants = new ArrayList<>();
    private ArrayList<Pane> selected_apprenants = new ArrayList<>();
    //
    private ArrayList<Seance> list_seances = new ArrayList<>();
    private ArrayList<Pane> components_seances = new ArrayList<>();
    private Pane selected_seance = null;
    //
    @FXML
    FlowPane cont_apprenants;
    @FXML
    ChoiceBox slct_groupe;
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
        fillComboBox();
        slct_groupe.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                displayLearners();
            }
        });
        //displayLearners();
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
            //
            int inserted_data_nb = 0;
            int not_inserted_data_nb = 0;
            //
            for (Pane comp_apprenant : selected_apprenants) {
                Double retard = -1.0;
                Double absence = -1.0;
                //
                if (comp_apprenant.getStyleClass().contains("apprenant_card_abs")) {
                    retard = -1.0;
                    absence = 1.0;
                } else if (comp_apprenant.getStyleClass().contains("apprenant_card_retS")) {
                    retard = 1.0;
                    absence = -1.0;
                } else if (comp_apprenant.getStyleClass().contains("apprenant_card_retB")) {
                    retard = 0.0;
                    absence = -1.0;
                }
                if (retard != -1 || absence != -1) {
                    //INSERT SEANCE
                    Calendar pk_date = Calendar.getInstance();
                    SeanceDao seanceDao = new SeanceDao();
                    FormateurDao formateurDao = new FormateurDao();
                    Formateur user_data = (formateurDao.get(Session.cin)).get();
                    boolean seance_insert_res = seanceDao.save(new Seance(pk_date, user_data.getMatricule(), user_data.getGroupe(), pk_date, pk_date));
                    if (seance_insert_res) {
                        int pos_apprenant = Integer.parseInt(comp_apprenant.getProperties().get("index_app").toString());
                        Apprenant apprenant = list_apprenants.get(pos_apprenant);
                        //
                        Calendar h_abs = Calendar.getInstance();
                        //
                        AbsenceDao absenceDao = new AbsenceDao();
                        boolean insert_res = absenceDao.save(new Absence(h_abs, apprenant.getCin(), pk_date, false, retard, absence));
                        if (!insert_res) {
                            System.out.println("Not saved");
                            not_inserted_data_nb++;
                            //new Alert(Alert.AlertType.ERROR, "Les données n'ont pas été sauvegardées").showAndWait();
                        } else {
                            System.out.println("Saved");
                            inserted_data_nb++;
                            //new Alert(Alert.AlertType.INFORMATION, "Les données ont été sauvegardées").showAndWait();
                        }
                    } else {
                        System.out.println("Seance not saved");
                        //new Alert(Alert.AlertType.INFORMATION, "Les données ont été sauvegardées").showAndWait();
                    }
                }
            }
            //
            new Alert(Alert.AlertType.INFORMATION, String.format("Nombre des données sauvegardées : %d \nNombre des données non sauvegardées : %d", inserted_data_nb, not_inserted_data_nb)).showAndWait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            switch (e.getMessage()) {
                case "1":
                    new Alert(Alert.AlertType.ERROR, "Veuillez sélectionner au moins 1 apprenant").showAndWait();
                    break;
                default:
                    new Alert(Alert.AlertType.ERROR, "Erreur inconnue").showAndWait();
            }
        }
    }

    //
    private void fillComboBox() {
        try {
            FormateurDao formateurDao = new FormateurDao();
            ArrayList<Integer> niveaux = formateurDao.getNiveaux(Session.cin);
            if (niveaux != null) {
                if (niveaux.size() > 0) {
                    for (Integer niveau : niveaux) {
                        slct_groupe.getItems().add(String.format("Groupe %d", niveau));
                    }
                    slct_groupe.getSelectionModel().selectFirst();
                    displayLearners();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(Alert.AlertType.ERROR, "Erreur inconnue").showAndWait();
        }
    }

    private void displayLearners() {
        if (!last_select.equals(slct_groupe.getValue().toString())) {
            try {
                list_apprenants.clear();
                components_apprenants.clear();
                cont_apprenants.getChildren().clear();
                //
                ApprenantDao apprenantDao = new ApprenantDao();
                ArrayList<String> splitted = new ArrayList<>(Arrays.asList(slct_groupe.getValue().toString().split(" ")));
                list_apprenants = apprenantDao.getAllByFormateur(Session.cin, Integer.parseInt(splitted.get(1)));
                if (list_apprenants != null) {
                    if (list_apprenants.size() > 0) {
                        for (Apprenant apprenant : list_apprenants) {
                            cont_apprenants.getChildren().add(make_apprenant(apprenant));
                        }
                    }
                }
                last_select = slct_groupe.getValue().toString();
            } catch (Exception e) {
                e.printStackTrace();
                new Alert(Alert.AlertType.ERROR, "Erreur inconnue").showAndWait();
            }
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
        Label grp_niv = new Label(String.format("%s | Groupe: %s", apprenant.getGroupe(), apprenant.getNiveau()));
        //
        HBox h_cont_ = new HBox();
        h_cont_.setAlignment(Pos.CENTER_LEFT);
        Label lb_slct = new Label("Nature: ");
        ChoiceBox slct_choice = new ChoiceBox();
        slct_choice.getItems().addAll("Présent", "Absent", "Retard <= 30min", "Retard > 30min");
        slct_choice.getSelectionModel().selectFirst();
        //
        slct_choice.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                String class_name = "";
                switch (slct_choice.getValue().toString()) {
                    case "Présent":
                        class_name = "EMPTY";
                        break;
                    case "Absent":
                        class_name = "apprenant_card_abs";
                        break;
                    case "Retard <= 30min":
                        class_name = "apprenant_card_retS";
                        break;
                    case "Retard > 30min":
                        class_name = "apprenant_card_retB";
                        break;
                    default:
                        class_name = "EMPTY";
                }
                if (slct_choice.getValue().toString().equals("Présent")) {
                    selected_apprenants.remove(container);
                } else {
                    if (!selected_apprenants.contains(container))
                        selected_apprenants.add(container);
                }
                //
                if (!container.getStyleClass().contains(class_name)) {
                    for (int i = 0; i < container.getStyleClass().size(); i++) {
                        String s_class = container.getStyleClass().get(i);
                        if (!s_class.equals("apprenant_card")) {
                            container.getStyleClass().remove(s_class);
                        }
                    }
                    //
                    container.getStyleClass().add(class_name);
                }
            }
        });
        //
        h_cont_.getChildren().addAll(lb_slct, slct_choice);
        //
        cont_data.getChildren().addAll(nom, cne, grp_niv, h_cont_);
        //
        //
        /*Circle indicator = new Circle();
        indicator.setRadius(10);
        indicator.getStyleClass().add("indicator");
        //
        container.getChildren().addAll(cont_data, indicator);*/
        container.getChildren().add(cont_data);
        container.getProperties().put("index_app", components_apprenants.size());
        //
        container.setOnMouseClicked(e -> {
            System.out.println(selected_apprenants.size());
            /*if (container.getStyleClass().contains("apprenant_card_active")) {
                selected_apprenants.remove(container);
                container.getStyleClass().remove("apprenant_card_active");
            } else {
                container.getStyleClass().add("apprenant_card_active");
                selected_apprenants.add(container);
            }*/
        });
        //
        //container.managedProperty().bind(container.visibleProperty());
        components_apprenants.add(container);
        return container;
    }

    //
}
