package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;

/**
 * An event that raises the current driving gear.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 2/12/13
 */
public class DriveGearUpEvent extends Event {
	/**
	 * Creates the event.
	 */
	public DriveGearUpEvent() {
		super(true);
	}

	/**
	 * Performs the event's contents.
	 */
	protected void event() {
		Components.driveGearbox.gearUp();
	}
}
