package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;

public class starShapeController extends Obstracle implements Initializable {
    @FXML
    public AnchorPane starRoot;

    @FXML
    public Polygon star1,star2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rotatingSpeed();
    }

    @Override
    public boolean checkColor(BallController ball) {

        if(ball.ballID.getLayoutY()<=star1.getLayoutY()-130){
            double dist = star1.getLayoutY()-1600;
            star1.setLayoutY(dist);
            star2.setLayoutY(dist);
            GameElements.addMusic("/Sound Effects/star.wav");
            return true;
        }
        return false;
    }

    @Override
    protected void movingSpeed() {
        double dist = star1.getLayoutY();
        if(dist>800){
            dist = -800;
        }
        dist++;
        star1.setLayoutY(dist);
        star2.setLayoutY(dist);
    }

    @Override
    protected void rotatingSpeed() {
        Rotate r1 = new Rotate();
        Rotate r2 = new Rotate();

        r1.setPivotX(-24);
        r1.setPivotY(-150);
        star1.getTransforms().add(r1);

        r2.setPivotX(-24);
        r2.setPivotY(-150);
        star2.getTransforms().add(r2);

        rotateObstacle(r1,-1,true);
        rotateObstacle(r2,-1,true);
    }

}
