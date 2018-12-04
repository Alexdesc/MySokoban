package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Screen extends JPanel implements KeyListener, ActionListener {


    private final JButton quitButton;

    public Screen (){

        //jpanel.setLayout(null);




        this.setBackground(Color.BLACK);
        //jPanel2.setBackground(Color.YELLOW);

        // jFrame.getContentPane().setLayout(new GridLayout(1,2));

        //       jFrame.getContentPane().add(jPanel2);


        this.quitButton = new JButton("Quit");
        quitButton.setBounds(this.getX(), this.getY()*2, 80, 30);

        this.add(quitButton);

        JLabel j1 = new JLabel();
        j1.setIcon(new ImageIcon("src/rsrc/perso.gif"));



        this.add(j1);
        //   jpanel.add(SImg.getPlayer());

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    public JButton getQuitButton() {
        return this.quitButton;
    }
}
