package plugin;

import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.AirportAgentSimulation;
import dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.config.ConfigurationFormatException;
import entities.officer;

public class SecurityPlugin implements dhbw.sose2022.softwareengineering.airportagentsim.simulation.api.plugin.Plugin {

    @Override
    public void activate() {
        try {
            AirportAgentSimulation.registerEntity(this, "officer", officer.class);
;
        } catch (ConfigurationFormatException e) {
            e.printStackTrace();
        }

    }
}


