package intelligence_artificielle.modele.manager;

import intelligence_artificielle.modele.capteur.CapteurPassage;
import intelligence_artificielle.modele.capteur.CapteurUtilisation;
import intelligence_artificielle.vue.FenetreLogging;
import patrons.observer.Observer;
import simulation.modele.Piece;
import simulation.modele.element.deuxEtats.AppareilDeuxEtats;
import simulation.modele.element.deuxEtats.Etat;
import simulation.modele.element.utilisable.Lit;
import simulation.modele.element.utilisable.Utilisable;

import java.util.HashMap;

public class ManagerGeneral implements Observer<Object> {

    private static ManagerGeneral instance;

    private LumiereManager lumiereManager;
    private AppareilManager appareilManager;

    // état interne (croyances)
    private Piece positionHabitant;
    private boolean habitantDort;
    private HashMap<AppareilDeuxEtats, Piece> appareilsAllumes;

    private ManagerGeneral() {
        this.lumiereManager = new LumiereManager();
        this.appareilManager = new AppareilManager();
        this.appareilsAllumes = new HashMap<>();
    }

    public static ManagerGeneral getInstance() {
        if (instance == null)
            instance = new ManagerGeneral();
        return instance;
    }


    @Override
    public void update(Object objet) {
        if (objet instanceof Integer) {
            if (positionHabitant != null && !habitantDort)
                lumiereManager.gererLumiere((Integer) objet, positionHabitant);
        } else if (objet instanceof CapteurPassage) {
            CapteurPassage cp = (CapteurPassage) objet;

            // regarder si un appareil a été laissé allumé
            // prévenir l'appareilManager si c'est le cas
            for (AppareilDeuxEtats appareil : appareilsAllumes.keySet())
                if (appareilsAllumes.get(appareil) == positionHabitant)
                    appareilManager.traiterAppareil(appareil, positionHabitant);

            // mettre à jour la position de l'habitant
            // et prévenir le LumiereManager et l'appareilManager
            if (positionHabitant == cp.getPiece1()) {
                positionHabitant = cp.getPiece2();
                lumiereManager.traiterPassage(cp.getPiece1(), cp.getPiece2());
            } else {
                positionHabitant = cp.getPiece1();
                lumiereManager.traiterPassage(cp.getPiece2(), cp.getPiece1());
            }
            appareilManager.stopper(positionHabitant);

            FenetreLogging.ajouterLoggingCapteur("L'habitant entre dans la pièce : " + positionHabitant);
        } else if (objet instanceof CapteurUtilisation) {
            CapteurUtilisation cu = (CapteurUtilisation) objet;

            if (cu.getAppareil() instanceof Utilisable) {
                if (cu.getAppareil() instanceof Lit) {
                    habitantDort = !habitantDort;
                    lumiereManager.traiterLit(habitantDort, cu.getPiece());
                }

                FenetreLogging.ajouterLoggingCapteur("L'habitant " +
                        (cu.getEtat() == Etat.Allume ? "utilise " : "a fini d'utiliser ") +
                        cu.getAppareil().getClass().getSimpleName());

            } else if (cu.getAppareil() instanceof AppareilDeuxEtats) {
                AppareilDeuxEtats appareil = (AppareilDeuxEtats) cu.getAppareil();
                if (cu.getEtat() == Etat.Allume)
                    appareilsAllumes.put(appareil, cu.getPiece());
                else
                    appareilsAllumes.remove(appareil);

                FenetreLogging.ajouterLoggingCapteur("L'habitant a " +
                        cu.getEtat() + " " + appareil.getClass().getSimpleName());
            }
        }
    }
}
