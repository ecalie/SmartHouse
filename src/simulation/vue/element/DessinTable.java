package simulation.vue.element;

import simulation.modele.element.Table;

import java.awt.*;

public class DessinTable implements DessinElement {

    private Table table;

    public DessinTable(Table table) {
        this.table = table;
    }

    public void dessiner(Graphics g) {
        int L = table.getLongueur();
        int l = table.getLargeur();
        int x = table.getX();
        int y = table.getY();

        g.drawRect(x+5,y,L-5,l-5);
        g.drawLine(x+5,y,x,y+5);
        g.drawLine(x,y+l,x+5,y+l-5);
        g.drawLine(x+L,y+l-5,x+L-5,y+l);
    }
}
