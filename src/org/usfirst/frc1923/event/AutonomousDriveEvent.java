package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;
import org.usfirst.frc1923.utils.DefaultConfiguration;

public class AutonomousDriveEvent extends Event {	
	private final double circumference;
	private final double speed, distance;
	
	/**
	 * Creates the event.
	 * @param speed
	 * 				the speed to drive at
	 * @param distance
	 * 				the distance to cover
	 */
	public AutonomousDriveEvent(double speed, double distance) {
		super();
		this.circumference = Components.preferences.getDouble("wheel_circumference", DefaultConfiguration.WHEEL_CIRCUMFERENCE);
		this.speed = speed;
		this.distance = distance;
	}
	
	protected void event() {
		boolean left = (Components.driveEncoderLeft.getDistance() * circumference) < distance;
		boolean right = (Components.driveEncoderRight.getDistance() * circumference) < distance;
		double diff = (Components.driveEncoderRight.getDistance() * circumference) - (Components.driveEncoderLeft.getDistance() * circumference);
		double diffSpeed = speed * ((diff * 2) / distance);
		while (left || right) {
			if (left && right) {
				Components.driveSystem.drive(speed + diffSpeed, speed);
			} else if (left && !right) {
				Components.driveSystem.drive(speed + diffSpeed, 0);
			} else if (right && !left) {
				Components.driveSystem.drive(0, speed);
			} else {
				Components.driveSystem.stop();
				this.stop();
			}
		}
	}
}
