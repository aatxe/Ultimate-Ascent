package org.usfirst.frc1923.systems;

import org.usfirst.frc1923.Components;
import org.usfirst.frc1923.utils.DefaultConfiguration;
import org.usfirst.frc1923.utils.MotorGroup;

/**
 * A system for controlling the robot's shooter.
 * 
 * @author Aaron Weiss
 * @version 1.5
 * @since 2/9/13
 */
public class ShooterSystem implements MotorizedSystem {
	private final MotorGroup leftController, rightController;
	private double maxOutput = 1.0;

	/**
	 * Creates the shooter system.
	 * 
	 * @param leftController
	 * 				the <code>MotorGroup</code> for the left (or front) shooter wheel
	 * @param rightController
	 * 				the <code>MotorGroup</code> for the right (or back) shooter wheel
	 */
	public ShooterSystem(MotorGroup leftController, MotorGroup rightController) {
		this.leftController = leftController;
		this.rightController = rightController;
	}

	/**
	 * Sets the speed of the shooter.
	 * 
	 * @param magnitude
	 * 				the magnitude of the shooter
	 */
	public void set(double magnitude) {
		this.set(-magnitude, -magnitude);
	}

	/**
	 * Sets the speed of the shooter.
	 * 
	 * @param leftMagnitude
	 * 				the magnitude of the left side of the shooter
	 * @param rightMagnitude
	 * 				the magnitude of the right side of the shooter
	 */
	public void set(double leftMagnitude, double rightMagnitude) {
		this.leftController.set(-leftMagnitude * this.maxOutput);
		this.rightController.set(-rightMagnitude * (this.maxOutput - this.diff()));
	}

	/**
	 * Gets the shooter speed diff from the preferences.
	 * 
	 * @return the shooter speed diff
	 */
	protected double diff() {
		return Components.preferences.getDouble("shooter_diff", DefaultConfiguration.SHOOTER_DIFF);
	}

	/**
	 * Sets the max motor output for the robot system.
	 * 
	 * @param maxOutput
	 *				the systems' new max output.
	 */
	public void setMaxOutput(double maxOutput) {
		this.maxOutput = maxOutput;
	}

	/**
	 * Completely stops the robot system.
	 */
	public void stop() {
		this.leftController.set(0);
		this.leftController.disable();
		this.rightController.set(0);
		this.rightController.disable();
	}
}
