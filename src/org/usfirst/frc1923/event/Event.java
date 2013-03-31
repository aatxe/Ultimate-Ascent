package org.usfirst.frc1923.event;

/**
 * An abstract, <code>Runnable</code> robot event.
 * 
 * @author Aaron Weiss
 * @version 2.0
 * @since 2/9/13
 */
public abstract class Event implements Runnable {
	private boolean run = false, ran = false;
	private final boolean oneTimeOnly;

	/**
	 * Creates an event that is not one time only.
	 */
	protected Event() {
		this(false);
	}

	/**
	 * Creates an event.
	 * @param oneTimeOnly
	 * 				whether or not to run it only once
	 */
	protected Event(boolean oneTimeOnly) {
		this.oneTimeOnly = oneTimeOnly;
	}

	/**
	 * Starts the event.
	 */
	public void start() {
		this.run = true;
		new Thread(this).start();
	}

	/**
	 * Runs the event.
	 */
	public void run() {
		while (this.run) {
			if (this.oneTimeOnly && !this.ran) {
				this.event();
				this.ran = true;
			} else if (!this.oneTimeOnly) {
				this.event();
			}
		}
	}

	public boolean alive() {
		return !this.run || this.ran;
	}

	/**
	 * Performs the event's contents.
	 */
	protected abstract void event();

	/**
	 * Stops the event.
	 */
	public void stop() {
		this.run = false;
	}
}