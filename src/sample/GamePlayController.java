package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.Collections;

public class GamePlayController  {
    @FXML
    AnimationTimer timer;

    @FXML
    public Circle ballID;

    @FXML
    private AnchorPane playRoot;


    BallController ball;

    circleShapeController obj;

    sqaureShapeController obj1;

    triangleShapeController obj2;

    LineShapeController obj3;

    starShapeController starObj1, starObj2, starObj3, starObj4;


    public void initialize() throws Exception{

        FXMLLoader load1 = new FXMLLoader(getClass().getResource("Ball.fxml"));
        AnchorPane ballPane = load1.load();
        ball = load1.getController();
        AnchorPane obstraclePane1;
        AnchorPane obstraclePane2;
        AnchorPane obstraclePane3;
        AnchorPane obstraclePane4;
        AnchorPane obstraclePane5;
        AnchorPane obstraclePane6;
        AnchorPane obstraclePane7;
        AnchorPane obstraclePane8;


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

        FXMLLoader load6 = new FXMLLoader(getClass().getResource("starShape.fxml"));
        obstraclePane5 = load6.load();
        starObj1=load6.getController();
        playRoot.getChildren().addAll(obstraclePane5);

        FXMLLoader load7 = new FXMLLoader(getClass().getResource("starShape.fxml"));
        obstraclePane6 = load7.load();
        starObj2=load7.getController();
        playRoot.getChildren().addAll(obstraclePane6);

        FXMLLoader load8 = new FXMLLoader(getClass().getResource("starShape.fxml"));
        obstraclePane7 = load8.load();
        starObj3=load8.getController();
        playRoot.getChildren().addAll(obstraclePane7);

        FXMLLoader load9 = new FXMLLoader(getClass().getResource("starShape.fxml"));
        obstraclePane8 = load9.load();
        starObj4=load9.getController();
        playRoot.getChildren().addAll(obstraclePane8);

        resetY();

        playRoot.getChildren().addAll(ballPane);

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    update();
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
        boolean color2=obj2.checkColor(ball);
        boolean color3=obj3.checkColor(ball);
        boolean color4=obj1.checkColor(ball);
        if(color){
            AnchorPane pane= FXMLLoader.load(getClass().getResource("GameOver.fxml"));
            playRoot.getChildren().setAll(pane);
        }
        else if(color2){
            AnchorPane pane= FXMLLoader.load(getClass().getResource("GameOver.fxml"));
            playRoot.getChildren().setAll(pane);
        }
        else if(color3 ){
            AnchorPane pane= FXMLLoader.load(getClass().getResource("GameOver.fxml"));
            playRoot.getChildren().setAll(pane);
        }
        else if(color4 ){
            AnchorPane pane= FXMLLoader.load(getClass().getResource("GameOver.fxml"));
            playRoot.getChildren().setAll(pane);
        }

    }


    void movingObstacles() throws Exception{

        if(ball.ballID.getLayoutY()<300){
            movingLine(700,800);
            movingTriangle(700,800);
            movingSquare(700,800);
            movingCircle(700,800);
        }

        }


