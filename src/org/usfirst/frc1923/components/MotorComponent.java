package org.usfirst.frc1923.components;

import org.usfirst.frc1923.Component;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Victor;

/**
 * A basic motor component with a single <code>Victor</code>.
 * @author Bhavish Yalamanchi
 * @version 1.0
 * @since 1/9/13
 */
public class MotorComponent implements Component {
	private int currentState = Component.ComponentState.COMPONENT_OFF;
	private Jaguar jag;

	/**
	 * Creates a new motor component.
	 * @param channel the desired digital channel
	 */
	public MotorComponent(int channel) {
		jag = new Jaguar(channel);
	}

	/**
	 * Creates a new motor component.
	 * @param moduleNumber the number of the digital module
	 * @param channel the desired digital channel
	 */
	public MotorComponent(int moduleNumber, int channel) {
		jag = new Jaguar(moduleNumber, channel);
	}

	/**
	 * Sets the motor to move forward at a specific speed.
	 * @param speed the desired speed to move at
	 */
	public void forward(int speed) {
		jag.set(speed);
		currentState = Component.ComponentState.COMPONENT_FORWARD;
	}

	/**
	 * Sets the motor to move backwards at a specific speed.
	 * @param speed the desired to move at
	 */
	public void reverse(int speed) {
		jag.set(-speed);
		currentState = Component.ComponentState.COMPONENT_REVERSE;
	}

	/**
	 * Gets the current PWM value of the motor component.
	 * @return the current PWM value of the component
	 */
	public double get() {
		return jag.get();
	}

	/**
	 * Sets the PWM value of the motor component.
	 * @param speed the motor speed between -1.0 and 1.0
	 */
	public void set(double speed) {
		jag.set(speed);
	}

	public void destroy() {
		jag.free();
	}

	public int getState() {
		return this.currentState;
	}
}
