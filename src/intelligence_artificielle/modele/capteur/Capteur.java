package intelligence_artificielle.modele.capteur;

import intelligence_artificielle.modele.manager.ManagerGeneral;
import patrons.observer.Observable;

public abstract class Capteur extends Observable<Capteur> {

    public Capteur() {
        this.ajouterObserver(ManagerGeneral.getInstance());
    }

    /**
     * Le capteur se déclenche.
     */
    public void declencher() {
        this.notifier(this);
    }
}
