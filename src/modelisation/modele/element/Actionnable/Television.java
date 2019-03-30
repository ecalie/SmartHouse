package modelisation.modele.element.Actionnable;

import modelisation.modele.element.Orientation;

public class Television extends Actionnable  {

    private Orientation orientation;

    public Television(int x, int y, int longueur, int largeur, Orientation orientation) {
        super(x,y,longueur, largeur);
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
