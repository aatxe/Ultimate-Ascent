package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;

public class HangingActivateEvent extends Event {
	/**
	 * Creates the event.
	 */
	public HangingActivateEvent() {
		super(true);
	}

	/**
	 * Performs the event's contents.
	 */
	protected void event() {
		Components.hangingSystem.set(true);
	}
}
