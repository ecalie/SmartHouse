package intelligence_artificielle.modele.manager;

import simulation.modele.Horloge;
import simulation.modele.Piece;

public class LumiereManager {

    /**
     * Gérer les lumière après le déplacement de l'habitant.
     *
     * @param depart  La pièce d'où il sort
     * @param arrivee La pièce où il va
     */
    public void traiterPassage(Piece depart, Piece arrivee) {
        this.eteindrePiece(depart);
        this.allumerPiece(arrivee);
    }

    /**
     * Gérer les lumière selon l'heure.
     *
     * @param heure L'heure actuelle
     * @param piece La pièce où se trouve l'habitant
     */
    public void gererLumiere(Integer heure, Piece piece) {
        // éteindre la lumière si le jour se lève (à 8h)
        // allumer la lumière si la nuit tombe (à 19h)
        if (piece.isLumiereAllumee() && heure == 8)
            piece.eteindre();
        else if (!piece.isLumiereAllumee() && heure == 19)
            piece.allumer();
    }

    /**
     * Gérer les lumière selon que l'habitant se lève ou se couhe.
     *
     * @param habitantDort Vrai si l'habitant vient de se couche
     *                     Faux s'il vient de se lever
     * @param chambre      La pièce où dort l'habitant
     */
    public void traiterLit(boolean habitantDort, Piece chambre) {
        if (habitantDort)
            this.eteindrePiece(chambre);
        else
            this.allumerPiece(chambre);
    }

    /**
     * Allumer la pièce.
     *
     * @param piece La pièce a allumer
     */
    private void allumerPiece(Piece piece) {
        // allumer la lumière s'il fait nuit
        if (piece != null && Horloge.getInstance().getHeure() < 9 || Horloge.getInstance().getHeure() > 19)
            piece.allumer();
    }

    /**
     * Eteindre la lumière d'une pièce.
     *
     * @param piece La pièce à éteindre
     */
    private void eteindrePiece(Piece piece) {
        // éteindre la lumière si elle était allumée
        if (piece != null && piece.isLumiereAllumee())
            piece.eteindre();
    }


}
