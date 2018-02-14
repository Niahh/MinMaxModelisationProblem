package pièces;

import plateau.Case;
import plateau.Plateau;

import java.util.ArrayList;
import java.util.List;

public class TourMobile implements Piece {

    private Case cas;
    private Joueur joueur;
    private String symbole = "S";
    private List<Position> champAttaque = new ArrayList<>();
    private List<Position> deplacementPossible = new ArrayList<>();
    private int sens;



    public TourMobile(int sens, Case cas){
        this.cas = cas;
        this.attaquesPossibles();
        this.mouvementPossibles();
        this.sens = sens;
    }

    @Override
    public Case getCase() {
        return null;
    }

    @Override
    public void setCase(Case caseToSet) {

    }

    @Override
    public Joueur getJoueur() {
        return null;
    }

    @Override
    public void setJoueur(Joueur joueur) {

    }

    @Override
    public String getSymbole() {
        return this.symbole;
    }

    public List<Position> getDeplacementPossible() {
        return deplacementPossible;
    }



    public void setDeplacementPossible(List<Position> deplacementPossible) {
        this.deplacementPossible.clear();
        this.deplacementPossible.addAll(deplacementPossible);
    }

    @Override
    public List<Position> mouvementPossibles() {
        this.deplacementPossible.clear();
        this.deplacementPossible = UtilMission3.mouvementBasique(this.cas);
        return this.deplacementPossible;
    }

    @Override
    public List<Position> attaquesPossibles() {

        this.champAttaque. clear();

        // Attaque à droite
        this.champAttaque.add(new Position(this.cas.getPosition().posX + 1, this.cas.getPosition().getPosY()));
        this.champAttaque.add(new Position(this.cas.getPosition().posX + 2, this.cas.getPosition().getPosY()));

        // Attaque à gauche
        this.champAttaque.add(new Position(this.cas.getPosition().posX -1, this.cas.getPosition().getPosY()));
        this.champAttaque.add(new Position(this.cas.getPosition().posX -2, this.cas.getPosition().getPosY()));

        // Attaque en haut
        this.champAttaque.add(new Position(this.cas.getPosition().posX , this.cas.getPosition().getPosY() + 1));
        this.champAttaque.add(new Position(this.cas.getPosition().posX , this.cas.getPosition().getPosY() + 2));

        // Attaque en bas
        this.champAttaque.add(new Position(this.cas.getPosition().posX, this.cas.getPosition().getPosY() - 1));
        this.champAttaque.add(new Position(this.cas.getPosition().posX, this.cas.getPosition().getPosY() - 2));

        // Attaque en diagonale haut gauche
        this.champAttaque.add(new Position(this.cas.getPosition().posX - 1, this.cas.getPosition().getPosY() - 1));
        this.champAttaque.add(new Position(this.cas.getPosition().posX - 2, this.cas.getPosition().getPosY() - 2));

        // Attaque en diagonale haut droite
        this.champAttaque.add(new Position(this.cas.getPosition().posX + 1, this.cas.getPosition().getPosY() - 1));
        this.champAttaque.add(new Position(this.cas.getPosition().posX + 2, this.cas.getPosition().getPosY() - 2));

        // attaque en diagonale bas gauche
        this.champAttaque.add(new Position(this.cas.getPosition().posX - 1, this.cas.getPosition().getPosY() + 1));
        this.champAttaque.add(new Position(this.cas.getPosition().posX - 2, this.cas.getPosition().getPosY() + 2));

        // Attauqe en diagonale bas droite
        this.champAttaque.add(new Position(this.cas.getPosition().posX + 1, this.cas.getPosition().getPosY() + 1));
        this.champAttaque.add(new Position(this.cas.getPosition().posX + 2, this.cas.getPosition().getPosY() + 2));

        return this.champAttaque;
    }

    public List<Position> getChampAttaque() {
        return this.champAttaque;
    }

    public void setChampAttaque(List<Position> champAttaque) {
        this.champAttaque.clear();
        this.champAttaque.addAll(champAttaque);
    }

    @Override
    public void clone(Piece piece) {

        this.cas.clone(piece.getCase());
        this.joueur.clone(piece.getJoueur());

        this.symbole = piece.getSymbole();

        this.deplacementPossible.clear();
        this.deplacementPossible.addAll(piece.getDeplacementPossible());

        this.champAttaque.clear();
        this.champAttaque.addAll(piece.getChampAttaque());
    }


    @Override
    public int getSens() {
        return sens;
    }

    @Override
    public void setSens(int sens) {
        this.sens = sens;
    }
}

