package pièces;

import javafx.geometry.Pos;
import plateau.Case;
import plateau.Plateau;

import java.util.ArrayList;
import java.util.List;

public class Mitrailleurs implements Piece{

    private Case cas;
    private Joueur joueur;
    private String symbole = "R";
    private List<Position> champAttaque = new ArrayList<>();
    private List<Position> deplacementPossible = new ArrayList<>();

    // Sens = 0 => les pièces essaie de monter
    private int sens;

    public Mitrailleurs(int sens, Case cas){
        this.cas = cas;
        this.attaquesPossibles();
        this.mouvementPossibles();
        this.sens = sens;
    }


    @Override
    public List<Position> getChampAttaque() {
        return this.champAttaque;
    }

    @Override
    public void setChampAttaque(List<Position> champAttaque) {
        this.champAttaque.clear();
        this.champAttaque.addAll(champAttaque);
    }

    @Override
    public List<Position> getDeplacementPossible() {
        return this.deplacementPossible;
    }

    @Override
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

        this.champAttaque.clear();

        if (this.sens == 0){
            this.champAttaque.add(new Position(this.cas.getPosition().posX, this.cas.getPosition().getPosY() - 1));
            this.champAttaque.add(new Position(this.cas.getPosition().posX, this.cas.getPosition().getPosY() - 2));
            this.champAttaque.add(new Position(this.cas.getPosition().posX, this.cas.getPosition().getPosY() - 3));
        } else {
            this.champAttaque.add(new Position(this.cas.getPosition().posX, this.cas.getPosition().getPosY() + 1));
            this.champAttaque.add(new Position(this.cas.getPosition().posX, this.cas.getPosition().getPosY() + 2));
            this.champAttaque.add(new Position(this.cas.getPosition().posX, this.cas.getPosition().getPosY() + 3));
        }

        this.champAttaque.add(new Position(this.cas.getPosition().posX -1, this.cas.getPosition().getPosY()));
        this.champAttaque.add(new Position(this.cas.getPosition().posX -2, this.cas.getPosition().getPosY()));

        this.champAttaque.add(new Position(this.cas.getPosition().posX + 1, this.cas.getPosition().getPosY()));
        this.champAttaque.add(new Position(this.cas.getPosition().posX + 2, this.cas.getPosition().getPosY()));

        return this.champAttaque;
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

    @Override
    public void clone(Piece piece) {

        this.symbole = piece.getSymbole();

        this.deplacementPossible.clear();
        this.deplacementPossible.addAll(piece.getDeplacementPossible());

        this.champAttaque.clear();
        this.champAttaque.addAll(piece.getChampAttaque());

//        this.tailleColonneMatriceAttaque = piece.getTailleColonneMatriceAttaque();
//        this.tailleLigneMatriceAttaque = piece.getTailleLigneMatriceAttaque();
//
//        this.tailleColonneMatriceDeplacement = piece.getTailleColonneMatriceDeplacement();
//        this.tailleLigneMatriceDeplacement = piece.getTailleLigneMatriceDeplacement();
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
