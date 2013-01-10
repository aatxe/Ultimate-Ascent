package org.usfirst.frc1923.components;

import org.usfirst.frc1923.Component;

import edu.wpi.first.wpilibj.DigitalOutput;

public class ElectricalComponent implements Component {
	private int currentState = Component.ComponentState.COMPONENT_OFF;
	private final DigitalOutput digitalOutput;

	public int getState() {
		return this.currentState;
	}

	public ElectricalComponent(int channel) {
		digitalOutput = new DigitalOutput(channel);
	}

	public ElectricalComponent(int moduleNumber, int channel) {
		digitalOutput = new DigitalOutput(moduleNumber, channel);
	}

	public void activate() {
		digitalOutput.set(true);
		currentState = Component.ComponentState.COMPONENT_ON;
	}

	public void deactivate() {
		digitalOutput.set(false);
		currentState = Component.ComponentState.COMPONENT_OFF;
	}

	public void set(boolean value) {
		if (value)
			this.activate();
		else
			this.deactivate();
	}

	public void toggle() {
		if (currentState == Component.ComponentState.COMPONENT_ON)
			this.deactivate();
		else
			this.activate();
	}

	public void destroy() {
		digitalOutput.free();
	}

}
