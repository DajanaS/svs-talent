package com.acme.heater;

import com.ventoelectrics.powerswitch.PoweredDevice;
import com.ventoelectrics.heater.Heater;

public class PoweredDeviceHeaterAdapter implements PoweredDevice {
    private Heater heater;

    public PoweredDeviceHeaterAdapter(Heater heater) {
        this.heater = heater;
    }

    public void enablePower() {
        heater.enablePower();
    }

    public void disablePower() {
        heater.disablePower();
    }

    public void startHeating() {
        heater.startHeating();
    }

    public void stopHeating() {
        heater.stopHeating();
    }
}
