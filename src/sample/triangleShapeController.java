package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Polygon;
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
    public Line tri1;

    @FXML
    public Line tri2;

    @FXML
    public Line tri3;

    @FXML
    public Polygon innerTri;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Rotate r1 = new Rotate();
        Rotate r2 = new Rotate();
        Rotate r3 = new Rotate();
        Rotate r4 = new Rotate();

        r1.setPivotX(100);
        r1.setPivotY(70);
        tri1.getTransforms().add(r1);

        r2.setPivotX(100);
        r2.setPivotY(70);
        tri2.getTransforms().add(r2);

        r3.setPivotX(100);
        r3.setPivotY(70);
        tri3.getTransforms().add(r3);

        r4.setPivotX(100);
        r4.setPivotY(70);
        innerTri.getTransforms().add(r4);

        timeset(r1,r2,r3,r4);

    }

    private void timeset(Rotate r1, Rotate r2, Rotate r3, Rotate r4) {
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

    @Override
    public boolean checkColor(BallController ball) {

        if(ball.ballID.getFill().equals(tri1.getFill())){
            if(tri2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerTri.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(tri3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerTri.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            else
                return false;
        }
        else if(ball.ballID.getFill().equals(tri2.getFill())){
            if(tri1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerTri.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(tri3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerTri.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            else
                return false;
        }

        else {
            if(tri2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerTri.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(tri1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerTri.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            else
                return false;
        }
    }
}


