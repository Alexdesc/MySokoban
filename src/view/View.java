package view;

import model.Player;
import model.Position;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

import static java.awt.Color.black;

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


    //images


    private ImageIcon wall = new ImageIcon(getClass().getResource("../rsrc/mur.gif"));
    private ImageIcon player = new ImageIcon(getClass().getResource("../rsrc/perso.gif"));
    private ImageIcon playerZone = new ImageIcon(getClass().getResource("../rsrc/persoZone.gif"));
    private ImageIcon object = new ImageIcon(getClass().getResource("../rsrc/caisse.gif"));
    private ImageIcon objectZone = new ImageIcon(getClass().getResource("../rsrc/caisseOK.gif"));
    private ImageIcon goal = new ImageIcon(getClass().getResource("../rsrc/zone.gif"));
    private ImageIcon none = new ImageIcon(getClass().getResource("../rsrc/vide.gif"));


    public JTextArea jTextArea;
    public JScrollPane jScrollPane;

    private JLabel keyLabel = new JLabel("Press something");
    private static final View instance = new View();
    private static Graphic graphic;

    private static Menu menu;
    //private constructor to avoid client applications to use constructor
    private View(){}

    public static View getInstance(){
        return instance;
    }


    public void displayTextMaze( LinkedHashMap<Position, Character> map, int coups ){



        for (Position pos: map.keySet()) {


           switch (map.get(pos)) {
                case '0':
                    System.out.print(ANSI_RESET + " " + ' ');
                    break;
                case '1':
                    System.out.print(ANSI_RED + " " + "#");
                    break;
                case '2':
                    System.out.print(ANSI_CYAN + " " + map.get(pos));
                    break;
                case '5':
                    System.out.print(ANSI_YELLOW + " " + map.get(pos));
                    break;
                case '4':
                    System.out.print(ANSI_GREEN + " " + map.get(pos));
                    break;
                default:
                    System.out.print(map.get(pos));
            }

        }

        System.out.println(coups);
    }

    public void displayMenu(){

        this.menu = new Menu();
        this.menu.setVisible(true);

    }

    public void displayGraphic(Position maze[][], LinkedHashMap map, Player player, int[] size){


        this.graphic = new Graphic();
        this.graphic.setVisible(true);
        this.graphic.graphic(maze, map, player, size);
    }

    public void win_console(){
        System.out.println(ANSI_GREEN + " " +"VICTOIRE");
    }

    public void win_graphic(){
        JFrame winframe = new JFrame("VICTOIRE");
        winframe.setVisible(true);
        winframe.setBackground(black);
        winframe.setSize(852 , 480);
        winframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        winframe.setLocationRelativeTo(null);
        winframe.add(new JLabel(new ImageIcon(getClass().getResource("../rsrc/win.jpg"))));

    }


    public Menu getMenu() {
        return this.menu;
    }


    public Graphic getGraphic() {
        return this.graphic;
    }



}
