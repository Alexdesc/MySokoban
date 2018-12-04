package model;

import javax.swing.*;
import java.awt.*;

public class Player {
    private Position position;
    protected int width;
    protected int height;
    protected boolean visible;
    protected Image image;


    public Player(Position position, String name)
      {

        this.position = position;

    }

    protected void loadImage(String imageName) {

        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    protected void getImageDimensions() {

        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    public Position getPosition(){
        return this.position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }
    private void initMissile() {

        loadImage("src/rsrc/Player.png");
        getImageDimensions();
    }
}
