package model;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {

        return this.y;
    }

    public int getX(){

        return this.x;
    }



    public Position toRight()
    {

        return new Position(this.x + 1, this.y);
    }


    public Position toLeft(){

        return new Position(this.x - 1, this.y);
    }

    public Position toUp(){

        return new Position(this.x, this.y - 1);
    }

    public Position toDown(){

        return new Position(this.x, this.y + 1);
    }
    public boolean equals(Position position){

        if (this.x != position.getX()) {
            return false;
        }
        if (this.y != position.getY()) {
            return false;
        }
        return true;
    }
}
