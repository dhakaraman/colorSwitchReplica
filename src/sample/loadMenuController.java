package sample;

import javafx.animation.RotateTransition;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class loadMenuController {
    @FXML
    private AnchorPane loadRoot;

    @FXML
    private Button BackButon1;

    @FXML
    private ImageView circle1;

    @FXML
    private ImageView circle2;

    @FXML
    private ImageView BackButton;

    @FXML
    private ListView textField;

    ArrayList<DataTable> loadedGames;

    @FXML
    void mainMenu(MouseEvent event) throws Exception{
        addMusic("/Sound Effects/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        loadRoot.getChildren().setAll(pane);
    }


    public void initialize() throws Exception{
        listOfSavedGames();
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

    public void deleteGames() throws Exception{
        File file = new File("SavedGames.txt");
        if(file.delete() && file.exists()){
            System.out.println("SavedGames.txt File deleted");
        }
        else{
            addMusic("/Sound Effects/error.wav");
        }
    }

    public void loadGame() throws IOException, ClassNotFoundException {
        ObservableList selectedIndices = textField.getSelectionModel().getSelectedIndices();
        for(Object o : selectedIndices){
            System.out.println("o = " + o + " (" + o.getClass() + ")");
            addMusic("/Sound Effects/button.wav");
            FXMLLoader load = new FXMLLoader(getClass().getResource("GamePlay.fxml"));
            AnchorPane Pane = load.load();
            GamePlayController GPobj=load.getController();
            loadRoot.getChildren().setAll(Pane);
            GPobj.deserialize((Integer) o);
        }
    }

    public void listOfSavedGames() throws Exception {
        ObjectInputStream in = null;
        DataTableObj obj;
        try {
            in = new ObjectInputStream(
                    new FileInputStream("SavedGames.txt"));
            obj = (DataTableObj) in.readObject();

            for(int i=0;i<obj.gameData.size();i++){
                textField.getItems().add(i+1+". Your score = "+ obj.gameData.get(i).score);
            }

        }
        finally {
            in.close();
        }
    }

    private void addMusic(String fileName){
        Media sound = new Media(getClass().getResource(fileName).toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setStartTime(Duration.seconds(0));
        mediaPlayer.setStopTime(Duration.seconds(1));
        mediaPlayer.play();
    }

    public void setLoadGame(ArrayList<DataTable> loadedGames){
        this.loadedGames = loadedGames;
    }
    public void addGame(DataTable game){
        this.loadedGames.add(game);
    }
}



