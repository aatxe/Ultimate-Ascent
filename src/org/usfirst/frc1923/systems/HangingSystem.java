package org.usfirst.frc1923.systems;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * A system for hanging the robot.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 2/18/13
 */
public class HangingSystem extends PneumaticSystem {
	private Solenoid hangingControllerOne, hangingControllerTwo;
	
	/**
	 * Creates a pneumatic hanging system.
	 *
	 * @param hangingControllerOne
	 * 					the first solenoid for the hanging system
	 * @param hangingControllerTwo
	 * 					the second solenoid for the hanging system
	 */
	public HangingSystem(Solenoid hangingControllerOne, Solenoid hangingControllerTwo) {
		this.hangingControllerOne = hangingControllerOne;
		this.hangingControllerTwo = hangingControllerTwo;
	}

	/**
	 * Activates the pneumatic system.
	 */
	public void activate() {
		this.hangingControllerOne.set(false);
		this.hangingControllerTwo.set(true);
	}

	/**
	 * Deactivates the pneumatic system.
	 */
	public void deactivate() {
		this.hangingControllerTwo.set(false);
		this.hangingControllerOne.set(true);
	}
	
}
