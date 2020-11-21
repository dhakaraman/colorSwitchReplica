package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
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

public class BallController {
    @FXML
    public AnchorPane BallRoot;

    @FXML
    public Circle ball;

    public void play(MouseEvent m) {
//        if (k.getCode().equals(KeyCode.SPACE)) {
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200),
                    new KeyValue(ball.layoutYProperty(), ball.getLayoutY() - 65)));
            timeline.setCycleCount(1);
            Timeline t2 = new Timeline(new KeyFrame(Duration.millis(800),
                    new KeyValue(ball.layoutYProperty(), BallRoot.getLayoutBounds().getMaxY() + ball.getRadius())));
            t2.setCycleCount(1);
            timeline.play();
            timeline.setOnFinished(actionEvent -> t2.play());

        }
}
