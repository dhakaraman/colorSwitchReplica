package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class GamePlayController  {
    @FXML
    AnimationTimer timer;

    double t;

    @FXML
    private AnchorPane playRoot;

    Obstracle obstracle;

    @FXML
    private ImageView circle1;

    @FXML
    private Button pauseGame1;

    @FXML
    private ImageView pauseGame;

    BallController ball;


    public void initialize()  throws Exception{

        int shape = 1;
        FXMLLoader load1 = new FXMLLoader(getClass().getResource("Ball.fxml"));
        AnchorPane ballPane = load1.load();
        ball = load1.getController();
        AnchorPane obstraclePane;

        if (shape == 1) {
            FXMLLoader load2 = new FXMLLoader(getClass().getResource("circleShape.fxml"));
            obstraclePane = load2.load();
            obstracle=load2.getController();
        }
        else if (shape == 2) {
            FXMLLoader load2 = new FXMLLoader(getClass().getResource("LineShape.fxml"));
            obstraclePane= load2.load();
            obstracle=load2.getController();
        }

        else if (shape == 3) {
            FXMLLoader load2 = new FXMLLoader(getClass().getResource("squareShape.fxml"));
            obstraclePane = load2.load();
            obstracle=load2.getController();
        }
        else {
            FXMLLoader load2 = new FXMLLoader(getClass().getResource("triangleShape.fxml"));
            obstraclePane = load2.load();
            obstracle=load2.getController();
        }

        playRoot.getChildren().addAll(ballPane);
        playRoot.getChildren().addAll(obstraclePane);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    update();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
        timer.start();

        System.out.print(shape);

    }

    void update() throws Exception{


        t+=0.016;

        boolean color=obstracle.checkColor(ball);
        if(color){
            AnchorPane pane= FXMLLoader.load(getClass().getResource("GameOver.fxml"));
            playRoot.getChildren().setAll(pane);
        }

        if(t>2){
            //t= Double.valueOf(0);
            t=0;
        }

    }

    int randomGenrator(){
        Random random = new Random();
        int ans = random.nextInt(4)+1;
        return ans;
    }
    @FXML
    void pauseGame(MouseEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("pauseMenu.fxml"));
        playRoot.getChildren().setAll(pane);
    }
}
