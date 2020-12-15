package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
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

    ArrayList<Double> obstacles = new ArrayList<>();
    ArrayList<Double> colorSwitch = new ArrayList<>();
    ArrayList<Double> stars = new ArrayList<>();
    double ballPos;

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

        resetY(-200);
        //deserialize();

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                try {
                    update();
                    //MovingObstacles();
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
            obj2.movingSpeed();
            obj3.movingSpeed();
            obj1.movingSpeed();
            starObj1.movingSpeed();
            starObj2.movingSpeed();
            starObj3.movingSpeed();
            starObj4.movingSpeed();
            CSobj1.movingSpeed();
            CSobj2.movingSpeed();
            CSobj3.movingSpeed();
            CSobj4.movingSpeed();

        }
        color = obj.checkColor(ball);
        color2 = obj2.checkColor(ball);
        color3 = obj3.checkColor(ball);
        color4 = obj1.checkColor(ball);
        color5 = starObj1.checkColor(ball);
        color6 = starObj2.checkColor(ball);
        color7 = starObj3.checkColor(ball);
        color8 = starObj4.checkColor(ball);
        color9 = CSobj1.checkColor(ball);
        color10 = CSobj2.checkColor(ball);
        color11 = CSobj3.checkColor(ball);
        color12 = CSobj4.checkColor(ball);
        if(color || color2 || color3 || color4){

            addMusic("/Sound Effects/breakball1.wav");
            timer.stop();

            FXMLLoader load = new FXMLLoader(getClass().getResource("GameOver.fxml"));

//            GameOverController controller = new GameOverController();
//            load.setController(controller);

            AnchorPane Pane = load.load();
            GameOverController GOobj=load.getController();
            playRoot.getChildren().setAll(Pane);
            String temp = Integer.toString(score);
            GOobj.textField.setText(temp);
        }
        if(color5 || color6 || color7 || color8){
            score++;
            String temp = Integer.toString(score);
            textField.setText(temp);
        }
        if(color9){
            String[] arr = new String[]{"#8f0fff","#ff0586","#fae100","#32e0f0"};
            Collections.shuffle(Arrays.asList(arr));
            ball.ballID.setFill(Paint.valueOf(arr[0]));
        }
        else if(color10 || color12){
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

    public void resetY(int pos){

        ArrayList<Integer> mylist = new ArrayList<Integer>();
        mylist.add(pos);
        mylist.add(pos-400);
        mylist.add(pos-800);
        mylist.add(pos-1200);

        //Collections.shuffle(mylist);

        obj.arc1.setLayoutY(mylist.get(0));
        obj.arc2.setLayoutY(mylist.get(0));
        obj.arc3.setLayoutY(mylist.get(0));
        obj.arc4.setLayoutY(mylist.get(0));
        obj.innerPart.setLayoutY(mylist.get(0));
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

    public void resetY2(ArrayList<Double> obs, ArrayList<Double> col, ArrayList<Double> star, double ballPos, int scr){

        obj.arc1.setLayoutY(obs.get(0));
        obj.arc2.setLayoutY(obs.get(0));
        obj.arc3.setLayoutY(obs.get(0));
        obj.arc4.setLayoutY(obs.get(0));
        obj.innerPart.setLayoutY(obs.get(0));
        starObj1.star1.setLayoutY(star.get(0));
        starObj1.star2.setLayoutY(star.get(0));
        CSobj1.arc1.setLayoutY(col.get(0));
        CSobj1.arc2.setLayoutY(col.get(0));
        CSobj1.arc3.setLayoutY(col.get(0));
        CSobj1.arc4.setLayoutY(col.get(0));

        obj1.line1.setLayoutY(obs.get(1));
        obj1.line2.setLayoutY(obs.get(1));
        obj1.line3.setLayoutY(obs.get(1));
        obj1.line4.setLayoutY(obs.get(1));
        obj1.sqrID.setLayoutY(obs.get(1));
        starObj2.star1.setLayoutY(star.get(1));
        starObj2.star2.setLayoutY(star.get(1));
        CSobj2.arc1.setLayoutY(col.get(1));
        CSobj2.arc2.setLayoutY(col.get(1));
        CSobj2.arc3.setLayoutY(col.get(1));
        CSobj2.arc4.setLayoutY(col.get(1));

        obj2.tri1.setLayoutY(obs.get(2));
        obj2.tri2.setLayoutY(obs.get(2));
        obj2.tri3.setLayoutY(obs.get(2));
        obj2.innerTri.setLayoutY(obs.get(2));
        starObj3.star1.setLayoutY(star.get(2));
        starObj3.star2.setLayoutY(star.get(2));
        CSobj3.arc1.setLayoutY(col.get(2));
        CSobj3.arc2.setLayoutY(col.get(2));
        CSobj3.arc3.setLayoutY(col.get(2));
        CSobj3.arc4.setLayoutY(col.get(2));

        obj3.line1.setLayoutY(obs.get(3));
        obj3.line2.setLayoutY(obs.get(3));
        obj3.line3.setLayoutY(obs.get(3));
        obj3.line4.setLayoutY(obs.get(3));
        obj3.line5.setLayoutY(obs.get(3));
        obj3.line6.setLayoutY(obs.get(3));
        obj3.line7.setLayoutY(obs.get(3));
        obj3.line8.setLayoutY(obs.get(3));
        starObj4.star1.setLayoutY(star.get(3));
        starObj4.star2.setLayoutY(star.get(3));
        CSobj4.arc1.setLayoutY(col.get(3));
        CSobj4.arc2.setLayoutY(col.get(3));
        CSobj4.arc3.setLayoutY(col.get(3));
        CSobj4.arc4.setLayoutY(col.get(3));

        ball.ballID.setLayoutY(ballPos);
        score = scr;
        String temp = Integer.toString(scr);
        textField.setText(temp);

    }



    @FXML
    void pauseGame(MouseEvent event) throws Exception{
        serialize();
        //ser();
        timer.stop();
        addMusic("/Sound Effects/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("pauseMenu.fxml"));
        playRoot.getChildren().setAll(pane);
    }

    private void addMusic(String fileName){
        Media sound = new Media(getClass().getResource(fileName).toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(1));
        mediaPlayer.play();
    }

    public void serialize() throws IOException {
        obstacles.add(obj.arc1.getLayoutY());//circle
        obstacles.add(obj1.line1.getLayoutY());//square
        obstacles.add(obj2.tri1.getLayoutY());//triangle
        obstacles.add(obj3.line1.getLayoutY());//lines

        colorSwitch.add(CSobj1.arc1.getLayoutY());
        colorSwitch.add(CSobj2.arc1.getLayoutY());
        colorSwitch.add(CSobj3.arc1.getLayoutY());
        colorSwitch.add(CSobj4.arc1.getLayoutY());

        stars.add(starObj1.star1.getLayoutY());
        stars.add(starObj2.star1.getLayoutY());
        stars.add(starObj3.star1.getLayoutY());
        stars.add(starObj4.star1.getLayoutY());


        DataTable oj = new DataTable(obstacles,colorSwitch,stars,ball.ballID.getLayoutY(),score);
        ObjectOutputStream out = null;
        try {
             out = new ObjectOutputStream (new FileOutputStream("out.txt"));
             out.writeObject(oj);
             }
        finally {
             out.close();
             }

    }
//    public void ser()  throws IOException{
//
//        ArrayList<Integer> arr = new ArrayList<>();
//        arr.add(89);
//        DataTableObj oj = new DataTableObj(arr);
//        ObjectOutputStream out = null;
//        try {
//            out = new ObjectOutputStream (new FileOutputStream("SavedGames.txt"));
//            out.writeObject(oj);
//        }
//        finally {
//            out.close();
//        }
//    }
    public void deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        DataTable s1;
        try {
            in = new ObjectInputStream(
                    new FileInputStream("out.txt"));
            s1 = (DataTable) in.readObject();
            resetY2(s1.obstacles,s1.colorSwitch,s1.stars,s1.ballPos,s1.score);
        } finally {
            in.close();
        }
    }

    public void deserialize(Integer index) throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        DataTableObj s1;
        try {
            in = new ObjectInputStream(
                    new FileInputStream("SavedGames.txt"));
            s1 = (DataTableObj) in.readObject();
            resetY2(s1.gameData.get(index).obstacles,s1.gameData.get(index).colorSwitch,s1.gameData.get(index).stars,s1.gameData.get(index).ballPos,s1.gameData.get(index).score);
        } finally {
            in.close();
        }

    }



}
