package view;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {
    private JPanel panel1;
    private JButton consoleModeButton;
    private Boolean START = false;
    private JButton quitButton;


    private JButton startButton;

    public Menu() {





        setTitle("Test Panel");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 500);
        setResizable(false);

        JPanel jpanel = new JPanel();
        getContentPane().add(jpanel);
        jpanel.setLayout(null);

        jpanel.setBackground(Color.RED);
        //jPanel2.setBackground(Color.YELLOW);

        // jFrame.getContentPane().setLayout(new GridLayout(1,2));

        this.getContentPane().add(jpanel);
        //       jFrame.getContentPane().add(jPanel2);

        this.quitButton = new JButton("Quit");
        quitButton.setBounds(150, 300, 80, 30);


        jpanel.add(quitButton);
        this.startButton = new JButton("Start");
        startButton.setBounds(150, 100, 80, 30);


        jpanel.add(startButton);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }


    public Boolean IsStart(){
        return START;
    }


    public JButton getStartButton() {
        return this.startButton;
    }

    public JButton getQuitButton() {
        return this.quitButton;
    }


}
