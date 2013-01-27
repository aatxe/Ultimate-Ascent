package org.usfirst.frc1923.events;

import org.usfirst.frc1923.components.ShooterComponent;
import org.usfirst.frc1923.components.ShooterGearbox;

/**
 *  An event to handle ShooterComponent
 * @author Pavan Hegde, Nabeel Rangwala
 * @version 1.0
 * @since 1/26/13
 */
public class ShooterStartEvent implements Event {
	private ShooterComponent shooter;
	private ShooterGearbox shooterGearbox;
	
	/**
	 * Creates the event by setting the <code>ShooterComponent</code> and the <code>ShooterGearbox</code>.
	 * @param shooter the desired ShooterComponent 
	 * @param shooterGearbox The desired ShooterGearbox
	 */
	public ShooterStartEvent(ShooterComponent shooter, ShooterGearbox shooterGearbox) {
		this.shooter = shooter;
		this.shooterGearbox = shooterGearbox;
	}
	
	/**
	 * Runs the shooter (left and right)
	 */
	public void run() {
		shooter.set(shooterGearbox.getLeftSpeed(), shooterGearbox.getRightSpeed());
	}
	
	/**
	 * Stops the shooter
	 */
	public void reset() {
		shooter.stop();
	}

}
