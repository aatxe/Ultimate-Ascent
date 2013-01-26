package org.usfirst.frc1923.events;

import org.usfirst.frc1923.components.DriveComponent;
import org.usfirst.frc1923.components.DriveGearbox;

/**
 *  An event to handle the Drive Gear
 * @author Pavan Hegde
 * @version 1.0
 * @since 1/22/13
 */
public class DriveGearChangeEvent implements Event {
	private DriveComponent drive;
	private DriveGearbox driveGear;
	private int gear;
	/**
	 *  A constructor to create the event
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

	public void reset() {
		// Quoting Aaron Weiss "Do shit"
		
	}
}
