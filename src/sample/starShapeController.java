package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class starShapeController extends Obstracle implements Initializable {
    @FXML
    public AnchorPane starRoot;

    @FXML
    public Polygon star1,star2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //rotatingSpeed();
    }

    @Override
    public boolean checkColor(BallController ball) {

        if(ball.ballID.getLayoutY()<=star1.getLayoutY()-130){
            double dist = star1.getLayoutY()-1600;
            star1.setLayoutY(dist);
            star2.setLayoutY(dist);
            addMusic();
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

        r1.setPivotX(250);
        r1.setPivotY(300);
        star1.getTransforms().add(r1);

        r2.setPivotX(250);
        r2.setPivotY(300);
        star2.getTransforms().add(r2);

        helper(r1);
        helper(r2);
    }

    public void addMusic() {
        Media sound = new Media(getClass().getResource("/Sound Effects/star.wav").toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(1));
        mediaPlayer.play();
    }


}
