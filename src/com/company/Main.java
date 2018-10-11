package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Init");
        Plateau p = new Plateau("lvl1.txt");
    	JFrame window = new JFrame();
    	window.setVisible(true);
    	window.setSize(800, 700);
    	window.setLocationRelativeTo(null);
    	window.setTitle("MySokoban");
    	window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	Panel panel = new Panel();
    	window.add(panel);
    }
}
