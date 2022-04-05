package edu.poniperro.entities;

import edu.poniperro.interfaces.Heater;
import edu.poniperro.interfaces.Measurament;
import edu.poniperro.interfaces.Regulator;

public class Controller implements Regulator{

    public Controller(double maxTemp, double minTemp, Room room, Heater heater, Measurament thermometer){};

    @Override
    public void deactivateHeater(double maxTemp, double minTemp, Room room, Heater heater, Measurament thermometer) {
        while(thermometer.readTemperature(room) > maxTemp && !heater.getStatus()) {
                room.decreaseRoomTemperature();
        }
    }

    public void activateHeater(double maxTemp, double minTemp, Room room, Heater heater, Measurament thermometer) {
        while(thermometer.readTemperature(room) < minTemp && heater.getStatus() == true) {
            heater.warm(room);
            // if (thermometer.readTemperature(room) == maxTemp) {
            //     break;
            // }
        }
    }

}
