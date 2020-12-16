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

    protected double side;


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
        rotatingSpeed();

    }


    @Override
    public boolean checkColor(BallController ball) {

        if(ball.ballID.getFill().equals(tri1.getFill()) && tri1.getLayoutY()-ball.ballID.getLayoutY()+150>=0){
            if(tri2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerTri.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            if(tri3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerTri.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            else
                return false;
        }
        else if(ball.ballID.getFill().equals(tri2.getFill()) && tri1.getLayoutY()-ball.ballID.getLayoutY()+150>=0){
            if(tri1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerTri.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            if(tri3.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerTri.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            else
                return false;
        }
        else if(ball.ballID.getFill().equals(tri3.getFill()) && tri1.getLayoutY()-ball.ballID.getLayoutY()+150>=0) {
            if(tri2.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerTri.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            if(tri1.getBoundsInParent().intersects(ball.ballID.getBoundsInParent()) && !innerTri.getBoundsInParent().intersects(ball.ballID.getBoundsInParent())){
                return true;
            }
            else
                return false;
        }

        return false;
    }

    @Override
    protected void movingSpeed() {
        double dist = tri1.getLayoutY();
        if(dist>800){
            dist = -800;
        }
        dist++;
        tri1.setLayoutY(dist);
        tri2.setLayoutY(dist);
        tri3.setLayoutY(dist);
        innerTri.setLayoutY(dist);
    }

    @Override
    protected void rotatingSpeed() {
        Rotate r1 = new Rotate();
        Rotate r2 = new Rotate();
        Rotate r3 = new Rotate();
        Rotate r4 = new Rotate();

        r1.setPivotX(64);
        r1.setPivotY(0);
        tri1.getTransforms().add(r1);

        r2.setPivotX(64);
        r2.setPivotY(0);
        tri2.getTransforms().add(r2);

        r3.setPivotX(64);
        r3.setPivotY(0);
        tri3.getTransforms().add(r3);

        r4.setPivotX(64);
        r4.setPivotY(0);
        innerTri.getTransforms().add(r4);

        rotateObstacle(r1,1,true);
        rotateObstacle(r2,1,true);
        rotateObstacle(r3,1,true);
        rotateObstacle(r4,1,true);
    }

}


