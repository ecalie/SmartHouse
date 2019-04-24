package simulation.modele;

import simulation.modele.element.Element;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Piece {

    private List<Element> elements;
    private int x;
    private int y;
    private int longueur;
    private int largeur;
    private boolean lumiereAllumee;
    private String nom;
    private int habitantX;
    private int habitantY;
    private HashMap<Point, Piece> connexionsEntrePieces;

    public Piece(int x, int y, int longueur, int largeur, String nom, int habitantX, int habitantY) {
        this.x = x;
        this.y = y;
        this.longueur = longueur;
        this.largeur = largeur;
        this.nom = nom;
        this.habitantX = habitantX;
        this.habitantY = habitantY;
        this.elements = new ArrayList<>();
        this.lumiereAllumee = false;
    }

    public List<Element> getElements() {
        return elements;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLongueur() {
        return longueur;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHabitantX() {
        return habitantX;
    }

    public int getHabitantY() {
        return habitantY;
    }

    public boolean isLumiereAllumee() {
        return lumiereAllumee;
    }

    public HashMap<Point, Piece> getConnexionsEntrePieces() {
        return connexionsEntrePieces;
    }

    public void ajouter(Element element) {
        this.elements.add(element);
    }

    public void setConnexions(HashMap<Point, Piece> connexions) {
        this.connexionsEntrePieces = connexions;
    }

    /**
     * Allumer la lumière de la pièce.
     */
    public void allumer() {
        this.lumiereAllumee = true;
    }

    /**
     * Eteindre la lumière de la pièce.
     */
    public void eteindre() {
        this.lumiereAllumee = false;
    }

    @Override
    public String toString() {
        return nom;
    }
}
