package modelisation.vue.element;

import modelisation.modele.element.Mur;

import java.awt.*;

public class DessinMur implements DessinElement {

    private Mur mur;

    public DessinMur(Mur mur) {
        this.mur = mur;
    }

    public void dessiner(Graphics g) {
        int x = mur.getX();
        int y = mur.getY();
        int L = mur.getLongueur();
        int l = mur.getLargeur();

        g.setColor(Color.BLACK);
        g.drawLine(x,y,x+L,y+l);
    }
}
