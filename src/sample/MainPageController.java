package sample;

import javafx.animation.RotateTransition;
import javafx.scene.control.Button;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainPageController{

    @FXML
    private AnchorPane mainRoot;

    @FXML
    private ImageView circle1,circle2,circle3,circle4,circle5;

    @FXML
    private ImageView linex1,linex2;


    public void initialize() throws IOException {

        File file = new File("SavedGames.txt");
        if(!file.exists()){
            ArrayList<DataTable> arr = new ArrayList<>();
            DataTableObj oj = new DataTableObj(arr);
            ObjectOutputStream out = null;
            try {
                out = new ObjectOutputStream (new FileOutputStream("SavedGames.txt"));
                out.writeObject(oj);
            }
            finally {
                out.close();
            }
        }

        Obstracle.imageRotate(circle1,1,true);
        Obstracle.imageRotate(circle2,1,true);
        Obstracle.imageRotate(circle3,-1,true);
        Obstracle.imageRotate(circle4,1,true);
        Obstracle.imageRotate(circle5,1,true);
        Obstracle.imageRotate(linex1,-1,true);
        Obstracle.imageRotate(linex2,1,true);

    }

    @FXML
    void startGame(MouseEvent event) throws Exception{
        GameElements.addMusic("/Sound Effects/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("GamePlay.fxml"));
        mainRoot.getChildren().setAll(pane);
    }

    @FXML
    void loadMenu(MouseEvent event) throws Exception{
        GameElements.addMusic("/Sound Effects/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("loadMenu.fxml"));
        mainRoot.getChildren().setAll(pane);
    }

    @FXML
    void exitGame(MouseEvent event) {
        GameElements.addMusic("/Sound Effects/button.wav");
        System.exit(0);
    }

}
