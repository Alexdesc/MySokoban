package view;

import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel{
    private JPanel panel1;
    private JButton consoleModeButton;
    private Boolean START = false;


    private JButton startButton;
    private JLabel infobar;
    private  BorderLayout layout;
    private JButton quitButton = new JButton("Quit");

    public Menu() {



        setVisible(true);


        infobar = new JLabel();
        layout = new BorderLayout();

        setBackground(Color.gray);

        quitButton = new JButton("Quit");

        quitButton.setFocusable(false);

        infobar.setText("Coups:");
        add(infobar, layout.PAGE_END);
        add(quitButton);




    }


    public JLabel getInfobar() {
        return infobar;
    }

    public JButton getQuitButton() {

        return quitButton;
    }
}
