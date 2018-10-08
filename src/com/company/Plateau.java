package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Plateau {
	
	//Tableau de 11 cases sur 19
	private Case tab[][] = new Case[11][19];
	
	public Plateau(String lvl) throws FileNotFoundException, IOException{
		initPlateau(lvl);
	}
	
	public void initPlateau(String lvl) throws FileNotFoundException, IOException{
		//lecture du fichier mit en paramètre
		String fichier=lvl;
		Case[] Plat = null;
		int cpts = 0;
			try{
				File ips = new File(fichier);
				Scanner sc = new Scanner(new File(fichier));
				FileReader ipsr = new FileReader(ips);
				BufferedReader br=new BufferedReader(ipsr);
				try {
					while (sc.hasNextLine()) {
						for (char c : sc.next().toCharArray()) {
							System.out.println(c);
							Plat[cpts+1].setLaCase(c);
						}
					}
				} finally {
				if (sc != null)
					sc.close();
				}

			} 
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
			//On rempli le plateau
			for(Case s:Plat){
				int longueur,largeur=0;
				for(longueur = 0; longueur < 10;longueur++){
					tab[longueur][largeur]= s;
				}
				largeur++;
			}
			
			for(Case[] a:tab){
				System.out.println(a);
			}
		}
	}

