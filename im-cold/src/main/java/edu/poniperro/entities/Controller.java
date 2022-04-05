package edu.poniperro.entities;

import edu.poniperro.interfaces.Heater;
import edu.poniperro.interfaces.Measurament;
import edu.poniperro.interfaces.Regulator;

public class Controller implements Regulator{

    public Controller(){};
    // public Controller(double maxTemp, double minTemp, Room room, Heater heater, Measurament thermometer){};

    @Override
    public void deactivateHeater(double maxTemp, double minTemp, Room room, Heater heater, Measurament thermometer) {
        while(thermometer.readTemperature(room) > maxTemp) {
                heater.setStatus(false);
                room.decreaseRoomTemperature();
                System.out.println("Enfriando..." + thermometer.readTemperature(room));

        }
    }

    public void activateHeater(double maxTemp, double minTemp, Room room, Heater heater, Measurament thermometer) {
        while(thermometer.readTemperature(room) < maxTemp) {
            heater.warm(room);
            System.out.println("Calentando..." + thermometer.readTemperature(room));
            if (thermometer.readTemperature(room) == maxTemp) {
                break;
            }
        }
    }


    public void regulate(double minTemp, double maxTemp, Room room, Heater heater, Measurament thermometer) {
        while(thermometer.readTemperature(room) != 10) {
            if(thermometer.readTemperature(room) > maxTemp) {
                deactivateHeater(maxTemp, minTemp, room, heater, thermometer);
            }

            if(thermometer.readTemperature(room) > minTemp) {
                activateHeater(maxTemp, minTemp, room, heater, thermometer);
            }
        }

    }

}
