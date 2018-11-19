import controler.Game;
import controler.Plateau;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Game game = new Game();
        game.initialisation();
    }
}
