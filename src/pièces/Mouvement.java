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
        boolean caseExists = false;
        boolean caseEmpty = false;

        Case ca = this.plateau.recoverCaseFromPiece(this.getPiece());
        if(ca != null)
            caseExists = true;

        if (caseExists){
            caseEmpty = !plateau.getCaseFromPosition(choixMouvement).isOccupied();
        }

        return  caseExists && caseEmpty;
    }

    public void applyMouvement(){
        System.out.println(this.isPossible());
        if (this.isPossible()){
            System.out.println("applyMouvement");
            Case ca = this.plateau.recoverCaseFromPiece(this.getPiece());
            ca.setPiece(null);
            ca.setValue(" ");
            Case caseCible = this.getPlateau().getCaseFromPosition(this.getChoixMouvement());
            caseCible.setPiece(this.getPiece());
            caseCible.setValue(this.getPiece().getSymbole());
            this.piece.setCase(caseCible);
        }
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }
}
