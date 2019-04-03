package simulation.vue.element;

import simulation.modele.element.Orientation;
import simulation.modele.element.utilisable.Baignoire;

import java.awt.*;

public class DessinBaignoire implements DessinElement {

    private Baignoire baignoire;

    public DessinBaignoire(Baignoire baignoire) {
        this.baignoire = baignoire;
    }

    public void dessiner(Graphics g) {
        int L = baignoire.getLongueur();
        int l = baignoire.getLargeur();
        int x = baignoire.getX();
        int y = baignoire.getY();

        if (baignoire.getOrientation() == Orientation.Est || baignoire.getOrientation() == Orientation.Ouest) { // horizontal
            g.drawRect(x,y,L,l);
            g.drawOval(x+1,y+1,L-2,l-2);
        }

        if (baignoire.getOrientation() == Orientation.Sud || baignoire.getOrientation() == Orientation.Nord) { // vertical
            g.drawRect(x, y, L, l);
            g.drawOval(x+1, y+1, L-2, l-2);
        }
    }
}
