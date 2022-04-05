package edu.poniperro.entities;

import edu.poniperro.interfaces.Measurament;


public class Thermometer implements Measurament{

    public double readTemperature(Room temperature) {
        return temperature.getRoomTemperature();
    }
}
