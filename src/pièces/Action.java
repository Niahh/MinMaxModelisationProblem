package pièces;

import plateau.Plateau;

public class Action {

    private Mouvement mouv;
    private Attaque attq;
    private Plateau plateau;
    private Piece piece;

    public Action(Plateau plateau, Piece piece, Position mv, Position at){

        this.plateau = plateau;
        this.piece = piece;
        this.mouv = new Mouvement(piece, mv, this.plateau);
        this.attq = new Attaque(piece, at, this.plateau);
    }

    public boolean apply(){
        boolean attqPossible = attq.applyAttaque();
        boolean mvPossible = mouv.applyMouvement();

        return mvPossible && attqPossible;
    }

    public Mouvement getMouv() {
        return mouv;
    }

    public void setMouv(Mouvement mouv) {
        this.mouv = mouv;
    }

    public Attaque getAttq() {
        return attq;
    }

    public void setAttq(Attaque attq) {
        this.attq = attq;
    }

    public void display(){
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        this.mouv.display();
        this.attq.display();
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }
}
