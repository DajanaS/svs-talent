package com.acme.thermoregulators;

import com.acme.heater.PoweredDeviceHeaterAdapter;
import com.acme.thermometer.PoweredDeviceThermometerAdapter;
import com.ventoelectrics.thermoregulator.Thermoregulator;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Profile("standard")
public class StandardThermoregulator extends Thread implements Thermoregulator {
    private int temperature;
    private PoweredDeviceHeaterAdapter heater;
    private PoweredDeviceThermometerAdapter thermometer;

    public StandardThermoregulator(PoweredDeviceHeaterAdapter heater, PoweredDeviceThermometerAdapter thermometer) {
        this.heater = heater;
        this.thermometer = thermometer;
    }

    public void setTemperature(Integer temperature) {
        this.temperature = temperature;
    }

    @Override
    public void run() {
        while (true) {
            if (Thread.interrupted()) {
                return;
            }

            int temp = thermometer.getTemperature();
            if (temperature > temp) {
                heater.stopHeating();
            }
            if (temperature < temp) {
                heater.startHeating();
            }

            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    @Override
    public void enablePower() {
        start();
    }

    @Override
    public void disablePower() {
        stop();
    }
}
