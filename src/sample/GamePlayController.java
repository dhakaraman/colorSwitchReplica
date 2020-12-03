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

    @FXML
    private AnchorPane playRoot;

    @FXML
    private AnchorPane ballPane;

    @FXML
    private AnchorPane obstraclePane;

    @FXML
    private ImageView circle1;

    @FXML
    private Button pauseGame1;

    @FXML
    private ImageView pauseGame;


    public void initialize()  throws Exception{

        int shape = randomGenrator();
        FXMLLoader load = FXMLLoader.load(getClass().getResource("Ball.fxml"));
        ballPane = load.load();

        if (shape == 1) {
            FXMLLoader load2 = FXMLLoader.load(getClass().getResource("circleShape.fxml"));
            obstraclePane = load2.load();
        }
        if (shape == 2) {
            FXMLLoader load2 = FXMLLoader.load(getClass().getResource("triangleShape.fxml"));
            obstraclePane = load2.load();
        }

        if (shape == 3) {
            FXMLLoader load2 = FXMLLoader.load(getClass().getResource("squareShape.fxml"));
            obstraclePane = load2.load();
        }
        if (shape == 4) {
            FXMLLoader load2 = FXMLLoader.load(getClass().getResource("LineShape.fxml"));
            obstraclePane = load2.load();
        }

        playRoot.getChildren().addAll(ballPane);
        playRoot.getChildren().addAll(obstraclePane);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                update();
            }

        };
        timer.start();

        System.out.print(shape);

    }

    void update(){

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
