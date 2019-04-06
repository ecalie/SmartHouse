package intelligence_artificielle.modele.manager;

import intelligence_artificielle.modele.capteur.CapteurPassage;
import intelligence_artificielle.modele.capteur.CapteurUtilisation;
import intelligence_artificielle.vue.FenetreLogging;
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

    // la maison qui est gérée par le manager
    private Maison maison;

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
        this.maison = maison;
        this.temperatureManager.setThermostat(maison.getThermostat());
    }

    @Override
    public void update(Object objet) {
        if (objet instanceof Integer) {
            if (positionHabitant != null && !habitantDort)
                lumiereManager.gererLumiere((Integer) objet, positionHabitant);
        }
         else if (objet instanceof CapteurPassage)
            this.traiterPassage((CapteurPassage) objet);
         else if (objet instanceof CapteurUtilisation)
            this.traiterUtilisation((CapteurUtilisation) objet);

    }

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

        FenetreLogging.ajouterLoggingCapteur("L'habitant entre dans la pièce : " + positionHabitant);

    }

    private void traiterUtilisation(CapteurUtilisation capteur) {
        if (capteur.getAppareil() instanceof Utilisable) {
            if (capteur.getAppareil() instanceof Lit) {
                habitantDort = !habitantDort;
                lumiereManager.traiterLit(habitantDort, capteur.getPiece());
                temperatureManager.gererTemperature(positionHabitant, habitantDort);
            }

            FenetreLogging.ajouterLoggingCapteur("L'habitant " +
                    (capteur.getEtat() == Etat.Allume ? "utilise " : "a fini d'utiliser ") +
                    capteur.getAppareil().getClass().getSimpleName());

        } else if (capteur.getAppareil() instanceof AppareilDeuxEtats) {
            AppareilDeuxEtats appareil = (AppareilDeuxEtats) capteur.getAppareil();
            if (capteur.getEtat() == Etat.Allume)
                appareilsAllumes.put(appareil, capteur.getPiece());
            else
                appareilsAllumes.remove(appareil);

            FenetreLogging.ajouterLoggingCapteur("L'habitant a " +
                    capteur.getEtat() + " " + appareil.getClass().getSimpleName());
        }
    }


}
