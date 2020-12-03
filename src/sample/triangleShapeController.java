package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;

import javax.xml.crypto.dsig.Reference;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;



public class triangleShapeController extends Obstracle implements Initializable{
    @FXML
    AnchorPane trianglePane;
    @FXML
    private Line tri1;

    @FXML
    private Line tri2;

    @FXML
    private Line tri3;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Rotate r1 = new Rotate();
        Rotate r2 = new Rotate();
        Rotate r3 = new Rotate();

        r1.setPivotX(100);
        r1.setPivotY(70);
        tri1.getTransforms().add(r1);

        r2.setPivotX(100);
        r2.setPivotY(70);
        tri2.getTransforms().add(r2);

        r3.setPivotX(100);
        r3.setPivotY(70);
        tri3.getTransforms().add(r3);

        timeset(r1,r2,r3);

    }

    private void timeset(Rotate r1, Rotate r2, Rotate r3) {
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
    }

    @Override
    public boolean checkColor(BallController ball) {
        return false;
    }
}


