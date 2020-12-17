package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ThemesController implements Initializable {
    GamePlayController obj;

    @FXML
    public AnchorPane themeRoot;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void blackBack() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm PlayBackgroundTheme " + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if(alert.getResult()==ButtonType.YES) {
            GamePlayController.id = 1;
            AnchorPane pane= FXMLLoader.load(getClass().getResource("Settings.fxml"));
            themeRoot.getChildren().setAll(pane);
        }
        else if(alert.getResult()==ButtonType.NO)
            alert.hide();
        else if(alert.getResult()==ButtonType.CANCEL)
            alert.hide();
    }

    public void white1Back() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm PlayBackgroundTheme " + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if(alert.getResult()==ButtonType.YES) {
            GamePlayController.id = 2;
            AnchorPane pane= FXMLLoader.load(getClass().getResource("Settings.fxml"));
            themeRoot.getChildren().setAll(pane);
        }
        else if(alert.getResult()==ButtonType.NO)
            alert.hide();
        else if(alert.getResult()==ButtonType.CANCEL)
            alert.hide();
    }

    public void whiteBack() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm PlayBackgroundTheme " + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if(alert.getResult()==ButtonType.YES) {
            GamePlayController.id = 3;
            AnchorPane pane= FXMLLoader.load(getClass().getResource("Settings.fxml"));
            themeRoot.getChildren().setAll(pane);
        }
        else if(alert.getResult()==ButtonType.NO)
            alert.hide();
        else if(alert.getResult()==ButtonType.CANCEL)
            alert.hide();
    }

    public void blueBack() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm PlayBackgroundTheme " + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if(alert.getResult()==ButtonType.YES) {
            GamePlayController.id = 4;
            AnchorPane pane= FXMLLoader.load(getClass().getResource("Settings.fxml"));
            themeRoot.getChildren().setAll(pane);
        }
        else if(alert.getResult()==ButtonType.NO)
            alert.hide();
        else if(alert.getResult()==ButtonType.CANCEL)
            alert.hide();
    }

    public void greyBack() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm PlayBackgroundTheme " + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if(alert.getResult()==ButtonType.YES) {
            GamePlayController.id = 5;
            AnchorPane pane= FXMLLoader.load(getClass().getResource("Settings.fxml"));
            themeRoot.getChildren().setAll(pane);
        }
        else if(alert.getResult()==ButtonType.NO)
            alert.hide();
        else if(alert.getResult()==ButtonType.CANCEL)
            alert.hide();
    }

    public void pinkBack() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Confirm PlayBackgroundTheme " + " ?", ButtonType.YES, ButtonType.NO, ButtonType.CANCEL);
        alert.showAndWait();
        if(alert.getResult()==ButtonType.YES) {
            GamePlayController.id = 6;
            AnchorPane pane= FXMLLoader.load(getClass().getResource("Settings.fxml"));
            themeRoot.getChildren().setAll(pane);
        }
        else if(alert.getResult()==ButtonType.NO)
            alert.hide();
        else if(alert.getResult()==ButtonType.CANCEL)
            alert.hide();
    }

    public void backToSetting() throws Exception{
        GameElements.addMusic("/Sound Effects/button.wav");
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Settings.fxml"));
        themeRoot.getChildren().setAll(pane);
    }

    @FXML
    void glowImage(MouseEvent event) throws IOException {
        Glow glow=new Glow();
        Node source = (Node) event.getSource();
        source.setEffect(glow);
        glow.setLevel(0.4);
    }

    @FXML
    void stopGlowing(MouseEvent event) throws IOException{
        Node source= (Node) event.getSource();
        Glow glow=(Glow) source.getEffect();
        source.setEffect(glow);
        glow.setLevel(0.0);
    }

}
