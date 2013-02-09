package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;

import edu.wpi.first.wpilibj.Relay;

/**
 * An event that turns off the ring light.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 2/9/13
 */
public class RingLightDeactivateEvent extends Event {
	/**
	 * Creates the event.
	 */
	public RingLightDeactivateEvent() {
		super(true);
	}

	/**
	 * Performs the event's contents.
	 */
	protected void event() {
		Components.ringLight.set(Relay.Value.kOff);
	}
}
