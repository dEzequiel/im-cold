package edu.poniperro.interfaces;

import edu.poniperro.entities.Room;

public interface Heater {
    public void warm(Room room);
    public void setStatus(boolean status);
    public boolean getStatus();
}
