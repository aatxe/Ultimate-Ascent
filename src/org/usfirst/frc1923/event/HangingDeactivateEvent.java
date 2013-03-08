package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;

public class HangingDeactivateEvent extends Event{

	public HangingDeactivateEvent() {
		super(true);
	}
	protected void event() {
		Components.hangingSystem.deactivate();
	}

}
