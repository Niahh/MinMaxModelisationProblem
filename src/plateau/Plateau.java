package plateau;

import javafx.geometry.Pos;
import pièces.Piece;
import pièces.Position;

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
                Position position = new Position(i,j);
                Case cas = new Case(position, null, " ");
                cases.add(cas);
            }
        }
    }

    public void setCase(Position position, Piece piece){
        if (position.getPosX() >= 0 && position.getPosX() < 25 && position.getPosY() >= 0 && position.getPosY() < 25 && symboleExist(piece.getSymbole())){
            this.cases.get((position.getPosX() + position.getPosY() * this.tailleLargeur)).setValue(piece.getSymbole());
            this.cases.get((position.getPosX() + position.getPosY() * this.tailleLargeur)).setPiece(piece);
        } else {
            System.out.println(" XXX La case ne peut pas être inséré XXX");
        }
    }

    private boolean symboleExist(String symbole){
        return symbole.equals(" ") || symbole.equals("S") || symbole.equals("R") || symbole.equals("L");
    }

    public List<Case> getCases() {
        return this.cases;
    }

    public void setCases(List<Case> cases) {
        if (!cases.isEmpty()){
            this.cases.clear();
            for (Case emplacement : cases){
                this.cases.add(emplacement);
            }
        } else {
            System.out.println("Impossible de set la list de cases pour le plateau");
        }
    }

    public int getTailleLargeur() {
        return this.tailleLargeur;
    }

    public void setTailleLargeur(int tailleLargeur) {
        this.tailleLargeur = tailleLargeur;
    }

    public int getTailleLongeur() {
        return this.tailleLongeur;
    }

    public void setTailleLongeur(int tailleLongeur) {
        this.tailleLongeur = tailleLongeur;
    }

    public Case getCase(Case caseSeek){
        for (Case cas : this.getCases()){
            if (cas.equals(caseSeek))
                return cas;
        }
        return null;
    }

    public Case getCaseFromPosition(Position positionCase){
        for (Case cas : this.getCases()){
            if (cas.getPosition().equals(positionCase))
                return cas;
        }
        return null;
    }

    public String formatPlateau(){
        StringBuilder str = new StringBuilder();

        for (int j = 0; j < (this.tailleLargeur * this.tailleLargeur); j += tailleLargeur){

            for (int i = 0; i < this.tailleLongeur; i ++){
                str.append("+---+ ");
            }

            str.append(System.getProperty("line.separator"));

            for (int i = 0; i < this.tailleLongeur; i ++){
                str.append("| " + this.cases.get((j+i)).getValue() + " | ");
            }

            str.append(System.getProperty("line.separator"));

            for (int i = 0; i < this.tailleLongeur; i ++){
                str.append("+---+ ");
            }

            str.append(System.getProperty("line.separator"));
        }

        return str.toString();
    }

    public void displayPlateau(){
        System.out.println(formatPlateau());
    }

    public void clone(Plateau plateau){
        this.cases.clear();
        this.cases.addAll(plateau.getCases());

        this.tailleLargeur = plateau.tailleLargeur;
        this.tailleLongeur = plateau.tailleLongeur;
    }
}
