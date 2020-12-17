package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;

public class PauseMenuController implements Initializable {
    @FXML
    private AnchorPane pauseRoot;

    @FXML
    private ImageView circle1, circle2;

    @FXML
    public Label textField;

    public DataTable lastGameData;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        Obstacle.imageRotate(circle1,1,true);
        Obstacle.imageRotate(circle2,1,true);

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
        GPobj.initializeData(lastGameData.obstacles,lastGameData.colorSwitch,lastGameData.stars,lastGameData.ballPos,lastGameData.score,lastGameData.ballCol,0, lastGameData.backgroImageID );
    }

    @FXML
    public void saveGame() throws IOException, ClassNotFoundException{
        GameElements.addMusic("/Sound Effects/button.wav");
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
