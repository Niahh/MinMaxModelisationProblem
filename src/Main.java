import pièces.*;
import plateau.Case;
import plateau.Plateau;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static Joueur creationJoueur1(Plateau plateau){
        // Creation du premier joueur et initialisation de ces pièces
        List<Fantassin> fantassins = new ArrayList<>();
        fantassins.add(new Fantassin(1, plateau.getCaseFromPosition(new Position(0,0))));

        List<Mitrailleurs> mitrailleurs = new ArrayList<>();
        mitrailleurs.add(new Mitrailleurs(1, plateau.getCaseFromPosition(new Position(3,0))));

        List<TourMobile> tourMobiles = new ArrayList<>();

        Joueur j = new Joueur(plateau, fantassins, mitrailleurs, tourMobiles);

        return j;
    }

    public static Joueur creationJoueur2(Plateau plateau){
        // Creation du second joueur et initialisation de ces pièces
        List<Fantassin> fantassins2 = new ArrayList<>();
        fantassins2.add(new Fantassin(0, plateau.getCaseFromPosition(new Position(0,3))));

        List<Mitrailleurs> mitrailleurs2 = new ArrayList<>();
        mitrailleurs2.add(new Mitrailleurs(0, plateau.getCaseFromPosition(new Position(3, 3))));

        List<TourMobile> tourMobiles2 = new ArrayList<>();

        Joueur j = new Joueur(plateau, fantassins2, mitrailleurs2, tourMobiles2);

        return j;
    }


    public static void main(String[] args) {
        testAction();
    }

    public static void testAction(){
        System.out.println("Test Action !");

        // Création d'un plateau 4 x 4 cases
        Plateau plateau = new Plateau(4, 4);

        Joueur j1 = creationJoueur1(plateau);
        Joueur j2 = creationJoueur2(plateau);

        plateau.displayPlateau();

        Position positionDeplacement = new Position( 0,2);
        Position positionAttaque = new Position( 0,3);

        Action action = new Action(plateau, j1.getFantassins().get(0), positionDeplacement, positionAttaque);

        action.apply();

        plateau.displayPlateau();

        System.out.println("Liste de fantassins du joueur 2 est vide : " + j2.getFantassins().isEmpty());
    }


}
