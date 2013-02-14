package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;

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
