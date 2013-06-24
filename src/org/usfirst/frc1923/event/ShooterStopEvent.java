package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;

/**
 * An event that stops the shooter.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 2/9/13
 */
public class ShooterStopEvent extends Event {
	/**
	 * Creates the event.
	 */
	public ShooterStopEvent() {
		super(true);
	}

	/**
	 * Performs the event's contents.
	 */
	protected void event() {
		Components.shooterSystem.stop();
	}
}
