package simulation.modele;

import intelligence_artificielle.modele.Capteur;
import intelligence_artificielle.modele.CapteurPassage;
import simulation.modele.element.Element;
import patrons.observer.Observable;

import java.util.ArrayList;
import java.util.List;

public class Piece extends Observable {

    private List<Element> elements;
    private int x;
    private int y;
    private int longueur;
    private int largeur;
    private Capteur capteurTemperature;
    private String nom;
    private int habitantX;
    private int habitantY;

    public Piece(int x, int y, int longueur, int largeur, String nom, int habitantX, int habitantY) {
        this.x = x;
        this.y = y;
        this.longueur = longueur;
        this.largeur = largeur;
        this.nom = nom;
        this.habitantX = habitantX;
        this.habitantY = habitantY;
        this.elements = new ArrayList<>();
        // TODO
        // this.capteurTemperature = new CapteurAnalogique(0,40,20);
        this.ajouterObserver(new CapteurPassage(this));
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

    public Capteur getCapteurTemperature() {
        return capteurTemperature;
    }

    public String getNom() {
        return nom;
    }

    public void ajouter(Element element) {
        this.elements.add(element);
    }

    @Override
    public String toString() {
        return nom;
    }
}
