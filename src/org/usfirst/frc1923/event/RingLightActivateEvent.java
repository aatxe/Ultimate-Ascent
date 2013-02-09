package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;

import edu.wpi.first.wpilibj.Relay;

/**
 * An event that turns on the ring light.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 2/9/13
 */
public class RingLightActivateEvent extends Event {
	/**
	 * Creates the event.
	 */
	public RingLightActivateEvent() {
		super(true);
	}

	/**
	 * Performs the event's contents.
	 */
	protected void event() {
		Components.ringLight.set(Relay.Value.kOn);
	}
}
