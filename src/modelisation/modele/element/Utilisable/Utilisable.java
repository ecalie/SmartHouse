package modelisation.modele.element.Utilisable;

import intelligence_artificielle.modele.Capteur;
import intelligence_artificielle.modele.CapteurUtilisation;
import modelisation.modele.element.Element;

public abstract class Utilisable extends Element {

    private Etat etat;

    public Utilisable(int x, int y, int longueur, int largeur) {
        super(x, y, longueur, largeur);
        this.etat = Etat.Libre;
        this.ajouterObserver(new CapteurUtilisation(this));
    }

    public void utiliser() {
        this.etat = Etat.Occupe;
        this.notifier();
    }

    public void liberer() {
        this.etat = Etat.Libre;
        this.notifier();
    }

    public Etat getEtat() {
        return etat;
    }
}
