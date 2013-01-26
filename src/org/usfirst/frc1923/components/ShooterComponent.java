package org.usfirst.frc1923.components;

import org.usfirst.frc1923.utils.MotorGroup;
/**
 *  The shooter component
 * @author Pavan Hegde, Aaron Weiss
 * @version 1.1
 * @since 1/26/13
 */
public class ShooterComponent {
	private MotorGroup left;
	private MotorGroup right;
	private boolean shooterRunning = false;
	/**
	 * A constructor to set the Jaguars and create the shooter component
	 * @param left left Jaguar
	 * @param right right Jaguar
	 */
	public ShooterComponent(MotorGroup left, MotorGroup right) {
		this.left = left;
		this.right = right;
	}
	/**
	 * Sets speed of left JaguarGroup
	 * @param leftSpeed the desired left speed
	 */
	public void runLeft(double leftSpeed) {
		left.set(-Math.abs(leftSpeed));
		shooterRunning = true;
	}
	/**
	 * Sets speed of right JaguarGroup
	 * @param rightSpeed the desired right speed
	 */
	public void runRight(double rightSpeed) {
		right.set(-Math.abs(rightSpeed));
		shooterRunning = true;
	}
	/**
	 * Stops shooter and disables both left and right Jaguars
	 */
	public void stop() {
		left.disable();
		right.disable();
		shooterRunning = false;
	}
	/**
	 * @return state of shooter (running vs. stopped)
	 */
	public boolean isShooterRunning() {
		return shooterRunning;
	}
}