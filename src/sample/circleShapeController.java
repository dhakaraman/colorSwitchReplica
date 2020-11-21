package sample;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class circleShapeController {

    @FXML
    private Arc arc1;

    @FXML
    private Arc arc2;

    @FXML
    private Arc arc3;

    @FXML
    private Arc arc4;


    @FXML
    private void initialize() {

        Rotate r1 = new Rotate();
        Rotate r2 = new Rotate();
        Rotate r3 = new Rotate();
        Rotate r4 = new Rotate();

        r1.setPivotX(0);
        r1.setPivotY(0);
        arc1.getTransforms().add(r1);

        r1.setPivotX(0);
        r1.setPivotY(0);
        arc2.getTransforms().add(r2);

        r1.setPivotX(0);
        r1.setPivotY(0);
        arc3.getTransforms().add(r3);

        r1.setPivotX(0);
        r1.setPivotY(0);
        arc4.getTransforms().add(r4);

        timeset(r1, r2, r3, r4);

    }

    private void timeset(Rotate r1, Rotate r2, Rotate r3, Rotate r4) {
        Timeline t1 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(r1.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(r1.angleProperty(), 36000)));
        t1.play();

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

}
