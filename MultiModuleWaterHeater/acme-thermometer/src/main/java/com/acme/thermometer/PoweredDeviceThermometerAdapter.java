package com.acme.thermometer;

import com.ventoelectrics.powerswitch.PoweredDevice;
import com.ventoelectrics.thermometer.Thermometer;

public class PoweredDeviceThermometerAdapter implements PoweredDevice {
    private Thermometer thermometer;

    public PoweredDeviceThermometerAdapter(Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    public void enablePower() {
        thermometer.enablePower();
    }

    public void disablePower() {
        thermometer.disablePower();
    }

    public Integer getTemperature() {
        return thermometer.getTemperature();
    }
}
