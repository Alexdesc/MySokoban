package view;

import model.Player;
import model.Position;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class Graphic extends JFrame {



  //  private  SokobanImage SImg = new SokobanImage();
    private  Screen sc;
    private DetailBar info;


    public Graphic(Position maze[][], LinkedHashMap map, Player player, int [] size ){
        setVisible(true);
        setBackground(Color.black);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setTitle("MySokoban");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        this.sc  = new Screen(size[0], size[1]);
        this.info = new DetailBar();
        this.add(info, BorderLayout.PAGE_END);
        this.add(sc, BorderLayout.CENTER);
        sc.setSprite(map);
    }

    public Screen getSc() {
        return sc;
    }

    public DetailBar getInfo(){
        return info;
    }

}