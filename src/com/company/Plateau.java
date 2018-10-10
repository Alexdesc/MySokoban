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

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";


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

			switch (map.get(pos)) {
				case '0':
					System.out.print(ANSI_RESET + " " +map.get(pos));
					break;
				case '1':
					System.out.print(ANSI_RED + " " + map.get(pos));
					break;
				case '2':
					System.out.print(ANSI_CYAN + " " + map.get(pos));
					break;
				case '5':
					System.out.print(ANSI_YELLOW + " " + map.get(pos));
					break;
				case '4':
					System.out.print(ANSI_GREEN + " " + map.get(pos));
					break;
				default:
					System.out.print(map.get(pos));
			}


		}

		}

	}

