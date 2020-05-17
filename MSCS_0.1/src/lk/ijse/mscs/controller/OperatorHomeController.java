/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class OperatorHomeController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private AnchorPane rootPaneMain;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnLogOutAction(MouseEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log out windows");
        alert.setHeaderText("Operator Logout");
        alert.setContentText("are you sure ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            rootPaneMain.getChildren().clear();
            AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/ReceptionLogIn.fxml"));
            FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            rootPaneMain.getChildren().add(ap);

        } else {
            
        }

    }

    @FXML
    private void btnPendingOrderAction(MouseEvent event) {

    }

    @FXML
    private void btnAccessoriesAction(MouseEvent event) throws IOException {
        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/AccessoriesForm.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);
    }

    @FXML
    private void btnFinishedOrderAction(MouseEvent event) throws IOException {
        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/FinishedOrders.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);
    }

}
