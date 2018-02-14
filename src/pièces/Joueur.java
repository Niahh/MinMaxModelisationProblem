package pièces;

import plateau.Plateau;

import java.util.ArrayList;
import java.util.List;

public class Joueur {
    private List<Fantassin> fantassins = new ArrayList<>();
    private List<TourMobile> tourMobiles = new ArrayList<>();
    private List<Mitrailleurs> mitrailleurs = new ArrayList<>();
    private Plateau plateau;

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
}
