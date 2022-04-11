package edu.poniperro.entities;

public class Room {

    private double roomTemperature = 0;
    private static Room instance = null;

    private Room() {
    };

    public static Room getInstance() {
        if (instance == null) {
            instance = new Room();
        }

        return instance;
    }

    public void setRoomTemperature(double temperature) {
        this.roomTemperature = temperature;
    }

    public double getRoomTemperature() {
        return this.roomTemperature;
    }

    public void decreaseRoomTemperature() {
        this.roomTemperature -= 1;
    }

    public void incrementRoomTemperature(double temperature) {
        this.roomTemperature += 1;
    }

}
