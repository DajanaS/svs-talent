package com.ventoelectrics.thermoregulator;

import com.ventoelectrics.powerswitch.*;

public interface Thermoregulator extends PoweredDevice {

    void setTemperature(int temperature);
}
