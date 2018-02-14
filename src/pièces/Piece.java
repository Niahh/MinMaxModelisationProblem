package pièces;

import javafx.geometry.Pos;
import plateau.Case;
import plateau.Plateau;

import java.util.List;

public interface Piece {

    public Case getCase();

    public void setCase(Case caseToSet);

    public Joueur getJoueur();

    public void setJoueur(Joueur joueur);

    public String getSymbole();

    // public void initChampDeplacement(Plateau plateau);

    // public void initChampAttaque(Plateau plateau);

    public List<Position> getChampAttaque();

    public void setChampAttaque(List<Position> champAttaque);

    public List<Position> getDeplacementPossible();

    public void setDeplacementPossible(List<Position> deplacementPossible);

    public List<Position> mouvementPossibles();

    public List<Position> attaquesPossibles();

    public void clone(Piece piece);

    public int getSens();

    public void setSens(int sens);

}
