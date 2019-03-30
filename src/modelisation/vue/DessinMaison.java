package modelisation.vue;

import intelligence_artificielle.modele.Habitant;
import modelisation.modele.Maison;
import modelisation.modele.Piece;
import patrons.observer.Observer;

import javax.swing.*;
import java.awt.*;

public class DessinMaison extends JFrame implements Observer {

    public DessinMaison(Maison maison, Habitant habitant) {
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        for (Piece s : maison.getPieces()) {
            gbc.gridx = s.getX();
            gbc.gridy = s.getY();
            gbc.gridwidth = s.getLongueur();
            gbc.gridheight = s.getLargeur();
            panel.add(new DessinPiece(s, habitant), gbc);
        }

        this.add(panel);
        this.setVisible(true);
        this.pack();

    }

    public void update() {
        this.repaint();
    }
}
