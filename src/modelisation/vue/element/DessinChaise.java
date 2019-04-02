package modelisation.vue.element;

import modelisation.modele.element.Orientation;
import modelisation.modele.element.utilisable.Chaise;

import java.awt.*;

public class DessinChaise implements DessinElement {

    private Chaise chaise;

    public DessinChaise(Chaise chaise) {
        this.chaise = chaise;
    }

    public void dessiner(Graphics g) {
        int L = chaise.getLongueur();
        int l = chaise.getLargeur();
        int x = chaise.getX();
        int y = chaise.getY();

        if (chaise.getOrientation() == Orientation.Nord) {
            g.drawRect(x+2,y,L-5,l-3);
            g.drawLine(x+2,y,x, y+2);
            g.drawLine(x+2,y+l-3,x,y+l-1);
            g.drawLine(x+2,y+l-3,x+5,y+l);
            g.drawLine(x+5,y+l,x+L,y+l);
            g.drawLine(x+L-3,y+l-3,x+L,y+l);
        }

        if (chaise.getOrientation() == Orientation.Est) {
            g.drawRect(x+3,y+3,L-3,l-5);
            g.drawLine(x,y,x+3,y+3);
            g.drawLine(x,y,x,y+l-5);
            g.drawLine(x,y+l-5,x+3,y+l-2);
            g.drawLine(x+3,y+l-2,x+1,y+l);
            g.drawLine(x+L,y+l-2,x+L-2,y+l);
        }

        if (chaise.getOrientation() == Orientation.Sud) {
            g.drawRect(x+2,y+3,L-5,l-5);
            g.drawLine(x+5,y,x+2,y+3);
            g.drawLine(x+5,y,x+L,y);
            g.drawLine(x+L,y,x+L-3,y+3);
            g.drawLine(x+2,y+3,x,y+5);
            g.drawLine(x+2,y+l-2,x,y+l);
            g.drawLine(x+L-3,y+l-2,x+L-5,y+l);
        }

        if (chaise.getOrientation() == Orientation.Ouest) {
            g.drawRect(x+2,y+3,L-5,l-5);
            g.drawLine(x+2,y+3,x,y+5);
            g.drawLine(x+L-3,y+3,x+L,y);
            g.drawLine(x+L-3,y+l-2,x+L,y+l-5);
            g.drawLine(x+L, y,x+L,y+l-5);
            g.drawLine(x+2,y+l-2,x,y+l);
            g.drawLine(x+L-3,y+l-2,x+L-5,y+l);
        }
    }
}
