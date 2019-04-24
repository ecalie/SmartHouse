package simulation.modele.element.utilisable;

import simulation.modele.element.Element;

public abstract class Utilisable extends Element {

    protected Utilisable(int x, int y, int longueur, int largeur) {
        super(x, y, longueur, largeur);
    }

    /**
     * Utilise du mobilier.
     */
    public void utiliser() {
        this.capteur.declencher();
    }

    /**
     * Libérer le mobilier.
     */
    public void liberer() {
        this.capteur.declencher();
    }

}
