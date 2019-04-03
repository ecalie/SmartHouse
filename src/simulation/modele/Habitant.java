package simulation.modele;

import patrons.observer.Observable;
import simulation.modele.Maison;
import simulation.modele.Piece;
import simulation.modele.element.deuxEtats.DeuxEtats;
import simulation.modele.element.utilisable.Utilisable;

import java.util.ArrayList;
import java.util.List;

public class Habitant extends Observable {

    private Piece position;
    private Maison maison;
    private Utilisable elementUtilise;

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

    public void utiliser(Utilisable element) {
        try {
            this.aller(maison.chercher(element));
            this.elementUtilise = element;
            element.utiliser();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void terminerAction() {
        if (this.elementUtilise != null) {
            this.elementUtilise.liberer();
            elementUtilise = null;
        }
    }

    public void allumer(DeuxEtats element) {
        this.aller(maison.chercher(element));
        element.allumer();
    }

    public void eteindre(DeuxEtats element) {
        this.aller(maison.chercher(element));
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
     *
     * @param piece La pièce adjacente où se rend l'habitant
     */
    public void entrer(Piece piece) {
        position = piece;
        piece.notifier();
        this.notifier();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * L'habitant se déplace dans une pièce de la maison.
     *
     * @param piece La pièce où se rend l'habitant
     */
    public void aller(Piece piece) {
        // rentrer dans la maison si l'habitant est dehors
        if (position == null) {
            this.entrer();
        }

        List<Piece> pieces = new ArrayList();
        pieces.addAll(maison.getPieces());

        pieces.remove(position);
        List<Piece> chemin = this.trouverChemin(piece, position, pieces, new ArrayList<>());
        for (Piece p : chemin)
            this.entrer(p);
    }

    private List<Piece> trouverChemin(Piece but, Piece position, List<Piece> pieces, List<Piece> chemin) {
        if (position == but) {
            return chemin;
        }

        for (int i = 0; i < pieces.size(); i++) {
            Piece p = pieces.get(i);
            if (p != position && maison.sontAdjacentes(position, p)) {
                chemin.add(p);
                List<Piece> copie = new ArrayList<>();
                copie.addAll(pieces);

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
