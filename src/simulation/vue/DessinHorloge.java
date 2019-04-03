package simulation.vue;

import patrons.observer.Observer;
import simulation.modele.Horloge;

import javax.swing.*;
import java.awt.*;

public class DessinHorloge extends JFrame implements Observer {

    private JTextArea heure;

    public DessinHorloge() {
        super("Horloge");
        this.heure = new JTextArea(1,5);
        heure.setText(Horloge.getInstance().toString());
        heure.setBackground(Color.DARK_GRAY);
        heure.setForeground(Color.WHITE);
        heure.setFont(new Font("Arial", Font.BOLD, 25));

        this.add(heure);
        this.pack();
        this.setLocation(600,0);
        this.setVisible(true);
    }

    @Override
    public void update() {
        this.heure.setText(Horloge.getInstance().toString());
    }
}