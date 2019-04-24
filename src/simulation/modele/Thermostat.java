package simulation.modele;

import patrons.observer.Observable;

public class Thermostat extends Observable<Integer> {

    private int temperatureCible;

    public Thermostat() {
        this.temperatureCible = 22;
    }

    /**
     * Régler la température dans la maison.
     *
     * @param nouvelleTemperature La nouvelle température
     */
    public void reglerTemperature(int nouvelleTemperature) {
        this.temperatureCible = nouvelleTemperature;
        this.notifier(this.temperatureCible);
    }
}
