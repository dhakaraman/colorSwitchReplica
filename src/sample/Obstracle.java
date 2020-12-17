package sample;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.scene.paint.Paint;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public abstract class Obstracle extends GameElements {

    protected double speed;
    protected boolean moving;
    protected boolean rotating;
    protected ArrayList<Paint> color = new ArrayList<>();

    public abstract boolean checkColor(BallController ball);

    protected abstract void movingSpeed();

    protected abstract void rotatingSpeed();

    public static void rotateObstacle(Rotate r, int rotation, boolean isRotating){
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(r.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(r.angleProperty(), rotation*36000)));
        if(isRotating)
            timeline.play();
        else
            timeline.stop();
    }

    public static void imageRotate(ImageView object,int rotation, boolean rotate){
        RotateTransition transition1 = new RotateTransition(Duration.seconds(30), object);
        transition1.setByAngle(rotation*3600);
        transition1.setCycleCount(50);
        transition1.setAutoReverse(true);
        if(rotate)
            transition1.play();
        else
            transition1.stop();
    }

}
