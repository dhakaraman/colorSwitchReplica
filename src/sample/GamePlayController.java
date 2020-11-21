package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class GamePlayController  {
    @FXML
    private AnchorPane playRoot;

    @FXML
    private Button pauseGame1;

    @FXML
    private ImageView pauseGame;

    public void initialize() throws Exception {
        int shape = randomGenrator();
        AnchorPane pane2= FXMLLoader.load(getClass().getResource("Ball.fxml"));
        playRoot.getChildren().addAll(pane2);

        if(shape==1){
            AnchorPane pane= FXMLLoader.load(getClass().getResource("circleShape.fxml"));
            playRoot.getChildren().addAll(pane);
        }
        if(shape==2){
            AnchorPane pane= FXMLLoader.load(getClass().getResource("triangleShape.fxml"));
            playRoot.getChildren().addAll(pane);
        }

        if(shape==3){
            AnchorPane pane= FXMLLoader.load(getClass().getResource("squareShape.fxml"));
            playRoot.getChildren().addAll(pane);
        }
        if(shape==4){
            AnchorPane pane= FXMLLoader.load(getClass().getResource("LineShape.fxml"));
            playRoot.getChildren().addAll(pane);
        }

        System.out.print(shape);

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
