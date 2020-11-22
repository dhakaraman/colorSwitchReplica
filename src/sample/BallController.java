package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BallController  {
    @FXML
    public AnchorPane BallRoot;

    @FXML
    public Circle ball;

    public void initialize() throws Exception{

    }

    @FXML
    public void play(ActionEvent event) throws IOException {
        Bounds bounds = BallRoot.getBoundsInLocal();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200),
                new KeyValue(ball.layoutYProperty(), ball.getLayoutY() - 65)));
        timeline.setCycleCount(1);
        Timeline t2 = new Timeline(new KeyFrame(Duration.millis(600),
                new KeyValue(ball.layoutYProperty(), bounds.getMaxY()+ball.getRadius())));
        t2.setCycleCount(1);
        timeline.play();
        timeline.setOnFinished(actionEvent -> t2.play());
    }
}
