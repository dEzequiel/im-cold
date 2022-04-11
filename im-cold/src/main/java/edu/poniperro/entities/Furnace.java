package edu.poniperro.entities;

import edu.poniperro.interfaces.Heater;

public class Furnace implements Heater{

    private boolean status = false;

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return this.status;
    }

    public void warm(Room room) {
        room.incrementRoomTemperature();

    }
}