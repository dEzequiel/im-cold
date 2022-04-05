package edu.poniperro.interfaces;

import edu.poniperro.entities.Room;

public interface Regulator {
    void activateHeater(double maxTemp, double minTemp, Room room, Heater heater, Measurament thermometer);
    void deactivateHeater(double maxTemp, double minTemp, Room room, Heater heater, Measurament thermometer);
}
