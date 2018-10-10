package com.company;

import javafx.geometry.Pos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Plateau {
	
	//Tableau de 11 cases sur 19
	private Position maze[][] = new Position[12][20];
	
	public Plateau(String lvl) throws FileNotFoundException, IOException{
		initPlateau(lvl);
	}
	
	public void initPlateau(String lvl) throws FileNotFoundException, IOException {


		String filePath = "test.txt";

		//lecture du fichier mit en paramètre
		String fichier = lvl;
		LinkedHashMap<Position, Character> map = new LinkedHashMap<Position, Character>();


		String line;
		File ips = new File(fichier);

		Scanner sc = new Scanner(new File(fichier));
		FileReader ipsr = new FileReader(ips);
		BufferedReader br = new BufferedReader(ipsr);
		try {
			int x = 0;
			int y = 0;
			while (sc.hasNextLine()) {
				for (char c : sc.next().toCharArray()) {

					if (x == 18) {
						y++;
						x = 0;
						Position position = new Position(x, y);
						map.put(position, '\n');
						break;
					}
					maze[y][x] = new Position(x, y);
					map.put(maze[y][x], c);
					x++;
				}
			}
		} finally {
			if (sc != null)
				sc.close();
		}

		//map.forEach((key,value) -> System.out.print(key.getX()+";"+key.getY()+"\n"));



		for (Position pos: map.keySet()){
			System.out.print(" " + map.get(pos));
		}

		}

	}

