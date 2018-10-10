package com.company;

import javax.swing.JFrame;

public class Game_Vue extends JFrame{
	
	public Game_Vue(){
		this.setVisible(true);
		this.setSize(800, 700);
		this.setLocationRelativeTo(null);
		this.setTitle("MySokoban");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void affiche_plateau(Plateau p){
		
	}

}
