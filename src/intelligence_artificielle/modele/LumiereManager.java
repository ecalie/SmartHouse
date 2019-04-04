package intelligence_artificielle.modele;

import simulation.modele.Horloge;
import simulation.modele.Piece;

public class LumiereManager {

    private static LumiereManager instance;
    private Piece positionHabitant;

    private LumiereManager() {
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
        if (positionHabitant == message.getPiece1()) { // l'habitant s'est déplacé vers la pièce 2
            this.eteindrePiece(message.getPiece1());
            this.allumerPiece(message.getPiece2());
            positionHabitant = message.getPiece2();
        } else { // l'habitant s'est déplacé vers la pièce 1
            this.allumerPiece(message.getPiece1());
            this.eteindrePiece(message.getPiece2());
            positionHabitant = message.getPiece1();
        }
    }

    private void allumerPiece(Piece piece) {
        if (piece != null && (Horloge.getInstance().getHeure() < 8 || Horloge.getInstance().getHeure() > 19))
            piece.allumer();
    }

    private void eteindrePiece(Piece piece) {
        if (piece != null && piece.isLumiereAllumee())
            piece.eteindre();
    }
}
