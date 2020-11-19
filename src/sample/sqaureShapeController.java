package sample;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Line;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class sqaureShapeController {

    @FXML
    private Line line1;

    @FXML
    private Line line2;

    @FXML
    private Line line3;

    @FXML
    private Line line4;

    @FXML
    private Line line5;

    @FXML
    private void initialize() {
        Rotate rotation = new Rotate();
        rotation.pivotXProperty().bind(line5.layoutXProperty());
        rotation.pivotYProperty().bind(line5.layoutYProperty());
        line1.getTransforms().add(rotation);
        line2.getTransforms().add(rotation);
        line3.getTransforms().add(rotation);
        line4.getTransforms().add(rotation);
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(rotation.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(1000), new KeyValue(rotation.angleProperty(), 36000)));
        timeline.play();


    }

}
