package org.usfirst.frc1923.events;

import org.usfirst.frc1923.components.ShooterComponent;

/**
 * An event to stop the shooter
 * @author Pavan Hegde, Keshav Ramesh
 * @version 1.0
 * @since 1/27/13
 */
public class ShooterStopEvent implements Event {
	private ShooterComponent shooter;
	
	public ShooterStopEvent(ShooterComponent shooter) {
		this.shooter = shooter;
	}
	/**
	 * Stops the shooter
	 */
	public void run() {
		shooter.stop();
	}

	public void reset() {
		//Does shit
	}

}
