package model;

import javax.swing.*;

public class SokobanImage {




    private ImageIcon Wall;
    private ImageIcon Player;
    private ImageIcon PlayerZone;
    private ImageIcon Caisse ;
    private ImageIcon CaisseOK;
    private ImageIcon Goal ;
    private ImageIcon none ;




    private static final SokobanImage instance = new SokobanImage();

    public static SokobanImage getInstance() {
        return instance;

    }

    public SokobanImage(){

        this.Wall = new ImageIcon(getClass().getResource("../rsrc/mur.gif"));
        this.Player = new ImageIcon(getClass().getResource("../rsrc/perso.gif"));
        this.PlayerZone = new ImageIcon(getClass().getResource("../rsrc/persoZone.gif"));
        this.Caisse = new ImageIcon(getClass().getResource("../rsrc/caisse.gif"));
        this.CaisseOK = new ImageIcon(getClass().getResource("../rsrc/caisseOK.gif"));
        this.Goal = new ImageIcon(getClass().getResource("../rsrc/zone.gif"));
        this.none = new ImageIcon(getClass().getResource("../rsrc/vide.gif"));

    }


    public ImageIcon getCaisse() {
        return this.Caisse;
    }

    public ImageIcon getCaisseOK() {
        return CaisseOK;
    }

    public ImageIcon getPlayer() {
        return this.Player;
    }

    public ImageIcon getNone() {
        return this.none;
    }

    public ImageIcon getWall() {
        return this.Wall;
    }

    public ImageIcon getGoal() {
        return this.Goal;
    }


}
