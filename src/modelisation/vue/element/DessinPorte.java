package modelisation.vue.element;

import modelisation.modele.element.Orientation;
import modelisation.modele.element.Porte;

import java.awt.*;

public class DessinPorte implements DessinElement {

    private Porte porte;

    public DessinPorte(Porte porte) {
        this.porte = porte;
    }

    public void dessiner(Graphics g) {
        int x = porte.getX();
        int y = porte.getY();
        int l = porte.getLargeur();

        if (porte.getSensOuverture() == Orientation.Nord) {
            g.drawArc(x - l, y - l, 2*l, l*2, 0, 90);
            g.drawLine(x, y, x, y - l);
            g.drawLine(x, y, x + l, y);
        }

        if (porte.getSensOuverture() == Orientation.Est) {
            g.drawArc(x - l, y - l, l*2, l*2, 0, -90);
            g.drawLine(x, y, x, y + l);
            g.drawLine(x, y, x + l, y);
        }

        if (porte.getSensOuverture() == Orientation.Sud) {
            g.drawArc(x - l, y - l, l*2, l*2, 180, 90);
            g.drawLine(x, y, x - l, y);
            g.drawLine(x, y, x, y + l);
        }

        if(porte.getSensOuverture() == Orientation.Ouest) {
            g.drawArc(x - l, y - l, l*2, l*2, 180, -90);
            g.drawLine(x, y, x - l, y);
            g.drawLine(x, y, x, y - l);
        }
    }
}
