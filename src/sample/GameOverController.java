package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class GameOverController implements Initializable {
    @FXML
    public AnchorPane OverRoot;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    void exitGame(MouseEvent event) {
//        try{
////            Main.serialize();
//        }
//        catch(IOException e){
//            //System.out.println("Could not save the progress :(");
//        }
        System.exit(0);
    }

    void mainMenu(MouseEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        OverRoot.getChildren().setAll(pane);
    }

    @FXML
    void newGame(MouseEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        OverRoot.getChildren().setAll(pane);
    }
}
