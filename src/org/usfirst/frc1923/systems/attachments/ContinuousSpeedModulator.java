package org.usfirst.frc1923.systems.attachments;

import org.usfirst.frc1923.systems.MotorizedSystem;

/**
 * A continuous speed modulator as an alternative to gearboxes.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 2/18/13
 */
public class ContinuousSpeedModulator {
	private final MotorizedSystem system;
	private final double mod;
	private double speed;
	
	/**
	 * Creates a speed modulator.
	 * @param system
	 * 				the motorized system to attach to
	 */
	public ContinuousSpeedModulator(MotorizedSystem system) {
		this(.05, system);
	}
	
	/**
	 * Creates a speed modulator.
	 * @param mod
	 * 				the speed to modulate by with the mod commands
	 * @param system
	 * 				the motorized system to attach to
	 */
	public ContinuousSpeedModulator(double mod, MotorizedSystem system) {
		this.mod = mod;
		this.system = system;
	}
	
	/**
	 * Updates the current speed to modulate at.
	 * @param speed
	 * 				the speed to modulate at
	 */
	public void update(double speed) {
		this.speed = speed;
		this.system.setMaxOutput(speed);
	}
	
	/**
	 * Adds the mod value to the current speed.
	 */
	public void modUp() {
		this.update(speed + mod);
	}

	/**
	 * Subtracts the mod value from the current speed.
	 */
	public void modDown() {
		this.update(speed - mod);
	}

	/**
	 * Gets the current speed.
	 * @return the current speed
	 */
	public double getSpeed() {
		return this.speed;
	}
}
