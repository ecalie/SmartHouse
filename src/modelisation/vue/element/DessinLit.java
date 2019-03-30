package modelisation.vue.element;

import modelisation.modele.element.Orientation;
import modelisation.modele.element.Utilisable.Lit;

import java.awt.*;

public class DessinLit implements DessinElement {

    private Lit lit;

    public DessinLit(Lit lit) {
        this.lit = lit;
    }

    @Override
    public void dessiner(Graphics g) {
        int x = lit.getX();
        int y = lit.getY();
        int l = lit.getLargeur();
        int L = lit.getLongueur();
        
        if (lit.getOrientation() == Orientation.Nord) {
            g.drawRect(x, y, L, l);
            g.drawRect(x + L/5, y + 10, L/5, 10);
            g.drawRect(x + L/5*3, y + 10, L/5, 10);
            g.drawLine(x, y + 15, x + L/5, y + 15);
            g.drawLine(x + L/5*2, y + 15, x + L/5*3, y + 15);
            g.drawLine(x + L/5*4, y + 15, x + L, y + 15);
        }

        if (lit.getOrientation() == Orientation.Est) {
            g.drawRect(x, y, L, l);
            g.drawRect(x + L-20, y + l/5, 10, l/5);
            g.drawRect(x + L-20, y + l/5*3, 10, l/5);
            g.drawLine(x+L-15,y,x+L-15,y+l/5);
            g.drawLine(x+L-15,y+l/5*2,x+L-15,y+l/5*3);
            g.drawLine(x+L-15,y+l/5*4,x+L-15,y+l);
        }

        if (lit.getOrientation() == Orientation.Sud) {
            g.drawRect(x, y, L, l);
            g.drawRect(x + L/5, y + l-20, L/5, 10);
            g.drawRect(x + L/5*3, y + l-20, L/5, 10);
            g.drawLine(x, y + l-15, x + L/5, y + l-15);
            g.drawLine(x + L/5*2, y + l-15, x + L/5*3, y + l-15);
            g.drawLine(x + L/5*4, y + l-15, x + L, y + l-15);
        }

        if (lit.getOrientation() == Orientation.Ouest) {
            g.drawRect(x, y, L, l);
            g.drawRect(x + 10, y + l/5, 10, l/5);
            g.drawRect(x + 10, y + l/5*3, 10, l/5);
            g.drawLine(x+15,y,x+15,y+l/5);
            g.drawLine(x+15,y+l/5*2,x+15,y+l/5*3);
            g.drawLine(x+15,y+l/5*4,x+15,y+l);
        }

    }
}
