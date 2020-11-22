package sample;

import javafx.animation.RotateTransition;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;



public class MainPageController implements Initializable{

    @FXML
    private AnchorPane mainRoot;

    @FXML
    private ImageView circle1;

    @FXML
    private ImageView linex1;

    @FXML
    private ImageView linex2;

    @FXML
    private ImageView circle2;

    @FXML
    private ImageView circle3;

    @FXML
    private ImageView circle4;

    @FXML
    private ImageView circle5;

    @FXML
    private Button startGame;

    @FXML
    private Button startGame1;

    @FXML
    private ImageView startgame;

    @FXML
    private ImageView exitGame;

    @FXML
    private ImageView loadGame;

    @FXML
    void exitGame(MouseEvent event) {
//        try{
////            Main.serialize();
//        }
//        catch(IOException e){
//            //System.out.println("Could not save the progress :(");
//        }
        System.exit(0);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

            RotateTransition transition1 = new RotateTransition(Duration.seconds(30), circle1);
            transition1.setByAngle(3600);
            transition1.setCycleCount(50);
            transition1.setAutoReverse(true);
            transition1.play();

            RotateTransition transition2 = new RotateTransition(Duration.seconds(25), circle2);
            transition2.setByAngle(3600);
            transition2.setCycleCount(55);
            transition2.setAutoReverse(true);
            transition2.play();

            RotateTransition transition3 = new RotateTransition(Duration.seconds(30), circle3);
            transition3.setByAngle(-3600);
            transition3.setCycleCount(50);
            transition3.setAutoReverse(true);
            transition3.play();

            RotateTransition transition5 = new RotateTransition(Duration.seconds(30), linex1);
            transition5.setByAngle(-3600);
            transition5.setCycleCount(50);
            transition5.setAutoReverse(true);
            transition5.play();

            RotateTransition transition4 = new RotateTransition(Duration.seconds(30), linex2);
            transition4.setByAngle(3600);
            transition4.setCycleCount(50);
            transition4.setAutoReverse(true);
            transition4.play();

            RotateTransition transition6 = new RotateTransition(Duration.seconds(30), circle4);
            transition6.setByAngle(3600);
            transition6.setCycleCount(50);
            transition6.setAutoReverse(true);
            transition6.play();

            RotateTransition transition7 = new RotateTransition(Duration.seconds(30), circle5);
            transition7.setByAngle(3600);
            transition7.setCycleCount(50);
            transition7.setAutoReverse(true);
            transition7.play();

    }


    @FXML
    void startGame(MouseEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        mainRoot.getChildren().setAll(pane);
    }

    @FXML
    void loadMenu(MouseEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("loadMenu.fxml"));
        mainRoot.getChildren().setAll(pane);
    }

}
