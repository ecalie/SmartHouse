package simulation.vue;

import patrons.observer.Observer;
import simulation.modele.Thermostat;

import javax.swing.*;
import java.awt.*;

public class DessinThermostat extends JFrame {

    private PanelThermostat panel;

    public DessinThermostat(Thermostat thermostat) {
        super("Thermostat");
        this.panel = new PanelThermostat();
        thermostat.ajouterObserver(panel);
        this.add(panel);
        this.setBackground(Color.GRAY);

        this.setSize(new Dimension(270, 270));
        this.setLocation(800, 0);
        this.setVisible(true);
    }
}

class PanelThermostat extends JPanel implements Observer<Integer> {

    private int temperature;

    public PanelThermostat() {
        super();
        this.temperature = 10;
    }

    @Override
    public void update(Integer objet) {
        this.temperature = objet;
        this.repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0,0,260,260);
        g.drawArc(30, 30, 200, 200, 0, 360);
        g.drawChars(new char[]{'1', '0'}, 0, 2, 25, 78);
        g.drawChars(new char[]{'1', '5'}, 0, 2, 60, 40);
        g.drawChars(new char[]{'2', '0'}, 0, 2, 120, 25);
        g.drawChars(new char[]{'2', '5'}, 0, 2, 180, 40);
        g.drawChars(new char[]{'3', '0'}, 0, 2, 215, 78);
        g.drawLine(130,130,
                (int) (130 + Math.cos(Math.PI / 6 * (35 - temperature) / 5) * 100),
                (int) (130 - Math.sin(Math.PI / 6 * (35 - temperature) / 5) * 100));
    }
}