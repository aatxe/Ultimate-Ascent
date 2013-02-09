package org.usfirst.frc1923.systems;

import org.usfirst.frc1923.utils.MotorGroup;

/**
 * A system for controlling the angle of the shooter.
 * 
 * @author Aaron Weiss
 * @version 1.3
 * @since 2/9/13
 */
public class ShooterAngleSystem implements System {
	private MotorGroup angleController;
	private double maxOutput = 1.0;
	
	/**
	 * Creates a <code>ShooterAngleSystem</code>.
	 * 
	 * @param angleController
	 * 				the <code>MotorGroup</code> to control the angle
	 */
	public ShooterAngleSystem(MotorGroup angleController) {
		this.angleController = angleController;
	}
	
	/**
	 * Sets the speed and direction of angle controller.
	 * 
	 * @param speed
	 * 				the desired speed and direction to move at
	 */
	public void set(double speed) {
		this.angleController.set(speed * this.maxOutput);
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
		this.angleController.set(0);
		this.angleController.disable();
	}
}
