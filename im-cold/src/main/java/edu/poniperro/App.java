package edu.poniperro;

import edu.poniperro.entities.Controller;
import edu.poniperro.entities.Furnace;
import edu.poniperro.entities.Jedi;
import edu.poniperro.entities.Room;
import edu.poniperro.entities.Thermometer;
import edu.poniperro.interfaces.Heater;
import edu.poniperro.interfaces.Measurament;
import edu.poniperro.interfaces.Regulator;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        double maxTemp = 21;
        double minTemp = 15;

        Room livingRoom = Room.getInstance();
        livingRoom.setRoomTemperature(15);

        Measurament thermometer = new Thermometer();

        Heater furnace = new Furnace();
        furnace.setStatus(true);

        Regulator distanceController = new Controller();
        distanceController.regulate(minTemp, maxTemp, livingRoom, furnace, thermometer);

        System.out.println( "Arrancando..." );
        distanceController.regulate(minTemp, maxTemp, livingRoom, furnace, thermometer);

        Jedi yoda = new Jedi();
        System.out.println( "\nArrancando a Yoda: " );
        distanceController.regulate(minTemp, maxTemp, livingRoom, yoda, thermometer);
        yoda.speak();

    }
}
