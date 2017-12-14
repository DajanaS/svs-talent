package com.acme.thermoregulators;

import com.ventoelectrics.thermoregulator.Thermoregulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("standard")
public class StandardThermoregulatorAdapter implements Thermoregulator {
    private StandardThermoregulator thermoregulator;

    @Autowired
    public StandardThermoregulatorAdapter(StandardThermoregulator thermoregulator){
        this.thermoregulator=thermoregulator;
    }

    @Override
    public void setTemperature(int temperature) {
        thermoregulator.setTemperature(temperature);
    }

    @Override
    public void enablePower() {
        thermoregulator.enablePower();
    }

    @Override
    public void disablePower() {
        thermoregulator.disablePower();
    }
}
