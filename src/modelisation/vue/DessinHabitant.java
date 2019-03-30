package modelisation.vue;

import intelligence_artificielle.modele.Habitant;

import java.awt.*;

public class DessinHabitant {

    public void dessiner(Graphics g, int x, int y) {
        g.setColor(Color.RED);
        g.fillOval(x,y,20,15);
        g.setColor(Color.BLACK);
    }

}
