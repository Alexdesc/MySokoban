package view;

import model.Player;
import model.Position;

import javax.swing.*;
import java.util.LinkedHashMap;

public class View {


    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public JTextArea jTextArea;
    public JScrollPane jScrollPane;


    private static final View instance = new View();
    private static Graphic graphic;

    private static Menu menu;
    //private constructor to avoid client applications to use constructor
    private View(){}

    public static View getInstance(){
        return instance;
    }


    public void displayTextMaze( LinkedHashMap<Position, Character> map ){



        for (Position pos: map.keySet()) {


           switch (map.get(pos)) {
                case '0':
                    System.out.print(ANSI_RESET + " " + ' ');
                    //jTextArea.append(" " + map.get(pos));
                    break;
                case '1':
                    System.out.print(ANSI_RED + " " + "#");
                    //jTextArea.append(" " + map.get(pos));
                    break;
                case '2':
                    System.out.print(ANSI_CYAN + " " + map.get(pos));
                    //jTextArea.append(" " + map.get(pos));
                    break;
                case '5':
                    System.out.print(ANSI_YELLOW + " " + map.get(pos));
                    //jTextArea.append(" " + map.get(pos));
                    break;
                case '4':
                    System.out.print(ANSI_GREEN + " " + map.get(pos));
                    //jTextArea.append(" " + map.get(pos));
                    break;
                default:
                    System.out.print(map.get(pos));
            }

        }
    }

    public void displayMenu(){

        this.menu = new Menu();
        this.menu.setVisible(true);

    }

    public void displayGraphic(Position maze[][], LinkedHashMap map, Player player){
        this.graphic = new Graphic();
        this.graphic.setVisible(true);
        this.graphic.graphic(maze, map, player);
    }




    public Menu getMenu() {
        return this.menu;
    }


    public Graphic getGraphic() {
        return this.graphic;
    }

}
