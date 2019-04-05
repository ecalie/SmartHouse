package intelligence_artificielle.modele;

import simulation.modele.Horloge;
import simulation.modele.Piece;

public class LumiereManager {

    private static LumiereManager instance;
    private Piece positionHabitant;
    private ThreadSlave threadSlave;

    private LumiereManager() {
        this.threadSlave = new ThreadSlave();
        this.threadSlave.start();
    }

    public static LumiereManager getInstance() {
        if (instance == null)
            instance = new LumiereManager();
        return instance;
    }

    public Piece getPositionHabitant() {
        return positionHabitant;
    }

    public void traiterMessage(MessagePassage message) {
        if (positionHabitant == message.getPiece1()) {
            // l'habitant s'est déplacé vers la pièce 2
            positionHabitant = message.getPiece2();
            this.eteindrePiece(message.getPiece1());
            this.allumerPiece(message.getPiece2());
        } else {
            // l'habitant s'est déplacé vers la pièce 1
            positionHabitant = message.getPiece1();
            this.allumerPiece(message.getPiece1());
            this.eteindrePiece(message.getPiece2());
        }
        this.threadSlave.setPositionHabitant(positionHabitant);
    }

    /**
     * Allumer en entrant
     */
    private void allumerPiece(Piece piece) {
        if (piece != null && Horloge.getInstance().getHeure() < 9 || Horloge.getInstance().getHeure() > 19) {
                piece.allumer();
            }

    }

    /**
     * Eteindre en sortant
     */
    private void eteindrePiece(Piece piece) {
        if (piece != null && piece.isLumiereAllumee())
            piece.eteindre();
    }
}

/**
 * Gestion de la lumière lorsquele jour se lève et la nuit tombe.
 */
class ThreadSlave extends Thread {

    private Piece positionHabitant;

    public void setPositionHabitant(Piece positionHabitant) {
        this.positionHabitant = positionHabitant;
    }

    @Override
    public void run() {
        while (true) {
            if (positionHabitant != null && positionHabitant.isLumiereAllumee() &&
                    Horloge.getInstance().getHeure() > 7 && Horloge.getInstance().getHeure() < 19)
                positionHabitant.eteindre();
            else if (positionHabitant != null && !positionHabitant.isLumiereAllumee() &&
                    (Horloge.getInstance().getHeure() < 8 || Horloge.getInstance().getHeure() > 18))
                positionHabitant.allumer();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}