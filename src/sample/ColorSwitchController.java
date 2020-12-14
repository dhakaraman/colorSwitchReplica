package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class ColorSwitchController extends Obstracle {

    @FXML
    public AnchorPane ColorSwitchRoot;

    @FXML
    public Arc arc1,arc2,arc3,arc4;

    public static MediaPlayer mediaPlayer;



    @Override
    public boolean checkColor(BallController ball) {
        if(ball.ballID.getLayoutY()<=arc1.getLayoutY()){
            double dist = arc1.getLayoutY()-1600;
            arc1.setLayoutY(dist);
            arc2.setLayoutY(dist);
            arc3.setLayoutY(dist);
            arc4.setLayoutY(dist);
            addMusic();
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
    }

    @Override
    protected void rotatingSpeed() {

    }

    public void addMusic() {
        Media sound = new Media(getClass().getResource("/Sound Effects/colorswitch.wav").toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(1));
        mediaPlayer.play();
    }


}
