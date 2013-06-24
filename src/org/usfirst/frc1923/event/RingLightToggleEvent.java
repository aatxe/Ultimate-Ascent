package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;

import edu.wpi.first.wpilibj.Relay;

/**
 * An event that toggles the state of the ring light.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 2/16/13
 */
public class RingLightToggleEvent extends Event {
	/**
	 * Creates the event.
	 */
	public RingLightToggleEvent() {
		super(true);
	}

	/**
	 * Performs the event's contents.
	 */
	protected void event() {
		if (Components.ringLight.get().value == Relay.Value.kOff.value)
			Components.ringLight.set(Relay.Value.kOn);
		else if (Components.ringLight.get().value == Relay.Value.kOn.value)
			Components.ringLight.set(Relay.Value.kOff);
	}
}
