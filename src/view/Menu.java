package view;

import javax.swing.*;
import java.awt.*;

public class Menu extends JFrame {


    JButton   aiButton = new JButton("AI");
    JButton   manualButton = new JButton("MANUAL");
    JButton   quitButton = new JButton("QUIT");

    public Menu(){
        JPanel panel = new JPanel();
        setVisible(true);
        setBackground(Color.black);
        setSize(100, 200);
        setLocationRelativeTo(null);
        setTitle("MySokoban");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();

        panel.add(manualButton);
        panel.add(aiButton);
        panel.add(quitButton);

        add(panel);

    }

    public JButton getAiButton() {
        return aiButton;
    }

    public JButton getManualButton() {
        return manualButton;
    }

    public JButton getQuitButton() {
        return quitButton;
    }
}
