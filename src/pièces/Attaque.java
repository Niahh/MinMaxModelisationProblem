package pièces;

import plateau.Case;
import plateau.Plateau;

import java.util.List;

public class Attaque {

    private Position cible;
    private Piece piece;
    private Plateau plateau;

    public Attaque(Piece piece, Position cible, Plateau plateau){
        this.piece = piece;
        this.cible = cible;
        this.plateau = plateau;
    }

    public boolean isPossible(){
        boolean caseExist = this.plateau.getCaseFromPosition(cible) != null;
        boolean canAttaque = false;

        for (Position pos : this.piece.getDeplacementPossible()){
            if (pos.equals(cible)){
                canAttaque = true;
            }
        }
        return (caseExist && canAttaque);
    }

    public boolean applyAttaque(){
        if (this.isPossible()){
            Case ca = this.plateau.getCaseFromPosition(cible);
            Piece p = ca.getPiece();
            if (p != null){
                if (p.getClass() == Mitrailleurs.class){
                    p.getJoueur().getMitrailleurs().remove(p);
                    p.getCase().setToNull();
                } else if (p.getClass() == TourMobile.class){
                    p.getJoueur().getTourMobiles().remove(p);
                    p.getCase().setToNull();
                } else {
                    p.getJoueur().getFantassins().remove(p);
                    p.getCase().setToNull();
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public Position getCible() {
        return cible;
    }

    public void setCible(Position cible) {
        this.cible = cible;
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
