package simulation.modele;

import intelligence_artificielle.modele.Capteur;
import intelligence_artificielle.modele.CapteurPassage;
import simulation.modele.element.Element;

import java.util.ArrayList;
import java.util.List;

public class Maison {

    private List<Piece> pieces;
    private Piece entree;
    private List<Capteur> capteurs;

    public Maison() {
        this.pieces = new ArrayList<>();
        this.capteurs = new ArrayList<>();
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

    public void ajouterSalle(Piece piece) {
        this.pieces.add(piece);
    }

    public Piece chercher(Element element) {
        for (Piece p : pieces)
            for (Element e : p.getElements())
                if (e == element)
                    return p;
        return null;
    }

    public void ajouterCapteur(Capteur capteur) {
        this.capteurs.add(capteur);
    }

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
