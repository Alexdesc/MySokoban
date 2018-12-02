package view;

import controler.Position;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class GraphicalMode extends JFrame {

    //images
    private ImageIcon wall = new ImageIcon(getClass().getResource("mur.gif"));
    private ImageIcon player = new ImageIcon(getClass().getResource("perso.gif"));
    private ImageIcon playerZone = new ImageIcon(getClass().getResource("persoZone.gif"));
    private ImageIcon object = new ImageIcon(getClass().getResource("caisse.gif"));
    private ImageIcon objectZone = new ImageIcon(getClass().getResource("caisseOK.gif"));
    private ImageIcon goal = new ImageIcon(getClass().getResource("zone.gif"));
    private ImageIcon none = new ImageIcon(getClass().getResource("vide.gif"));

    public GraphicalMode(LinkedHashMap<Position, Character> map){

        super("GraphicalMode");
        setVisible(true);
        setBackground(Color.black);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setTitle("MySokoban");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        panel.setVisible(true);
        //panel.setSize(800,700);
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
        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);
        panel.setVisible(true);
        //panel.setSize(800,700);
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
}
