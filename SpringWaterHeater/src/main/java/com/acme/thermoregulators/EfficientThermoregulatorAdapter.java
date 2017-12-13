package com.acme.thermoregulators;

import com.ventoelectrics.thermoregulator.Thermoregulator;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("efficient")
public class EfficientThermoregulatorAdapter implements Thermoregulator {
    EfficientThermoregulator thermoregulator;

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
