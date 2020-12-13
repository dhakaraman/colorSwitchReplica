package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.text.html.ListView;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class GamePlayController implements Serializable {
    @FXML
    transient AnimationTimer timer;

    @FXML
    transient public Circle ballID;

    @FXML
    transient public Label textField;

    @FXML
    transient private AnchorPane playRoot;

    @FXML
    transient public ImageView circleID;

    @FXML
    transient TextArea textArea;

    transient BallController ball;

    transient circleShapeController obj;

    transient sqaureShapeController obj1;

    transient triangleShapeController obj2;

    transient LineShapeController obj3;

    transient ColorSwitchController CSobj1,CSobj2,CSobj3,CSobj4;

    transient public int score=0;

    transient starShapeController starObj1, starObj2, starObj3, starObj4;

    public double a1,a2,a3,a4;

    public void initialize() throws Exception{

        RotateTransition transition1 = new RotateTransition(Duration.seconds(30), circleID);
        transition1.setByAngle(3600);
        transition1.setCycleCount(50);
        transition1.setAutoReverse(true);
        transition1.play();

        String temp = Integer.toString(score);
        textField.setText(temp);

        AnchorPane obstraclePane1;
        AnchorPane obstraclePane2;
        AnchorPane obstraclePane3;
        AnchorPane obstraclePane4;
        AnchorPane obstraclePane5;
        AnchorPane obstraclePane6;
        AnchorPane obstraclePane7;
        AnchorPane obstraclePane8;
        AnchorPane obstraclePane9;
        AnchorPane obstraclePane10;
        AnchorPane obstraclePane11;
        AnchorPane obstraclePane12;


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
        CSobj1=load10.getController();
        playRoot.getChildren().addAll(obstraclePane9);

        FXMLLoader load11 = new FXMLLoader(getClass().getResource("ColorSwitch.fxml"));
        obstraclePane10 = load11.load();
        CSobj2=load11.getController();
        playRoot.getChildren().addAll(obstraclePane10);

        FXMLLoader load12 = new FXMLLoader(getClass().getResource("ColorSwitch.fxml"));
        obstraclePane11 = load12.load();
        CSobj3=load12.getController();
        playRoot.getChildren().addAll(obstraclePane11);

        FXMLLoader load13 = new FXMLLoader(getClass().getResource("ColorSwitch.fxml"));
        obstraclePane12 = load13.load();
        CSobj4=load13.getController();
        playRoot.getChildren().addAll(obstraclePane12);

        resetY();

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    update();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        timer.start();
    }

    void update() throws Exception{
        //System.out.println(a1+" "+a2+" "+a3+" "+a4);

        boolean color9=false,color10=false,color11=false,color12=false;
        boolean color=false,color2=false,color3=false,color4=false,color5=false,color6=false,color7=false,color8=false;
        if(ball.ballID.getLayoutY()<400) {
            obj.movingSpeed();
            color = obj.checkColor(ball);
            obj2.movingSpeed();
            color2 = obj2.checkColor(ball);
            obj3.movingSpeed();
            color3 = obj3.checkColor(ball);
            obj1.movingSpeed();
            color4 = obj1.checkColor(ball);
            starObj1.movingSpeed();
            starObj2.movingSpeed();
            starObj3.movingSpeed();
            starObj4.movingSpeed();
            color5 = starObj1.checkColor(ball);
            color6 = starObj2.checkColor(ball);
            color7 = starObj3.checkColor(ball);
            color8 = starObj4.checkColor(ball);
            CSobj1.movingSpeed();
            CSobj2.movingSpeed();
            CSobj3.movingSpeed();
            CSobj4.movingSpeed();
            color9 = CSobj1.checkColor(ball);
            color10 = CSobj2.checkColor(ball);
            color11 = CSobj3.checkColor(ball);
            color12 = CSobj4.checkColor(ball);
        }
        if(color || color2 || color3 || color4){
            AnchorPane pane= FXMLLoader.load(getClass().getResource("GameOver.fxml"));
            playRoot.getChildren().setAll(pane);
            FXMLLoader load = new FXMLLoader(getClass().getResource("GameOver.fxml"));
            AnchorPane Pane = load.load();
            GameOverController GOobj=load.getController();
            playRoot.getChildren().addAll(Pane);
            String temp = Integer.toString(score);
            GOobj.textField.setText(temp);

        }
        if(color5 || color6 || color7 || color8){
            System.out.println(score);
            score++;
            String temp = Integer.toString(score);
            textField.setText(temp);
        }
        if(color9 || color10 || color12){
            String[] arr = new String[]{"#8f0fff","#ff0586","#fae100","#32e0f0"};
            Collections.shuffle(Arrays.asList(arr));
            ball.ballID.setFill(Paint.valueOf(arr[0]));
        }
        else if(color11){
            String[] arr = new String[]{"#32dbf0","#fae100","#ff0181"};
            Collections.shuffle(Arrays.asList(arr));
            ball.ballID.setFill(Paint.valueOf(arr[0]));
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
        starObj1.star1.setLayoutY(mylist.get(0)+160);
        starObj1.star2.setLayoutY(mylist.get(0)+160);
        CSobj1.arc1.setLayoutY(mylist.get(0)+200);
        CSobj1.arc2.setLayoutY(mylist.get(0)+200);
        CSobj1.arc3.setLayoutY(mylist.get(0)+200);
        CSobj1.arc4.setLayoutY(mylist.get(0)+200);

        obj1.line1.setLayoutY(mylist.get(1));
        obj1.line2.setLayoutY(mylist.get(1));
        obj1.line3.setLayoutY(mylist.get(1));
        obj1.line4.setLayoutY(mylist.get(1));
        obj1.sqrID.setLayoutY(mylist.get(1));
        starObj2.star1.setLayoutY(mylist.get(1)+160);
        starObj2.star2.setLayoutY(mylist.get(1)+160);
        CSobj2.arc1.setLayoutY(mylist.get(1)+200);
        CSobj2.arc2.setLayoutY(mylist.get(1)+200);
        CSobj2.arc3.setLayoutY(mylist.get(1)+200);
        CSobj2.arc4.setLayoutY(mylist.get(1)+200);

        obj2.tri1.setLayoutY(mylist.get(2));
        obj2.tri2.setLayoutY(mylist.get(2));
        obj2.tri3.setLayoutY(mylist.get(2));
        obj2.innerTri.setLayoutY(mylist.get(2));
        starObj3.star1.setLayoutY(mylist.get(2)+160);
        starObj3.star2.setLayoutY(mylist.get(2)+160);
        CSobj3.arc1.setLayoutY(mylist.get(2)+200);
        CSobj3.arc2.setLayoutY(mylist.get(2)+200);
        CSobj3.arc3.setLayoutY(mylist.get(2)+200);
        CSobj3.arc4.setLayoutY(mylist.get(2)+200);

        obj3.line1.setLayoutY(mylist.get(3));
        obj3.line2.setLayoutY(mylist.get(3));
        obj3.line3.setLayoutY(mylist.get(3));
        obj3.line4.setLayoutY(mylist.get(3));
        obj3.line5.setLayoutY(mylist.get(3));
        obj3.line6.setLayoutY(mylist.get(3));
        obj3.line7.setLayoutY(mylist.get(3));
        obj3.line8.setLayoutY(mylist.get(3));
        starObj4.star1.setLayoutY(mylist.get(3)+160);
        starObj4.star2.setLayoutY(mylist.get(3)+160);
        CSobj4.arc1.setLayoutY(mylist.get(3)+200);
        CSobj4.arc2.setLayoutY(mylist.get(3)+200);
        CSobj4.arc3.setLayoutY(mylist.get(3)+200);
        CSobj4.arc4.setLayoutY(mylist.get(3)+200);

    }

    @FXML
    void pauseGame(MouseEvent event) throws Exception{
        serialize();
        timer.stop();
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

    @FXML
    public void initData(double a1,double a2, double a3, double a4){
        this.a1 = a1;
        this.a2 = a2;
        this.a3 = a3;
        this.a4 = a4;
    }


}
