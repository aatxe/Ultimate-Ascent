package org.usfirst.frc1923.components;

import org.usfirst.frc1923.Component;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * A basic pneumatic component with a single <code>Solenoid</code>.
 * @author Aaron Weiss
 * @version 1.0
 * @since 1/9/13
 */
public class PneumaticComponent implements Component {
	private int currentState = Component.ComponentState.COMPONENT_OFF;
	private final Solenoid pneumaticSolenoid;
	
	/**
	 * Creates a new pneumatic component.
	 * @param channel the desired digital channel
	 */
	public PneumaticComponent(int channel) {
		pneumaticSolenoid = new Solenoid(channel);
	}
	
	/**
	 * Creates a new pneumatic component.
	 * @param moduleNumber the number of the digital module
	 * @param channel the desired digital channel
	 */
	
	public PneumaticComponent(int moduleNumber, int channel)  {
		pneumaticSolenoid = new Solenoid(moduleNumber, channel);
	}
	
	/**
	 * Activates the pneumatic component.
	 */
	public void activate() {
		pneumaticSolenoid.set(true);
		currentState = Component.ComponentState.COMPONENT_ON;
	}
	
	/**
	 * Deactivates the pneumatic component.
	 */
	public void deactivate() {
		pneumaticSolenoid.set(false);
		currentState = Component.ComponentState.COMPONENT_OFF;
	}
	
	/**
	 * Toggles the current state of the pneumatic component.
	 */
	public void toggle() {
		if (pneumaticSolenoid.get())
			this.deactivate();
		else
			this.activate();
	}
	
	/**
	 * Sets the current state of electrical component.
	 * @param value the desired value for the component.
	 */
	public void set(boolean value) {
		if (value)
			this.activate();
		else 
			this.deactivate();
	}
	
	public void destroy() {
		pneumaticSolenoid.free();
	}
	
	public int getState() {
		return this.currentState;
	}
}
