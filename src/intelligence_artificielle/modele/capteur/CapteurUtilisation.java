package intelligence_artificielle.modele.capteur;

import simulation.modele.Piece;
import simulation.modele.element.Element;
import simulation.modele.element.deuxEtats.Etat;

public class CapteurUtilisation extends Capteur {

    private Element appareil;
    private Piece piece;
    private Etat etat;

    public CapteurUtilisation(Element appareil, Piece piece) {
        super();
        this.appareil = appareil;
        this.piece = piece;
        this.etat = Etat.Eteint;
    }

    public Element getAppareil() {
        return appareil;
    }

    public Etat getEtat() {
        return etat;
    }

    public Piece getPiece() {
        return piece;
    }

    @Override
    public void declencher() {
        if (etat == Etat.Allume)
            etat = Etat.Eteint;
        else
            etat = Etat.Allume;

        super.declencher();
    }
}
