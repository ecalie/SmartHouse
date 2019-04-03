package simulation.vue.element;

import simulation.modele.element.Orientation;
import simulation.modele.element.utilisable.Canape;

import java.awt.*;

public class DessinCanape implements DessinElement {

    private Canape canape;

    public DessinCanape(Canape canape) {
        this.canape = canape;
    }

    public void dessiner(Graphics g) {
        int L = canape.getLongueur();
        int l = canape.getLargeur();
        int x = canape.getX();
        int y = canape.getY();

        if (canape.getOrientation() == Orientation.Nord) {
            g.drawRect(x + 7, y, (L - 14) / 3, l - 7);
            g.drawRect(x + (L - 14) / 3 + 7, y, (L - 14) / 3, l - 7);
            g.drawRect(x + (L - 14) / 3 * 2 + 7, y, (L - 14) / 3, l - 7);
            g.drawLine(x, y + 7, x, y + l - 7);
            g.drawLine(x, y + l, x + L, y + l);
            g.drawLine(x + L, y + l, x + L, y + 7);
            g.drawLine(x, y + 7, x + 7, y + 7);
            g.drawLine(x + L - 7, y + 7, x + L, y + 7);
        }

        if (canape.getOrientation() == Orientation.Est) {
            g.drawRect(x, y + 7, L, (l - 14) / 3);
            g.drawRect(x, y + (l - 14) / 3 + 7, L, (l - 14) / 3);
            g.drawRect(x, y + (l - 14) / 3 * 2 + 7, L, (l - 14) / 3);

            g.drawLine(x, y, x + 14, y);
            g.drawLine(x, y, x, y + l);
            g.drawLine(x, y + l, x + 14, y + l);
            g.drawLine(x + 14, y, x + 14, y + 7);
            g.drawLine(x + 14, y + l - 7, x + 14, y + l);
        }

        if (canape.getOrientation() == Orientation.Sud) {
            g.drawRect(x + 7, y, (L - 14) / 3, l - 7);
            g.drawRect(x + (L - 14) / 3 + 7, y, (L - 14) / 3, l - 7);
            g.drawRect(x + (L - 14) / 3 * 2 + 7, y, (L - 14) / 3, l - 7);

            g.drawLine(x, y, x + L, y);
            g.drawLine(x, y, x, y + 14);
            g.drawLine(x + L, y, x + L, y + 14);
            g.drawLine(x, y + 14, x + 7, y + 14);
            g.drawLine(x + L - 7, y + 14, x + L, y + 14);
        }

        if (canape.getOrientation() == Orientation.Ouest) {
            g.drawRect(x, y + 7, L - 7, (l - 14) / 3);
            g.drawRect(x, y + (l - 14) / 3 + 7, L - 7, (l - 14) / 3);
            g.drawRect(x, y + (l - 14) / 3 * 2 + 7, L - 7, (l - 14) / 3);

            g.drawLine(x + 7, y, x + L, y);
            g.drawLine(x + L, y, x + L, y + l);
            g.drawLine(x + 7, y + l, x + L, y + l);
            g.drawLine(x + 7, y, x + 7, y + 7);
            g.drawLine(x + 7, y + l - 7, x + 7, y + l);
        }
    }
}
