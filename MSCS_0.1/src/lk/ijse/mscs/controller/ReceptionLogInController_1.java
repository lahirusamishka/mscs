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
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class ReceptionLogInController_1 implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label lblErrorMsg1;
    @FXML
    private JFXTextField txtUserNameR;
    @FXML
    private JFXPasswordField txtPasswordR;
    @FXML
    private Label lblErrorMsgreception;
    @FXML
    private Label lblErrorMsgOperar;
    @FXML
    private Label lblErrorMsgAdmin;
    @FXML
    private Label lblErrorMsgreception1;
    @FXML
    private Label lblErrorMsgOperar1;
    @FXML
    private Label lblErrorMsgAdmin1;
    @FXML
    private JFXTextField txtUserNameO;
    @FXML
    private JFXPasswordField txtPasswordO;
    @FXML
    private JFXTextField txtUserNameA;
    @FXML
    private JFXPasswordField txtPasswordA;
    @FXML
    private StackPane stackPane3;

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
    private void btnBackActionReception(MouseEvent event) throws IOException {
        rootPane.setBackground(Background.EMPTY);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Are you sure system exit ?");
        alert.initStyle(StageStyle.UNDECORATED);
        GaussianBlur blur = new GaussianBlur(20);
        stackPane3.setEffect(blur);
        rootPane.setStyle("-fx-background-color:   #233a3a");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
            rootPane.setStyle("-fx-background-color:   #233a3a");
        } else {
            GaussianBlur blur2 = new GaussianBlur(0);
            stackPane3.setEffect(blur2);
            rootPane.setStyle("-fx-background-color:   #233a3a");
        }
    }

    @FXML
    private void btnNextActionOperator(MouseEvent event) throws FileNotFoundException, IOException {
        Properties dbProperties = new Properties();
        File dbFile = new File("settings/dbsettings.properties");
        FileReader dbReader = new FileReader(dbFile);
        dbProperties.load(dbReader);
        String Username = dbProperties.getProperty("operatorusername");
        String Password = dbProperties.getProperty("operatorpassword");
        if (!txtUserNameO.getText().matches(Username)) {
            lblErrorMsgOperar1.setText("Check username is incorrect");
            if (!txtPasswordO.getText().matches(Password)) {
                lblErrorMsgOperar.setText("Check password is incorrect");
            }
        } else {
            lblErrorMsgOperar1.setText("");
            if (!txtPasswordO.getText().matches(Password)) {
                lblErrorMsgOperar.setText("Check password is incorrect");
            } else {
                lblErrorMsgOperar.setText("");
                rootPane.getChildren().clear();
                AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/OperatorHome.fxml"));
                FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
                ft.setFromValue(0.0);
                ft.setToValue(1.0);
                ft.play();
                rootPane.getChildren().add(ap);
            }
        }
    }

    @FXML
    private void btnBackActionOperator(MouseEvent event) {
        rootPane.setBackground(Background.EMPTY);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Shut down indows");
        alert.setHeaderText("Look, a Confirmation Dialog");
        alert.setContentText("are you sure system exit ?");
        GaussianBlur blur = new GaussianBlur(20);
        stackPane3.setEffect(blur);
        rootPane.setStyle("-fx-background-color:   #233a3a");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
            rootPane.setStyle("-fx-background-color:   #233a3a;");
        } else {
            rootPane.setStyle("-fx-background-color:   #233a3a;");
            GaussianBlur blur2 = new GaussianBlur(0);
            stackPane3.setEffect(blur2);
        }
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
        rootPane.setBackground(Background.EMPTY);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setContentText("Are you sure system exit ?");
        alert.initStyle(StageStyle.UNDECORATED);
        GaussianBlur blur = new GaussianBlur(20);
        stackPane3.setEffect(blur);
        rootPane.setStyle("-fx-background-color:   #233a3a");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            System.exit(0);
            rootPane.setStyle("-fx-background-color:   #233a3a");
        } else {
            GaussianBlur blur2 = new GaussianBlur(0);
            stackPane3.setEffect(blur2);
            rootPane.setStyle("-fx-background-color:   #233a3a");
        } 
    }
}
