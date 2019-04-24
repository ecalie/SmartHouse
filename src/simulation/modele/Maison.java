package simulation.modele;

import intelligence_artificielle.modele.capteur.Capteur;
import intelligence_artificielle.modele.capteur.CapteurPassage;
import simulation.modele.element.Element;

import java.util.ArrayList;
import java.util.List;

public class Maison {

    private List<Piece> pieces;
    private Piece entree;
    private List<Capteur> capteurs;
    private Thermostat thermostat;

    public Maison() {
        this.pieces = new ArrayList<>();
        this.capteurs = new ArrayList<>();
        this.thermostat = new Thermostat();
    }

    public Piece getEntree() {
        return entree;
    }

    public void setEntree(Piece entree) {
        this.entree = entree;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public Thermostat getThermostat() {
        return thermostat;
    }

    public void ajouterSalle(Piece piece) {
        this.pieces.add(piece);
    }

    public void ajouterCapteur(Capteur capteur) {
        this.capteurs.add(capteur);
    }

    /**
     * Chercher la pièce dans laquelle se trouve un élément.
     *
     * @param element L'élément cherché
     * @return La pièce dans laquelle se trouve `élément`
     */
    public Piece chercher(Element element) {
        for (Piece p : pieces)
            for (Element e : p.getElements())
                if (e == element)
                    return p;
        return null;
    }

    /**
     * Récupérer un capteur entre deux pièce.
     *
     * @param piece1 La pièce d'un côté du capteur
     * @param piece2 La pièce de l'autre côté du capteur
     * @return Le capteur entre `piece1` et `piece2`
     */
    public CapteurPassage recupererCapteurPassage(Piece piece1, Piece piece2) {
        for (Capteur c : capteurs)
            if (c instanceof CapteurPassage) {
                CapteurPassage cp = (CapteurPassage) c;
                if (cp.getPiece1() == piece1 && cp.getPiece2() == piece2 ||
                        cp.getPiece1() == piece2 && cp.getPiece2() == piece1)
                    return cp;
            }
        return null;
    }
}
