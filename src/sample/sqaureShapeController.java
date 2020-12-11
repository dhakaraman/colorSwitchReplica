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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rotatingSpeed();
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

    @Override
    protected void movingSpeed() {
        double dist = line1.getLayoutY();
        if(dist>800){
            dist = -800;
        }
        dist++;
        line1.setLayoutY(dist);
        line2.setLayoutY(dist);
        line3.setLayoutY(dist);
        line4.setLayoutY(dist);
        sqrID.setLayoutY(dist);
    }

    @Override
    protected void rotatingSpeed() {
        Rotate r1 = new Rotate();
        Rotate r2 = new Rotate();
        Rotate r3 = new Rotate();
        Rotate r4 = new Rotate();
        Rotate r5 = new Rotate();

        r1.setPivotX(51);
        r1.setPivotY(51);
        line1.getTransforms().add(r1);
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

        helper(r1);
        helper(r2);
        helper(r3);
        helper(r4);
        helper(r5);

    }

}
