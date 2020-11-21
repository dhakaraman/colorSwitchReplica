package sample;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class sqaureShapeController implements Initializable {

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
    
    private void timeset(Rotate rotation, Rotate r2) {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(rotation.angleProperty(), 36000)));
        timeline.play();

        Timeline t2 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(r2.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(r2.angleProperty(), 36000)));
        t2.play();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Rotate rotation = new Rotate();
        Rotate r2 = new Rotate();
        Rotate r3 = new Rotate();
        Rotate r4 = new Rotate();
        rotation.setPivotX(50);
        rotation.setPivotY(150);
        line1.getTransforms().add(rotation);
        r2.setPivotX(50);
        r2.setPivotY(-50);
        line2.getTransforms().add(r2);
        r3.setPivotX(50);
        r3.setPivotY(50);
        line3.getTransforms().add(r3);
        r4.setPivotX(50);
        r4.setPivotY(50);
        line4.getTransforms().add(r4);

        timeset(rotation, r2);
        timeset(r3, r4);
    }
}
