package org.usfirst.frc1923;

import edu.wpi.first.wpilibj.Victor;

public class MotorComponent implements Component {

	private int currentState = new Component.ComponentState().COMPONENT_OFF;
	private Victor victor;
	
	public MotorComponent(int channel) {
		victor = new Victor(channel);
	}
	
	public MotorComponent(int slot, int channel){
		victor = new Victor(slot, channel);
	}
	
	/**
	 * @return the current state.
	 */
	
	public int getState() {
		return currentState;
	}
	
	
	/**
	 * Sets the motor to forward with a specified speed. 
	 * @param speed
	 */
	
	public void forward(int speed) {
		victor.set(speed);
		currentState = new Component.ComponentState().COMPONENT_FORWARD;
	}
	
	/**
	 * Sets the motor to reverse with a specified speed.
	 * @param speed
	 */
	
	public void reverse(int speed) {
		victor.set(speed);
		currentState = new Component.ComponentState().COMPONENT_REVERSE;
	}
	
	/**
	 * Get the recently set value of the PWM.
	 * @return PWM value
	 */
	
	public double get() {
		return victor.get();
	}
	
	/**
	 *Set the PWM value.
	 * @param speed between -1.0 and 1.0
	 */
	
	public void set(double speed) {
		victor.set(speed);
	}
}
