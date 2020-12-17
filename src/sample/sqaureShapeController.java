package sample;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class sqaureShapeController extends Obstracle implements Initializable {

    protected double side;

    @FXML
    AnchorPane squareRoot;

    @FXML
    public Polygon sqrID;

    @FXML
    public Line line1, line2, line3, line4;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        rotatingSpeed();
    }

//    @Override
//    public boolean checkColor(BallController ball) {
//
//        if(ball.ballID.getFill().equals(line1.getFill()) && line1.getLayoutY()-ball.ballID.getLayoutY()+150>=0){
//            if(line2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
//                return true;
//            if(line3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
//                return true;
//            if(line4.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
//                return true;
//            else
//                return false;
//        }
//        else if(ball.ballID.getFill().equals(line2.getFill()) && line1.getLayoutY()-ball.ballID.getLayoutY()+150>=0){
//            if(line1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
//                return true;
//            if(line3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
//                return true;
//            if(line4.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
//                return true;
//            else
//                return false;
//        }
//        else if(ball.ballID.getFill().equals(line3.getFill()) && line1.getLayoutY()-ball.ballID.getLayoutY()+150>=0){
//            if(line2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
//                return true;
//            if(line1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
//                return true;
//            if(line4.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
//                return true;
//            else
//                return false;
//        }
//        else if(ball.ballID.getFill().equals(line4.getFill()) && line1.getLayoutY()-ball.ballID.getLayoutY()+150>=0){
//            if(line2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
//                return true;
//            if(line3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
//                return true;
//            if(line1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !sqrID.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()))
//                return true;
//            else
//                return false;
//        }
//        return false;
//    }
@Override
public boolean checkColor(BallController obj){

    Shape s1 = Shape.intersect(line1,obj.ballID);
    Shape s2 = Shape.intersect(line2,obj.ballID);
    Shape s3 = Shape.intersect(line3,obj.ballID);
    Shape s4 = Shape.intersect(line4,obj.ballID);
    //System.out.println(line1.getFill()+" "+line2.getFill()+" "+line3.getFill()+" "+line4.getFill()+"  "+obj.ballID.getFill());
    if(s1.getBoundsInParent().getWidth() != -1 && !(line1.getFill().equals(obj.ballID.getFill()))){
        return true;
    }
    else if(s2.getBoundsInParent().getWidth() != -1 && !(line2.getFill().equals(obj.ballID.getFill()))){
        return true;
    }
    else if(s3.getBoundsInParent().getWidth() != -1 && !(line3.getFill().equals(obj.ballID.getFill()))){
        return true;
    }
    else if(s4.getBoundsInParent().getWidth() != -1 && !(line4.getFill().equals(obj.ballID.getFill()))){
        return true;
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
        sqrID.setLayoutY(dist);
    }

    @Override
    protected void rotatingSpeed() {
        Rotate r1 = new Rotate();
        Rotate r2 = new Rotate();
        Rotate r3 = new Rotate();
        Rotate r4 = new Rotate();
        Rotate r5 = new Rotate();

        r1.setPivotX(50);
        r1.setPivotY(5);
        line1.getTransforms().add(r1);
        r2.setPivotX(50);
        r2.setPivotY(5);
        line2.getTransforms().add(r2);
        r3.setPivotX(50);
        r3.setPivotY(5);
        line3.getTransforms().add(r3);
        r4.setPivotX(50);
        r4.setPivotY(5);
        line4.getTransforms().add(r4);

        r5.setPivotX(50);
        r5.setPivotY(5);
        sqrID.getTransforms().add(r5);

        rotateObstacle(r1,1,true);
        rotateObstacle(r2,1,true);
        rotateObstacle(r3,1,true);
        rotateObstacle(r4,1,true);
        rotateObstacle(r5,1,true);

    }

}
