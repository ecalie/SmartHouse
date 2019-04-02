package modelisation.modele.element.deuxEtats;

import modelisation.modele.element.Orientation;

public class Television extends DeuxEtats {

    private Orientation orientation;

    public Television(int x, int y, int longueur, int largeur, Orientation orientation) {
        super(x,y,longueur, largeur);
        this.orientation = orientation;
    }

    public Orientation getOrientation() {
        return orientation;
    }
}
