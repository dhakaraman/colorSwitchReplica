package sample;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;

public class circleShapeController extends Obstracle {

    private double radius;

    @FXML
    public Arc arc1,arc2,arc3,arc4;

    @FXML
    public Circle innerPart;

    @FXML
    private void initialize() {

        rotatingSpeed();

    }


//    @Override
//    public boolean checkColor(BallController ball) {
//
//        if(ball.ballID.getFill().equals(arc1.getFill())){
//            if(arc2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
//                return true;
//            }
//            if(arc3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
//                return true;
//            }
//            if(arc4.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
//                return true;
//            }
//            else
//                return false;
//        }
//        else if(ball.ballID.getFill().equals(arc2.getFill())){
//            if(arc1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
//                return true;
//            }
//            if(arc3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
//                return true;
//            }
//            if(arc4.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
//                return true;
//            }
//            else
//                return false;
//        }
//        else if(ball.ballID.getFill().equals(arc3.getFill())){
//            if(arc2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
//                return true;
//            }
//            if(arc1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
//                return true;
//            }
//            if(arc4.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
//                return true;
//            }
//            else
//                return false;
//        }
//        else if(ball.ballID.getFill().equals(arc4.getFill())){
//            if(arc2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
//                return true;
//            }
//            if(arc3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
//                return true;
//            }
//            if(arc1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
//                return true;
//            }
//            else
//                return false;
//        }
//        else{
//            return false;
//        }
//
//    }

    @Override
    public boolean checkColor(BallController obj){

        Shape s1 = Shape.intersect(arc1,obj.ballID);
        Shape s2 = Shape.intersect(arc2,obj.ballID);
        Shape s3 = Shape.intersect(arc3,obj.ballID);
        Shape s4 = Shape.intersect(arc4,obj.ballID);
        if(s1.getBoundsInParent().getWidth() != -1 && !(arc1.getFill().equals(obj.ballID.getFill()))){
            return true;
        }
        else if(s2.getBoundsInParent().getWidth() != -1 && !(arc2.getFill().equals(obj.ballID.getFill()))){
            return true;
        }
        else if(s3.getBoundsInParent().getWidth() != -1 && !(arc3.getFill().equals(obj.ballID.getFill()))){
            return true;
        }
        else if(s4.getBoundsInParent().getWidth() != -1 && !(arc4.getFill().equals(obj.ballID.getFill()))){
            return true;
        }
        return false;
    }

    @Override
    protected void movingSpeed() {
        double dist = arc1.getLayoutY();
        if(dist>800){
            dist = -800;
        }
        dist++;
        arc1.setLayoutY(dist);
        arc2.setLayoutY(dist);
        arc3.setLayoutY(dist);
        arc4.setLayoutY(dist);
        innerPart.setLayoutY(dist);
    }

    @Override
    protected void rotatingSpeed() {
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

        rotateObstacle(r1,1,true);
        rotateObstacle(r2,1,true);
        rotateObstacle(r3,1,true);
        rotateObstacle(r4,1,true);
    }
}
