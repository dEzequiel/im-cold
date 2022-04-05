package edu.poniperro;

import edu.poniperro.entities.Controller;
import edu.poniperro.entities.Furnace;
import edu.poniperro.entities.Room;
import edu.poniperro.entities.Thermometer;
import edu.poniperro.interfaces.Heater;
import edu.poniperro.interfaces.Measurament;
import edu.poniperro.interfaces.Regulator;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        double maxTemp = 21;
        double minTemp = 15;

        Room livingRoom = Room.getInstance();
        livingRoom.setRoomTemperature(30);

        Measurament thermometer = new Thermometer();

        Heater furnace = new Furnace();
        furnace.setStatus(true);


        // Room 15Cn
        // Termometro
        // Horno
        // Control

        Regulator distanceController = new Controller();

        distanceController.regulate(maxTemp, minTemp, livingRoom, furnace, thermometer);


    }
}
