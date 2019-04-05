package simulation.modele.element.utilisable;

import simulation.modele.element.Element;

public abstract class Utilisable extends Element {

    protected Utilisable(int x, int y, int longueur, int largeur) {
        super(x, y, longueur, largeur);
    }

    public void utiliser() {
        this.capteur.declencher();
    }

    public void liberer() {
        this.capteur.declencher();
    }

}
