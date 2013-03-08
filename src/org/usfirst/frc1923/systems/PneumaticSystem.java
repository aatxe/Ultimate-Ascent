package org.usfirst.frc1923.systems;

/**
 * A basic pneumatic system for the robot.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 2/18/13
 */
public abstract class PneumaticSystem implements System {
	private boolean state = false;
	
	/**
	 * Activates the pneumatic system.
	 */
	public abstract void activate();
	
	/**
	 * Deactivates the pneumatic system.
	 */
	public abstract void deactivate();
	
	/**
	 * Sets the state of the pneumatic system.
	 * @param on
	 * 				the state of the pneumatic system
	 */
	public void set(boolean on) {
		if (on)
			this.activate();
		else
			this.deactivate();
	}

	/**
	 * Toggles the state of the pneumatic system.
	 */
	public void toggle() {
		this.set(!this.state);
	}
	
	/**
	 * Completely stops the robot system.
	 */
	public void stop() {
		this.set(false);
	}

}
