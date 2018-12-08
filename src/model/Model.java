package model;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

public class Model {


    private Player player;
    private Position maze[][] = new Position[50][50];
    private LinkedHashMap<Position, Character> map = new LinkedHashMap<Position, Character>();
    private List<Position> ArrivalList = new ArrayList<>();
    private static final Model instance = new Model();
    private String FirstLine = "";
    public int x = 0;
    public int y = 0;

    private int height = 0 ;
    private int  width = 0;


    private boolean graphicalStart = false;

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



        while(this.FirstLine != null) {
            this.FirstLine = br.readLine();
            if (FirstLine != null) {
                mapping();
            }
            this.x=0;
            this.y++;

        }


    }




    public void mapping() {

        for(char c : this.FirstLine.toCharArray()) {

           maze[this.y][this.x] = new Position(this.x, this.y);

                    if (c == '5') {
                        player = new Player(maze[this.y][this.x], "PLAYER");
                    }
                    if (c == '4') {
                        ArrivalList.add(maze[this.y][this.x]);
                    }
                    map.put(maze[this.y][this.x], c);
                    x++;
                }




        this.height = y;
        this.width = x;

        maze[this.y][this.x] = new Position(this.x, this.y);
        map.put(maze[this.y][this.x], '\n');

    }




    /** AI of this maze**/







    public void AI() throws InterruptedException {

        Position tmp = new Position(0, 0);
        Position tmp2 = player.getPosition();
        Player player_tmp = player;

        char move;

        move = 'z';
        tmp = player.getPosition().toUp();

        move = 's';
        tmp = player.getPosition().toDown();

        move = 'q';
        tmp = player.getPosition().toLeft();

        move = 'd';
        tmp = player.getPosition().toRight();


        /** Move  with bloc**/
        if (map.get(maze[tmp.getY()][tmp.getX()]) == '2') {
        if (map.get(maze[tmp2.getY()][tmp2.getX()]) == '0' ||
                map.get(maze[tmp2.getY()][tmp2.getX()]) == '4' && map.get(maze[tmp2.getY()][tmp2.getX()]) != '2') {


            map.put(maze[tmp2.getY()][tmp2.getX()], '2');


            if (!ArrivalList.contains(maze[player.getPosition().getY()][player.getPosition().getX()])) {
                map.put(maze[player.getPosition().getY()][player.getPosition().getX()], '0');
            } else {

                map.put(maze[player.getPosition().getY()][player.getPosition().getX()], '4');
            }
            player.setPosition(tmp);
            map.put(maze[player.getPosition().getY()][player.getPosition().getX()], '5');

        }

    }

        /**===============================**/


        /** Move without bloc**/
        else if (map.get(maze[tmp.getY()][tmp.getX()]) != '1') {
            if (!ArrivalList.contains(maze[player.getPosition().getY()][player.getPosition().getX()])) {
                map.put(maze[player.getPosition().getY()][player.getPosition().getX()], '0');
            }
            else{
                map.put(maze[player.getPosition().getY()][player.getPosition().getX()], '4');
            }
            player.setPosition(tmp);
            map.put(maze[player.getPosition().getY()][player.getPosition().getX()], '5');
        }
        Thread.sleep(100);
    }












    public LinkedHashMap getMap() {
        return this.map;
    }


    public Position[][] getMaze() {
        return this.maze;
    }

    public List<Position> getArrivals() {

        return this.ArrivalList;

    }

    public Player getPlayer(){
        return this.player;
    }

    public boolean isGraphicalStart() {
        return graphicalStart;
    }

    public void setGraphicalStart(boolean graphicalStart) {
        this.graphicalStart = graphicalStart;
    }



    public int[] getSize() {
        return (new int[]{this.height, this.width});
    }
}

