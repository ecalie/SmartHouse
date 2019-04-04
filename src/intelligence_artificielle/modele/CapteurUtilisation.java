package intelligence_artificielle.modele;

import simulation.modele.element.Element;
import simulation.modele.element.deuxEtats.Etat;

public class CapteurUtilisation implements Capteur {

    private Element appareil;
    private Etat etat;

    public CapteurUtilisation(Element appareil) {
        this.appareil = appareil;
        this.etat = Etat.Eteint;
    }

    public Element getAppareil() {
        return appareil;
    }

    public Etat getEtat() {
        return etat;
    }

    @Override
    public void declencher() {
        if (etat == Etat.Allume)
            etat = Etat.Eteint;
        else
            etat = Etat.Allume;
    }
}
