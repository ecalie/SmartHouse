import intelligence_artificielle.modele.CapteurUtilisation;
import intelligence_artificielle.modele.LumiereManager;
import intelligence_artificielle.modele.MessagePassage;
import intelligence_artificielle.vue.FenetreLogging;
import simulation.modele.element.deuxEtats.DeuxEtats;
import simulation.modele.element.deuxEtats.Etat;

public aspect LoggingCapteur {

    pointcut deplacement(): execution (public void intelligence_artificielle.modele.LumiereManager.traiterMessage(MessagePassage));
    after(): deplacement() {
        FenetreLogging.ajouterLoggingCapteur("L'habitant entre dans la pièce : " +
                (LumiereManager.getInstance().getPositionHabitant() == ((MessagePassage) thisJoinPoint.getArgs()[0]).getPiece1() ?
                        ((MessagePassage) thisJoinPoint.getArgs()[0]).getPiece1().getNom() :
                        ((MessagePassage) thisJoinPoint.getArgs()[0]).getPiece2().getNom()));
    }

    pointcut utilisation(): execution (public void intelligence_artificielle.modele.CapteurUtilisation.declencher(..));
    after(): utilisation() {
        if (((CapteurUtilisation) thisJoinPoint.getTarget()).getAppareil() instanceof DeuxEtats)
            FenetreLogging.ajouterLoggingCapteur("L'habitant à " +
                    (((CapteurUtilisation) thisJoinPoint.getTarget()).getEtat() == Etat.Allume ? "allumé " : "éteint ") +
                    ((CapteurUtilisation) thisJoinPoint.getTarget()).getAppareil().getClass().getSimpleName());
        else
            FenetreLogging.ajouterLoggingCapteur("L'habitant " +
                    (((CapteurUtilisation) thisJoinPoint.getTarget()).getEtat() == Etat.Allume ? "utilise " : "a fini d'utiliser ") +
                    ((CapteurUtilisation) thisJoinPoint.getTarget()).getAppareil().getClass().getSimpleName());
    }
}

