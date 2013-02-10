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
	private int disques;
	
	/**
	 * Creates the event.
	 */
	public ShooterActuatorEvent() {
		this(1);
	}
	
	public ShooterActuatorEvent(int disques) {
		super(true);
		this.disques = disques;
	}

	/**
	 * Performs the event's contents.
	 */
	protected void event() {
		for (int i = 0; i < disques; i++) {
			Components.pneumaticActuator.set(true);
			Timer.delay(Components.preferences.getDouble("shooter_pneumatic_time", DefaultConfiguration.SHOOTER_PNEUMATIC_TIME));
			Components.pneumaticActuator.set(false);
			Timer.delay(Components.preferences.getDouble("shooter_pneumatic_time", DefaultConfiguration.SHOOTER_PNEUMATIC_TIME));
		}
	}
}
