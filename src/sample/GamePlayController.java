package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;

import javax.swing.text.html.ListView;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class GamePlayController implements Serializable {
    @FXML
    transient AnimationTimer timer;

    @FXML
    transient public Circle ballID;

    @FXML
    transient private AnchorPane playRoot;

    @FXML
    private TextArea list1;


    transient  BallController ball;

    transient circleShapeController obj;

    transient sqaureShapeController obj1;

    transient triangleShapeController obj2;

    transient LineShapeController obj3;

    ColorSwitchController obj4;

    transient starShapeController starObj1, starObj2, starObj3, starObj4;

    public double a1,a2,a3,a4;

    public void initialize() throws Exception{


        AnchorPane obstraclePane1;
        AnchorPane obstraclePane2;
        AnchorPane obstraclePane3;
        AnchorPane obstraclePane4;
        AnchorPane obstraclePane5;
        AnchorPane obstraclePane6;
        AnchorPane obstraclePane7;
        AnchorPane obstraclePane8;
        AnchorPane obstraclePane9;

        FXMLLoader load1 = new FXMLLoader(getClass().getResource("Ball.fxml"));
        AnchorPane ballPane = load1.load();
        ball = load1.getController();
        playRoot.getChildren().addAll(ballPane);

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

        FXMLLoader load10 = new FXMLLoader(getClass().getResource("ColorSwitch.fxml"));
        obstraclePane9 = load10.load();
        obj4=load10.getController();
        playRoot.getChildren().addAll(obstraclePane9);

        resetY();

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
    }

    void update() throws Exception{

        boolean color=false,color2=false,color3=false,color4=false;
        if(ball.ballID.getLayoutY()<400) {
            color = obj.checkColor(ball);
            obj.movingSpeed();
            color2 = obj2.checkColor(ball);
            obj2.movingSpeed();
            color3 = obj3.checkColor(ball);
            obj3.movingSpeed();
            color4 = obj1.checkColor(ball);
            obj1.movingSpeed();
            starObj1.movingSpeed();
            starObj2.movingSpeed();
            starObj3.movingSpeed();
            starObj4.movingSpeed();
            starObj1.checkColor(ball);
            starObj2.checkColor(ball);
            starObj3.checkColor(ball);
            starObj4.checkColor(ball);
            obj4.movingSpeed();
        }
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
        starObj1.star1.setLayoutY(mylist.get(0));
        starObj1.star2.setLayoutY(mylist.get(0));

        obj1.line1.setLayoutY(mylist.get(1));
        obj1.line2.setLayoutY(mylist.get(1));
        obj1.line3.setLayoutY(mylist.get(1));
        obj1.line4.setLayoutY(mylist.get(1));
        obj1.sqrID.setLayoutY(mylist.get(1));
        starObj2.star1.setLayoutY(mylist.get(1));
        starObj2.star2.setLayoutY(mylist.get(1));

        obj2.tri1.setLayoutY(mylist.get(2));
        obj2.tri2.setLayoutY(mylist.get(2));
        obj2.tri3.setLayoutY(mylist.get(2));
        obj2.innerTri.setLayoutY(mylist.get(2));
        starObj3.star1.setLayoutY(mylist.get(2));
        starObj3.star2.setLayoutY(mylist.get(2));

        obj3.line1.setLayoutY(mylist.get(3));
        obj3.line2.setLayoutY(mylist.get(3));
        obj3.line3.setLayoutY(mylist.get(3));
        obj3.line4.setLayoutY(mylist.get(3));
        obj3.line5.setLayoutY(mylist.get(3));
        obj3.line6.setLayoutY(mylist.get(3));
        obj3.line7.setLayoutY(mylist.get(3));
        obj3.line8.setLayoutY(mylist.get(3));
        starObj4.star1.setLayoutY(mylist.get(3));
        starObj4.star2.setLayoutY(mylist.get(3));

    }


    @FXML
    void pauseGame(MouseEvent event) throws Exception{
        //serialize();
        AnchorPane pane= FXMLLoader.load(getClass().getResource("pauseMenu.fxml"));
        playRoot.getChildren().setAll(pane);
    }

    public void serialize() throws IOException {
        a1 = obj.arc1.getLayoutY();
        a2 = obj.arc2.getLayoutY();
        a3 = obj.arc3.getLayoutY();
        a4 = obj.arc4.getLayoutY();

        ObjectOutputStream out = null;
        try {
             out = new ObjectOutputStream (new FileOutputStream("out.txt"));
             out.writeObject(this);
             }
        finally {
             out.close();
             }
    }


}
