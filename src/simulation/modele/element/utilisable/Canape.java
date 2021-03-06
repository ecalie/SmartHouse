package simulation.modele.element.utilisable;

import simulation.modele.element.Orientation;

public class Canape extends Utilisable {

    private Orientation orientation;

    public Canape(int x, int y, int longueur, int largeur, Orientation orientation) {
        super(x, y, longueur, largeur);
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
