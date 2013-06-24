package org.usfirst.frc1923.routines;

import org.usfirst.frc1923.Components;

/**
 * A basic autonomous routine for the robot to perform using events.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 2/14/13
 */
public abstract class AutonomousRoutine implements Runnable {
	private Thread thread, emergencyThread;

	/**
	 * Starts the routine.
	 */
	public void start() {
		thread = new Thread(this);
		emergencyThread = new Thread(new Runnable() {
			public void run() {
				try {
					Thread.sleep(14300);
					stop();
				} catch (InterruptedException e) {
					return;
				}
			}
		});
		emergencyThread.start();
		thread.start();
	}

	/**
	 * Runs the routine.
	 */
	public void run() {
		try {
			routine();
		} catch (InterruptedException e) {
			// made auton not work
			// Components.eventBus.clear();
			return;
		}
	}

	/**
	 * Performs the routine
	 * @throws InterruptedException
	 * 					when the routine takes too long
	 */
	protected abstract void routine() throws InterruptedException;

	/**
	 * Stops the routine immediately.
	 */
	public void stop() {
		thread.interrupt();
		Components.eventBus.clear();
	}
}