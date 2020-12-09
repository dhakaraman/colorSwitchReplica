package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class starShapeController extends Obstracle implements Initializable {
    @FXML
    public AnchorPane starRoot;

    @FXML
    public Polygon star1,star2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Rotate r1 = new Rotate();
        Rotate r2 = new Rotate();

        r1.setPivotX(250);
        r1.setPivotY(300);
        star1.getTransforms().add(r1);

        r2.setPivotX(250);
        r2.setPivotY(300);
        star2.getTransforms().add(r2);

        //timeset(r1,r2);

    }

    @Override
    public boolean checkColor(BallController ball) {
        return false;
    }

    private void timeset(Rotate r1, Rotate r2) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(r1.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(r1.angleProperty(), 36000)));
        timeline.play();

        Timeline t2 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(r2.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(r2.angleProperty(), 36000)));
        t2.play();
    }
}
