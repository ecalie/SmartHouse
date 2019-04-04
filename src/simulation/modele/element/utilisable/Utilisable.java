package simulation.modele.element.utilisable;

import intelligence_artificielle.modele.CapteurUtilisation;
import simulation.modele.element.Element;

public abstract class Utilisable extends Element {

    private CapteurUtilisation capteur;

    protected Utilisable(int x, int y, int longueur, int largeur) {
        super(x, y, longueur, largeur);
        this.capteur = new CapteurUtilisation(this);
    }

    public void utiliser() {
        this.capteur.declencher();
    }

    public void liberer() {
        this.capteur.declencher();
    }

}
