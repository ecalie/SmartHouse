package intelligence_artificielle.modele;

import modelisation.modele.Maison;
import modelisation.modele.Piece;
import modelisation.modele.element.Actionnable.Actionnable;
import modelisation.modele.element.Utilisable.Utilisable;
import patrons.observer.Observable;

import java.util.ArrayList;
import java.util.List;

public class Habitant extends Observable {

    private Piece position;
    private Maison maison;

    public Habitant(Maison maison) {
        this.position = maison.getEntree();
        this.maison = maison;
    }

    public Piece getPosition() {
        return position;
    }

    //////////////////
    // FAIRE ACTION //
    //////////////////

    public void utiliser(Utilisable element, int duree) {
        this.aller(maison.chercher(element));
        element.utiliser();
        try {
            Thread.sleep(duree);
        } catch (Exception e) {
            e.printStackTrace();
        }
        element.liberer();
    }

    public void allumer(Actionnable element) {
        this.aller(maison.chercher(element));
        element.allumer();
    }

    public void eteindre(Actionnable element) {
        assert (position == maison.chercher(element));
        element.eteindre();
    }

    /////////////////
    // SE DEPLACER //
    /////////////////

    public void entrer() {
        this.position = maison.getEntree();
    }

    public void sortir() {
        assert (this.position == maison.getEntree());
        this.position = null;
    }

    /**
     * L'habitant se déplace dans une pièce adjacente.
     * @param piece La pièce adjacente où se rend l'habitant
     */
    public void entrer(Piece piece) {
        position = piece;
        piece.notifier();
        this.notifier();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * L'habitant se déplace dans une pièce de la maison.
     * @param piece La pièce où se rend l'habitant
     */
    public void aller(Piece piece) {
        // rentrer dans la maison si l'habitant est dehors
        if (position == null) {
            this.entrer();
        }

        List<Piece> pieces = new ArrayList();
        for (Piece p : maison.getPieces())
            pieces.add(p);
        pieces.remove(position);
        List<Piece> chemin = this.trouverChemin(piece, position, pieces, new ArrayList<>());
        for (Piece p : chemin)
            this.entrer(p);
    }

    private List<Piece> trouverChemin(Piece but, Piece position, List<Piece> pieces, List<Piece> chemin) {
        if (position == but) {
            return chemin;
        }

        for (int i = 0 ; i < pieces.size() ; i++) {
            Piece p = pieces.get(i);
            if (p != position && maison.sontAdjacentes(position, p)) {
                chemin.add(p);
                List<Piece> copie = new ArrayList<>();
                for (Piece piece : pieces)
                    copie.add(piece);
                copie.remove(p);
                List<Piece> ch = trouverChemin(but, p, copie, chemin);
                if (ch != null)
                    return ch;
                chemin.remove(p);
            }
        }

        return null;
    }

}