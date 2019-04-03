package simulation.controleur;

import intelligence_artificielle.modele.Habitant;
import simulation.modele.Piece;
import simulation.modele.element.Element;
import simulation.modele.element.deuxEtats.DeuxEtats;
import simulation.modele.element.deuxEtats.Etat;
import simulation.modele.element.utilisable.Utilisable;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ClickPiece implements MouseListener {

    private Piece piece;
    private Habitant habitant;

    public ClickPiece(Piece piece, Habitant habitant) {
        this.piece = piece;
        this.habitant = habitant;
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        habitant.terminerAction();

        boolean elementTrouve = false;
        for (Element e : piece.getElements()) {
            if (e.getX() <= mouseEvent.getX() && mouseEvent.getX() <= e.getX() + e.getLongueur() &&
                    e.getY() <= mouseEvent.getY() && mouseEvent.getY() <= e.getY() + e.getLargeur()) {
                if (e instanceof Utilisable)
                    habitant.utiliser((Utilisable) e);
                else if (e instanceof DeuxEtats)
                    if (((DeuxEtats) e).getEtat() == Etat.Eteint)
                        habitant.allumer((DeuxEtats) e);
                    else
                        habitant.eteindre((DeuxEtats) e);

                    elementTrouve = true;
                break;
            }
        }
         if (!elementTrouve)
             habitant.aller(piece);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }
}
