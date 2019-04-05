public aspect LoggingCapteur {

   /* pointcut deplacement(): call (public void intelligence_artificielle.modele.manager.LumiereManager.traiterMessage(MessagePassage));
    after(): deplacement() {
        FenetreLogging.ajouterLoggingCapteur("L'habitant entre dans la pièce : " +
                (LumiereManager.getInstance().getPositionHabitant() == ((MessagePassage) thisJoinPoint.getArgs()[0]).getPiece1() ?
                        ((MessagePassage) thisJoinPoint.getArgs()[0]).getPiece1().getNom() :
                        ((MessagePassage) thisJoinPoint.getArgs()[0]).getPiece2().getNom()));
    }

    pointcut utilisation(): call (public void intelligence_artificielle.modele.capteur.CapteurUtilisation.declencher(..));
    after(): utilisation() {
        if (((CapteurUtilisation) thisJoinPoint.getTarget()).getAppareil() instanceof DeuxEtats)
            FenetreLogging.ajouterLoggingCapteur("L'habitant a " +
                    (((CapteurUtilisation) thisJoinPoint.getTarget()).getEtat() == Etat.Allume ? "allumé " : "éteint ") +
                    ((CapteurUtilisation) thisJoinPoint.getTarget()).getAppareil().getClass().getSimpleName());
        else
            FenetreLogging.ajouterLoggingCapteur("L'habitant " +
                    (((CapteurUtilisation) thisJoinPoint.getTarget()).getEtat() == Etat.Allume ? "utilise " : "a fini d'utiliser ") +
                    ((CapteurUtilisation) thisJoinPoint.getTarget()).getAppareil().getClass().getSimpleName());
    }*/
}

