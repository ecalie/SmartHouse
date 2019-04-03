package simulation.modele.element.utilisable;

import intelligence_artificielle.modele.CapteurUtilisation;
import simulation.modele.element.Element;

public abstract class Utilisable extends Element {


    protected Utilisable(int x, int y, int longueur, int largeur) {
        super(x, y, longueur, largeur);
        this.ajouterObserver(new CapteurUtilisation(this));
    }

    public void utiliser() {
        this.notifier();
    }

    public void liberer() {
        this.notifier();
    }

}
