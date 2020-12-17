package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.*;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.media.*;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;


public class settingsController {
    @FXML
    private Slider slider;

    public void initialize() throws Exception {
//        Media sound = new Media(GameElements.class.getResource("/Sound Effects/ColorSwitchGame.mp3").toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.setAutoPlay(true);
//        mediaPlayer.setStartTime(Duration.seconds(0));
//        mediaPlayer.setStopTime(Duration.seconds(50));

        slider.setValue(Main.mediaPlayer.getVolume() * 100);
//        slider.setValue(GameElements.mediaPlayer.getVolume() * 100);
        slider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Main.mediaPlayer.setVolume(slider.getValue() / 100);
//                GameElements.mediaPlayer.setVolume(slider.getValue() / 100);
            }
        });

    }
}
