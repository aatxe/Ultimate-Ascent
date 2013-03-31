package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;

/**
 * An event that raises the current shooter gear.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 2/9/13
 */
public class ShooterGearUpEvent extends Event {
	/**
	 * Creates the event.
	 */
	public ShooterGearUpEvent() {
		super(true);
	}

	/**
	 * Performs the event's contents.
	 */
	protected void event() {
		Components.shooterGearbox.gearUp();
	}
}
