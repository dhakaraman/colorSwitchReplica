package sample;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class sqaureShapeController extends Obstracle implements Initializable {
    @FXML
    AnchorPane squareRoot;

    @FXML
    public Polygon sqrID;

    @FXML
    public Line line1;

    @FXML
    public Line line2;

    @FXML
    public Line line3;

    @FXML
    public Line line4;

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

        Rotate r5 = new Rotate();

        rotation.setPivotX(51);
        rotation.setPivotY(51);
        line1.getTransforms().add(rotation);
        r2.setPivotX(51);
        r2.setPivotY(51);
        line2.getTransforms().add(r2);
        r3.setPivotX(51);
        r3.setPivotY(51);
        line3.getTransforms().add(r3);
        r4.setPivotX(51);
        r4.setPivotY(51);
        line4.getTransforms().add(r4);


        r5.setPivotX(51);
        r5.setPivotY(51);
        sqrID.getTransforms().add(r5);

        Timeline t2 = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(r5.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(r5.angleProperty(), 36000)));
        t2.play();


        timeset(rotation, r2);
        timeset(r3, r4);
    }

    @Override
    public boolean checkColor(BallController ball) {

        if(ball.ballID.getFill().equals(line1.getFill())){
            if(line2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(line3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(line4.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            else
                return false;
        }
        else if(ball.ballID.getFill().equals(line2.getFill())){
            if(line1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(line3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(line4.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            else
                return false;
        }
        else if(ball.ballID.getFill().equals(line3.getFill())){
            if(line2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(line1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(line4.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            else
                return false;
        }
        else {
            if(line2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(line3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(line1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            else
                return false;
        }
    }
}
