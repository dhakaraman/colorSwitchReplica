package sample;

import javafx.animation.RotateTransition;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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
    private ImageView circle1, circle2;

    @FXML
    private ListView textField;

    ArrayList<DataTable> loadedGames;

    private DataTableObj game;

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
        if(file.exists() && game.gameData.size()>0){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Delete " + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                file.delete();
                Alert alert2 = new Alert(Alert.AlertType.CONFIRMATION, "Your saved games have been Deleted! " + " !", ButtonType.OK);
                alert2.showAndWait();
                if(alert2.getResult()==ButtonType.OK){
                    GameElements.addMusic("/Sound Effects/button.wav");
                    AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
                    loadRoot.getChildren().setAll(pane);
                    alert2.hide();
                }
                alert.hide();

            }
            else if(alert.getResult()==ButtonType.NO){
                alert.hide();
            }
            else if(alert.getResult()==ButtonType.CANCEL){
                alert.hide();
            }
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR, "You Don't have saved games " + " !", ButtonType.OK);
            alert.showAndWait();
            if(alert.getResult()==ButtonType.OK){
                alert.hide();
            }

            GameElements.addMusic("/Sound Effects/error.wav");
        }
    }

    @FXML
    void mainMenu(MouseEvent event) throws Exception{
        GameElements.addMusic("/Sound Effects/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        loadRoot.getChildren().setAll(pane);
    }

    public void loadGame() throws IOException, ClassNotFoundException {
        ObservableList selectedIndices = textField.getSelectionModel().getSelectedIndices();
        for(Object o : selectedIndices){
            System.out.println("o = " + o + " (" + o.getClass() + ")");
            GameElements.addMusic("/Sound Effects/button.wav");
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
            game=obj;
            for(int i=0;i<obj.gameData.size();i++){
                textField.getItems().add(i+1+". Your score = "+ obj.gameData.get(i).score);
            }

        }
        finally {
            in.close();
        }
    }

    public void setLoadGame(ArrayList<DataTable> loadedGames){
        this.loadedGames = loadedGames;
    }
    public void addGame(DataTable game){
        this.loadedGames.add(game);
    }
}



