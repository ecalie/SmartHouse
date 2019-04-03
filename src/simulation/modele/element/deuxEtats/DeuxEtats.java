package simulation.modele.element.deuxEtats;

import intelligence_artificielle.modele.CapteurUtilisation;
import simulation.modele.element.Element;

public abstract class DeuxEtats extends Element {

    private Etat etat;

    protected DeuxEtats(int x, int y, int longueur, int largeur) {
        super(x, y, longueur, largeur);
        this.ajouterObserver(new CapteurUtilisation(this));
        this.etat = Etat.Eteint;
    }

    public Etat getEtat() {
        return etat;
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