package org.usfirst.frc1923.systems;

/**
 * The basic interface for motorized robotic systems.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 2/14/13
 */
public interface MotorizedSystem extends System {
	/**
	 * Sets the max motor output for the robot system.
	 * 
	 * @param maxOutput
	 *				the systems' new max output.
	 */
	public void setMaxOutput(double maxOutput);
}
