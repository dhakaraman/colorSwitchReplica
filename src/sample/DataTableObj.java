package sample;

import java.io.Serializable;
import java.util.ArrayList;

public class DataTableObj  implements Serializable {

    ArrayList<DataTable> gameData;

    public DataTableObj(ArrayList<DataTable> gameData){
        this.gameData = gameData;
    }
}
