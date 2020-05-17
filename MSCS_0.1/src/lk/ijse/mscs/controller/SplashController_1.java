/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class SplashController_1 implements Initializable {

    @FXML
    private AnchorPane rootPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        new SplahScreen().start();
    }

    class SplahScreen extends Thread {

        @Override
        public void run() {
            try {
                Thread.sleep(800);
                Platform.runLater(() -> {
                    try {
                        Parent startRoot = null;
                        startRoot = FXMLLoader.load(getClass().getResource("/lk/ijse/mscs/view/ReceptionLogIn_1.fxml"));
                        Scene scene = new Scene(startRoot);
                        Stage Stage = new Stage();
                        Stage.setScene(scene);
                        Stage.initStyle(StageStyle.UNDECORATED);
                        Stage.getIcons().add(
                                new javafx.scene.image.Image("/lk/ijse/mscs/img/Edit Property_24px.png"));
                        Stage.setTitle("Mobile Shop Communication Service-MSCS");
                        Stage.show();
                        rootPane.getScene().getWindow().hide();
                    } catch (IOException ex) {
                        Logger.getLogger(SplashController_1.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            } catch (InterruptedException ex) {
                Logger.getLogger(SplashController_1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
