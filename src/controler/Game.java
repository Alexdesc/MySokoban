package controler;

import model.Model;
import model.Player;
import model.Position;
import view.Menu;
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

    public void initialisation() throws FileNotFoundException, IOException, InterruptedException{

        m.initPlateau("lvl2.txt");
        System.out.println("Console mode : 1 \n Graphical mode : 2");
        Scanner scanner = new Scanner(System.in);
       option = scanner.next();
        if (option.equals("1")){
            v.displayTextMaze(m.getMap(),  coups);
            while (!CheckWin()) {
                console_mode();
                v.displayTextMaze(m.getMap(), coups);
            }
        }
        else {

                    v.displayGraphic(m.getMaze(), m.getMap(),m.getPlayer(), m.getSize());
                    v.getGraphic().addKeyListener(MyKey());

        }

    }



    private KeyListener MyKey() {
        Screen sc =  v.getGraphic().getSc();
        Menu info =  v.getGraphic().getInfo();

        KeyListener keyListener = new KeyListener() {
            @Override

            public void keyTyped(KeyEvent e) {

            }

            @Override
            public  synchronized void  keyPressed(KeyEvent e) {
                move(e.getKeyChar()+"");
                info.getInfobar().setText("Coups: " + coups);
                sc.Update(m.getMap());

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        };

       info.getQuitButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        return keyListener;

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
                System.out.println(this.option);
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
