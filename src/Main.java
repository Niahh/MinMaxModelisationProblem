import pièces.*;
import plateau.Case;
import plateau.Plateau;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void placementPieceJoueur1(Plateau plateau){

    }

    public static void placementPieceJoueur2(Plateau plateau){

    }

    public static void placementPieceDepart(Plateau plateau){
        placementPieceJoueur1(plateau);
        placementPieceJoueur2(plateau);
    }

    public static Joueur creationJoueur1(Plateau plateau){
        // Creation du premier joueur et initialisation de ces pièces
        List<Fantassin> fantassins = new ArrayList<>();
        fantassins.add(new Fantassin(0, plateau.getCaseFromPosition(new Position(0,0))));

        List<Mitrailleurs> mitrailleurs = new ArrayList<>();
        mitrailleurs.add(new Mitrailleurs(0, plateau.getCaseFromPosition(new Position(2,0))));

        List<TourMobile> tourMobiles = new ArrayList<>();

        Joueur j = new Joueur(plateau, fantassins, mitrailleurs, tourMobiles);

        return j;
    }

    public static Joueur creationJoueur2(Plateau plateau){
        // Creation du second joueur et initialisation de ces pièces
        List<Fantassin> fantassins2 = new ArrayList<>();
        fantassins2.add(new Fantassin(0, plateau.getCaseFromPosition(new Position(2,3))));

        List<Mitrailleurs> mitrailleurs2 = new ArrayList<>();
        mitrailleurs2.add(new Mitrailleurs(0, plateau.getCaseFromPosition(new Position(3, 3))));

        List<TourMobile> tourMobiles2 = new ArrayList<>();

        Joueur j = new Joueur(plateau, fantassins2, mitrailleurs2, tourMobiles2);

        return j;
    }


    public static void main(String[] args) {
        System.out.println("Mission 3!");

        // Création d'un plateau 4 x 4 cases
        Plateau plateau = new Plateau(4, 4);

        // Affichage du plateau
        plateau.displayPlateau();

        Joueur j1 = creationJoueur1(plateau);

        plateau.displayPlateau();

        Joueur j2 = creationJoueur2(plateau);

        plateau.displayPlateau();

    }


}
