package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;

public class HangingActivateEvent extends Event {

	public HangingActivateEvent() {
		super(true);
	}
	
	protected void event() {
		Components.hangingSystem.activate();
	}

}
