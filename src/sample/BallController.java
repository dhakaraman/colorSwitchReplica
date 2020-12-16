package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Bounds;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.io.IOException;

public class BallController extends GameElements {

    private Paint color;
    private double speed;

    @FXML
    public AnchorPane BallRoot;

    @FXML
    public Circle ballID;

    public void initialize() throws Exception{
        this.setSpeed(50);
    }

    @FXML
    public void jump(ActionEvent event) throws IOException {
        addMusic("/Sound Effects/jump.wav");
        Bounds bounds = BallRoot.getBoundsInLocal();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200),
                new KeyValue(ballID.layoutYProperty(), ballID.getLayoutY()-speed)));
        timeline.setCycleCount(1);

        Timeline t2 = new Timeline(new KeyFrame(Duration.millis(2000),
                new KeyValue(ballID.layoutYProperty(), bounds.getMaxY()+ballID.getRadius()-speed)));
        t2.setCycleCount(1);
        timeline.play();
        timeline.setOnFinished(actionEvent -> t2.play());

    }

//    public void addMusic() {
//        Media sound = new Media(getClass().getResource("/Sound Effects/jump.wav").toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(sound);
//        mediaPlayer.setAutoPlay(true);
//        mediaPlayer.setStartTime(Duration.seconds(0));
//        mediaPlayer.setStopTime(Duration.seconds(1));
//        mediaPlayer.play();
//    }

    public void setSpeed(double speed){
        this.speed = speed;
    }

    public double getSpeed(){
        return this.speed;
    }

    public void setColor(Paint color){
        this.color = color;
    }
    public Paint getColor(){
        return this.color;
    }

}
