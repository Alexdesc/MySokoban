package view;

import model.Player;
import model.Position;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class Graphic extends JFrame {



  //  private  SokobanImage SImg = new SokobanImage();
    private  Screen sc;
    private Menu info;

    public final void initUI(int[] size) {


        setVisible(true);
        setBackground(Color.black);
        setSize(800, 700);
        setLocationRelativeTo(null);
        setTitle("MySokoban");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        this.sc  = new Screen(size[0], size[1]);
        this.info = new Menu();
        this.add(info, BorderLayout.PAGE_END);
        this.add(sc, BorderLayout.CENTER);




    }


    public void graphic(Position maze[][], LinkedHashMap map, Player player, int [] size ) {

        initUI(size);
        sc.setSprite(map);

    }


    public Screen getSc() {
        return sc;
    }

    public Menu getInfo(){
        return info;
    }

}