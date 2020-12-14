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
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.io.IOException;

public class BallController  {

    public static MediaPlayer mediaPlayer;

    @FXML
    transient AnimationTimer timer;

    @FXML
    transient public AnchorPane BallRoot;

    @FXML
    transient  public Circle ballID;

    transient circleShapeController obj;


    public void initialize() throws Exception{

    }

    @FXML
    public void play(ActionEvent event) throws IOException {
        addMusic();
        Bounds bounds = BallRoot.getBoundsInLocal();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(200),
                new KeyValue(ballID.layoutYProperty(), ballID.getLayoutY()-50)));
        timeline.setCycleCount(1);

        Timeline t2 = new Timeline(new KeyFrame(Duration.millis(2000),
                new KeyValue(ballID.layoutYProperty(), bounds.getMaxY()+ballID.getRadius()-50)));
        t2.setCycleCount(1);
        timeline.play();
        timeline.setOnFinished(actionEvent -> t2.play());

    }

    public void addMusic() {
        Media sound = new Media(getClass().getResource("/Sound Effects/jump.wav").toString());
        mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(1));
        mediaPlayer.play();
    }

}
