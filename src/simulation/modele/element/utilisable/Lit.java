package simulation.modele.element.utilisable;

import simulation.modele.element.Orientation;

public class Lit extends Utilisable {

    private Orientation orientation;

    public Lit(int x, int y, int longueur, int largeur, Orientation orientation) {
        super(x, y, longueur, largeur);
        this.orientation = orientation;

    }

    public Orientation getOrientation() {
        return orientation;
    }
}
