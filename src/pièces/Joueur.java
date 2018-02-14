package pièces;

import javafx.geometry.Pos;
import plateau.Case;
import plateau.Plateau;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private List<Fantassin> fantassins = new ArrayList<>();
    private List<TourMobile> tourMobiles = new ArrayList<>();
    private List<Mitrailleurs> mitrailleurs = new ArrayList<>();
    private Plateau plateau;

    private List<Action> actions = new ArrayList<>();

    public Joueur(Plateau plateau, List<Fantassin> fantassins, List<Mitrailleurs> mitrailleurs, List<TourMobile> tourMobiles){
        this.plateau = plateau;

        this.setFantassins(fantassins);
        this.setMitrailleurs(mitrailleurs);
        this.setTourMobiles(tourMobiles);

        placementPiecePlateau();
    }

    public void placementPiecePlateau(){
        //placementTours();
        placementMitrailleurs();
        placementFantassins();
    }

    public void placementTours(){
        for (TourMobile tr : this.tourMobiles){
            this.plateau.setCase(tr);
        }
    }

    public void placementMitrailleurs(){
        for (Mitrailleurs mi : this.mitrailleurs){
            this.plateau.setCase(mi);
        }
    }

    public void placementFantassins(){
        for (Fantassin fa : this.fantassins){
            this.plateau.setCase(fa);
        }
    }

    public List<Fantassin> getFantassins() {
        return fantassins;
    }

    public void setFantassins(List<Fantassin> fantassins) {
        this.fantassins.clear();
        for (Fantassin fa : fantassins){
            fa.setJoueur(this);
            this.fantassins.add(fa);
        }
    }

    public List<Mitrailleurs> getMitrailleurs() {
        return mitrailleurs;
    }

    public void setMitrailleurs(List<Mitrailleurs> mitrailleurs) {
        this.mitrailleurs.clear();
        for (Mitrailleurs mi : mitrailleurs){
            mi.setJoueur(this);
            this.mitrailleurs.add(mi);
        }
    }

    public List<TourMobile> getTourMobiles() {
        return tourMobiles;
    }

    public void setTourMobiles(List<TourMobile> tourMobiles) {
        this.tourMobiles.clear();
        for (TourMobile tr: tourMobiles){
            tr.setJoueur(this);
            this.tourMobiles.add(tr);
        }
    }

    public boolean equals(Joueur joueur){
        return this.tourMobiles.equals(joueur.getTourMobiles()) && this.mitrailleurs.equals(joueur.getMitrailleurs()) && this.fantassins.equals(joueur.getFantassins());
    }

    public void clone (Joueur joueur){
        this.fantassins.clear();
        this.fantassins.addAll(joueur.getFantassins());

        this.mitrailleurs.clear();
        this.mitrailleurs.addAll(joueur.getMitrailleurs());

        this.tourMobiles.clear();
        this.tourMobiles.addAll(joueur.getTourMobiles());
    }

    public Plateau getPlateau() {
        return plateau;
    }

    public void setPlateau(Plateau plateau) {
        this.plateau = plateau;
    }

    public List<Action> allActionsPossiblePiece(Plateau plateau, Piece piece){
        List<Action > actions = new ArrayList<>();

        Case cas = piece.getCase();

        System.out.println("Mouvement possibles : " + this.allMouvementsPossiblePiece(plateau, piece).size());

        int attaquesPos = 0;

        for (Position mv : this.allMouvementsPossiblePiece(plateau, piece)){
            Mouvement mouv = new Mouvement(piece, mv, plateau);

            for (Position attq : allAttaquesPossiblePiece(plateau, mouv)){
                attaquesPos += allAttaquesPossiblePiece(plateau, mouv).size();
                actions.add(new Action(plateau, piece, mv, attq));
            }
        }

        System.out.println("Attaque possibles : " + attaquesPos);
        return actions;
    }

    public List<Position> allAttaquesPossiblePiece(Plateau plateau, Mouvement mv){
        List<Position> attaques = new ArrayList<>();

        Position positionTmp = mv.getPiece().getCase().getPosition();

        mv.applyMouvement();

        for (Position pos : mv.getPiece().attaquesPossibles()){
            Case cas = plateau.getCaseFromPosition(pos);
            if (cas != null){
                attaques.add(pos);
            }
        }

        Mouvement mvReturn = new Mouvement(mv.getPiece(), positionTmp, plateau);
        mvReturn.applyMouvement();

        return attaques;
    }

    public List<Position> allMouvementsPossiblePiece(Plateau plateau, Piece piece){

        List<Position> mouvements = new ArrayList<>();

        for (Position pos : piece.mouvementPossibles()){
            Case ca = plateau.getCaseFromPosition(pos);
            if ( ca != null && ca.getPiece() == null){
                mouvements.add(pos);
            }
        }

        return mouvements;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }
}
