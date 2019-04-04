package simulation.modele.element.deuxEtats;

import intelligence_artificielle.modele.CapteurUtilisation;
import simulation.modele.element.Element;

public abstract class DeuxEtats extends Element {

    private Etat etat;
    private CapteurUtilisation capteur;

    protected DeuxEtats(int x, int y, int longueur, int largeur) {
        super(x, y, longueur, largeur);
        this.etat = Etat.Eteint;
        this.capteur = new CapteurUtilisation(this);
    }

    public Etat getEtat() {
        return etat;
    }

    public void allumer() {
        assert (etat == Etat.Eteint);
        this.capteur.declencher();
    }

    public void eteindre() {
        assert (etat == Etat.Allume);
        this.capteur.declencher();
    }
}
