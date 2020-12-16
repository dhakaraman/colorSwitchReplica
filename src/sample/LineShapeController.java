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
    public Line line1, line2,line3,line4,line5,line6,line7,line8;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        rotatingSpeed();

    }


    @Override
    public boolean checkColor(BallController ball) {

        if(ball.ballID.getFill().equals(line1.getFill()) && ball.ballID.getFill().equals(line6.getFill()) && line1.getLayoutY()-ball.ballID.getLayoutY()+150>=0){
            if(line2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) || line5.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(line3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) || line7.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(line4.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) || line8.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            else
                return false;
        }
        else if(ball.ballID.getFill().equals(line2.getFill()) && ball.ballID.getFill().equals(line5.getFill()) && line1.getLayoutY()-ball.ballID.getLayoutY()+150>=0){
            if(line1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) || line6.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(line3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) || line7.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(line4.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) || line8.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            else
                return false;
        }
        else if(ball.ballID.getFill().equals(line3.getFill()) && ball.ballID.getFill().equals(line7.getFill()) && line1.getLayoutY()-ball.ballID.getLayoutY()+150>=0){
            if(line2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) || line5.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(line1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) || line6.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(line4.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) || line8.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            else
                return false;
        }
        else if(ball.ballID.getFill().equals(line4.getFill()) && ball.ballID.getFill().equals(line8.getFill()) && line1.getLayoutY()-ball.ballID.getLayoutY()+150>=0) {
            if(line2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) || line5.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(line3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) || line7.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            if(line1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) || line6.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
                return true;
            else
                return false;
        }
        return false;
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
        line5.setLayoutY(dist);
        line6.setLayoutY(dist);
        line7.setLayoutY(dist);
        line8.setLayoutY(dist);
    }

    @Override
    protected void rotatingSpeed() {

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

        rotateObstacle(r1,1,true);
        rotateObstacle(r2,1,true);
        rotateObstacle(r3,1,true);
        rotateObstacle(r4,1,true);
        rotateObstacle(r5,-1,true);
        rotateObstacle(r6,-1,true);
        rotateObstacle(r7,-1,true);
        rotateObstacle(r8,-1,true);

    }
}
