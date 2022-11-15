package com.example.demo3;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    public ImageView view;
    @FXML
    public Button stop;

    public ImageCollection imgs = new ImageCollection();
    public Iterator iter_main = imgs.getIterator();
    public Timeline timeline = new Timeline();


    public void onNext(ActionEvent actionEvent) {
        if (iter_main.hasNext()) {
            Image name = (Image) iter_main.next();
            view.setImage(name);
        }
    }

    public void OnBack(ActionEvent event) {
        if (iter_main.hasPreview()) {
            Image name = (Image) iter_main.preview();
            view.setImage(name);
        }
    }

    public void onPlay(ActionEvent event) {
        timeline.play();
    }

    public void onStop(ActionEvent event) {
        timeline.stop();
    }
    @Override
public void initialize(URL url, ResourceBundle resourceBundle){
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.getKeyFrames().add(new KeyFrame(new Duration(1000), new EventHandler() {
            @Override
            public void handle(Event event) {
                if (iter_main.hasNext()) {
                    Image name = (Image) iter_main.next();
                    view.setImage(name);
                }
            }
        }));
}

}

