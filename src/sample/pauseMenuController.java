package sample;

import javafx.animation.RotateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Popup;
import javafx.util.Duration;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class pauseMenuController  implements Initializable {
    @FXML
    private AnchorPane pauseRoot;

    @FXML
    private ImageView circle1, circle2;

    public DataTable lastGameData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Obstracle.imageRotate(circle1,1,true);
        Obstracle.imageRotate(circle2,1,true);

    }

    @FXML
    void mainMenu(MouseEvent event) throws Exception{
        GameElements.addMusic("/Sound Effects/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        pauseRoot.getChildren().setAll(pane);
    }

    @FXML
    void newGame(MouseEvent event) throws Exception{
        GameElements.addMusic("/Sound Effects/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        pauseRoot.getChildren().setAll(pane);
    }

    @FXML
    void resumeGame(MouseEvent event) throws Exception{
        GameElements.addMusic("/Sound Effects/button.wav");
        FXMLLoader load = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        AnchorPane Pane = load.load();
        GamePlayController GPobj=load.getController();
        pauseRoot.getChildren().setAll(Pane);
        GPobj.initializeData(lastGameData.obstacles,lastGameData.colorSwitch,lastGameData.stars,lastGameData.ballPos,lastGameData.score,lastGameData.ballCol);
    }

    @FXML
    public void saveGame() throws IOException, ClassNotFoundException{
        ObjectInputStream in = null;
        DataTableObj object;
        try {
            in = new ObjectInputStream(
                    new FileInputStream("SavedGames.txt"));
            object = (DataTableObj) in.readObject();
            object.gameData.add(lastGameData);
        }
        finally {
            in.close();
        }

        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream (new FileOutputStream("SavedGames.txt"));
            out.writeObject(object);
        }
        finally {
            out.close();
        }

        System.exit(0);

    }
}
