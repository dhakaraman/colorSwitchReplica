package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class pauseMenuController implements Initializable {
    @FXML
    private AnchorPane pauseRoot;

    @FXML
    private Button resumeGame1;

    @FXML
    private ImageView resumeGame;

    @FXML
    private Button newGame1;

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

    }

    @FXML
    void mainMenu(MouseEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        pauseRoot.getChildren().setAll(pane);
    }

    @FXML
    void newGame(MouseEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        pauseRoot.getChildren().setAll(pane);
    }

}
