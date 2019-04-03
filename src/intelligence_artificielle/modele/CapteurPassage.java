package intelligence_artificielle.modele;

import simulation.modele.Piece;

public class CapteurPassage implements Capteur {

    private Piece piece;

    public CapteurPassage(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public void update() {

    }

}
