package pièces;


import javafx.geometry.Pos;
import plateau.Case;
import plateau.Plateau;

import java.util.ArrayList;
import java.util.List;

public class Fantassin implements Piece {

    private Case cas;
    public Joueur joueur;
    private String symbole = "L";
    private List<Position> champAttaque = new ArrayList<>();
    private List<Position> deplacementPossible = new ArrayList<>();
    private int sens;

    public Fantassin(int sens, Case cas)  {
        this.cas = cas;
        this.mouvementPossibles();
        this.attaquesPossibles();
        this.sens = sens;
    }

    @Override
    public Case getCase() {
        return this.cas;
    }

    @Override
    public void setCase(Case caseToSet) {
        this.cas.clone(caseToSet);
    }

    @Override
    public Joueur getJoueur() {
        return this.joueur;
    }

    @Override
    public void setJoueur(Joueur joueur) {
        this.joueur.clone(joueur);
    }

    @Override
    public String getSymbole() {
        return this.symbole;
    }

    public List<Position> getChampAttaque() {
        return this.champAttaque;
    }

    public void setChampAttaque(List<Position> champAttaque) {
        this.champAttaque.clear();
        this.champAttaque.addAll(champAttaque);
    }

    public List<Position> getDeplacementPossible() {
        return this.deplacementPossible;
    }

    public void setDeplacementPossible(List<Position> deplacementPossible) {
        this.deplacementPossible = deplacementPossible;
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

        if (sens == 0) {
            this.champAttaque.add(new Position(this.cas.getPosition().getPosX(), this.cas.getPosition().getPosY() - 1));
        } else {
            this.champAttaque.add(new Position(this.cas.getPosition().getPosX(), this.cas.getPosition().getPosY() + 1));
        }

        this.champAttaque.add(new Position(this.cas.getPosition().getPosX() - 1, this.cas.getPosition().getPosY()));
        this.champAttaque.add(new Position(this.cas.getPosition().getPosX() + 1, this.cas.getPosition().getPosY()));

        return this.champAttaque;
    }

    @Override
    public void clone(Piece piece) {

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

/*


    public void initChampDeplacement(Plateau plateau) {

        List<Position> deplacements = UtilMission3.mouvementBasique(this.cas);

        for (Position pos : deplacements) {
            for (Case c : plateau.getCases()) {
                if (c.getPosition().equals(pos) && !c.isOccupied()) {
                    this.deplacementPossible.add(pos);
                }
            }
        }
    }

        public void initChampAttaque(Plateau plateau) {

        List<Position> attaques = new ArrayList<>();


        if (sens == 0) {
            attaques.add(new Position(this.cas.getPosition().getPosX(), this.cas.getPosition().getPosY() - 1));
        } else {
            attaques.add(new Position(this.cas.getPosition().getPosX(), this.cas.getPosition().getPosY() + 1));
        }

        attaques.add(new Position(this.cas.getPosition().getPosX() - 1, this.cas.getPosition().getPosY()));
        attaques.add(new Position(this.cas.getPosition().getPosX() + 1, this.cas.getPosition().getPosY()));

    }
 */
