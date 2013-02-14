package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;

public class ShooterAngleControllerDeactivateEvent extends Event {
	/**
	 * Creates the event.
	 */
	public ShooterAngleControllerDeactivateEvent() {
		super(true);
	}
	
	/**
	 * Performs the event's contents.
	 */
	protected void event() {
		Components.shooterAngleSystem.set(false);
	}
}
