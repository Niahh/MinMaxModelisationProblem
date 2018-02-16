import jdk.nashorn.internal.scripts.JO;
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
        fantassins.add(new Fantassin(1, plateau.getCaseFromPosition(new Position(3,0))));

        List<Mitrailleurs> mitrailleurs = new ArrayList<>();
        //mitrailleurs.add(new Mitrailleurs(1, plateau.getCaseFromPosition(new Position(3,0))));

        List<TourMobile> tourMobiles = new ArrayList<>();

        Joueur j = new Joueur(plateau, fantassins, mitrailleurs, tourMobiles);

        return j;
    }

    public static Joueur creationJoueur2(Plateau plateau){
        // Creation du second joueur et initialisation de ces pièces
        List<Fantassin> fantassins2 = new ArrayList<>();
        fantassins2.add(new Fantassin(0, plateau.getCaseFromPosition(new Position(1,3))));
        fantassins2.add(new Fantassin(0, plateau.getCaseFromPosition(new Position(3, 3))));

        List<Mitrailleurs> mitrailleurs2 = new ArrayList<>();
        //mitrailleurs2.add(new Mitrailleurs(0, plateau.getCaseFromPosition(new Position(3, 3))));

        List<TourMobile> tourMobiles2 = new ArrayList<>();

        Joueur j = new Joueur(plateau, fantassins2, mitrailleurs2, tourMobiles2);

        return j;
    }


    public static void main(String[] args) {
        //testAction();
        testJeux();
    }


    public static void testJeux(){

        System.out.println("Test Jeux !");

        // Création d'un plateau 4 x 4 cases
        Plateau plateau = new Plateau(4, 4);

        Joueur j1 = creationJoueur1(plateau);

        Joueur j2 = creationJoueur2(plateau);

        List<Action> actions = j1.allActionsPossible(plateau, j1.getFantassins());
        List<Action> actions2 = j2.allActionsPossible(plateau, j2.getFantassins());

        plateau.displayPlateau();

        boolean endOfTheGame = end(j1, j2);

        while (!endOfTheGame){
            jouer(j1, j2, plateau, endOfTheGame);
            plateau.displayPlateau();

            try{
                Thread.sleep(2000);
            } catch (Exception e){
                e.printStackTrace();
            }

            if (end(j1, j2)){
                endOfTheGame = true;
            } else {
                j2.allActionsPossible(plateau, j2.getFantassins()).get(random(j2.allActionsPossible(plateau, j2.getFantassins()).size(), 0)).apply();
                plateau.displayPlateau();

                try{
                    Thread.sleep(2000);
                } catch (Exception e){
                    e.printStackTrace();
                }
                if (end(j1, j2)){
                    endOfTheGame = true;
                }
            }
        }

    }

    public static boolean end(Joueur j1, Joueur j2){
        return j1.getFantassins().isEmpty() || j2.getFantassins().isEmpty();
    }


    public static void jouer(Joueur j, Joueur opposant, Plateau plateau, boolean end){
        // On défini la profondeur de notre min max
        int profondeur = 1;

        // On crée une variable qui stock en mémoire la valeur maximal à dépasser si on veut devenir l'action la plus intéressante. Au début elle est donc largement facile à dépasser.
        int maxVal = -100000;

        // List d'action avec poids egal
        List<Action> poidsEgal = new ArrayList<>();

        // On crée une copie du plateau actuel qui va nous permettre de tester les différentes actions.
        Plateau plateauEssai = new Plateau();

        int maxDuMin = -100000;
        System.out.println("Nombre action joueur : "  + j.allActionsPossible(plateau, j.getFantassins()).size());

        // On itère sur toutes les actions possible pour le joueur.
        for (Action action : j.allActionsPossible(plateau, j.getFantassins())){
            plateauEssai.clone(plateau);
            // On effectue le coup actuel sur le nouveau plateau
            action.setPlateau(plateauEssai);
            if (action.getMouv().getPiece().getCase().getPiece() == null){
                maxDuMin = -100000;
            } else {
                if (action.apply()){
                    // On récupère le minimum des noeuds-fils du noeud en paramètre
                    maxDuMin = min(plateauEssai, profondeur, j, opposant, end);
                } else {
                    maxDuMin = -100000;
                }
            }

            if (maxDuMin > maxVal){
                maxVal = maxDuMin;
                if (action.getMouv().getPiece().getCase().getPiece() == null){
                    poidsEgal.clear();
                    poidsEgal.add(action);
                }
            } else if (maxDuMin == maxVal){
                poidsEgal.add(action);
                if (action.getMouv().getPiece().getCase().getPiece() == null){
                    poidsEgal.clear();
                    poidsEgal.add(action);
                }
            }
        }
        if (poidsEgal.size() == 1){
            poidsEgal.get(0).apply();
        } else {
            poidsEgal.get(random(poidsEgal.size(), 0)).apply();
        }
    }

    public static int min(Plateau plateau, int profondeur, Joueur j, Joueur opposant, boolean endOfGame){

        // On crée une copie de ce plateau pour tester les coups de notre opposant et choisir le min
        Plateau plateauOpposant = new Plateau();

        // Si on arrive à la fin(feuille) on renvoit l'évaluation du plateau
        if (profondeur == 0 || endOfGame){
            return eval(plateau, j, opposant);
        }

        // On crée une variable qui va stocker le coup avec le plus faible coût.
        int minVal = 100000;

        int minDuMax = 100000;

        for (Action action : opposant.allActionsPossible(plateau, opposant.getFantassins())){
            plateauOpposant.clone(plateau);
            // On effectue le coup actuel sur le nouveau plateau
            action.setPlateau(plateauOpposant);
            if (action.getMouv().getPiece().getCase().getPiece() == null){
                minDuMax = 100000;
            } else {
                if(action.apply()){
                    // On récupère le minimum des noeuds-fils du noeud en paramètre
                    minDuMax = max(plateauOpposant, profondeur - 1, j, opposant, endOfGame);
                } else {
                    minDuMax = 100000;
                }
            }

            if (minDuMax < minVal){
                minVal = minDuMax;
            }
        }

        return minVal;
    }

    public static int max(Plateau plateau, int profonfeur, Joueur joueur, Joueur opposant, boolean endOfTheGame){

        // Même étape de mise en cache d'information
        Plateau plateauJoueur = new Plateau();

        if (profonfeur == 0 || endOfTheGame){
            return eval(plateau, joueur, opposant);
        }

        int maxVal = -100000;

        int maxDuMin = -100000;

        for (Action action : joueur.allActionsPossible(plateau, joueur.getFantassins())){
            plateauJoueur.clone(plateau);
            if (action.getMouv().getPiece().getCase().getPiece() != null){
                maxDuMin = -100000;
            } else {
                if(action.apply()){
                    maxDuMin = min(plateauJoueur, profonfeur - 1, joueur, opposant, endOfTheGame );
                } else {
                    maxDuMin = -100000;
                }

            }

            if (maxDuMin > maxVal) {
                maxVal = maxDuMin;
            }
        }

         return maxVal;
    }

    public static int eval(Plateau plateau, Joueur joueur, Joueur opposant){
        // Chaque piece sur le terrain rapporte 100 points, cette fonction d'évaluation est simple,  mais elle permet de servir de base pour l'implémentation du min max.
        int scoreJoueur = joueur.getFantassins().size() * 100;
        int scoreOpposant = joueur.getFantassins().size() * 100;
        return scoreJoueur - scoreOpposant;
    }

    public static int random(int max, int min){
        return (int)Math.random() * (max - min);
    }

    /*
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

        public static void testListActions(){

        System.out.println("Test Action !");

        // Création d'un plateau 4 x 4 cases
        Plateau plateau = new Plateau(4, 4);

        Joueur j1 = creationJoueur1(plateau);

        Joueur j2 = creationJoueur2(plateau);

        List<Action> actions = j1.allActionsPossible(plateau, j1.getFantassins());
        List<Action> actions2 = j2.allActionsPossible(plateau, j2.getFantassins());

        System.out.println("Taille de la liste d'action : " + actions.size());
        System.out.println("Taille de la liste d'action : " + actions2.size());


        plateau.displayPlateau();
    }

    */

}
