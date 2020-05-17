/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.mscs.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author samishka
 */
public class HomeController implements Initializable {

 
    @FXML
    private ImageView imgView;
    @FXML
    private Label DateNew;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dataset();
    }

    public void init() {
//        Image BGd = new Image("lk/ijse/mscs/img/TWILIGHT_SAGA_drama_fantasy_romance_movie_film_vampire_4256x2832.jpg");
//        //this.imgView = new ImageView(images[0]);
//        Timeline timeLine = new Timeline();
//        Collection<KeyFrame> frames = timeLine.getKeyFrames();
//        //for (Image img : images) {
//            frames.add(new KeyFrame(Duration.millis(10000), e -> imgView.setImage(BGd)));
//        //}
//
//        timeLine.setCycleCount(Timeline.INDEFINITE);
//        timeLine.play();
    }

    private void dataset() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD E");
        DateNew.setText(dateFormat.format(date));
    }

}
