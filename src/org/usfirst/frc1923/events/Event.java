package org.usfirst.frc1923.events;

/**
 * A basic interface for robot events.
 * @author Aaron Weiss
 * @version 1.0
 * @since 1/12/13
 */
public interface Event extends Runnable {
	/**
	 * Resets everything required to execute the event.
	 */
	public void reset();
}
