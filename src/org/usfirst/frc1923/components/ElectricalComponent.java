package org.usfirst.frc1923.components;

import org.usfirst.frc1923.Component;

import edu.wpi.first.wpilibj.DigitalOutput;

/**
 * A basic electrical component using <code>DigitalOutput</code>.
 * @author Nihar Sidhu
 * @version 1.0
 * @since 1/9/13
 */
public class ElectricalComponent implements Component {
	private int currentState = Component.ComponentState.COMPONENT_OFF;
	private final DigitalOutput digitalOutput;

	/**
	 * Creates a new electrical component.
	 * @param channel the desired digital channel.
	 */
	public ElectricalComponent(int channel) {
		digitalOutput = new DigitalOutput(channel);
	}
	
	/**
	 * Creates a new electrical component.
	 * @param moduleNumber the number of the digital module
	 * @param channel the desired digital channel.
	 */
	public ElectricalComponent(int moduleNumber, int channel) {
		digitalOutput = new DigitalOutput(moduleNumber, channel);
	}

	/**
	 * Activates the electrical component.
	 */
	public void activate() {
		digitalOutput.set(true);
		currentState = Component.ComponentState.COMPONENT_ON;
	}
	
	/**
	 * Deactivates the electrical component.
	 * 
	 */
	public void deactivate() {
		digitalOutput.set(false);
		currentState = Component.ComponentState.COMPONENT_OFF;
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

	/**
	 * Toggles the current state of the pneumatic component.
	 */
	public void toggle() {
		if (currentState == Component.ComponentState.COMPONENT_ON)
			this.deactivate();
		else
			this.activate();
	}

	public void destroy() {
		digitalOutput.free();
	}
	

	public int getState() {
		return this.currentState;
	}
}
