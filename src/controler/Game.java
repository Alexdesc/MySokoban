package controler;

import model.Model;
import view.View;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;


public class Game {


    /**
     * Singlestons to use MVC data easily
     */
    private View v = View.getInstance();
    private Model m = Model.getInstance();

    public void initialisation() throws FileNotFoundException, IOException, InterruptedException {
        m.initPlateau("lvl1.txt");
        System.out.println(" Console mode : 1 \n Graphical mode : 2");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.next();
        if (option.equals("1")){
            v.displayTextMaze(m.getMap());
            while (m.isWin() != true) {
                m.move(m.getMap());
                v.displayTextMaze(m.getMap());
            }
        }
        else {
            v.GraphicalMode(m.getMap());
            while (m.isWin() != true) {
                m.move(m.getMap());
                v.Update(m.getMap());
            }
        }
    }

    public void current_game() {

        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent keyEvent) {
                printIt("Pressed", keyEvent);
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

            private void printIt(String title, KeyEvent keyEvent) {
                int keyCode = keyEvent.getKeyCode();
                String keyText = KeyEvent.getKeyText(keyCode);
                System.out.println(title + " : " + keyText + " / " + keyEvent.getKeyChar());
            }
        };
    }

}
