package simulation.vue.element;

import simulation.modele.element.Orientation;
import simulation.modele.element.utilisable.Toilette;

import java.awt.*;

public class DessinToilette implements DessinElement {

    private Toilette toilette;

    public DessinToilette(Toilette toilette) {
        this.toilette = toilette;
    }

    public void dessiner(Graphics g) {
        int x = toilette.getX();
        int y = toilette.getY();
        int l = toilette.getLargeur();
        int L = toilette.getLongueur();

        if (toilette.getOrientation() == Orientation.Nord) {
            g.drawRect(x, y + l * 35 / 60, L, l / 2);
            g.drawArc(x + 5, y, L - 10, l / 2, -10, 200);
        }

        if (toilette.getOrientation() == Orientation.Est) {
            g.drawRect(x, y, L / 2, l);
            g.drawArc(x, y + 5, L, l - 10, -100, 200);
        }

        if (toilette.getOrientation() == Orientation.Sud) {
            g.drawRect(x, y, L, l / 2);
            g.drawArc(x + 5, y + l, L - 10, l, 160, 200);
        }

        if (toilette.getOrientation() == Orientation.Ouest) {
            g.drawRect(x + L * 35 / 60, y, L / 2, l);
            g.drawArc(x, y + 5, L, l - 10, 80, 200);
        }
    }
}
