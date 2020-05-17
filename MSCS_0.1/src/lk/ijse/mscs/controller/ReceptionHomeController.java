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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class ReceptionHomeController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private AnchorPane rootPaneMain;
    @FXML
    private JFXButton btnAddItem;
    @FXML
    private JFXButton btnAddReception;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        try {
//            // TODO
//            loadHome();
//        } catch (IOException ex) {
//            Logger.getLogger(ReceptionHomeController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    private void PlaceOrderAction(MouseEvent event) throws IOException {
        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/PlaceOrder.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);
    }

    private void CheckWarrantyAction(MouseEvent event) throws IOException {

    }

    @FXML
    private void btnLogOutAction(MouseEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Log out windows");
        alert.setHeaderText("Reception Logout");
        alert.setContentText("are you sure ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Parent startRoot = null;
                        startRoot = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/LogIn1.fxml"));
                        Scene scene = new Scene(startRoot);
                        Stage Stage = new Stage();
                        Stage.setScene(scene);
                        Stage.initStyle(StageStyle.UNDECORATED);
                        Stage.getIcons().add(
                                new javafx.scene.image.Image("/lk/ijse/mscs/img/Edit Property_24px.png"));
                        Stage.setTitle("Mobile Shop Communication Service-MSCS");
                        Stage.show();
                        rootPane.getScene().getWindow().hide();
        }
    }

    @FXML
    private void viewCustomerAction(MouseEvent event) throws IOException {
        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/CustomerForm.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);
    }

    @FXML
    private void btnCustomerOrderAction(MouseEvent event) throws IOException {

        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/PlaceOrder.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);
    }

    @FXML
    private void ViewItemAction(MouseEvent event) throws IOException {
        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/ItemForm.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);

    }

    @FXML
    private void btnWarrantyAction(MouseEvent event) throws IOException {
        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/WarrantyForm.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);
    }

    @FXML
    private void btnFinishedAction(MouseEvent event) throws IOException {
        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/FinishedOrders.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);
    }

    @FXML
    private void btnHomeAction(MouseEvent event) throws IOException {
        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/Home.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);
    }

    @FXML
    private void btnAboutAction(MouseEvent event) {
    }

    private void loadHome() throws IOException {
        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/Home.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);
    }

    @FXML
    private void btnClose(MouseEvent event) {
        rootPane.getScene().getWindow().hide();
    }

}
