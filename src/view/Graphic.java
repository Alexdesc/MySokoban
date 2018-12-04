package view;

import model.Player;
import model.Position;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedHashMap;

public class Graphic extends JFrame {



    private  SokobanImage SImg = new SokobanImage();
    private  Screen sc;
    public final void initUI() {


        setTitle("Test Panel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setResizable(false);
        //setLocationRelativeTo(null);


        setLayout(new GridLayout(1,1,0,0));

        this.sc  = new Screen();

        this.getContentPane().add(sc);
        add(sc);



      //  JPanel jpanel = new JPanel(new GridLayout(10, 10));


    }


    public void graphic(Position maze[][], LinkedHashMap map, Player player) {

        initUI();
/*
        System.out.println("Graphic mode");
        JFrame window = new JFrame();
        window.setVisible(true);
        window.setSize(800, 700);
        window.setLocationRelativeTo(null);
        window.setTitle("MySokoban Project");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Panel panel = new Panel();
        window.setBackground(Color.black);
        window.add(panel);
*/

    }


    public JButton getQuitButton() {
        return sc.getQuitButton();
    }
}