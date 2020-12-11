package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public abstract class Obstracle  {

    public abstract boolean checkColor(BallController ball);

    protected abstract void movingSpeed();

    protected abstract void rotatingSpeed();

    protected void helper(Rotate r1){
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(r1.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(r1.angleProperty(), 36000)));
        timeline.play();
    }

}
