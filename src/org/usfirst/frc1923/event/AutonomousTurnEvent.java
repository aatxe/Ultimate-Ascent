package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;
import org.usfirst.frc1923.utils.DefaultConfiguration;

import edu.wpi.first.wpilibj.Gyro;

public class AutonomousTurnEvent extends Event {
	private final double speed, angle;
	private final Gyro g;
	
	/**
	 * Creates the event.
	 * @param speed
	 * 				the speed to drive at
	 * @param angle
	 * 				the angle to turn
	 */
	public AutonomousTurnEvent(double speed, double angle) {
		super();
		this.speed = speed;
		this.angle = angle;
		this.g = Components.gyro;
	}
	
	protected void event() {
		while (!closeness(g.getAngle(), angle, Components.preferences.getDouble("shooter_aiming_margin", DefaultConfiguration.SHOOTER_AIMING_MARGIN))) {
			if (g.getAngle() > angle)
				Components.driveSystem.drive(speed, -speed);
			else
				Components.driveSystem.drive(-speed, speed);
		}
	}
	
	private boolean closeness(double a, double b, double margin) {
		return (a > b - margin) && (a < b + margin);
	}
}
