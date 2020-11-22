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

public class loadMenuController implements Initializable {
    @FXML
    private AnchorPane loadRoot;

    @FXML
    private Button BackBuuton1;

    @FXML
    private ImageView BackButton;

    @FXML
    void mainMenu(MouseEvent event) throws Exception{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        loadRoot.getChildren().setAll(pane);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
}



