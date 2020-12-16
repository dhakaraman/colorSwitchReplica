package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

public abstract class GameElements {
//    public abstract void setX();
//    public abstract double getX();
//    public abstract void setY();
//    public abstract double getY();

    public static void addMusic(String filename) {
        Media sound = new Media(GameElements.class.getResource(filename).toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(1));
        mediaPlayer.play();
    }
}
