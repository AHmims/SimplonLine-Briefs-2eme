package sample.interfaces.apprenant;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import sample.daoAPI.AbsenceDao;
import sample.domainClasses.Absence;
import sample.helpers.Connexion;
import sample.helpers.Session;

public class FichePresence implements Initializable {

    @FXML
    private Label idNom;
    @FXML
    private Label idPrenom;
    @FXML
    private ComboBox<String> idMois;
    @FXML
    private TableView<Absence> idTable;
    @FXML
    private TableColumn<Absence, Calendar> cellDate;
    @FXML
    private TableColumn<Absence, Calendar> cellHeure;
    @FXML
    private TableColumn<Absence, Double> cellAbsence;
    @FXML
    private TableColumn<Absence, Double> cellRetard;
    @FXML
    private TableColumn<Absence, Boolean> cellJustif;
    @FXML
    private HBox idHboxTable;
    public String cinUser;

    @Override

    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        idHboxTable.setMinHeight(200);
        chargercmbMois();
        Session s = null;
        cinUser = s.cin;
        chargerUserData(cinUser);

        showAbsence();
    }

    //click sur le cmb Mois
    EventHandler<ActionEvent> eventChangeMonth =
            new EventHandler<ActionEvent>() {
                public void handle(ActionEvent e) {
                    showAbsence();
                }
            };

    public void chargercmbMois() {
        idMois.getItems().clear();
        idMois.getItems().add("Janvier");
        idMois.getItems().add("F�vrier");
        idMois.getItems().add("Mars");
        idMois.getItems().add("Avril");
        idMois.getItems().add("Mai");
        idMois.getItems().add("Juin");
        idMois.getItems().add("Juillet");
        idMois.getItems().add("Ao�t");
        idMois.getItems().add("Septembre");
        idMois.getItems().add("Octobre");
        idMois.getItems().add("Novembre");
        idMois.getItems().add("D�cembre");
        idMois.getSelectionModel().select(0);
        ;
        idMois.setOnAction(eventChangeMonth);

    }

    public int moisCorrespondant(String mois) {
        int ret = 0;
        switch (mois) {
            case "Janvier":
                ret = 1;
                break;
            case "F�vrier":
                ret = 2;
                break;
            case "Mars":
                ret = 3;
                break;
            case "Avril":
                ret = 4;
                break;
            case "Mai":
                ret = 5;
                break;
            case "Juin":
                ret = 6;
                break;
            case "Juillet":
                ret = 7;
                break;
            case "Ao�t":
                ret = 8;
                break;
            case "Septembre":
                ret = 9;
                break;
            case "Octobre":
                ret = 10;
                break;
            case "Novembre":
                ret = 11;
                break;
            case "D�cembre":
                ret = 12;
                break;


        }
        return ret;

    }

    public void chargerUserData(String id) {
        String nom = "";
        String prenom = "";
        Connection con = Connexion.db_connect();

        String query = "SELECT * FROM `Utilisateur` , Apprenant WHERE Utilisateur.cin = Apprenant.cin and Utilisateur.cin ='" + id + "'";

        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);

            while (rs.next()) {

                nom = rs.getString("nom");
                prenom = rs.getString("prenom");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        idNom.setText(nom);
        idPrenom.setText(prenom);
    }

    public ObservableList<Absence> getAbsence() {
        ObservableList<Absence> ListAbsence = FXCollections.observableArrayList();
        Connection con = Connexion.db_connect();
        String query = "SELECT * FROM Absence Where Month(dateSeance)='" + moisCorrespondant(idMois.getValue()) + "' && YEAR(CURDATE()) && cinApprenant='" + cinUser + "'";
        Statement st;
        ResultSet rs;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);
            Absence abs;
            while (rs.next()) {
                Calendar dateS = Calendar.getInstance();
                Calendar heureAbs = Calendar.getInstance();
                dateS.setTime(rs.getTimestamp("dateSeance"));
                heureAbs.setTime(rs.getTimestamp("heureAbsence"));
                rs.getDate("dateSeance");


                abs = new Absence(heureAbs, rs.getString("cinApprenant"), dateS, rs.getBoolean("justifie"), rs.getDouble("retard"), rs.getDouble("absence"));

                ListAbsence.add(abs);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ListAbsence;

    }

    public void showAbsence() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        AbsenceDao absD = new AbsenceDao();
        ObservableList<Absence> ListAbsence = absD.getAllWithClause(moisCorrespondant(idMois.getValue()), cinUser);


        cellHeure.setCellValueFactory(new PropertyValueFactory<Absence, Calendar>("heureAbsence"));
        DateFormat dateFormat = DateFormat.getDateInstance();
        cellHeure.setCellFactory(col -> new TableCell<Absence, Calendar>() {
            @Override
            protected void updateItem(Calendar date, boolean empty) {
                super.updateItem(date, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(sdf.format(date.getTime()));
                }
            }
        });
        cellDate.setCellValueFactory(new PropertyValueFactory<Absence, Calendar>("dateSeance"));
        cellDate.setCellFactory(col -> new TableCell<Absence, Calendar>() {
            @Override
            protected void updateItem(Calendar date, boolean empty) {
                super.updateItem(date, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(sdf.format(date.getTime()));
                }
            }
        });
        cellAbsence.setCellValueFactory(new PropertyValueFactory<Absence, Double>("absence"));
        cellRetard.setCellValueFactory(new PropertyValueFactory<Absence, Double>("retard"));
        cellJustif.setCellValueFactory(new PropertyValueFactory<Absence, Boolean>("justifie"));

        idTable.setItems(ListAbsence);

    }

}
