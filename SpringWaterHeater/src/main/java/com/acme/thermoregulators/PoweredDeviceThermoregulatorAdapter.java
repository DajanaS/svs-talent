package com.acme.thermoregulators;

import com.ventoelectrics.powerswitch.*;
import com.ventoelectrics.thermoregulator.Thermoregulator;
import org.springframework.stereotype.Component;

@Component
public class PoweredDeviceThermoregulatorAdapter implements PoweredDevice {
    private Thermoregulator thermoregulator;

    public PoweredDeviceThermoregulatorAdapter(Thermoregulator thermoregulator) {
        this.thermoregulator = thermoregulator;
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
