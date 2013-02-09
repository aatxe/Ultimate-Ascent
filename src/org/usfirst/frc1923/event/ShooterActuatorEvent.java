package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;
import org.usfirst.frc1923.utils.DefaultConfiguration;

import edu.wpi.first.wpilibj.Timer;

/**
 * An event that actuates the shooter pneumatically.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 2/9/13
 */
public class ShooterActuatorEvent extends Event {
	/**
	 * Creates the event.
	 */
	public ShooterActuatorEvent() {
		super(true);
	}

	/**
	 * Performs the event's contents.
	 */
	protected void event() {
		Components.pneumaticActuator.set(true);
		Timer.delay(Components.preferences.getDouble("shooter_pneumatic_time", DefaultConfiguration.SHOOTER_PNEUMATIC_TIME));
		Components.pneumaticActuator.set(false);
	}
}
