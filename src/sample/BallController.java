package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.io.IOException;

public class BallController  {
    @FXML
    public AnchorPane BallRoot;

    @FXML
    public Circle ballID;

    circleShapeController obj;


    public void initialize() throws Exception{

    }

    @FXML
    public void play(ActionEvent event) throws IOException {
        Bounds bounds = BallRoot.getBoundsInLocal();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200),
                new KeyValue(ballID.layoutYProperty(), ballID.getLayoutY()-50)));
        timeline.setCycleCount(1);

        Timeline t2 = new Timeline(new KeyFrame(Duration.millis(2000),
                new KeyValue(ballID.layoutYProperty(), bounds.getMaxY()+ballID.getRadius()-50)));
        t2.setCycleCount(1);
        timeline.play();
        timeline.setOnFinished(actionEvent -> t2.play());
    }
}
