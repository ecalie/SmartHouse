package simulation.modele;

import patrons.observer.Observable;

public class Horloge extends Observable<Integer> implements Runnable {

    private static Horloge instance;
    private int heure;

    private Horloge() {
        heure = 05;
    }

    public static Horloge getInstance() {
        if (instance == null)
            instance = new Horloge();
        return instance;
    }

    public int getHeure() {
        return heure;
    }

    @Override
    public void run() {
        while (true) {
            heure = (heure + 1) % 24;
            this.notifier(heure);
            try {
                Thread.sleep(Constante.Heure);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
