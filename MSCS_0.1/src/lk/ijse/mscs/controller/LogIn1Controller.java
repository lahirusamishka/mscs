/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class LogIn1Controller implements Initializable {

    @FXML
    private JFXTextField txtUserNameR;
    @FXML
    private JFXPasswordField txtPasswordR;
    @FXML
    private Label lblErrorMsgreception;
    @FXML
    private Label lblErrorMsgreception1;
    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnNextActionReception(MouseEvent event) throws FileNotFoundException, IOException {
   Properties dbProperties = new Properties();
        File dbFile = new File("settings/dbsettings.properties");
        FileReader dbReader = new FileReader(dbFile);
        dbProperties.load(dbReader);
        String Username = dbProperties.getProperty("receptionusername");
        String Password = dbProperties.getProperty("receptionpassword");
        if (!txtUserNameR.getText().matches(Username)) {
            lblErrorMsgreception1.setText("Check username is incorrect");
            if (!txtPasswordR.getText().matches(Password)) {
                lblErrorMsgreception.setText("Check password is incorrect");
            }
        } else {
            lblErrorMsgreception1.setText("");
            if (!txtPasswordR.getText().matches(Password)) {
                lblErrorMsgreception.setText("Check password is incorrect");
            } else {
                Parent startRoot = null;
                startRoot = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/ReceptionHome.fxml"));
                Scene scene = new Scene(startRoot);
                Stage Stage = new Stage();
                Stage.setScene(scene);
                Stage.initStyle(StageStyle.UNDECORATED);
                Stage.getIcons().add(new javafx.scene.image.Image("/lk/ijse/mscs/img/Edit Property_24px.png"));
                Stage.setTitle("Mobile Shop Communication Service-MSCS");
                Stage.show();
                rootPane.getScene().getWindow().hide();
            }
        }
    }

    @FXML
    private void btnBackActionReception(MouseEvent event) {
         System.exit(0);
    }
    
}
