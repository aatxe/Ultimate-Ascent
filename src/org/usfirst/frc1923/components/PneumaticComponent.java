package org.usfirst.frc1923.components;

import org.usfirst.frc1923.Component;

import edu.wpi.first.wpilibj.Solenoid;

public class PneumaticComponent implements Component {
	private int currentState = Component.ComponentState.COMPONENT_OFF;
	private final Solenoid pneumaticSolenoid;
	
	public PneumaticComponent(int channel) {
		pneumaticSolenoid = new Solenoid(channel);
	}
	
	public PneumaticComponent(int moduleNumber, int channel)  {
		pneumaticSolenoid = new Solenoid(moduleNumber, channel);
	}
	
	public void activate() {
		pneumaticSolenoid.set(true);
		currentState = Component.ComponentState.COMPONENT_ON;
	}
	
	public void deactivate() {
		pneumaticSolenoid.set(false);
		currentState = Component.ComponentState.COMPONENT_OFF;
	}
	
	public void toggle() {
		if (pneumaticSolenoid.get())
			this.deactivate();
		else
			this.activate();
	}
	
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
