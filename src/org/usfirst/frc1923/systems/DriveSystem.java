package org.usfirst.frc1923.systems;

import org.usfirst.frc1923.Components;
import org.usfirst.frc1923.utils.DefaultConfiguration;
import org.usfirst.frc1923.utils.MotorGroup;

import edu.wpi.first.wpilibj.RobotDrive;

/**
 * A system for controlling the robot's drivetrain.
 * 
 * @author Aaron Weiss
 * @version 1.5
 * @since 2/9/13
 */
public class DriveSystem implements System {
	private RobotDrive robotDrive;
	
	/**
	 * Creates a new drive system.
	 * 
	 * @param leftSide 
	 * 				a <code>MotorGroup</code> of the left side.
	 * @param rightSide
	 * 				a <code>MotorGroup</code> of the right side.
	 */
	public DriveSystem(MotorGroup leftSide, MotorGroup rightSide) {
		this.robotDrive = new RobotDrive(leftSide, rightSide);
	}
	
	/**
	 * Drives the robot according to the set magnitudes.
	 * 
	 * @param leftMagnitude
	 * 				the magnitude for the left side.
	 * @param rightMagnitude
	 * 				the magnitude for the right side.
	 */
	public void drive(double leftMagnitude, double rightMagnitude) {
		double correction = Components.preferences.getDouble("drive_correction", DefaultConfiguration.DRIVE_CORRECTION);
		if (leftMagnitude > 0 && rightMagnitude > 0) 
			this.robotDrive.tankDrive(leftMagnitude, rightMagnitude - correction);
		else if (leftMagnitude < 0 && rightMagnitude < 0)
			this.robotDrive.tankDrive(leftMagnitude - correction, rightMagnitude);
		else 
			this.robotDrive.tankDrive(leftMagnitude, rightMagnitude);
	}
	
	/**
	 * Sets whether or not to use the proper safety channels with the drivetrain.
	 * 
	 * @param enabled
	 * 				whether or not to use the safety channels
	 */
	public void setSafety(boolean enabled) {
		this.robotDrive.setSafetyEnabled(enabled);
	}
	
	/**
	 * Sets the max motor output for the robot system.
	 * 
	 * @param maxOutput
	 *				the systems' new max output.
	 */
	public void setMaxOutput(double maxOutput) {
		this.robotDrive.setMaxOutput(maxOutput);
	}

	/**
	 * Completely stops the robot system.
	 */
	public void stop() {
		this.robotDrive.stopMotor();
	}
}
