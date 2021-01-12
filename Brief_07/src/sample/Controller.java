package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.db_classes.User;
import sample.helpers.Connexion;
import sample.helpers.SimplonLine;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    Pane root;
    @FXML
    TextField input_email;
    @FXML
    PasswordField input_pass;
    @FXML
    Button btn_login;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
    //
    @FXML
    private void login() {
        //CHECK IF USER IN DB, IF NOT CREATE USER | SKILLS
        //IF YES, CHECK IF THERE IS A CHANGE IN USER'S PERSONAL INFOS, IF YES UPDATE
        //ON SUCCESS, REDIRECT TO THE NEXT WINDOW BASED ON USER'S ROLE, APPRENANT / STAFF
        SimplonLine sl = new SimplonLine();
        int login_res = sl.login(input_email.getText(), input_pass.getText());
        if (login_res == 1) {
            System.out.println("In");
            Connexion db_cnx = new Connexion();
            User loged_in_user = sl.getUserData(Connexion.email);
            if (loged_in_user != null) {
                Connexion.userId = loged_in_user.getIdUser();
                boolean operation_res = false;
                //Set env globals
                Connexion.nom = String.format("%s %s", loged_in_user.getNomUser(), loged_in_user.getPrenomUser().toUpperCase());
                Connexion.avatar = loged_in_user.getAvatarUrl();
                //Check if user in DB
                User db_user = db_cnx.getUser(loged_in_user.getIdUser());
                if (db_user == null) {
                    //Add new User
                    operation_res = db_cnx.addUser(loged_in_user);
                    if(operation_res){
                        operation_res = sl.setupUser(loged_in_user.getIdUser());
                    }
                } else if (!db_user.equals(loged_in_user)) {
                    //Update DB
                    operation_res = db_cnx.updateUser(loged_in_user);
                }
                //
                if (operation_res) {
                    if (db_user == null)
                        switchScene(loged_in_user.getRoleUser().equals("ROLE_LEARNER"));
                    else //to create an alt user in DB to have access to staff instance (we have a staff login dont have a)
                        switchScene(db_user.getRoleUser().equals("ROLE_LEARNER"));
                } else System.out.println("error");
            } else System.out.println("error");
        } else {
            if (login_res == 0) System.out.println("INVALID CREDENTIALS");
            else System.out.printf("code : %d, FUNCTION : login()\n", login_res);
        }
        //switchScene();
    }

    //Method called when user authenticates successfully
    private void switchScene(boolean apprenant) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("apprenant_comp.fxml"));
            /* if(!apprenant) // staff interface
                loader = new FXMLLoader(getClass().getResource("apprenant_comp.fxml")); */
            Stage stage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(loader.load());
            stage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
