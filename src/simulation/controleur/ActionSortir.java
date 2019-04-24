package simulation.controleur;

import simulation.modele.Habitant;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ActionSortir implements KeyListener {

    private Habitant habitant;

    public ActionSortir(Habitant habitant) {
        this.habitant = habitant;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_ESCAPE)
            habitant.sortirMaison();
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
