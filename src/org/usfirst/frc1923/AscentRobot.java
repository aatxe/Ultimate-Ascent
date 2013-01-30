
package org.usfirst.frc1923;

import org.usfirst.frc1923.events.EventBus;
import org.usfirst.frc1923.events.ShooterStartEvent;
import org.usfirst.frc1923.events.ShooterStopEvent;
import org.usfirst.frc1923.utils.Configuration;
import org.usfirst.frc1923.utils.XboxController;

import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * The core <code>IterativeRobot</code> for the Ultimate Ascent robot.
 * @author Aaron Weiss, Bhavish Yalamanchi, Pavan Hegde
 * @version 1.0.1
 * @since 1/8/13
 */
public class AscentRobot extends IterativeRobot {
	private final EventBus eventBus = new EventBus();
	private boolean[] justPressed = new boolean[11];
	
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
		if (Components.controller.getButton(XboxController.Button.A)) {
			
			this.justPressed[XboxController.Button.A.value] = true;
		} else {
			this.justPressed[XboxController.Button.A.value] = false;
		}
		if (Components.controller.getButton(XboxController.Button.B)) {
			
			this.justPressed[XboxController.Button.B.value] = true;
		} else {
			this.justPressed[XboxController.Button.B.value] = false;
		}
		if (Components.controller.getButton(XboxController.Button.X)) {
			
			this.justPressed[XboxController.Button.X.value] = true;
		} else {
			this.justPressed[XboxController.Button.X.value] = false;
		}
		if (Components.controller.getButton(XboxController.Button.Y)) {
			
			this.justPressed[XboxController.Button.Y.value] = true;
		} else {
			this.justPressed[XboxController.Button.Y.value] = false;
		}
		if (Components.controller.getButton(XboxController.Button.RB)) {
			this.eventBus.addEvent(new ShooterStartEvent(Components.shooter, Components.shooterGears));
			this.justPressed[XboxController.Button.RB.value] = true;
		} else {
			this.justPressed[XboxController.Button.RB.value] = false;
		}
		if (Components.controller.getButton(XboxController.Button.LB)) {
			this.eventBus.addEvent(new ShooterStopEvent(Components.shooter));
			this.justPressed[XboxController.Button.LB.value] = true;
		} else {
			this.justPressed[XboxController.Button.LB.value] = false;
		}
		if (Components.controller.getButton(XboxController.Button.RightClick)) {
			
			this.justPressed[XboxController.Button.RightClick.value] = true;
		} else {
			this.justPressed[XboxController.Button.RightClick.value] = false;
		}
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
		this.eventBus.next();
	}
}