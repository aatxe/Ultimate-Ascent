package org.usfirst.frc1923.events;

import org.usfirst.frc1923.components.DriveComponent;
import org.usfirst.frc1923.components.DriveGearbox;

/**
 *  An event to handle the Drive Gear
 * @author Pavan Hegde
 * @version 1.0
 * @since 1/27/13
 */
public class DriveGearChangeEvent implements Event {
	private DriveComponent drive;
	private DriveGearbox driveGear;
	private int gear;
	
	/**
	 * Creates the event by setting the <code>DriveComponent</code> and <code>DriveGearbox</code>
	 * @param gear the gear
	 * @param driveGear the Drive Gearbox
	 */
	public DriveGearChangeEvent (int gear, DriveGearbox driveGear) {
		this.driveGear = driveGear;
		this.gear = gear;
	}
	
	/**
	 * Sets the gear
	 */
	public void run() {
		driveGear.setGear(gear);
		drive.setMaxOutput(driveGear.getSpeed());
	}
	
	
	public double DriveTrainSpeed(){
		return driveGear.getSpeed();
	}

	public void reset() {
		// Quoting Aaron Weiss "Do shit"
		
	}
}
