package simulation.vue;

import patrons.observer.Observer;
import simulation.controleur.ClickPiece;
import simulation.modele.Habitant;
import simulation.modele.Maison;
import simulation.modele.Piece;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DessinMaison extends JFrame implements Observer<Object> {

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
            dessinPiece.setBackground(new Color(140, 140, 140));
            dessinPiece.addMouseListener(new ClickPiece(p, habitant));
            panel.add(dessinPiece, gbc);
            dessinPieces.add(dessinPiece);
        }

        this.add(panel);
        this.setVisible(true);
        this.pack();

    }

    @Override
    public void update(Object objet) {
        if (objet instanceof Piece) {
            for (DessinPiece dp : dessinPieces)
                if (dp.getPiece() == objet)
                    dp.repaint();
        } else if (objet instanceof Integer) {
            int heure = (Integer) objet;
            for (DessinPiece dp : dessinPieces)
                if (dp.getPiece().isLumiereAllumee()) {
                    dp.setBackground(new Color(200, 200, 200));
                } else {
                    if (heure < 7 || heure > 21)
                        dp.setBackground(new Color(100, 100, 100));
                    else
                        dp.setBackground(new Color(180 - Math.abs(14 - heure) * 10, 180 - Math.abs(14 - heure) * 10, 180 - Math.abs(14 - heure) * 10));
                }
        }
    }
}
