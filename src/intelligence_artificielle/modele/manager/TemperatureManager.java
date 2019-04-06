package intelligence_artificielle.modele.manager;

import simulation.modele.Piece;
import simulation.modele.Thermostat;

public class TemperatureManager {

    private Thermostat thermostat;

    public void setThermostat(Thermostat thermostat) {
        this.thermostat = thermostat;
    }

    public void gererTemperature(Piece position, boolean endormi) {
        if (position == null)
            thermostat.reglerTemperature(10);
        else if (endormi)
            thermostat.reglerTemperature(18);
        else
            thermostat.reglerTemperature(22);
    }
}
