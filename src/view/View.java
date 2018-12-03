package view;

import controler.Position;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class View extends JFrame{


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
    private ImageIcon wall = new ImageIcon(getClass().getResource("mur.gif"));
    private ImageIcon player = new ImageIcon(getClass().getResource("perso.gif"));
    private ImageIcon playerZone = new ImageIcon(getClass().getResource("persoZone.gif"));
    private ImageIcon object = new ImageIcon(getClass().getResource("caisse.gif"));
    private ImageIcon objectZone = new ImageIcon(getClass().getResource("caisseOK.gif"));
    private ImageIcon goal = new ImageIcon(getClass().getResource("zone.gif"));
    private ImageIcon none = new ImageIcon(getClass().getResource("vide.gif"));

    JPanel panel = new JPanel();

    private static final View instance = new View();

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


    public void GraphicalMode(LinkedHashMap<Position, Character> map){

        setVisible(true);
        setBackground(Color.black);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setTitle("MySokoban");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(null);
        add(panel);
        panel.setVisible(true);
        panel.setBackground(Color.black);
        GridLayout dimention = new GridLayout(11,19);
        dimention.setHgap(-165);
        dimention.setVgap(-300);
        panel.setLayout(dimention);

        for (Position pos: map.keySet()) {

            switch (map.get(pos)) {
                case '0':
                    panel.add(new JLabel(none));
                    break;
                case '1':
                    panel.add(new JLabel(wall));
                    break;
                case '2':
                    panel.add(new JLabel(object));
                    break;
                case '5':
                    panel.add(new JLabel(player));
                    break;
                case '4':
                    panel.add(new JLabel(goal));
                    break;
                default:
                    panel.add(new JLabel(none));
            }
        }

        panel.updateUI();

    }

    public void Update(LinkedHashMap<Position, Character> map){

        panel.removeAll();

        for (Position pos: map.keySet()) {

            switch (map.get(pos)) {
                case '0':
                    panel.add(new JLabel(none));
                    break;
                case '1':
                    panel.add(new JLabel(wall));
                    break;
                case '2':
                    panel.add(new JLabel(object));
                    break;
                case '5':
                    panel.add(new JLabel(player));
                    break;
                case '4':
                    panel.add(new JLabel(goal));
                    break;
                default:
                    panel.add(new JLabel(none));
            }
        }

        panel.updateUI();
    }

}
