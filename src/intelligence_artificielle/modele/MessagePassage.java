package intelligence_artificielle.modele;

import simulation.modele.Piece;

/**
 * Un capteur de passage a détecté un mouvement, il envoie un message au LumiereManager.
 */
public class MessagePassage {

    private Piece piece1;
    private Piece piece2;

    public MessagePassage(Piece piece1, Piece piece2) {
        this.piece1 = piece1;
        this.piece2 = piece2;
    }

    public Piece getPiece1() {
        return piece1;
    }

    public Piece getPiece2() {
        return piece2;
    }

    public void envoyer() {
        LumiereManager.getInstance().traiterMessage(this);
    }
}
