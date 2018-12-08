package view;

import model.Position;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class Screen extends JPanel{


    //images


    private ImageIcon wall = new ImageIcon(getClass().getResource("../rsrc/mur.gif"));
    private ImageIcon player = new ImageIcon(getClass().getResource("../rsrc/perso.gif"));
    private ImageIcon playerZone = new ImageIcon(getClass().getResource("../rsrc/persoZone.gif"));
    private ImageIcon object = new ImageIcon(getClass().getResource("../rsrc/caisse.gif"));
    private ImageIcon objectZone = new ImageIcon(getClass().getResource("../rsrc/caisseOK.gif"));
    private ImageIcon goal = new ImageIcon(getClass().getResource("../rsrc/zone.gif"));
    private ImageIcon none = new ImageIcon(getClass().getResource("../rsrc/vide.gif"));



    private JLabel infobar;
    private  BorderLayout layout;

    public Screen (int height, int width){


        setVisible(true);
        setBackground(Color.black);
        setSize(800, 700);

       layout = new BorderLayout();
        setLayout(null);

        setVisible(true);
        setBackground(Color.black);
        GridLayout dimention = new GridLayout(height+1,width);
        dimention.setHgap(-165);
        dimention.setVgap(-300);

        setLayout(dimention);


    }

    public void setSprite(LinkedHashMap<Position, Character> map){

        for (Position pos: map.keySet()) {

            switch (map.get(pos)) {
                case '0':
                    this.add(new JLabel(none));
                    break;
                case '1':
                    this.add(new JLabel(wall));
                    break;
                case '2':
                    this.add(new JLabel(object));
                    break;
                case '5':
                    this.add(new JLabel(player));
                    break;
                case '4':
                    this.add(new JLabel(goal));
                    break;
                default:
                    this.add(new JLabel(none));
            }
        }

        this.updateUI();
        Update(map);
    }


    public void Update(LinkedHashMap<Position, Character> map){

        this.removeAll();

        for (Position pos: map.keySet()) {

            switch (map.get(pos)) {
                case '0':
                    this.add(new JLabel(none));
                    break;
                case '1':
                    this.add(new JLabel(wall));
                    break;
                case '2':
                    this.add(new JLabel(object));
                    break;
                case '5':
                    this.add(new JLabel(player));
                    break;
                case '4':
                    this.add(new JLabel(goal));
                    break;
                default:
                    this.add(new JLabel(none));
            }
        }

        this.updateUI();
    }









}
