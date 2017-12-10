package com.acme.thermometer;

import com.ventoelectrics.powerswitch.PoweredDevice;
import com.ventoelectrics.thermometer.Thermometer;
import org.springframework.stereotype.Component;

@Component
public class PoweredDeviceThermometerAdapter implements PoweredDevice {
    private Thermometer thermometer;

    public PoweredDeviceThermometerAdapter(Thermometer thermometer) {
        this.thermometer = thermometer;
    }

    @Override
    public void enablePower() {
        thermometer.enablePower();
    }

    @Override
    public void disablePower() {
        thermometer.disablePower();
    }

    public Integer getTemperature() {
        return thermometer.getTemperature();
    }
}
