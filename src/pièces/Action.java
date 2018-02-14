package pièces;

public class Action {

    private Mouvement mouv;
    private Attaque attq;

    public Action(Mouvement mouv, Attaque attaque){
        this.mouv = mouv;
        this.attq = attaque;
    }

    public Mouvement getMouv() {
        return mouv;
    }

    public void setMouv(Mouvement mouv) {
        this.mouv = mouv;
    }

    public Attaque getAttq() {
        return attq;
    }

    public void setAttq(Attaque attq) {
        this.attq = attq;
    }
}
