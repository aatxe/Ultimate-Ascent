/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc1923.systems;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * A pneumatic system for actuating the shooter piston.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 3/2/13
 */
public class ShooterActuatorSystem extends PneumaticSystem {
   	private Solenoid actuatorControllerOne, actuatorControllerTwo;
	
	/**
	 * Creates a pneumatic shooter actuator.
	 *
	 * @param actuatorControllerOne
	 * 					the first solenoid for the pneumatic shooter actuator
	 * @param actuatorControllerTwo
	 * 					the second solenoid for the pneumatic shooter actuator
	 */
	public ShooterActuatorSystem(Solenoid actuatorControllerOne, Solenoid actuatorControllerTwo) {
		this.actuatorControllerOne = actuatorControllerOne;
		this.actuatorControllerTwo = actuatorControllerTwo;
	}

	/**
	 * Activates the pneumatic system.
	 */
	public void activate() {
		this.actuatorControllerOne.set(false);
		this.actuatorControllerTwo.set(true);
	}

	/**
	 * Deactivates the pneumatic system.
	 */
	public void deactivate() {
		this.actuatorControllerTwo.set(false);
		this.actuatorControllerOne.set(true);
	} 
}
