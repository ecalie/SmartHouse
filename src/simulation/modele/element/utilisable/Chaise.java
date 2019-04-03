package simulation.modele.element.utilisable;

import simulation.modele.element.Orientation;

public class Chaise extends Utilisable {

    private Orientation orientation;

    public Chaise(int x, int y, int longueur, int largeur, Orientation orientation) {
        super(x, y, longueur, largeur);
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
