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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
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
public class AdminHomeController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private JFXButton btnAddItem;
    @FXML
    private JFXButton btnAddReception;
    @FXML
    private JFXButton btnAddRepar;

    @FXML
    private AnchorPane rootPaneMain;
    private JFXButton btnAccessoris;
    @FXML
    private JFXButton btnGRN;
    @FXML
    private JFXButton btnSupplier;
    @FXML
    private JFXButton btnSupplierOrder;
    @FXML
    private Label setTimeAndDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            LoadHome();
        } catch (IOException ex) {
            Logger.getLogger(AdminHomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void AddItemAction(MouseEvent event) throws IOException {
        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/ItemForm.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);

    }

    @FXML
    private void AddReceptionAction(MouseEvent event) throws IOException {
        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/ReceptionForm.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);
    }

    @FXML
    private void AddReparAction(MouseEvent event) throws IOException {
        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/OperatorForm.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);
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
                        startRoot = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/Login2.fxml"));
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
    private void btnGRNAction(MouseEvent event) throws IOException {
        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/GRNForm.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);
    }

    @FXML
    private void btnSupplierAction(MouseEvent event) throws IOException {
        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/SupplierForm.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);
    }

    @FXML
    private void btnSupplierOrderAction(MouseEvent event) throws IOException {
        //
        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/SupplierOrderForm.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);

    }

    @FXML
    private void colorAction(ActionEvent event) {

//        Node btnNode = (Node) event.getSource();
//        Node[] btnList = {btnAccessoris, btnAddItem, btnAddReception, btnAddRepar, btnGRN, btnSupplier, btnSupplierOrder};
//        for (Node node : btnList) {
//            node.getStyleClass().remove("btnSelected");
//            if (!node.getStyleClass().contains("btn")) {
//                node.getStyleClass().add("btn");
//            }
//        }
//
//        btnNode.getStyleClass().remove("btn");
//        if (!btnNode.getStyleClass().contains("btnSelected")) {
//            btnNode.getStyleClass().add("btnSelected");
//        }
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
    private void btnAboutAction(MouseEvent event) throws IOException {
//        Stage stage = new Stage();
//        Parent root = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/About.fxml"));
//        Scene scene = new Scene(root);
//        stage.initStyle(StageStyle.UNDECORATED);
//        stage.setScene(scene);
//        stage.show();

    }

    private void LoadHome() throws IOException {
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
    }

}
