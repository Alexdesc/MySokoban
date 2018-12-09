package controler;

import model.Model;
import model.Player;
import model.Position;
import view.DetailBar;
import view.Screen;
import view.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;


public class Game {


    /**
     * Singlestons to use MVC data easily
     */

    private View v = View.getInstance();
    private Model m = Model.getInstance();
    private int coups = 0;
    String option;
    String option2;
    private Boolean useAI = false;

    public void initialisation() throws FileNotFoundException, IOException, InterruptedException{

        m.initPlateau("src/rsrc/lvl2.txt");
        System.out.println("Console mode : 1 \n Graphical mode : 2");
        Scanner scanner = new Scanner(System.in);
       option = scanner.next();
        if (option.equals("1")){
            System.out.println("Use AI ?\n Yes : 1 \n No : 2");
            option2 = scanner.next();

            v.displayTextMaze(m.getMap(),  coups);
            while (!CheckWin()) {
                if (option2.equals("2")){
                    console_mode();
                }
                else
                {
                    System.out.println("AI");
                    algo();

                }

                v.displayTextMaze(m.getMap(), coups);
            }
        }
        else {


         //   Menu menu = new Menu();


          //  v.CreateGraphic(m.getMaze(), m.getMap(),m.getPlayer(), m.getSize());

         /*   while (!CheckWin()){
                try {
                    algo();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                otherListner();
            }*/


//            v.CreateGraphic(m.getMaze(), m.getMap(),m.getPlayer(), m.getSize());


          /*  menu.getQuitButton().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    System.exit(0);
                }
            });
*/
        /*    menu.getAiButton().addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent event) {

                    menu.setVisible(false);
                    v.getGraphic().setVisible(true);
                }
            });
*//*
            menu.getManualButton().addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event) {
*/
                   // menu.setVisible(false);
                    v.CreateGraphic(m.getMaze(), m.getMap(),m.getPlayer(), m.getSize());
                    v.getGraphic().addKeyListener(MyKey());
                    otherListner();
           /*     }
            });
*/










            //info.getInfobar().setText("Coups: " + coups);
            //sc.Update(m.getMap());
        }

    }


    private void algo() throws InterruptedException {
        Player player = m.getPlayer();
        Position next_position;
        LinkedHashMap<Position, Character> map = m.getMap();
        Position[][] maze = m.getMaze();
        List ArrivalList = m.getArrivals();


        Thread.sleep(1000);
        next_position =  player.getPosition().toUp();
        if (map.get(maze[next_position.getY()][next_position.getX()]) == '0'){
            move("z");
            return;
        }
        next_position =  player.getPosition().toDown();
        if (map.get(maze[next_position.getY()][next_position.getX()]) == '0'){
            move("s");
            return;
        }
        next_position =  player.getPosition().toLeft();
        if (map.get(maze[next_position.getY()][next_position.getX()]) == '0'){
            move("q");
            return;
        }
        next_position =  player.getPosition().toRight();
        if (map.get(maze[next_position.getY()][next_position.getX()]) == '0'){
            move("d");
            return;
        }



    }


    private KeyListener MyKey() {


        KeyListener keyListener = new KeyListener() {
            @Override

            public void keyTyped(KeyEvent e) {

            }

            @Override
            public  synchronized void  keyPressed(KeyEvent e) {
                move(e.getKeyChar()+"");
                otherListner();

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        };

        otherListner();


        return keyListener;

    }

    private void otherListner() {
        Screen sc =  v.getGraphic().getSc();
        DetailBar info =  v.getGraphic().getInfo();
        info.getInfobar().setText("Coups: " + coups);
        sc.Update(m.getMap());
        info.getQuitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });
    }


    /**Move with keyboard to play in your own**/

    public void console_mode() throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        String key = scanner.next();
        move(key);

    }


    /**Move with keyboard to play in your own**/


    public void move(String key){

        Position tmp ;
        Position tmp2;
        Player player = m.getPlayer();
        LinkedHashMap<Position, Character> map = m.getMap();
        Position[][] maze = m.getMaze();
        List ArrivalList = m.getArrivals();


        if (key.toLowerCase().equals("quit")){
            System.exit(0);
        }
        switch (key.toLowerCase().charAt(0)) {

            case 'z':
                tmp = player.getPosition().toUp();
                this.coups++;
                break;
            case 's':
                tmp = player.getPosition().toDown();
                this.coups++;
                break;
            case 'q':
                tmp = player.getPosition().toLeft();
                this.coups++;
                break;
            case 'd':
                tmp = player.getPosition().toRight();
                this.coups++;
                break;

            default:
                System.out.println("none");
                return;
        }


        /** Move  with bloc**/
        if (map.get(maze[tmp.getY()][tmp.getX()]) == '2') {

            switch (key.toLowerCase().charAt(0)) {

                case 'z':
                    tmp2 = tmp.toUp();
                    break;
                case 's':
                    tmp2 = tmp.toDown();

                    break;
                case 'q':
                    tmp2 = tmp.toLeft();
                    break;
                case 'd':
                    tmp2 = tmp.toRight();
                    break;

                default:
                    System.out.println("none");
                    return;
            }


            if (map.get(maze[tmp2.getY()][tmp2.getX()]) == '0' ||
                    map.get(maze[tmp2.getY()][tmp2.getX()]) == '4' && map.get(maze[tmp2.getY()][tmp2.getX()]) != '2') {
                map.put(maze[tmp2.getY()][tmp2.getX()], '2');

                if (!ArrivalList.contains(maze[player.getPosition().getY()][player.getPosition().getX()])) {

                    map.put(maze[player.getPosition().getY()][player.getPosition().getX()], '0');
                }
                else{
                    map.put(maze[player.getPosition().getY()][player.getPosition().getX()], '4');
                }

                player.setPosition(tmp);
                map.put(maze[player.getPosition().getY()][player.getPosition().getX()], '5');


            }

            if (CheckWin()){
                if (this.option.equals("2")) {
                    v.win_graphic();
                } else {
                    v.displayTextMaze(m.getMap(), coups);
                    v.win_console(coups);
                    System.exit(0);
                }

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
    }


    public boolean CheckWin() {


        Boolean win = true;

        for (int i = 0; i < m.getArrivals().size(); i++) {
            if (m.getMap().get(m.getMaze()[m.getArrivals().get(i).getY()][m.getArrivals().get(i).getX()]).equals('4')) {
                win = false;
            }
        }

        return win;
    }
}
