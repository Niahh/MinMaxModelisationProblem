package pièces;

import plateau.Case;

import java.util.ArrayList;
import java.util.List;

public class UtilMission3 {

    /*
        public static String displayMatrice(int tailleLigne, int tailleColonne, List<Position> valeurs){
        StringBuilder str = new StringBuilder();
        for (int j = 0; j < tailleLigne * tailleColonne; j += tailleLigne){

            for (int i = 0; i <  tailleLigne; i ++){
                str.append("+---+ ");
            }

            str.append(System.getProperty("line.separator"));

            for (int i = 0; i <  tailleLigne; i ++){
                str.append("| ").append(valeurs.get(i + j)).append(" | ");
            }

            str.append(System.getProperty("line.separator"));

            for (int i = 0; i <  tailleLigne; i ++){
                str.append("+---+ ");
            }

            str.append(System.getProperty("line.separator"));
        }
        return str.toString();
    }
     */

    public static List<Position> mouvementBasique(Case cas){

        List<Position> deplacements = new ArrayList<>();

        // Déplacement gauche
        deplacements.add(new Position(cas.getPosition().posX - 1, cas.getPosition().posY));
        deplacements.add(new Position(cas.getPosition().posX - 2, cas.getPosition().posY));

        // Déplacement droite
        deplacements.add(new Position(cas.getPosition().posX + 1, cas.getPosition().posY));
        deplacements.add(new Position(cas.getPosition().posX + 2, cas.getPosition().posY));

        // Déplacement bas
        deplacements.add(new Position(cas.getPosition().posX , cas.getPosition().posY - 1));
        deplacements.add(new Position(cas.getPosition().posX , cas.getPosition().posY - 2));

        // Déplacement Haut
        deplacements.add(new Position(cas.getPosition().posX, cas.getPosition().posY + 1));
        deplacements.add(new Position(cas.getPosition().posX, cas.getPosition().posY + 2));

        return deplacements;
    }


}
