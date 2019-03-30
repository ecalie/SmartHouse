package modelisation.modele.element;

import patrons.observer.Observable;

public abstract class Element extends Observable {

    private int x;
    private int y;
    private int longueur;
    private int largeur;

    public Element(int x, int y, int longueur, int largeur) {
        this.x = x;
        this.y = y;
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getLongueur() {
        return longueur;
    }

    public void setLongueur(int longueur) {
        this.longueur = longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public void setLargeur(int largeur) {
        this.largeur = largeur;
    }
}
