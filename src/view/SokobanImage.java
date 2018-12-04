package view;

import javax.swing.*;

public class SokobanImage {


    public JLabel getCaisse() {
        return Caisse;
    }

    public JLabel getCaisseOK() {
        return CaisseOK;
    }

    public JLabel getPlayer() {
        return Player;
    }

    public JLabel getVide() {
        return Vide;
    }

    public JLabel getMur() {
        return Mur;
    }

    private JLabel Caisse;
    private JLabel CaisseOK;
    private JLabel Player;
    private JLabel Vide;
    private JLabel Mur;

    private static final SokobanImage instance = new SokobanImage();

    public static SokobanImage getInstance() {
        return instance;

    }

    public SokobanImage(){

        Caisse = new JLabel( new ImageIcon( "rsrc/caisse.gif"));
        CaisseOK = new JLabel( new ImageIcon( "rsrc/caisseOK.gif"));
        Player = new JLabel( new ImageIcon( "rsrc/perso.gif"));
        Mur = new JLabel( new ImageIcon( "rsrc/mur.gif"));
        Vide = new JLabel( new ImageIcon( "rsrc/vide.gif"));
    }

}
