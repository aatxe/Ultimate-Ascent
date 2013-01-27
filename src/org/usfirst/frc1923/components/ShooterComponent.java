package org.usfirst.frc1923.components;

import org.usfirst.frc1923.Component;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * A component representing the robot's shooter.
 * @author Pavan Hegde, Aaron Weiss
 * @version 1.4
 * @since 1/26/13
 */
public class ShooterComponent implements Component {
	private int currentState = Component.ComponentState.COMPONENT_OFF;
	private final SpeedController leftController;
	private final SpeedController rightController;
	
	/**
	 * Creates a <code>ShooterComponent</code> with a <code>SpeedController</code> for each wheel.
	 * @param leftController the <code>SpeedController</code> for the left wheel.
	 * @param rightController the <code>SpeedController</code> for the right wheel.
	 */
	public ShooterComponent(SpeedController leftController, SpeedController rightController) {
		this.leftController = leftController;
		this.rightController = rightController;
	}
	
	/**
	 * Sets the speed of the left and right <code>SpeedControllers</code>.
	 * @param leftValue the value for the left shooter controller
	 * @param rightValue the value for the right shooter controller
	 */
	public void set(double leftValue, double rightValue) {
		this.setLeftShooter(leftValue);
		this.setRightShooter(rightValue);
		this.currentState = Component.ComponentState.COMPONENT_ON;
	}
	
	/**
	 * Sets the speed for the left shooter controller.
	 * @param value the desired value to run at
	 */
	protected void setLeftShooter(double value) {
		this.leftController.set(-Math.abs(value));
		this.currentState = Component.ComponentState.COMPONENT_ON;
	}
	
	/**
	 * Sets the speed for the right shooter controller.
	 * @param value the desired value to run at
	 */
	protected void setRightShooter(double value) {
		this.rightController.set(-Math.abs(value));
		this.currentState = Component.ComponentState.COMPONENT_ON;
	}
	
	/**
	 * Disables the left and right <code>SpeedControllers</code>.
	 */
	public void stop() {
		this.leftController.disable();
		this.rightController.disable();
		this.currentState = Component.ComponentState.COMPONENT_OFF;
	}
	
	public int getState() {
		return this.currentState;
	}

	public void destroy() {
		this.stop();
	}
}