package simulation.vue;

import intelligence_artificielle.modele.Habitant;
import simulation.controleur.ClickPiece;
import simulation.modele.Horloge;
import simulation.modele.Maison;
import simulation.modele.Piece;
import patrons.observer.Observer;

import javax.swing.*;
import java.util.List;
import java.util.ArrayList;
import java.awt.*;

public class DessinMaison extends JFrame implements Observer {

    private List<DessinPiece> dessinPieces;

    public DessinMaison(Maison maison, Habitant habitant) {
        this.dessinPieces = new ArrayList<>();
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        for (Piece p : maison.getPieces()) {
            gbc.gridx = p.getX();
            gbc.gridy = p.getY();
            gbc.gridwidth = p.getLongueur();
            gbc.gridheight = p.getLargeur();
            DessinPiece dessinPiece = new DessinPiece(p, habitant);
            dessinPiece.setBackground(new Color(140,140,140));
            dessinPiece.addMouseListener(new ClickPiece(p, habitant));
            panel.add(dessinPiece, gbc);
            dessinPieces.add(dessinPiece);
        }

        this.add(panel);
        this.setVisible(true);
        this.pack();

    }

    public void update() {
        this.repaint();
        int heure = Horloge.getInstance().getHeure();
        for (DessinPiece dp : dessinPieces)
            if (heure < 7 || heure > 21)
                dp.setBackground(new Color(100,100,100));
            else
                dp.setBackground(new Color(180 - Math.abs(14-heure)*10, 180 - Math.abs(14-heure)*10, 180 - Math.abs(14-heure)*10));
    }
}
