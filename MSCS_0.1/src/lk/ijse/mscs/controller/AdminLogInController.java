/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class AdminLogInController implements Initializable {

    @FXML
    private AnchorPane rootPane;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    private Label lblErrorMsg;

    @FXML
    void btnNextAction(MouseEvent event) throws IOException, SQLException {

//        String account = "admin";
//        String name = txtUserName.getText();
//        String pass = txtPassword.getText();
//        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "samishka");
//        Statement st = (Statement) conn.createStatement();
//
//        String query = "select * from User where Account = ? and Name = ? and Password = ?";
//        PreparedStatement pst = conn.prepareStatement(query);
//
//        pst.setString(1, account);
//        pst.setString(2, name);
//        pst.setString(3, pass);
//        ResultSet rs = pst.executeQuery();
//
//        if (rs.next()) {
            rootPane.getChildren().clear();
            AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/AdminHome.fxml"));
            FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
            ft.setFromValue(0.0);
            ft.setToValue(1.0);
            ft.play();
            rootPane.getChildren().add(ap);
//        } else {
//            txtPassword.setStyle("-fx-text-fill: red;");
//            txtPassword.setStyle(":pressed {-fx-background-color: #1c2f2f;}");
//            txtPassword.setPromptText("Invalid Password");
//            txtUserName.setStyle("-fx-text-fill: red;");
//            txtUserName.setStyle(":pressed {-fx-background-color: #1c2f2f;}");
//            txtUserName.setPromptText("Invalid Username");
//            lblErrorMsg.setText("check your username and password!");
//            System.out.println("Invalid Login");
//        }

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void btnBackAction(MouseEvent event) throws IOException {
        rootPane.getChildren().clear();
        AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/LogIn.fxml"));
        FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
        ft.setFromValue(0.0);
        ft.setToValue(1.0);
        ft.play();
        rootPane.getChildren().add(ap);

    }

}
