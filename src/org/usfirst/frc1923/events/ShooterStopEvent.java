package org.usfirst.frc1923.events;

import org.usfirst.frc1923.components.ShooterComponent;
/**
 * An event to stop the shooter
 * @author Keshav Ramesh, Pavan Hegde
 * @version 1.0
 * @since 1/26/13
 */
public class ShooterStopEvent implements Event {
	private ShooterComponent shooter;
	
	/**
	 * Stops the shooter
	 */
	public void run() {
		shooter.stop();
	}

	public void reset() {
		//Do shit
	}

}
