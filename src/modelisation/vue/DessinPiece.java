package modelisation.vue;

import intelligence_artificielle.modele.Habitant;
import modelisation.modele.Piece;
import modelisation.modele.element.Actionnable.*;
import modelisation.modele.element.*;
import modelisation.modele.element.Utilisable.*;
import modelisation.vue.element.*;

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

    private void initialiser() {
        this.elements = new ArrayList<>();
        for (modelisation.modele.element.Element e : piece.getElements()) {
            if (e instanceof Baignoire)
                elements.add(new DessinBaignoire((Baignoire) e));

            if (e instanceof Canape)
                elements.add(new DessinCanape((Canape)e));

            if (e instanceof Chaise)
                elements.add(new DessinChaise((Chaise) e));

            if (e instanceof Table)
                elements.add(new DessinTable((Table)e));

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
                elements.add(new DessinPlaqueCuisson((PlaqueCuisson)e));

            if (e instanceof Porte)
                elements.add(new DessinPorte((Porte) e));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.elements == null)
            initialiser();
        for (DessinElement e : elements)
            e.dessiner(g);
        if (habitant.getPosition() == piece)
            new DessinHabitant().dessiner(g, piece.getHabitantX(), piece.getHabitantY());
    }

}