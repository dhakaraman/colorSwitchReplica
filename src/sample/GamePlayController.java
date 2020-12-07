package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
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
    Obstracle obstracle;

    @FXML
    public Circle ballID;

    @FXML
    private AnchorPane playRoot;

    @FXML
    private Arc arc1;

    @FXML
    private ImageView circle1;

    @FXML
    private Button pauseGame1;

    @FXML
    private ImageView pauseGame;

    BallController ball;

    circleShapeController obj;

    sqaureShapeController obj1;

    triangleShapeController obj2;

    LineShapeController obj3;

    int flag=0;
    int value;
    int jump=100;

    public void initialize() throws Exception{

        int shape = randomGenrator();
        FXMLLoader load1 = new FXMLLoader(getClass().getResource("Ball.fxml"));
        AnchorPane ballPane = load1.load();
        ball = load1.getController();
        AnchorPane obstraclePane1;
        AnchorPane obstraclePane2;
        AnchorPane obstraclePane3;
        AnchorPane obstraclePane4;

        FXMLLoader load2 = new FXMLLoader(getClass().getResource("circleShape.fxml"));
        obstraclePane1 = load2.load();
        obj=load2.getController();
        playRoot.getChildren().addAll(obstraclePane1);

        FXMLLoader load3 = new FXMLLoader(getClass().getResource("LineShape.fxml"));
        obstraclePane2= load3.load();
        obj3=load3.getController();
        playRoot.getChildren().addAll(obstraclePane2);

        FXMLLoader load4 = new FXMLLoader(getClass().getResource("squareShape.fxml"));
        obstraclePane3 = load4.load();
        obj1=load4.getController();
        playRoot.getChildren().addAll(obstraclePane3);

        FXMLLoader load5 = new FXMLLoader(getClass().getResource("triangleShape.fxml"));
        obstraclePane4 = load5.load();
        obj2=load5.getController();
        playRoot.getChildren().addAll(obstraclePane4);


        playRoot.getChildren().addAll(ballPane);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    //update();
                    //fun();
                    movingObstacles();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer.start();

    }

    void update() throws Exception{

        boolean color=obj.checkColor(ball);
        if(color){
            AnchorPane pane= FXMLLoader.load(getClass().getResource("GameOver.fxml"));
            playRoot.getChildren().setAll(pane);
        }

    }

    void movingObstacles() throws Exception{
        int rand = randomGenrator();
        if(flag==0){
            flag=1;
            if(rand==1){
                movingCircle(700,jump);
                value=1;
            }
            else if(rand==2){
                movingSquare(700,jump);
                value=2;
            }
            else if(rand==3){
                movingTriangle(700,jump);
                value=3;
            }
            else{
                movingLine(700,jump);
                value=4;
            }
        }

        if(ball.ballID.getLayoutY()<200){
            if(value==1){
                jump+=5;
                movingCircle(700,jump);
            }
            else if(value==2){
                jump+=5;
                movingSquare(700,jump);
            }
            else if(value==3){
                jump+=5;
                movingTriangle(700,jump);
            }
            else{
                jump+=5;
                movingLine(700,jump);
            }

        }
        if(jump>700){
            flag=0;
            jump=100;
            resetY();
        }

    }

    void resetY(){
        obj.arc1.setLayoutY(-246);
        obj.arc2.setLayoutY(-246);
        obj.arc3.setLayoutY(-246);
        obj.arc4.setLayoutY(-246);

        obj1.line1.setLayoutY(-332);
        obj1.line2.setLayoutY(-127);
        obj1.line3.setLayoutY(-229);
        obj1.line4.setLayoutY(-229);

        obj2.tri1.setLayoutY(-313);
        obj2.tri2.setLayoutY(-313);
        obj2.tri3.setLayoutY(-313);

        obj3.line1.setLayoutY(-212);
        obj3.line2.setLayoutY(-212);
        obj3.line3.setLayoutY(-212);
        obj3.line4.setLayoutY(-212);
        obj3.line5.setLayoutY(-212);
        obj3.line6.setLayoutY(-212);
        obj3.line7.setLayoutY(-212);
        obj3.line8.setLayoutY(-212);
    }


    void movingCircle(int a,int b) throws Exception{
        if(ball.ballID.getLayoutY()<a){
            Timeline t2 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj.arc1.layoutYProperty(), b)));
            t2.setCycleCount(1);
            t2.play();

            Timeline t1 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj.arc2.layoutYProperty(), b)));
            t1.setCycleCount(1);
            t1.play();

            Timeline t3 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj.arc3.layoutYProperty(), b)));
            t3.setCycleCount(1);
            t3.play();

            Timeline t4 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj.arc4.layoutYProperty(), b)));
            t4.setCycleCount(1);
            t4.play();

        }

    }

    void movingSquare(int a, int b) throws Exception{


        if(ball.ballID.getLayoutY()<a){

            Timeline t1 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj1.line2.layoutYProperty(), b)));
            t1.setCycleCount(1);
            t1.play();

            Timeline t2 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj1.line2.layoutYProperty(), b)));
            t2.setCycleCount(1);
            t2.play();

            Timeline t3 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj1.line3.layoutYProperty(), b)));
            t3.setCycleCount(1);
            t3.play();

            Timeline t4 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj1.line4.layoutYProperty(), b)));
            t4.setCycleCount(1);
            t4.play();
        }

    }

    void movingTriangle(int a, int b) throws Exception{

        if(ball.ballID.getLayoutY()<a){
            Timeline t2 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj2.tri1.layoutYProperty(), b)));
            t2.setCycleCount(1);
            t2.play();

            Timeline t1 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj2.tri2.layoutYProperty(), b)));
            t1.setCycleCount(1);
            t1.play();

            Timeline t3 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj2.tri3.layoutYProperty(), b)));
            t3.setCycleCount(1);
            t3.play();

        }

    }

    void movingLine(int a, int b) throws Exception{
        if(ball.ballID.getLayoutY()<a){

            Timeline t1 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj3.line1.layoutYProperty(), b)));
            t1.setCycleCount(1);
            t1.play();

            Timeline t2 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj3.line2.layoutYProperty(), b)));
            t2.setCycleCount(1);
            t2.play();


            Timeline t3 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj3.line3.layoutYProperty(), b)));
            t3.setCycleCount(1);
            t3.play();

            Timeline t4 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj3.line4.layoutYProperty(), b)));
            t4.setCycleCount(1);
            t4.play();

            Timeline t5 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj3.line5.layoutYProperty(), b)));
            t5.setCycleCount(1);
            t5.play();

            Timeline t6 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj3.line6.layoutYProperty(), b)));
            t6.setCycleCount(1);
            t6.play();


            Timeline t7 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj3.line7.layoutYProperty(), b)));
            t7.setCycleCount(1);
            t7.play();

            Timeline t8 = new Timeline(new KeyFrame(Duration.millis(600),
                    new KeyValue(obj3.line8.layoutYProperty(), b)));
            t8.setCycleCount(1);
            t8.play();

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
