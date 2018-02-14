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
        boolean mvPossible = mouv.applyMouvement();
        for (Position pos : this.piece.attaquesPossibles()){
            pos.displayInfoPosition();
        }
        boolean attqPossible = attq.applyAttaque();
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
}
