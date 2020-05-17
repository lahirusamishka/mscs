/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class AboutController implements Initializable {

    @FXML
    private AnchorPane stage1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        rootPane.getChildren().clear();
//            AnchorPane ap = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/AdminHome.fxml"));
//            FadeTransition ft = new FadeTransition(Duration.millis(500), ap);
//            ft.setFromValue(0.0);
//            ft.setToValue(1.0);
//            ft.play();
//            rootPane.getChildren().add(ap);
    }    

    @FXML
    private void btnPaneCloseAboutAction(MouseEvent event) {
       ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void cloce(ActionEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    private void sssd(MouseEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
    
}
