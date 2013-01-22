package org.usfirst.frc1923.events;

import org.usfirst.frc1923.components.DriveGearBox;

public class DriveGearChangeEvent implements Event {
	private DriveGearBox driveGear;
	private int gear;
	
	public DriveGearChangeEvent (int gear, DriveGearBox driveGear) {
		this.driveGear = driveGear;
		this.gear = gear;
	}
	
	public void run() {
		driveGear.setGear(gear);
	}

	public void reset() {
		// TODO Auto-generated method stub
		
	}
}
