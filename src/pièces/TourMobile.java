package pièces;

import plateau.Case;

import java.util.ArrayList;
import java.util.List;

public class TourMobile implements Piece {

    private List<Integer> champAttaque = new ArrayList<>();

    private List<Integer> deplacementPossible = new ArrayList<>();

    public TourMobile(){
        this.initChampAttaque();
        this.initChampDeplacement();
    }

    public void initChampDeplacement(){
        for (int i = 0; i < 9; i ++){
            this.deplacementPossible.add(1);
        }
    }

    public void initChampAttaque(){
        // première ligne
        this.champAttaque.add(1);
        this.champAttaque.add(0);
        this.champAttaque.add(1);
        this.champAttaque.add(0);
        this.champAttaque.add(1);

        // deuxième ligne
        this.champAttaque.add(0);
        this.champAttaque.add(1);
        this.champAttaque.add(1);
        this.champAttaque.add(1);
        this.champAttaque.add(0);

        // toisième ligne
        this.champAttaque.add(1);
        this.champAttaque.add(1);
        // ici se trouve la pièce
        this.champAttaque.add(0);
        this.champAttaque.add(1);
        this.champAttaque.add(1);

        // quatrième ligne
        this.champAttaque.add(0);
        this.champAttaque.add(1);
        this.champAttaque.add(1);
        this.champAttaque.add(1);
        this.champAttaque.add(0);

        // cinquième ligne
        this.champAttaque.add(1);
        this.champAttaque.add(0);
        this.champAttaque.add(1);
        this.champAttaque.add(0);
        this.champAttaque.add(1);
    }



    @Override
    public void mouvement(Case emplacementDeplacement) {

    }

    @Override
    public void attaque(Case emplacementVise) {

    }

    public List<Integer> getDeplacementPossible() {
        return deplacementPossible;
    }

    public void setDeplacementPossible(List<Integer> deplacementPossible) {
        this.deplacementPossible = deplacementPossible;
    }

    public List<Integer> getChampAttaque() {
        return champAttaque;
    }

    public void setChampAttaque(List<Integer> champAttaque) {
        this.champAttaque = champAttaque;
    }
}
