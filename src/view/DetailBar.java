package view;

import javax.swing.*;
import java.awt.*;

public class DetailBar extends JPanel{

    private JLabel infobar;
    private  BorderLayout layout;
    private JButton quitButton ;

    public DetailBar() {



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
