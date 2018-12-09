package view;

import model.Position;
import model.SokobanImage;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class Screen extends JPanel{
    

    private SokobanImage sprite = SokobanImage.getInstance();
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
                    this.add(new JLabel(sprite.getNone()));
                    break;
                case '1':
                    this.add(new JLabel(sprite.getWall()));
                    break;
                case '2':
                    this.add(new JLabel(sprite.getCaisse()));
                    break;
                case '5':
                    this.add(new JLabel(sprite.getPlayer()));
                    break;
                case '4':
                    this.add(new JLabel(sprite.getGoal()));
                    break;
                default:
                    this.add(new JLabel(sprite.getNone()));
            }
        }

        this.updateUI();
    }


    public void Update(LinkedHashMap<Position, Character> map){

        this.removeAll();
        this.setSprite(map);
    }









}
