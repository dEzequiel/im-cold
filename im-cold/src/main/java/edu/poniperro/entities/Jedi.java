package edu.poniperro.entities;
import edu.poniperro.interfaces.Heater;

public class Jedi implements Heater {

	public void warm(Room temperature){
		 temperature.incrementRoomTemperature(this.toucheLightSable());
	}

	public void decreaseRoomTemperature(Room temperature){
		Heater heater = new Furnace();
        heater.setStatus(true);
		this.forcePersuasion(heater, temperature);
	}

	private double toucheLightSable(){
		final double lightSableTemperature = 1400; // in ºC
		return lightSableTemperature;
	}

	private void forcePersuasion(Heater heater, Room temperature, double temperature){
		heater.warm(room);
		temperature.decreaseRoomTemperature(-1400);

	}

	public void speak(){
    System.out.println("\n"
    		+ "\t  __.-._   \n"
    		+ "\t  '-._\"7' \n"
    		+ "\t   /'.-c   \n"
    		+ "\t   |  /T   \n"
    		+ "\t  _)_/LI   \n"
    		+ "\nDo or do not. There is no try ");
	}
    @Override
    public void setStatus(boolean status) {
        // TODO Auto-generated method stub

    }
    @Override
    public boolean getStatus() {
        // TODO Auto-generated method stub
        return false;
    }
}
