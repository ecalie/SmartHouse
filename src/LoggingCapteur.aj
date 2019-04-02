import intelligence_artificielle.modele.CapteurUtilisation;
import intelligence_artificielle.modele.CapteurPassage;
import intelligence_artificielle.vue.FenetreLogging;
import modelisation.modele.element.deuxEtats.DeuxEtats;
import modelisation.modele.element.deuxEtats.Etat;

public aspect LoggingCapteur {

    pointcut capteur() : execution (public void intelligence_artificielle.modele.Capteur.update(..));
    after() : capteur() {
        if (thisJoinPoint.getTarget() instanceof CapteurPassage) {
            FenetreLogging.ajouterLoggingCapteur("L'habitant entre dans la pièce : " + ((CapteurPassage) thisJoinPoint.getTarget()).getPiece().getNom());
        }

        if (thisJoinPoint.getTarget() instanceof CapteurUtilisation)
            if (((CapteurUtilisation) thisJoinPoint.getTarget()).getAppareil() instanceof DeuxEtats)
                FenetreLogging.ajouterLoggingAction("L'habitant à " +
                        (((CapteurUtilisation) thisJoinPoint.getTarget()).getEtat() == Etat.Allume ? "allumé " : "éteint ") +
                        ((CapteurUtilisation) thisJoinPoint.getTarget()).getAppareil().getClass().getSimpleName());
            else
                FenetreLogging.ajouterLoggingAction("L'habitant " +
                        (((CapteurUtilisation) thisJoinPoint.getTarget()).getEtat() == Etat.Allume ? "utilise " : "a fini d'utiliser ") +
                        ((CapteurUtilisation) thisJoinPoint.getTarget()).getAppareil().getClass().getSimpleName());
        }
}