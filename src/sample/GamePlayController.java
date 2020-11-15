package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.html.ImageView;
import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class GamePlayController implements Initializable {
    @FXML
    private AnchorPane playRoot;

    @FXML
    private Button pauseGame1;

    @FXML
    private ImageView pauseGame;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void pauseGame(MouseEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("pauseMenu.fxml"));
        playRoot.getChildren().setAll(pane);
    }
}
