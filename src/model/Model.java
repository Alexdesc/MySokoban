package model;

import controler.Player;
import controler.Position;
import sun.font.TrueTypeFont;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Model {


    private Player player;
    private Position maze[][] = new Position[12][20];
    private LinkedHashMap<Position, Character> map = new LinkedHashMap<Position, Character>();
    private static final Model instance = new Model();
    private boolean Win = false;
    private char keys[] = {'z','q','s','d'};
    private boolean OnTheArrival = false;
    private boolean OnTheArrival2 = false;
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

    public void move( LinkedHashMap<Position, Character> map ) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        String key = scanner.next();
        Position tmp = new Position(0,0);
        Position tmp2 = player.getPosition();
        Player player_tmp = player;
        switch (key.toLowerCase()){

                case "z":
                    tmp = player.getPosition().toUp();
                    break;
                case "s":
                    tmp = player.getPosition().toDown();

                    break;
                case "q":
                    tmp = player.getPosition().toLeft();
                    break;
                case "d":
                    tmp = player.getPosition().toRight();
                    break;

                    default:
                        System.out.println("none");
        }



        /** Move without with bloc**/
        if (map.get(maze[tmp.getY()][tmp.getX()]) == '2') {

            switch (key.toLowerCase()) {

                case "z":
                    tmp2 = tmp.toUp();
                    break;
                case "s":
                    tmp2 = tmp.toDown();

                    break;
                case "q":
                    tmp2 = tmp.toLeft();
                    break;
                case "d":
                    tmp2 = tmp.toRight();
                    break;

                default:
                    System.out.println("none");
            }


            if (map.get(maze[tmp2.getY()][tmp2.getX()]) == '0' ||
                    map.get(maze[tmp2.getY()][tmp2.getX()]) == '4') {

                map.put(maze[tmp2.getY()][tmp2.getX()], '2');

                map.put(maze[player.getPosition().getY()][player.getPosition().getX()], '0');
                if (OnTheArrival2){
                    map.put(maze[player.getPosition().getY()][player.getPosition().getX()], '4');
                    OnTheArrival2 = false;
                }
                if (map.get(maze[tmp.getY()][tmp.getX()]) == '4')
                    OnTheArrival2 = true;


                player.setPosition(tmp);
                map.put(maze[player.getPosition().getY()][player.getPosition().getX()], '5');
            }
        }

        /** Move without without bloc**/
        else if (map.get(maze[tmp.getY()][tmp.getX()]) != '1') {

            map.put(maze[player.getPosition().getY()][player.getPosition().getX()], '0');
            if (OnTheArrival){
                map.put(maze[player.getPosition().getY()][player.getPosition().getX()], '4');
                OnTheArrival = false;
            }
            if (map.get(maze[tmp.getY()][tmp.getX()]) == '4')
                OnTheArrival = true;
            player.setPosition(tmp);
            map.put(maze[player.getPosition().getY()][player.getPosition().getX()], '5');
        }
        Thread.sleep(100);

    }
    public LinkedHashMap getMap(){
        return this.map;
    }

    public void ToWin(){
        this.Win = true;
    }

    public boolean isWin(){
        return this.Win;
    }
    public Position[][] getMaze(){
        return this.maze;
    }

}