    void resetY(){

        ArrayList<Integer> mylist = new ArrayList<Integer>();
        mylist.add(-200);
        mylist.add(-600);
        mylist.add(-1000);
        mylist.add(-1400);

        Collections.shuffle(mylist);

        obj.arc1.setLayoutY(mylist.get(0));
        obj.arc2.setLayoutY(mylist.get(0));
        obj.arc3.setLayoutY(mylist.get(0));
        obj.arc4.setLayoutY(mylist.get(0));
        obj.arc4.setLayoutY(mylist.get(0));
        starObj1.star1.setLayoutY(mylist.get(0)-200);
        starObj1.star2.setLayoutY(mylist.get(0)-200);

        obj1.line1.setLayoutY(mylist.get(1));
        obj1.line2.setLayoutY(mylist.get(1));
        obj1.line3.setLayoutY(mylist.get(1));
        obj1.line4.setLayoutY(mylist.get(1));
        obj1.sqrID.setLayoutY(mylist.get(1));
        starObj2.star1.setLayoutY(mylist.get(1)-200);
        starObj2.star2.setLayoutY(mylist.get(1)-200);

        obj2.tri1.setLayoutY(mylist.get(2));
        obj2.tri2.setLayoutY(mylist.get(2));
        obj2.tri3.setLayoutY(mylist.get(2));
        obj2.innerTri.setLayoutY(mylist.get(2));
        starObj3.star1.setLayoutY(mylist.get(2)-200);
        starObj3.star2.setLayoutY(mylist.get(2)-200);

        obj3.line1.setLayoutY(mylist.get(3));
        obj3.line2.setLayoutY(mylist.get(3));
        obj3.line3.setLayoutY(mylist.get(3));
        obj3.line4.setLayoutY(mylist.get(3));
        obj3.line5.setLayoutY(mylist.get(3));
        obj3.line6.setLayoutY(mylist.get(3));
        obj3.line7.setLayoutY(mylist.get(3));
        obj3.line8.setLayoutY(mylist.get(3));
        starObj4.star1.setLayoutY(mylist.get(3)-200);
        starObj4.star2.setLayoutY(mylist.get(3)-200);



    }


    void movingCircle(int a,int b) throws Exception{
        double dist = obj.arc1.getLayoutY();
        if(dist>800){
            dist = -800;
        }
        dist++;
        obj.arc1.setLayoutY(dist);
        obj.arc2.setLayoutY(dist);
        obj.arc3.setLayoutY(dist);
        obj.arc4.setLayoutY(dist);
        obj.innerPart.setLayoutY(dist);
        starObj1.star1.setLayoutY(dist);
        starObj1.star2.setLayoutY(dist);
    }

    void movingSquare(int a, int b) throws Exception{
        double dist = obj1.line1.getLayoutY();
        if(dist>800){
            dist = -800;
        }
        dist++;
        obj1.line1.setLayoutY(dist);
        obj1.line2.setLayoutY(dist);
        obj1.line3.setLayoutY(dist);
        obj1.line4.setLayoutY(dist);
        obj1.sqrID.setLayoutY(dist);
        starObj2.star1.setLayoutY(dist);
        starObj2.star2.setLayoutY(dist);
    }

    void movingTriangle(int a, int b) throws Exception{
        double dist = obj2.tri1.getLayoutY();
        if(dist>800){
            dist = -800;
        }
        dist++;
        obj2.tri1.setLayoutY(dist);
        obj2.tri2.setLayoutY(dist);
        obj2.tri3.setLayoutY(dist);
        obj2.innerTri.setLayoutY(dist);
        starObj3.star1.setLayoutY(dist);
        starObj3.star2.setLayoutY(dist);

    }

    void movingLine(int a, int b) throws Exception{
        double dist = obj3.line1.getLayoutY();
        if(dist>800){
            dist = -800;
        }
        dist++;
        obj3.line1.setLayoutY(dist);
        obj3.line2.setLayoutY(dist);
        obj3.line3.setLayoutY(dist);
        obj3.line4.setLayoutY(dist);
        obj3.line5.setLayoutY(dist);
        obj3.line6.setLayoutY(dist);
        obj3.line7.setLayoutY(dist);
        obj3.line8.setLayoutY(dist);
        starObj4.star1.setLayoutY(dist);
        starObj4.star2.setLayoutY(dist);

    }

//    void movingStar(int a,int b) throws Exception{
//        double dist = obj4.star1.getLayoutY();
//        if(dist>800){
//            dist = -800;
//        }
//        dist++;
//        obj4.star1.setLayoutY(dist);
//        obj4.star2.setLayoutY(dist);
//    }


    @FXML
    void pauseGame(MouseEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("pauseMenu.fxml"));
        playRoot.getChildren().setAll(pane);
    }
}
