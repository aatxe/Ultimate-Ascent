
package org.usfirst.frc1923;

import org.usfirst.frc1923.utils.Configuration;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The core <code>IterativeRobot</code> for the Ultimate Ascent robot.
 * @author Aaron Weiss, Bhavish Yalamanchi, Pavan Hegde
 * @version 1.0.1
 * @since 1/8/13
 */
public class AscentRobot extends IterativeRobot {
	
	public void robotInit() {
		// TODO: this
	}

	public void disabledInit() {
		// TODO: this
	}

	public void autonomousInit() {
		// TODO: this
	}

	public void teleopInit() {
		// TODO: this
	}

	public void disabledPeriodic() {
		// TODO: this
	}

	public void autonomousPeriodic() {
		// TODO: this
	}

	public void teleopPeriodic() {
		// TODO: this
	}

	public void disabledContinuous() {
		// TODO: this
	}

	public void autonomousContinuous() {
		// TODO: this
	}

	public void teleopContinuous() {
		if (Configuration.EXPERIMENTAL_DRIVE) {
			double forwardMagnitude = Components.leftDriveStick.getCoalescedY();
			double curvature = Components.rightDriveStick.getCoalescedX();
			if ( curvature < 0.1) { //Turns left
				Components.driveSystem.tankDrive(forwardMagnitude, forwardMagnitude - curvature);
			} else if (curvature > 0.1) { //Turns right
				Components.driveSystem.tankDrive(forwardMagnitude + curvature, forwardMagnitude);
			} else {
				Components.driveSystem.tankDrive(forwardMagnitude, forwardMagnitude);
			}
		} else {
			Components.driveSystem.tankDrive(Components.leftDriveStick.getCoalescedY(), Components.rightDriveStick.getCoalescedY());
		}
	}
}