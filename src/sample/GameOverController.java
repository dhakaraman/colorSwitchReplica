package sample;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class GameOverController{
    @FXML
    public AnchorPane OverRoot;

    @FXML
    private ImageView circle1;

    @FXML
    public ImageView circle2;


    public void initialize() {
//        RotateTransition transition1 = new RotateTransition(Duration.seconds(30), circle1);
//        transition1.setByAngle(3600);
//        transition1.setCycleCount(50);
//        transition1.setAutoReverse(true);
//        transition1.play();
//
//        RotateTransition transition2 = new RotateTransition(Duration.seconds(30), circle2);
//        transition1.setByAngle(3600);
//        transition1.setCycleCount(50);
//        transition1.setAutoReverse(true);
//        transition1.play();
    }

    void exitGame(MouseEvent event) {
//        try{
////            Main.serialize();
//        }
//        catch(IOException e){
//            //System.out.println("Could not save the progress :(");
//        }
        System.exit(0);
    }

    void mainMenu(MouseEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        OverRoot.getChildren().setAll(pane);
    }

    @FXML
    void newGame(MouseEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        OverRoot.getChildren().setAll(pane);
    }



}
