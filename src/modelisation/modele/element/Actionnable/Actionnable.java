package modelisation.modele.element.Actionnable;

import intelligence_artificielle.modele.Capteur;
import intelligence_artificielle.modele.CapteurUtilisation;
import modelisation.modele.element.Element;

public abstract class Actionnable extends Element {

    private Etat etat;

    public Actionnable(int x, int y, int longueur, int largeur) {
        super(x, y, longueur, largeur);
        this.ajouterObserver(new CapteurUtilisation(this));
        this.etat = Etat.Eteint;
    }

    public void allumer() {
        assert (etat == Etat.Eteint);
        this.notifier();
    }

    public void eteindre() {
        assert (etat == Etat.Allume);
        this.notifier();
    }
}
