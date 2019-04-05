package intelligence_artificielle.modele.capteur;

import simulation.modele.Piece;

/**
 * Capteur entre deux pièces.
 * Il ne permet pas de détecter le sens de passage.
 */
public class CapteurPassage extends Capteur {

    private Piece piece1;
    private Piece piece2;

    public CapteurPassage(Piece piece1, Piece piece2) {
        super();
        this.piece1 = piece1;
        this.piece2 = piece2;
    }

    public Piece getPiece1() {
        return piece1;
    }

    public Piece getPiece2() {
        return piece2;
    }
}
