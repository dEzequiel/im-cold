package edu.poniperro.entities;

import edu.poniperro.interfaces.Heater;
import edu.poniperro.interfaces.Measurament;
import edu.poniperro.interfaces.Regulator;
import edu.poniperro.types.RegulatorCodes;

public class Controller implements Regulator{

    public Controller(){};
    // public Controller(double maxTemp, double minTemp, Room room, Heater heater, Measurament thermometer){};

    @Override
    public void deactivateHeater(double maxTemp, double minTemp, Room room, Heater heater, Measurament thermometer) {
        RegulatorCodes code = RegulatorCodes.COOLING;
        while(thermometer.readTemperature(room) > minTemp) {
            heater.setStatus(false);
            room.decreaseRoomTemperature();
            message(code, room);
            if (thermometer.readTemperature(room) == minTemp) {
                heater.setStatus(true);
            }
        }
    }

    public void activateHeater(double maxTemp, double minTemp, Room room, Heater heater, Measurament thermometer) {
        RegulatorCodes code = RegulatorCodes.WARMING_UP;
        while(thermometer.readTemperature(room) < maxTemp) {
            heater.warm(room);
            message(code, room);
            if (thermometer.readTemperature(room) == maxTemp) {
                heater.setStatus(false);
            }
        }
    }

    public void regulate(double minTemp, double maxTemp, Room room, Heater heater, Measurament thermometer) {

        while (heater.getStatus()) {
            activateHeater(maxTemp, minTemp, room, heater, thermometer);
        }

        while(!heater.getStatus()) {
            deactivateHeater(maxTemp, minTemp, room, heater, thermometer);
        }
    }

    private void message(RegulatorCodes code, Room temperature) {
		switch (code) {
			case WARMING_UP:
			System.out.println("Calentando => temperatura " + temperature.getRoomTemperature());
				break;
			case COOLING:
				System.out.println("Apagado => temperatura " + temperature.getRoomTemperature());
				break;
			default:
				System.out.println("Algo raro sucede...");
				break;
		}
	}

}
