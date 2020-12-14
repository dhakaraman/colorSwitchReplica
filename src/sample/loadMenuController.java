package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class loadMenuController implements Initializable {
    @FXML
    private AnchorPane loadRoot;

    @FXML
    private Button BackButon1;

    @FXML
    private ImageView BackButton;

    @FXML
    void mainMenu(MouseEvent event) throws Exception{
        addMusic("/Sound Effects/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        loadRoot.getChildren().setAll(pane);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
    private void addMusic(String fileName){
        Media sound = new Media(getClass().getResource(fileName).toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(1));
        mediaPlayer.play();
    }
}



