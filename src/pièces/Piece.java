package pièces;

import plateau.Case;

public interface Piece {
    public void mouvement(Case emplacementDeplacement);

    public void attaque(Case emplacementVise);
}
