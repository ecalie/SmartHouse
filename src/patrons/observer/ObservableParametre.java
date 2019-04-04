package patrons.observer;

import simulation.modele.Piece;

import java.util.ArrayList;
import java.util.List;

public abstract class ObservableParametre {

    private List<ObserverParametre> observers;


    public ObservableParametre() {
        this.observers = new ArrayList<>();
    }

    public void ajouterObserver(ObserverParametre observer) {
        this.observers.add(observer);
    }

    public void supprimerObserver(ObserverParametre observer) {
        this.observers.remove(observer);
    }

    public void notifier(Piece piece) {
        for (ObserverParametre o : observers)
            o.update(piece);
    }
}
