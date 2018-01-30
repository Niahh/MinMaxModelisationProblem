package plateau;

import java.util.ArrayList;
import java.util.List;

public class Plateau {
    private List<Case> cases;
    private int tailleLargeur;
    private int tailleLongeur;


    public Plateau(){
        this.tailleLargeur = 25;
        this.tailleLongeur = 25;
        this.cases = new ArrayList<>(this.tailleLargeur * this.tailleLongeur);
        this.initCasesPlateauBase(this.cases);
    }

    public Plateau(int tailleLongeur, int tailleLargeur){
        this.tailleLargeur = tailleLargeur;
        this.tailleLongeur = tailleLongeur;
        this.cases = new ArrayList<>(this.tailleLargeur * this.tailleLongeur);
        this.initCasesPlateauBase(this.cases);
    }

    public void initCasesPlateauBase(List<Case> cases){
        for (int j = 0; j < this.tailleLargeur; j ++){
            for (int i = 0; i < this.tailleLongeur; i++){
                cases.add(new Case(i, j, false, " "));
            }
        }
    }

    public List<Case> getCases() {
        return cases;
    }

    public void setCases(List<Case> cases) {
        this.cases = cases;
    }

    public int getTailleLargeur() {
        return tailleLargeur;
    }

    public void setTailleLargeur(int tailleLargeur) {
        this.tailleLargeur = tailleLargeur;
    }

    public int getTailleLongeur() {
        return tailleLongeur;
    }

    public void setTailleLongeur(int tailleLongeur) {
        this.tailleLongeur = tailleLongeur;
    }

    public String formatPlateau(){
        StringBuilder str = new StringBuilder();
        for (int j = 0; j < this.tailleLargeur; j ++){
            for (int i = 0; i < this.tailleLongeur; i ++){
                if (i == 24) {

                }
            }
        }
        return str.toString();
    }

    public void displayPlateau(){
        System.out.println(formatPlateau());
    }
}
