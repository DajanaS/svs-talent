package com.acme.thermoregulators;

import com.acme.heater.PoweredDeviceHeaterAdapter;
import com.acme.thermometer.PoweredDeviceThermometerAdapter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@Profile("efficient")
public class EfficientThermoregulator extends Thread {
    private int temperature;
    private PoweredDeviceHeaterAdapter heater;
    private PoweredDeviceThermometerAdapter thermometer;

    public EfficientThermoregulator(PoweredDeviceHeaterAdapter heater, PoweredDeviceThermometerAdapter thermometer) {
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
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
