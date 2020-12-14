package sample;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;

public class circleShapeController extends Obstracle {

    @FXML
    public Arc arc1;

    @FXML
    public Arc arc2;

    @FXML
    public Arc arc3;

    @FXML
    public Arc arc4;

    @FXML
    public Circle innerPart;


    @FXML
    private void initialize() {

        rotatingSpeed();

    }


    @Override
    public boolean checkColor(BallController ball) {
        //System.out.println("I am in circle");

        if(ball.ballID.getFill().equals(arc1.getFill())){
            if(arc2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            if(arc3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            if(arc4.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            else
                return false;
        }
        else if(ball.ballID.getFill().equals(arc2.getFill())){
            if(arc1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            if(arc3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            if(arc4.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            else
                return false;
        }
        else if(ball.ballID.getFill().equals(arc3.getFill())){
            if(arc2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            if(arc1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            if(arc4.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            else
                return false;
        }
        else if(ball.ballID.getFill().equals(arc4.getFill())){
            if(arc2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            if(arc3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            if(arc1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerPart.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            else
                return false;
        }
        else{
            return false;
        }

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

        helper(r1);
        helper(r2);
        helper(r3);
        helper(r4);
    }
}
