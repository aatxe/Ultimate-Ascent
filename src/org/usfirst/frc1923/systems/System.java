package org.usfirst.frc1923.systems;

/**
 * The basic interface for robotic systems.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 2/9/13
 */
public interface System {
	/**
	 * Sets the max motor output for the robot system.
	 * 
	 * @param maxOutput
	 *				the systems' new max output.
	 */
	public void setMaxOutput(double maxOutput);
	
	/**
	 * Completely stops the robot system.
	 */
	public void stop();
}
