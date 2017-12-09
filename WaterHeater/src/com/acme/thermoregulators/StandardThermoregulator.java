package com.acme.thermoregulators;

import java.util.concurrent.TimeUnit;

public class StandardThermoregulator extends Thread {
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
}
