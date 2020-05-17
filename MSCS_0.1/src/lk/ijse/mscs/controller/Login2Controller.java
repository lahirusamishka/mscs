/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class Login2Controller implements Initializable {

    @FXML
    private JFXTextField txtUserNameA;
    @FXML
    private JFXPasswordField txtPasswordA;
    @FXML
    private Label lblErrorMsgAdmin;
    @FXML
    private Label lblErrorMsgAdmin1;
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
    private void btnNextActionAdmin(MouseEvent event) throws IOException {
        Properties dbProperties = new Properties();
        File dbFile = new File("settings/dbsettings.properties");
        FileReader dbReader = new FileReader(dbFile);
        dbProperties.load(dbReader);
        String Username = dbProperties.getProperty("adminusername");
        String Password = dbProperties.getProperty("adminpassword");
        if (!txtUserNameA.getText().matches(Username)) {
            lblErrorMsgAdmin1.setText("Check username is incorrect");
            if (!txtPasswordA.getText().matches(Password)) {
                lblErrorMsgAdmin.setText("Check password is incorrect");
            }
        } else {
            lblErrorMsgAdmin1.setText("");
            if (!txtPasswordA.getText().matches(Password)) {
                lblErrorMsgAdmin.setText("Check password is incorrect");
            } else {
                Parent startRoot = null;
                startRoot = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/AdminHome.fxml"));
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
    private void btnBackActionAdmin(MouseEvent event) {
//    rootPane.setBackground(Background.EMPTY);
//        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//        alert.setContentText("Are you sure system exit ?");
//        alert.initStyle(StageStyle.UNDECORATED);
//        GaussianBlur blur = new GaussianBlur(20);
//       // stackPane3.setEffect(blur);
//        rootPane.setStyle("-fx-background-color:   #233a3a");
//        Optional<ButtonType> result = alert.showAndWait();
//        if (result.get() == ButtonType.OK) {
//            System.exit(0);
//            rootPane.setStyle("-fx-background-color:   #233a3a");
//        } else {
//            GaussianBlur blur2 = new GaussianBlur(0);
//            //stackPane3.setEffect(blur2);
//            rootPane.setStyle("-fx-background-color:   #233a3a");
//        }
        System.exit(0);
    }

}
