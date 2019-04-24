package simulation.vue;

import simulation.modele.Habitant;
import simulation.modele.Horloge;
import simulation.modele.Piece;
import simulation.modele.element.Meuble;
import simulation.modele.element.Mur;
import simulation.modele.element.Porte;
import simulation.modele.element.Table;
import simulation.modele.element.deuxEtats.PlaqueCuisson;
import simulation.modele.element.deuxEtats.Television;
import simulation.modele.element.utilisable.*;
import simulation.vue.element.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DessinPiece extends JPanel {

    private Piece piece;
    private List<DessinElement> elements;
    private Habitant habitant;

    public DessinPiece(Piece piece, Habitant habitant) {
        super();
        this.piece = piece;
        this.habitant = habitant;
        setPreferredSize(new Dimension(piece.getLongueur(), piece.getLargeur()));
    }

    public Piece getPiece() {
        return piece;
    }

    /**
     * Desiiner la pièce.
     */
    private void initialiser() {
        this.elements = new ArrayList<>();

        // dessiner tous les éléments de la pièce
        for (simulation.modele.element.Element e : piece.getElements()) {
            if (e instanceof Baignoire)
                elements.add(new DessinBaignoire((Baignoire) e));

            if (e instanceof Canape)
                elements.add(new DessinCanape((Canape) e));

            if (e instanceof Chaise)
                elements.add(new DessinChaise((Chaise) e));

            if (e instanceof Table)
                elements.add(new DessinTable((Table) e));

            if (e instanceof Television)
                elements.add(new DessinTelevision((Television) e));

            if (e instanceof Toilette)
                elements.add(new DessinToilette((Toilette) e));

            if (e instanceof Lit)
                elements.add(new DessinLit((Lit) e));

            if (e instanceof Meuble)
                elements.add(new DessinMeuble((Meuble) e));

            if (e instanceof Mur)
                elements.add(new DessinMur((Mur) e));

            if (e instanceof PlaqueCuisson)
                elements.add(new DessinPlaqueCuisson((PlaqueCuisson) e));

            if (e instanceof Porte)
                elements.add(new DessinPorte((Porte) e));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.elements == null)
            initialiser();

        // modifier la couleur de fond selon l'heure
        if (piece.isLumiereAllumee()) {
            this.setBackground(new Color(200, 200, 200));
        } else {
            int heure = Horloge.getInstance().getHeure();
            if (heure < 7 || heure > 21)
                this.setBackground(new Color(100, 100, 100));
            else
                this.setBackground(new Color(180 - Math.abs(14 - heure) * 10, 180 - Math.abs(14 - heure) * 10, 180 - Math.abs(14 - heure) * 10));
        }

        // redessiner les éléments
        for (DessinElement e : elements)
            e.dessiner(g);

        // dessiner l'habitant s'il est dans la pièce
        if (habitant.getPosition() == piece)
            new DessinHabitant().dessiner(g, piece.getHabitantX(), piece.getHabitantY());
    }
}
