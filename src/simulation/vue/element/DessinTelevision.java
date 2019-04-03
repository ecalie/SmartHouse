package simulation.vue.element;

import simulation.modele.element.deuxEtats.Television;
import simulation.modele.element.Orientation;

import java.awt.*;

public class DessinTelevision implements DessinElement {

    private Television television;

    public DessinTelevision(Television television) {
        this.television = television;
    }

    public void dessiner(Graphics g) {
        int L = television.getLongueur();
        int l = television.getLargeur();
        int x = television.getX();
        int y = television.getY();

        if (television.getOrientation() == Orientation.Nord) {
            g.drawRect(x+7,y,L-14,l-7);
            g.drawLine(x, y + 7, x, y + l);
            g.drawLine(x, y + l, x + L,y + l);
            g.drawLine(x + L, y + l, x + L, y + 7);
            g.drawLine(x,y+7,x+7,y+7);
            g.drawLine(x+L-7,y+7,x+L,y+7);
        }

        if (television.getOrientation() == Orientation.Est) {
            g.drawRect(x+7,y+7,20,20);
            g.drawLine(x, y, x + L-7, y);
            g.drawLine(x, y, x, y + l);
            g.drawLine(x, y + l, x + 20, y + l);
            g.drawLine(x+L-7,y,x+L-7,y+7);
            g.drawLine(x+L-7,y+l-7,x+L-7,y+l);
        }

        if (television.getOrientation() == Orientation.Sud) {
            g.drawRect(x+7,y+7,L-14,l-7);
            g.drawLine(x, y, x + L, y);
            g.drawLine(x, y, x, y + l-7);
            g.drawLine(x + L, y, x + L, y + l-7);
            g.drawLine(x, y + l-7, x + 7, y + l-7);
            g.drawLine(x + L-7, y + l-7, x + L, y + l-7);
        }

        if(television.getOrientation() == Orientation.Ouest) {
            g.drawRect(x,y+7,L-7,l-14);
            g.drawLine(x+7,y,x+L,y);
            g.drawLine(x+L,y,x+L,y+l);
            g.drawLine(x+7,y+l,x+L,y+l);
            g.drawLine(x+7,y,x+7,y+7);
            g.drawLine(x+7,y+l-7,x+7,y+l);
        }
    }

}
