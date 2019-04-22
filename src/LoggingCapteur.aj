import intelligence_artificielle.modele.capteur.CapteurPassage;
import intelligence_artificielle.modele.capteur.CapteurUtilisation;
import intelligence_artificielle.modele.manager.ManagerGeneral;
import intelligence_artificielle.vue.FenetreLogging;
import simulation.modele.element.deuxEtats.Etat;
import simulation.modele.element.utilisable.Utilisable;

public aspect LoggingCapteur {

    pointcut deplacement(): execution (private void intelligence_artificielle.modele.manager.ManagerGeneral.traiterPassage(CapteurPassage));
    after(): deplacement() {
        if (((CapteurPassage) thisJoinPoint.getArgs()[0]).getPiece1() == null || ((CapteurPassage) thisJoinPoint.getArgs()[0]).getPiece2() == null)
            if (ManagerGeneral.getInstance().getPositionHabitant() == null)
                FenetreLogging.ajouterLoggingCapteur("L'habitant sort de la maison");
            else
                FenetreLogging.ajouterLoggingCapteur("L'habitant entre dans la maison");
        else
            FenetreLogging.ajouterLoggingCapteur("L'habitant entre dans la pièce : " + ManagerGeneral.getInstance().getPositionHabitant());
    }

    pointcut utilisation(): execution (private void intelligence_artificielle.modele.manager.ManagerGeneral.traiterUtilisation(CapteurUtilisation));
    after(): utilisation() {
        if (((CapteurUtilisation) thisJoinPoint.getArgs()[0]).getAppareil() instanceof Utilisable)
            FenetreLogging.ajouterLoggingCapteur("L'habitant " +
                    (((CapteurUtilisation) thisJoinPoint.getArgs()[0]).getEtat() == Etat.Allume ? "utilise " : "a fini d'utiliser ") +
                    ((CapteurUtilisation) thisJoinPoint.getArgs()[0]).getAppareil().getClass().getSimpleName());
        else
            FenetreLogging.ajouterLoggingCapteur(((CapteurUtilisation) thisJoinPoint.getArgs()[0]).getAppareil().getClass().getSimpleName() +
                    " est " + (((CapteurUtilisation) thisJoinPoint.getArgs()[0]).getEtat()));
    }
}

