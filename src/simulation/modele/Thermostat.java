package simulation.modele;

import patrons.observer.Observable;

public class Thermostat extends Observable<Integer> {

    private int temperatureCible;

    public Thermostat() {
        this.temperatureCible = 22;
    }

    public void reglerTemperature(int nouvelleTemperature) {
        this.temperatureCible = nouvelleTemperature;
        this.notifier(this.temperatureCible);
    }
}
