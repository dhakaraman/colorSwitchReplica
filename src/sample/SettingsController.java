package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
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


public class SettingsController {
    @FXML
    private Slider slider;

    @FXML
    private AnchorPane settingRoot;

    public void initialize() throws Exception {

        slider.setValue(Main.mediaPlayer.getVolume() * 100);

        slider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                Main.mediaPlayer.setVolume(slider.getValue() / 100);

            }
        });

    }

    public void themeManager() throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Themes.fxml"));
        settingRoot.getChildren().setAll(pane);
    }
    public void backToMain() throws Exception{
        GameElements.addMusic("/Sound Effects/button.wav");
        MainPageController.primaryStage.close();
    }

    public void howToPlay(MouseEvent mouseEvent) {
        GameElements.addMusic("/Sound Effects/button.wav");
        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Tap, Tap, Tap to get the ball past each obstacle. Follow the colour pattern to cross each obstacle. Timing and Patience are the keys to victory. Earn stars and enjoy the game!.", ButtonType.OK, ButtonType.CANCEL);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK){
            alert.hide();
        }
    }
}
