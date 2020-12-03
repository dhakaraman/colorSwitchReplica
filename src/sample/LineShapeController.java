package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class LineShapeController extends Obstracle implements Initializable {



    @FXML
    private Line line1;

    @FXML
    private Line line2;

    @FXML
    private Line line3;

    @FXML
    private Line line4;

    @FXML
    private Line line5;

    @FXML
    private Line line6;

    @FXML
    private Line line7;

    @FXML
    private Line line8;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Rotate r1 = new Rotate();
        Rotate r2 = new Rotate();
        Rotate r3 = new Rotate();
        Rotate r4 = new Rotate();

        Rotate r5 = new Rotate();
        Rotate r6 = new Rotate();
        Rotate r7 = new Rotate();
        Rotate r8 = new Rotate();

        r1.setPivotX(32);
        r1.setPivotY(0);
        line1.getTransforms().add(r1);

        r2.setPivotX(32);
        r2.setPivotY(0);
        line2.getTransforms().add(r2);

        r3.setPivotX(32);
        r3.setPivotY(0);
        line3.getTransforms().add(r3);

        r4.setPivotX(32);
        r4.setPivotY(0);
        line4.getTransforms().add(r4);

        r5.setPivotX(32);
        r5.setPivotY(0);
        line5.getTransforms().add(r5);

        r6.setPivotX(32);
        r6.setPivotY(0);
        line6.getTransforms().add(r6);

        r7.setPivotX(32);
        r7.setPivotY(0);
        line7.getTransforms().add(r7);

        r8.setPivotX(32);
        r8.setPivotY(0);
        line8.getTransforms().add(r8);

        timeset1(r1,r2,r3,r4);
        timeset2(r5,r6,r7,r8);

    }

    private void timeset1(Rotate r1, Rotate r2, Rotate r3, Rotate r4) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(r1.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(r1.angleProperty(), 36000)));
        timeline.play();

        Timeline t2 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(r2.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(r2.angleProperty(), 36000)));
        t2.play();

        Timeline t3 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(r3.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(r3.angleProperty(), 36000)));
        t3.play();

        Timeline t4 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(r4.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(r4.angleProperty(), 36000)));
        t4.play();

    }

    private void timeset2(Rotate r1, Rotate r2, Rotate r3, Rotate r4) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(r1.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(r1.angleProperty(), -36000)));
        timeline.play();

        Timeline t2 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(r2.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(r2.angleProperty(), -36000)));
        t2.play();

        Timeline t3 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(r3.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(r3.angleProperty(), -36000)));
        t3.play();

        Timeline t4 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(r4.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(r4.angleProperty(), -36000)));
        t4.play();

    }


}
