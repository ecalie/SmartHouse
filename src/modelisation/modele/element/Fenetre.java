package modelisation.modele.element;

public class Fenetre extends Element {

    private Mur mur;

    public Fenetre(int x, int y, Mur mur) {
        super(x,y,0,0);
        this.mur = mur;
    }
}
