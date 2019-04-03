package simulation.vue.element;

import simulation.modele.element.Meuble;

import java.awt.*;

public class DessinMeuble implements DessinElement {

    private Meuble meuble;

    public DessinMeuble(Meuble meuble) {
        this.meuble = meuble;
    }

    public void dessiner(Graphics g) {
        int x = meuble.getX();
        int y = meuble.getY();
        int L = meuble.getLongueur();
        int l = meuble.getLargeur();

        g.drawRect(x, y, L, l);
    }
}
