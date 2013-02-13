package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;

/**
 * An event that lowers the current driving gear.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 2/12/13
 */
public class DriveGearDownEvent extends Event {
	/**
	 * Creates the event.
	 */
	public DriveGearDownEvent() {
		super(true);
	}

	/**
	 * Performs the event's contents.
	 */
	protected void event() {
		Components.driveGearbox.gearDown();
	}
}
