package plateau;

import pièces.Piece;
import pièces.Position;

public class Case {
    private Position position;
    private Piece piece;
    private String value;

    public Case(){
        // TO DO
        this.position.setPosX(-1);
        this.position.setPosY(-1);
        this.value = " ";
        this.piece = null;
    }

    public Case(Position pos, Piece piece, String value){
        this.position = pos;
        //this.position.clone(pos);
        this.piece = piece;
        this.value = value;
    }

    public Position getPosition(){
        return this.position;
    }

    public void setPosition(Position pos){
        this.position.clone(pos);
    }

    public boolean isOccupied() {

        if (piece == null)
            return false;
        else
            return true;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String formatStringCase(){
        StringBuilder str = new StringBuilder();
        str.append("+---+");
        str.append(System.getProperty("line.separator"));
        str.append("| " + this.value + " |");
        str.append(System.getProperty("line.separator"));
        str.append("+---+");
        return str.toString();
    }

    public void displayCase(){
        System.out.println(this.formatStringCase());
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }


    public void clone(Case cas){
        this.position.clone(cas.getPosition());
        this.piece.clone(cas.getPiece());
        this.value = cas.getValue();
    }
}
