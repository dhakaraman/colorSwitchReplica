package sample;

import javafx.animation.RotateTransition;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.RotateTransition;
import javafx.util.Duration;


public class MainPageController implements Initializable{

    @FXML
    private AnchorPane mainRoot;

    @FXML
    private ImageView circle1;

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
        RotateTransition transition1 = new RotateTransition(Duration.seconds(40),circle1);
        transition1.setByAngle(3600);
        transition1.play();
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
