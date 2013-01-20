package org.usfirst.frc1923.events;

import org.usfirst.frc1923.Component;
import org.usfirst.frc1923.components.PneumaticComponent;
/**
 * An event for actuating pneumatic components.
 * @author Pavan Hegde, Aaron Weiss, Nabeel Rangwala
 * @version 1.0
 * @since 1/20/13
 */
public class PistonActuationEvent implements Event {
	
	private int desiredState;
	private PneumaticComponent pneumaticComponent;
	/**
	 * Creates a piston actuation event
	 * @param desiredState the desired state of the component
	 * @param pneumaticComponent the pneumatic component
	 */
	public PistonActuationEvent(int desiredState, PneumaticComponent pneumaticComponent) {
		this.desiredState = desiredState;
		this.pneumaticComponent = pneumaticComponent;
	}
	
	public void run() {
		switch (desiredState) {
		case Component.ComponentState.COMPONENT_ON:
			pneumaticComponent.activate();
			break;
		case Component.ComponentState.COMPONENT_OFF:
			pneumaticComponent.deactivate();
			break;
		}
	}
	
	public void reset() {
		pneumaticComponent.destroy();
	}

}
