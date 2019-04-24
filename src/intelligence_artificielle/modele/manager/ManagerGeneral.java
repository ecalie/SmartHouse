package intelligence_artificielle.modele.manager;

import intelligence_artificielle.modele.capteur.CapteurPassage;
import intelligence_artificielle.modele.capteur.CapteurUtilisation;
import patrons.observer.Observer;
import simulation.modele.Maison;
import simulation.modele.Piece;
import simulation.modele.element.deuxEtats.AppareilDeuxEtats;
import simulation.modele.element.deuxEtats.Etat;
import simulation.modele.element.utilisable.Lit;
import simulation.modele.element.utilisable.Utilisable;

import java.util.HashMap;

public class ManagerGeneral implements Observer<Object> {

    private static ManagerGeneral instance;

    // managers délégués
    private LumiereManager lumiereManager;
    private AppareilManager appareilManager;
    private TemperatureManager temperatureManager;

    // état interne (croyances)
    private Piece positionHabitant;
    private boolean habitantDort;
    private HashMap<AppareilDeuxEtats, Piece> appareilsAllumes;

    private ManagerGeneral() {
        this.lumiereManager = new LumiereManager();
        this.appareilManager = new AppareilManager();
        this.temperatureManager = new TemperatureManager();
        this.appareilsAllumes = new HashMap<>();
    }

    public static ManagerGeneral getInstance() {
        if (instance == null)
            instance = new ManagerGeneral();
        return instance;
    }

    public void setMaison(Maison maison) {
        this.temperatureManager.setThermostat(maison.getThermostat());
    }

    public Piece getPositionHabitant() {
        return positionHabitant;
    }

    @Override
    public void update(Object objet) {
        // un capteur s'est déclenché
        if (objet instanceof Integer) {
            // l'heure a changée
            // gérer la lumière si l'habitant ne dort pas
            if (positionHabitant != null && !habitantDort)
                lumiereManager.gererLumiere((Integer) objet, positionHabitant);
        } else if (objet instanceof CapteurPassage)
            // l'habitant s'est déplacé
            this.traiterPassage((CapteurPassage) objet);
        else if (objet instanceof CapteurUtilisation)
            // l'habitant utilise ou termine d'utiliser un appareil
            this.traiterUtilisation((CapteurUtilisation) objet);
    }

    /**
     * Traiter le déplcement de l'habitant.
     *
     * @param capteur Le capteur de passage qui s'est déclenché
     */
    private void traiterPassage(CapteurPassage capteur) {
        // regarder si un appareil a été laissé allumé
        // prévenir l'appareilManager si c'est le cas
        for (AppareilDeuxEtats appareil : appareilsAllumes.keySet())
            if (appareilsAllumes.get(appareil) == positionHabitant)
                appareilManager.traiterAppareil(appareil, positionHabitant);

        // mettre à jour la position de l'habitant
        // et prévenir le LumiereManager, l'AppareilManager et le TemperatureManager
        if (positionHabitant == capteur.getPiece1()) {
            positionHabitant = capteur.getPiece2();
            lumiereManager.traiterPassage(capteur.getPiece1(), capteur.getPiece2());
        } else {
            positionHabitant = capteur.getPiece1();
            lumiereManager.traiterPassage(capteur.getPiece2(), capteur.getPiece1());
        }
        appareilManager.stopper(positionHabitant);
        temperatureManager.gererTemperature(positionHabitant, habitantDort);
    }

    /**
     * Traiter l'utilisation d'un appareil.
     *
     * @param capteur Le capteur d'utilistion qui s'est déclenché
     */
    private void traiterUtilisation(CapteurUtilisation capteur) {
        if (capteur.getAppareil() instanceof Utilisable) {
            if (capteur.getAppareil() instanceof Lit) {
                // L'habitant vient de se lever ou de se coucher
                // gérer la température et la lumière
                habitantDort = !habitantDort;
                lumiereManager.traiterLit(habitantDort, capteur.getPiece());
                temperatureManager.gererTemperature(positionHabitant, habitantDort);
            }

        } else if (capteur.getAppareil() instanceof AppareilDeuxEtats) {
            // L'habitant vient d'allumer ou d'éteindre un appareil
            // mise à jour de la liste des apprails allumés
            AppareilDeuxEtats appareil = (AppareilDeuxEtats) capteur.getAppareil();
            if (capteur.getEtat() == Etat.Allume)
                appareilsAllumes.put(appareil, capteur.getPiece());
            else
                appareilsAllumes.remove(appareil);
        }
    }
}
