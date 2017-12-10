package com.acme.thermoregulators;

import com.ventoelectrics.powerswitch.PoweredDevice;
import com.ventoelectrics.thermoregulator.Thermoregulator;

public class PoweredDeviceThermoregulatorAdapter implements PoweredDevice {
    private Thermoregulator thermoregulator;

    public PoweredDeviceThermoregulatorAdapter(Thermoregulator thermoregulator) {
        this.thermoregulator = thermoregulator;
    }

    public void enablePower() {
        thermoregulator.enablePower();
    }

    public void disablePower() {
        thermoregulator.disablePower();
    }
}
