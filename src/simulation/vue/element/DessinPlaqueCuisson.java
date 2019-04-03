package simulation.vue.element;

import simulation.modele.element.deuxEtats.PlaqueCuisson;

import java.awt.*;

public class DessinPlaqueCuisson implements DessinElement {

    private PlaqueCuisson plaqueCuisson;

    public DessinPlaqueCuisson(PlaqueCuisson plaqueCuisson) {
        this.plaqueCuisson = plaqueCuisson;
    }

    public void dessiner(Graphics g) {
        int x = plaqueCuisson.getX();
        int y = plaqueCuisson.getY();
        int L = plaqueCuisson.getLongueur();
        int l = plaqueCuisson.getLargeur();

        g.drawRect(x, y, L, l);
        g.drawArc(x + L / 9, y + l / 9, L / 3, l / 3, 0, 360);
        g.drawArc(x + L - 4 * L / 9, y + l / 9, L / 3, l / 3, 0, 360);
        g.drawArc(x + L / 9, y + l - 4 * l / 9, L / 3, l / 3, 0, 360);
        g.drawArc(x + L - 4 * L / 9, y + l - 4 * l / 9, L / 3, l / 3, 0, 360);
    }
}
