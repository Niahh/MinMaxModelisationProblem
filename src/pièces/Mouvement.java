package pièces;

import plateau.Case;
import plateau.Plateau;

public class Mouvement {

    private Piece piece;
    private Position choixMouvement;
    private Plateau plateau;

    public Mouvement(Piece piece, Position choixMouvement, Plateau plateau){
        this.piece = piece;
        this.choixMouvement = choixMouvement;
        this.plateau = plateau;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Position getChoixMouvement() {
        return choixMouvement;
    }

    public void setChoixMouvement(Position choixMouvement) {
        this.choixMouvement = choixMouvement;
    }

    public boolean isPossible(){
        boolean mouvement_permi = false;
        boolean case_exists = false;
        boolean case_empty = false;

        for (Position pos : this.piece.mouvementPossibles()){
            if (pos.equals(choixMouvement)){
                mouvement_permi = true;
                break;
            }
        }

         if (mouvement_permi){
            Case ca = this.plateau.recoverCaseFromPiece(this.getPiece());
            if(ca != null){
                case_exists = true;
            }

            if (case_exists){
                case_empty = !ca.isOccupied();
            }
         }

        return mouvement_permi && case_exists && case_empty;
    }

    public void applyMouvement(){
        if (this.isPossible()){
            Case ca = this.plateau.recoverCaseFromPiece(this.getPiece());
            ca.setPiece(null);
            this.piece.setCase(this.getPlateau().getCaseFromPosition(this.getChoixMouvement()));
        }
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }
}
