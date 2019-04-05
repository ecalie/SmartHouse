package patrons.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable<T> {

    private List<Observer> observers;


    public Observable() {
        this.observers = new ArrayList<>();
    }

    public void ajouterObserver(Observer observer) {
        this.observers.add(observer);
    }

    public void notifier(T objet) {
        for (Observer o : observers)
            o.update(objet);
    }
}
