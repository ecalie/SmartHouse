package intelligence_artificielle.modele;

import modelisation.modele.element.Actionnable.Actionnable;
import modelisation.modele.element.Actionnable.Etat;
import modelisation.modele.element.Element;

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
    public void update() {
        if (etat == Etat.Allume)
            etat = Etat.Eteint;
        else
            etat = Etat.Allume;
    }
}
