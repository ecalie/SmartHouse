package modelisation.modele.element.utilisable;

import modelisation.modele.element.Orientation;

public class Baignoire extends Utilisable  {

    private Orientation orientation;

    public Baignoire(int x, int y, int longueur, int largeur, Orientation orientation) {
        super(x,y,longueur, largeur);
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
