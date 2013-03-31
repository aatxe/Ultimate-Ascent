package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;
import org.usfirst.frc1923.utils.DefaultConfiguration;
import org.usfirst.frc1923.utils.MidknightTargetingComputer;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.NIVisionException;

public class TargetingEvent extends Event {
	private final double angle, speed;
	private final Gyro g;
	
	public TargetingEvent() throws AxisCameraException, NIVisionException {
		super();
<<<<<<< HEAD
		MidknightTargetingComputer.update(Components.camera.getImage());
=======
		//MidknightTargetingComputer.update(Components.camera.getImage());
>>>>>>> Changes from Lenape.
		g = Components.gyro;
		g.reset();
		angle = MidknightTargetingComputer.getTurnAngle();
		System.out.println("Turn Angle: " + angle);
		speed = Components.preferences.getDouble("auton_drive_speed", DefaultConfiguration.AUTON_DRIVE_SPEED);
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
