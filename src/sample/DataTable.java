
package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DataTable implements Serializable {

    ArrayList<Double> obstacles;
    ArrayList<Double> colorSwitch;
    ArrayList<Double> stars;
    double ballPos;
    int ballCol;
    int score;

    public DataTable(ArrayList<Double> obstacles, ArrayList<Double> colorSwitch, ArrayList<Double> stars, double ballPos, int score,int ballCol){
        this.obstacles  = obstacles;
        this.colorSwitch = colorSwitch;
        this.stars = stars;
        this.ballPos = ballPos;
        this.ballCol = ballCol;
        this.score = score;
    }

}