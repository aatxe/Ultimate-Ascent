package org.usfirst.frc1923.systems;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * A system for controlling the angle of the shooter.
 * 
 * @author Aaron Weiss
 * @version 2.0
 * @since 2/9/13
 */
public class ShooterAngleSystem extends PneumaticSystem {
	private Solenoid angleControllerOne, angleControllerTwo;

	/**
	 * Creates a <code>ShooterAngleSystem</code>.
	 * 
	 * @param angleController
	 * 				the <code>Solenoid</code> to control the angle
	 */
	public ShooterAngleSystem(Solenoid angleControllerOne, Solenoid angleControllerTwo) {
		this.angleControllerOne = angleControllerOne;
		this.angleControllerTwo = angleControllerTwo;
	}

	/**
	 * Activates the pneumatic system.
	 */
	public void activate() {
		this.angleControllerTwo.set(false);
		this.angleControllerOne.set(true);
	}

	/**
	 * Deactivates the pneumatic system.
	 */
	public void deactivate() {
		this.angleControllerOne.set(false);
		this.angleControllerTwo.set(true);
	}

}
