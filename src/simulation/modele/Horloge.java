package simulation.modele;

import patrons.observer.Observable;

public class Horloge extends Observable implements Runnable {

    private static Horloge instance;
    private int heure;

    private Horloge() {
        heure = 10;
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
            heure = (heure + 1)%24;
            this.notifier();
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        if (heure < 10)
            return ("0" + heure + ":00");
        else
            return (heure + ":00");
    }
}
