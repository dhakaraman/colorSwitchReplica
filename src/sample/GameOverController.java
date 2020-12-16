package sample;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.transform.Rotate;
import javafx.stage.Popup;
import javafx.util.Duration;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class GameOverController{
    @FXML
    public AnchorPane OverRoot;

    @FXML
    private ImageView circle1,circle2;

    @FXML
    public Label textField;

    @FXML
    public Button button;

    private DataTable lastGame;


    public void initialize() {

//        Popup popup = new Popup();
//        button.setText("Game Saved!");
//        button.setStyle(" -fx-background-color: #885c5e;");
//        popup.getContent().add(button);
//        popup.setAnchorX(190);
//        popup.setAnchorY(90);
//        popup.show(Main.stage);
//        popup.setAutoHide(true);

        Obstracle.imageRotate(circle1,1,true);
        Obstracle.imageRotate(circle2,1,true);

    }

    @FXML
    public void restart(MouseEvent event) throws Exception{
        GameElements.addMusic("/Sound Effects/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        OverRoot.getChildren().setAll(pane);
    }
    @FXML
    public void mainMenu(MouseEvent event) throws Exception{
        GameElements.addMusic("/Sound Effects/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        OverRoot.getChildren().setAll(pane);
    }

    @FXML
    public void revive() throws Exception{
        GameElements.addMusic("/Sound Effects/button.wav");
        FXMLLoader load = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        AnchorPane Pane = load.load();
        GamePlayController GPobj=load.getController();
        OverRoot.getChildren().setAll(Pane);

    }

    @FXML
    public void exitGame(MouseEvent event) {
        GameElements.addMusic("/Sound Effects/button.wav");
        System.exit(0);
    }



}
