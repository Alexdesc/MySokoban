package model;

import controler.Player;
import controler.Position;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Model {


    private Player player;
    private Position maze[][] = new Position[12][20];
    private LinkedHashMap<Position, Character> map = new LinkedHashMap<Position, Character>();
    private static final Model instance = new Model();

    //private constructor to avoid client applications to use constructor
    private Model() {
    }

    public static Model getInstance() {
        return instance;
    }


    public void initPlateau(String lvl) throws FileNotFoundException, IOException {


        //lecture du fichier mit en paramètre
        String fichier = lvl;


        File ips = new File(fichier);

        Scanner sc = new Scanner(new File(fichier));
        FileReader ipsr = new FileReader(ips);
        BufferedReader br = new BufferedReader(ipsr);
        try {
            int x = 0;
            int y = 0;
            while (sc.hasNextLine()) {
                for (char c : sc.next().toCharArray()) {

                    if (x == 18)
                    {
                        y++;
                        x = 0;
                        Position position = new Position(x, y);
                        map.put(position, '\n');
                        break;
                    }

                    maze[y][x] = new Position(x, y);

                    if (c == '5') {
                        player = new Player(maze[y][x], "PLAYER");
                    }
                    map.put(maze[y][x], c);
                    x++;
                }
            }
        } finally {
            if (sc != null)
                sc.close();
        }

    }

    public LinkedHashMap getMap(){
        return this.map;
    }

    public Position[][] getMaze(){
        return this.maze;
    }

}
