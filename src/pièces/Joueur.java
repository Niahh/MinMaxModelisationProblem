package pièces;

import plateau.Plateau;

import java.util.List;

public class Joueur {
    private List<Fantassin> fantassins;
    private List<TourMobile> tourMobiles;
    private List<Mitrailleurs> mitrailleurs;
    private Plateau plateau;

    public Joueur(Plateau plateau, List<Fantassin> fantassins, List<Mitrailleurs> mitrailleurs, List<TourMobile> tourMobiles){
        this.plateau.clone(plateau);

        this.setFantassins(fantassins);
        this.setMitrailleurs(mitrailleurs);
        this.setTourMobiles(tourMobiles);
    }

    public List<Fantassin> getFantassins() {
        return fantassins;
    }

    public void setFantassins(List<Fantassin> fantassins) {
        this.fantassins.clear();
        this.fantassins.addAll(fantassins);
    }

    public List<Mitrailleurs> getMitrailleurs() {
        return mitrailleurs;
    }

    public void setMitrailleurs(List<Mitrailleurs> mitrailleurs) {
        this.mitrailleurs.clear();
        this.mitrailleurs.addAll(mitrailleurs);
    }

    public List<TourMobile> getTourMobiles() {
        return tourMobiles;
    }

    public void setTourMobiles(List<TourMobile> tourMobiles) {
        this.tourMobiles.clear();
        this.tourMobiles.addAll(tourMobiles);
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
