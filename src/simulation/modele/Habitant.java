package simulation.modele;

import patrons.observer.Observable;
import simulation.modele.element.deuxEtats.AppareilDeuxEtats;
import simulation.modele.element.utilisable.Utilisable;

import java.util.ArrayList;
import java.util.List;

public class Habitant extends Observable {

    private Piece position;
    private Maison maison;
    private Utilisable elementUtilise;

    public Habitant(Maison maison) {
        // initialement l'habitant n'est pas dans la maison
        this.position = null;
        this.maison = maison;
    }

    public Piece getPosition() {
        return position;
    }

    //////////////////
    // FAIRE ACTION //
    //////////////////

    /**
     * Utiliser du mobilier.
     *
     * @param element Le mobilier utilisé
     */
    public void utiliser(Utilisable element) {
        // se déplacer jusqu'à l'appareil
        this.aller(maison.chercher(element));

        // l'utiliser
        this.elementUtilise = element;
        element.utiliser();
    }

    /**
     * Temriner d'utiliser le mobilier utilisé.
     */
    public void terminerAction() {
        if (this.elementUtilise != null) {
            this.elementUtilise.liberer();
            elementUtilise = null;
        }
    }

    /**
     * Allumer un appareil.
     *
     * @param element L'appareil a allumer
     */
    public void allumer(AppareilDeuxEtats element) {
        // se déplacer jusqu'à l'appareil
        this.aller(maison.chercher(element));

        // allumer l'appareil
        element.allumer();
    }

    /**
     * Eteindre un appareil.
     *
     * @param element L'appareil à éteindre
     */
    public void eteindre(AppareilDeuxEtats element) {
        // se déplacer jusqu'à l'appareil
        this.aller(maison.chercher(element));

        // éeindre l'appareil
        element.eteindre();
    }

    /////////////////
    // SE DEPLACER //
    /////////////////

    /**
     * Entrer dans la maison.
     */
    public void entrerMaison() {
        // modifier la position de l'habitant
        this.position = maison.getEntree();

        // déclencher le capteur de passage de l'entrée
        maison.recupererCapteurPassage(null, maison.getEntree()).declencher();
        this.notifier(position);
    }

    /**
     * Sortir de la maison.
     */
    public void sortirMaison() {
        // Faire déplacer l'habitant jusqu'à la porte d'entrée
        this.aller(maison.getEntree());

        // modifier la position de l'habitant
        this.position = null;

        // déclencher le capteur de passage de l'entrée
        maison.recupererCapteurPassage(maison.getEntree(), null).declencher();
        this.notifier(position);
    }

    /**
     * L'habitant se déplace dans une pièce adjacente.
     *
     * @param piece La pièce adjacente où se rend l'habitant
     */
    private void seDeplacer(Piece piece) {
        // déclencher le bon capteur
        maison.recupererCapteurPassage(position, piece).declencher();

        // modifier la position de l'habitant
        // et notifier avant et après le déplacement (pour l'affichage)
        this.notifier(position);
        position = piece;
        this.notifier(position);
        try {
            Thread.sleep(Constante.tempsDeplacement);
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
            this.entrerMaison();
        }

        // trouver le chemin jusqu'à la pièce
        List<Piece> chemin = this.trouverChemin(piece, position, new ArrayList<>());
        for (Piece p : chemin)
            this.seDeplacer(p);
    }

    /**
     * Trouver le chemin vers un pièce de la maison.
     *
     * @param but      La pièce destination
     * @param position La position actuelle
     * @param chemin   Le chemin jusqu'à la position actuelle
     * @return Le chemin complet
     */
    private List<Piece> trouverChemin(Piece but, Piece position, List<Piece> chemin) {
        // si l'habitant est arrivé
        if (position == but) {
            return chemin;
        }

        // sinon trouvé un chemin
        for (Point pt : position.getConnexionsEntrePieces().keySet()) {
            // pour chaque pièce voisine de la position actuelle
            Piece p = position.getConnexionsEntrePieces().get(pt);

            // si cette pièce voisine n'est pas deéjà dans le chemin
            if (!chemin.contains(p) && p != null) {
                // l'ajouter au chemin
                chemin.add(p);

                // regarder si cette pièce permet d'aller jusqu'à la destination
                List<Piece> ch = trouverChemin(but, p, chemin);

                // si oui, retouner le chemin
                if (ch != null)
                    return ch;

                // sinon ertier cette pièce du chemin et reprendre avec une autre pièce voisine
                chemin.remove(p);
            }
        }
        return null;
    }
}
