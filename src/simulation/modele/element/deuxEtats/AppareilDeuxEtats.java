package simulation.modele.element.deuxEtats;

import simulation.modele.element.Element;

public abstract class AppareilDeuxEtats extends Element {

    private Etat etat;

    protected AppareilDeuxEtats(int x, int y, int longueur, int largeur) {
        super(x, y, longueur, largeur);
        this.etat = Etat.Eteint;
    }

    public Etat getEtat() {
        return etat;
    }

    /**
     * Allumer l'appareil.
     */
    public void allumer() {
        assert (etat == Etat.Eteint);
        this.capteur.declencher();
    }

    /**
     * Eteindre l'appareil.
     */
    public void eteindre() {
        assert (etat == Etat.Allume);
        this.capteur.declencher();
    }
}
