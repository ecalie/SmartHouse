package simulation.controleur;

import simulation.modele.Habitant;
import simulation.modele.Piece;
import simulation.modele.element.Element;
import simulation.modele.element.deuxEtats.AppareilDeuxEtats;
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
        // faire déplacer l'habitant
        // et le faire terminer ce qu'il fait
        // et utiliser un appareil si on clique sur un appareil
        habitant.terminerAction();

        // regarder si on vient de cliquer sur un appareil
        boolean elementTrouve = false;
        for (Element e : piece.getElements()) {
            if (e.getX() <= mouseEvent.getX() && mouseEvent.getX() <= e.getX() + e.getLongueur() &&
                    e.getY() <= mouseEvent.getY() && mouseEvent.getY() <= e.getY() + e.getLargeur()) {
                if (e instanceof Utilisable)
                    habitant.utiliser((Utilisable) e);
                else if (e instanceof AppareilDeuxEtats)
                    if (((AppareilDeuxEtats) e).getEtat() == Etat.Eteint)
                        habitant.allumer((AppareilDeuxEtats) e);
                    else
                        habitant.eteindre((AppareilDeuxEtats) e);

                elementTrouve = true;
                break;
            }
        }

        // sinon simplement faire déplacer l'habitant dans la pièce
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
