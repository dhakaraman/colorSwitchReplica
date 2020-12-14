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
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class pauseMenuController  implements Initializable {
    @FXML
    private AnchorPane pauseRoot;

    @FXML
    private ImageView circle1;

    @FXML
    private ImageView circle2;

    @FXML
    private ImageView newGame;

    @FXML
    private Button mainMenu1;

    @FXML
    private ImageView mainMenu;

    @FXML
    private Button exitGame1;

    @FXML
    private ImageView exitGame;

    GamePlayController obj;

    public int temp;

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

        System.out.println(temp);

        RotateTransition transition1 = new RotateTransition(Duration.seconds(30), circle1);
        transition1.setByAngle(3600);
        transition1.setCycleCount(50);
        transition1.setAutoReverse(true);
        transition1.play();

        RotateTransition transition2 = new RotateTransition(Duration.seconds(30), circle2);
        transition2.setByAngle(3600);
        transition2.setCycleCount(50);
        transition2.setAutoReverse(true);
        transition2.play();

    }

    @FXML
    void mainMenu(MouseEvent event) throws Exception{
        addMusic("/Sound Effects/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        pauseRoot.getChildren().setAll(pane);
    }

    @FXML
    void newGame(MouseEvent event) throws Exception{
        addMusic("/Sound Effects/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        pauseRoot.getChildren().setAll(pane);
    }

    @FXML
    void resumeGame(MouseEvent event) throws Exception{
//        Main.deserialize();
//        AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
//        pauseRoot.getChildren().setAll(pane);
        addMusic("/Sound Effects/button.wav");
        FXMLLoader load = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
        GamePlayController temp;
        GamePlayController obj = deserialize();
        AnchorPane pane = load.load();
        temp = load.getController();
        temp.initData(obj.a1, obj.a2, obj.a3, obj.a4);
        //temp.a1= obj.a1;

        pauseRoot.getChildren().setAll(pane);

        //AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        //pauseRoot.getChildren().setAll(pane);
    }

    private void addMusic(String fileName){
        Media sound = new Media(getClass().getResource(fileName).toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(1));
        mediaPlayer.play();
    }


    public static GamePlayController deserialize() throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;
        GamePlayController s1;
        try {
            in = new ObjectInputStream(
                    new FileInputStream("out.txt"));
             s1 = (GamePlayController) in.readObject();
        } finally {
            in.close();
        }
        return s1;
    }
}
