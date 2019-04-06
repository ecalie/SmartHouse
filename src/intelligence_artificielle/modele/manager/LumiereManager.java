package intelligence_artificielle.modele.manager;

import simulation.modele.Horloge;
import simulation.modele.Piece;

public class LumiereManager {

    public void traiterPassage(Piece depart, Piece arrivee) {
        this.eteindrePiece(depart);
        this.allumerPiece(arrivee);

    }

    public void gererLumiere(Integer heure, Piece piece) {
        if (piece.isLumiereAllumee() && heure == 8)
            piece.eteindre();
        else if (!piece.isLumiereAllumee() && heure == 19)
            piece.allumer();
    }

    public void traiterLit(boolean habitantDort, Piece chambre) {
        if (habitantDort)
            chambre.eteindre();
        else
            chambre.allumer();
    }

    /**
     * Allumer en entrant
     */
    private void allumerPiece(Piece piece) {
        if (piece != null && Horloge.getInstance().getHeure() < 9 || Horloge.getInstance().getHeure() > 19)
            piece.allumer();
    }

    /**
     * Eteindre en sortant
     */
    private void eteindrePiece(Piece piece) {
        if (piece != null && piece.isLumiereAllumee())
            piece.eteindre();
    }


}
