package controler;

public class Player {
    private Position position;


    public Player(Position position, String name)
      {
        this.position = position;
    }

    public Position getPosition(){
        return this.position;
    }

    public void setPosition(Position position)
    {
        this.position = position;
    }
}
