package simulation.modele;

import simulation.modele.element.Element;
import simulation.modele.element.Mur;
import simulation.modele.element.Porte;

import java.util.ArrayList;
import java.util.List;

public class Maison {

    private List<Piece> pieces;
    private Piece entree;

    public Maison() {
        this.pieces = new ArrayList<>();
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

    public boolean sontAdjacentes(Piece piece1, Piece piece2) {
        boolean mur = false;
        // est-ce que piece2 est à l'Est de piece1
        if (piece1.getLongueur() + piece1.getX() == piece2.getX() &&
                ((piece1.getY() <= piece2.getY() && piece2.getY() <= piece1.getY() + piece1.getLargeur()) ||
                        (piece1.getY() <= piece2.getY() + piece2.getLargeur()
                                && piece2.getY() + piece2.getLargeur() <= piece1.getY() + piece1.getLargeur()))) {
            for (Element e : piece1.getElements()) {
                if (e instanceof Porte) {
                    Porte p = (Porte) e;
                    if (p.getX() == piece1.getLongueur() && p.getY() + piece1.getY() >= piece2.getY() && p.getY() + piece1.getY() <= piece2.getLargeur())
                        return true;
                }
                if (e instanceof Mur) {
                    Mur m = (Mur) e;
                    if (m.getX() == piece1.getLongueur() - 1 && m.getLargeur() > 0) {
                        mur = true;
                    }
                }
            }

            for (Element e : piece2.getElements()) {
                if (e instanceof Porte) {
                    Porte p = (Porte) e;
                    if (p.getX() == 0 && p.getY() + piece2.getY() >= piece1.getY() && p.getY() + piece2.getY() <= piece1.getLargeur())
                        return true;
                }
                if (e instanceof Mur) {
                    Mur m = (Mur) e;
                    if (m.getX() == 0 && m.getLargeur() > 0) {
                        mur = true;
                    }
                }
            }
            return !mur;
        }

        // est-ce que piece2 est au Sud de piece1
        if (piece1.getLargeur() + piece1.getY() == piece2.getY() &&
                ((piece1.getX() <= piece2.getX() && piece2.getX() <= piece1.getX() + piece1.getLongueur()) ||
                        (piece1.getX() <= piece2.getX() + piece2.getLongueur()
                                && piece2.getX() + piece2.getLongueur() <= piece1.getX() + piece1.getLongueur()))) {
            for (Element e : piece1.getElements()) {
                if (e instanceof Porte) {
                    Porte p = (Porte) e;
                    if (p.getY() == piece1.getLargeur() && p.getX() + piece1.getX() <= piece2.getX() + piece2.getLongueur() && p.getX() + piece1.getX() >= piece2.getX())
                        return true;
                }

                if (e instanceof Mur) {
                    Mur m = (Mur) e;
                    if (m.getY() == piece1.getLargeur() - 1 && m.getLongueur() > 0) {
                        mur = true;
                    }
                }
            }

            for (Element e : piece2.getElements()) {
                if (e instanceof Porte) {
                    Porte p = (Porte) e;
                    if (p.getY() == 0 && p.getX() + piece2.getX() <= piece1.getX() + piece1.getLongueur() && p.getX() + piece2.getX() >= piece1.getX())
                        return true;
                }

                if (e instanceof Mur) {
                    Mur m = (Mur) e;
                    if (m.getY() == 0 && m.getLongueur() > 0) {
                        mur = true;
                    }
                }
            }
            return !mur;

        }

        // est-ce que piece2 est à l'Ouest de piece1
        if (piece1.getX() == piece2.getX() + piece2.getLongueur() &&
                ((piece1.getY() <= piece2.getY() && piece2.getY() <= piece1.getY() + piece1.getLargeur()) ||
                        (piece1.getY() <= piece2.getY() + piece2.getLargeur()
                                && piece2.getY() + piece2.getLargeur() <= piece1.getY() + piece1.getLargeur()))) {
            for (Element e : piece1.getElements()) {
                if (e instanceof Porte) {
                    Porte p = (Porte) e;
                    if (p.getX() == 0 && p.getY() + piece1.getY() >= piece2.getY() && p.getY() + piece1.getY() <= piece2.getLargeur())
                        return true;
                }
                if (e instanceof Mur) {
                    Mur m = (Mur) e;
                    if (m.getX() == 0 && m.getLargeur() > 0) {
                        mur = true;
                    }
                }
            }

            for (Element e : piece2.getElements()) {
                if (e instanceof Porte) {
                    Porte p = (Porte) e;
                    if (p.getX() == piece2.getLongueur() && p.getY() + piece2.getY() >= piece1.getY() && p.getY() + piece2.getY() <= piece1.getLargeur())
                        return true;
                }
                if (e instanceof Mur) {
                    Mur m = (Mur) e;
                    if (m.getX() == piece2.getLongueur() - 1 && m.getLargeur() > 0) {
                        mur = true;
                    }
                }
            }
            return !mur;

        }

        // est-ce que piece2 est au Nord de piece1
        if (piece1.getY() == piece2.getY() + piece2.getLargeur() &&
                ((piece1.getX() <= piece2.getX() && piece2.getX() <= piece1.getX() + piece1.getLongueur()) ||
                        (piece1.getX() <= piece2.getX() + piece2.getLongueur()
                                && piece2.getX() + piece2.getLongueur() <= piece1.getX() + piece1.getLongueur()))) {
            for (Element e : piece1.getElements()) {
                if (e instanceof Porte) {
                    Porte p = (Porte) e;
                    if (p.getY() == 0 && p.getX() + piece1.getX() <= piece2.getX() + piece2.getLongueur() && p.getX() + piece1.getX() >= piece2.getX())
                        return true;
                }
                if (e instanceof Mur) {
                    Mur m = (Mur) e;
                    if (m.getY() == 0 && m.getLongueur() > 0) {
                        mur = true;
                    }
                }
            }

            for (Element e : piece2.getElements()) {
                if (e instanceof Porte) {
                    Porte p = (Porte) e;
                    if (p.getY() == piece2.getLargeur() && p.getX() + piece2.getX() <= piece1.getX() + piece1.getLongueur() && p.getX() + piece2.getX() >= piece1.getX())
                        return true;
                }
                if (e instanceof Mur) {
                    Mur m = (Mur) e;
                    if (m.getY() == piece2.getLargeur() - 1 && m.getLongueur() > 0) {
                        mur = true;
                    }
                }

            }
            return !mur;

        }

        return false;
    }

    public Piece chercher(Element element) {
        for (Piece p : pieces)
            for (Element e : p.getElements())
                if (e == element)
                    return p;
        return null;
    }
}
