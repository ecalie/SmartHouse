package intelligence_artificielle.modele;

import simulation.modele.Piece;

/**
 * Capteur entre deux pièces.
 * Il ne permet pas de détecter le sens de passage.
 */
public class CapteurPassage implements Capteur {

    private Piece piece1;
    private Piece piece2;

    public CapteurPassage(Piece piece1, Piece piece2) {
        this.piece1 = piece1;
        this.piece2 = piece2;
    }

    public Piece getPiece1() {
        return piece1;
    }

    public Piece getPiece2() {
        return piece2;
    }

    @Override
    public void declencher() {
        new MessagePassage(piece1, piece2).envoyer();
    }

}
