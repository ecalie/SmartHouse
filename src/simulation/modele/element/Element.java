package simulation.modele.element;

import intelligence_artificielle.modele.capteur.Capteur;

public abstract class Element {

    protected int x;
    protected int y;
    protected int longueur;
    protected int largeur;
    protected Capteur capteur;

    public Element(int x, int y, int longueur, int largeur) {
        this.x = x;
        this.y = y;
        this.longueur = longueur;
        this.largeur = largeur;
    }

    public void setCapteur(Capteur capteur) {
        this.capteur = capteur;
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
