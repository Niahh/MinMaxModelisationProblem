package pièces;

public class Position {
    int posX;
    int posY;

    public Position(int posX, int posY){
        this.posX = posX;
        this.posY = posY;
    }

    public int getPosX(){
        return this.posX;
    }

    public void setPosX(int posX){
        this.posX = posX;
    }

    public int getPosY(){
        return this.posY;
    }

    public void setPosY(int posY){
        this.posY = posY;
    }

    public void clone(Position pos){
        this.posX = pos.getPosX();
        this.posY = pos.getPosY();
    }

    public boolean equals(Position pos){
        return (this.posX == pos.getPosX() && this.posY == pos.getPosY());
    }

    public void displayInfoPosition(){
        System.out.println("x :" + this.getPosX() + " - y : " + this.getPosY());
    }

}
