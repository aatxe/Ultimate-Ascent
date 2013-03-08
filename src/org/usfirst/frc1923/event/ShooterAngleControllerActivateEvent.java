package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;

/**
 * An event that activates the shooter angle controller.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 2/14/13
 */
public class ShooterAngleControllerActivateEvent extends Event {
	/**
	 * Creates the event.
	 */
	public ShooterAngleControllerActivateEvent() {
		super(true);
	}

	/**
	 * Performs the event's contents.
	 */
	protected void event() {
		Components.shooterAngleSystem.set(true);
	}
}
