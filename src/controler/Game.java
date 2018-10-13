package controler;

import model.Model;
import view.View;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Game {


    private View v = View.getInstance();
    private Model m = Model.getInstance();

    public void initialisation() throws FileNotFoundException, IOException {

        m.initPlateau("lvl1.txt");
        v.displayTextMaze(m.getMap());
        v.displayGraphic(m.getMaze(), m.getMap());
    }
}
