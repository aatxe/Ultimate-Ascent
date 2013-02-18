package org.usfirst.frc1923;

import org.usfirst.frc1923.event.DriveGearDownEvent;
import org.usfirst.frc1923.event.DriveGearUpEvent;
import org.usfirst.frc1923.event.HangingActivateEvent;
import org.usfirst.frc1923.event.HangingDeactivateEvent;
import org.usfirst.frc1923.event.ShooterActuatorEvent;
import org.usfirst.frc1923.event.ShooterAngleControllerActivateEvent;
import org.usfirst.frc1923.event.ShooterAngleControllerDeactivateEvent;
import org.usfirst.frc1923.event.ShooterStartEvent;
import org.usfirst.frc1923.event.ShooterStopEvent;
import org.usfirst.frc1923.routines.AlphaRoutine;
import org.usfirst.frc1923.routines.AutonomousRoutine;
import org.usfirst.frc1923.routines.BetaRoutine;
import org.usfirst.frc1923.routines.CharlieRoutine;
import org.usfirst.frc1923.routines.DeltaRoutine;
import org.usfirst.frc1923.routines.EchoRoutine;
import org.usfirst.frc1923.routines.FoxtrotRoutine;
import org.usfirst.frc1923.routines.GammaRoutine;
import org.usfirst.frc1923.routines.HotelRoutine;
import org.usfirst.frc1923.routines.TestRoutine;
import org.usfirst.frc1923.utils.DefaultConfiguration;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.camera.AxisCamera;

/**
 * The core <code>IterativeRobot</code> for the Ultimate Ascent robot.
 * 
 * @author Aaron Weiss, Pavan Hegde 
 * @version 2.0
 * @since 2/9/13
 */
public class AscentRobot extends IterativeRobot {
	private AutonomousRoutine autonomousRoutine;
	private boolean[] justPressed = new boolean[14];
	private boolean[] triggers = new boolean[3];

	/**
	 * Initializes the robot.
	 */
	public void robotInit() {
		// Components.networkTable.putBoolean("~S A V E~", true);
		resolution();
		int pulseRate = Components.preferences.getInt("pulse_rate", DefaultConfiguration.PULSE_RATE);
		double gearRatio = Components.preferences.getDouble("gear_ratio", DefaultConfiguration.GEAR_RATIO);
		Components.driveEncoderLeft.setDistancePerPulse(pulseRate * gearRatio);
		Components.driveEncoderRight.setDistancePerPulse(pulseRate * gearRatio);
		Components.driveEncoderLeft.reset();
		Components.driveEncoderRight.reset();
		Components.gyro.setSensitivity(Components.preferences.getDouble("gyro_sensitivity", DefaultConfiguration.GYRO_SENSITIVITY));
		Components.gyro.reset();
	}

	/**
	 * Initializes the robot for disabled.
	 * Safely stops everything to prevent it from running upon restart.
	 */
	public void disabledInit() {
		resolution();
		Components.driveGearbox.setGear(0);
		Components.shooterModbox.update(0.75);
		Components.driveSystem.stop();
		Components.shooterSystem.stop();
		Components.driveEncoderLeft.reset();
		Components.driveEncoderRight.reset();
		Components.gyro.reset();
	}

	/**
	 * Provides periodic functionality while disabled.
	 */
	public void disabledPeriodic() {
		// Nothing to see here.
	}

	/**
	 * Launches the desired autonomous routine.
	 */
	public void autonomousInit() {
		switch (Components.preferences.getInt("auton_program", DefaultConfiguration.AUTON_PROGRAM)) {
		case 1:
			autonomousRoutine = new AlphaRoutine();
			break;
		case 2:
			autonomousRoutine = new BetaRoutine();
			break;
		case 3:
			autonomousRoutine = new CharlieRoutine();
			break;
		case 4:
			autonomousRoutine = new DeltaRoutine();
			break;
		case 5:
			autonomousRoutine = new EchoRoutine();
			break;
		case 6:
			autonomousRoutine = new FoxtrotRoutine();
			break;
		case 7:
			autonomousRoutine = new GammaRoutine();
			break;
		case 8:
			autonomousRoutine = new HotelRoutine();
			break;
		default:
			autonomousRoutine = new TestRoutine();
			break;
		}
		if (autonomousRoutine != null)
			autonomousRoutine.start();
	}

	/**
	 * Provides periodic autonomous functionality.
	 */
	public void autonomousPeriodic() {
		Components.eventBus.next();
	}

	/**
	 * Initializes the robot for teleop.
	 */
	public void teleopInit() {
		Components.driveGearbox.setGear(0);
		Components.shooterModbox.update(0.75);
	}

	/**
	 * Provides periodic tele-operated functionality.
	 */
	public void teleopPeriodic() {
		{ // Driving Scope
			// Direct Driving Controls
			if (Components.preferences.getBoolean("experimental_drive", DefaultConfiguration.EXPERIMENTAL_DRIVE)) {
				double forwardMagnitude = -Components.leftDriveStick.getCoalescedY();
				double curvature = Components.rightDriveStick.getCoalescedX();
				if (curvature < -0.1) { // Turning left
					Components.driveSystem.drive(-(forwardMagnitude + curvature), -forwardMagnitude, false);
				} else if (curvature > 0.1) { // Turning right
					Components.driveSystem.drive(-forwardMagnitude, -(forwardMagnitude - curvature), false);
				} else { // Going straight
					Components.driveSystem.drive(-forwardMagnitude, -forwardMagnitude, true);
				}
			} else {
				Components.driveSystem.drive(Components.leftDriveStick.getCoalescedY(), Components.rightDriveStick.getCoalescedY());
			}

			// Left Stick Trigger -- Driving gear down
			if (Components.leftDriveStick.getTrigger() && !this.triggers[0]) {
				Components.eventBus.push(new DriveGearDownEvent());
				this.triggers[0] = true;
			} else if (!Components.leftDriveStick.getTrigger()) {
				this.triggers[0] = false;
			}

			// Right Stick Trigger -- Driving gear up
			if (Components.rightDriveStick.getTrigger() && !this.triggers[1]) {
				Components.eventBus.push(new DriveGearUpEvent());
				this.triggers[1] = true;
			} else if (!Components.rightDriveStick.getTrigger()) {
				this.triggers[1] = false;
			}
		} // End Driving Scope

		{ // Shooter Speed Scope
			Components.shooterModbox.update((Components.leftDriveStick.getCoalescedZ() + Components.rightDriveStick.getCoalescedZ()) / 2.0);
		} // End Shooter Speed Scope
		
		{ // Shooter Scope
			// Right Drive Stick - Button 2 - 1 Disque
			if (Components.rightDriveStick.getRawButton(2) && !justPressed[5]) {
				Components.eventBus.push(new ShooterActuatorEvent());
				justPressed[5] = true;
			} else if (!Components.rightDriveStick.getRawButton(2)) {
				justPressed[5] = false;
			}

			// Right Drive Stick - Button 3 - 4 Disques
			if (Components.rightDriveStick.getRawButton(3) && !justPressed[0]) {
				Components.eventBus.push(new ShooterActuatorEvent(4));
				justPressed[0] = true;
			} else if (!Components.rightDriveStick.getRawButton(3)) {
				justPressed[0] = false;
			}

			// Shooter state control options
			if (!Components.preferences.getBoolean("shooter_always_on", DefaultConfiguration.SHOOTER_ALWAYS_ON)) {
				// Right Drive Stick - Button 4 - Stop shooter
				if (Components.rightDriveStick.getRawButton(4) && !justPressed[1]) {
					Components.eventBus.push(new ShooterStopEvent());
					justPressed[1] = true;
				} else if (!Components.rightDriveStick.getRawButton(4)) {
					justPressed[1] = false;
				}

				// Right Drive Stick - Button 5 - Start shooter
				if (Components.rightDriveStick.getRawButton(5) && !justPressed[2]) {
					Components.eventBus.push(new ShooterStartEvent());
					justPressed[2] = true;
				} else if (!Components.rightDriveStick.getRawButton(5)) {
					justPressed[2] = false;
				}
			} else {
				Components.shooterSystem.set(1);
			}
		} // End Shooter Scope

		{ // Shooter Angle Scope
			// Left Drive Stick - Button 4 - Deactivate shooter angle controller.
			if (Components.leftDriveStick.getRawButton(4) && !justPressed[3]) {
				Components.eventBus.push(new ShooterAngleControllerDeactivateEvent());
				justPressed[3] = true;
			} else if (!Components.rightDriveStick.getRawButton(4)) {
				justPressed[3] = false;
			}

			// Left Drive Stick - Button 5 - Activate shooter angle controller.
			if (Components.leftDriveStick.getRawButton(5) && !justPressed[4]) {
				Components.eventBus.push(new ShooterAngleControllerActivateEvent());
				justPressed[4] = true;
			} else if (!Components.rightDriveStick.getRawButton(5)) {
				justPressed[4] = false;
			}
		} // End Shooter Angle Scope

		{ // Hanging Scope
			// Left Drive Stick - Button 3 - Deactivate shooter angle controller.
			if (Components.leftDriveStick.getRawButton(3) && !justPressed[6]) {
				Components.eventBus.push(new HangingActivateEvent());
				justPressed[6] = true;
			} else if (!Components.rightDriveStick.getRawButton(3)) {
				justPressed[6] = false;
			}

			// Left Drive Stick - Button 2 - Activate shooter angle controller.
			if (Components.leftDriveStick.getRawButton(2) && !justPressed[7]) {
				Components.eventBus.push(new HangingDeactivateEvent());
				justPressed[7] = true;
			} else if (!Components.rightDriveStick.getRawButton(2)) {
				justPressed[7] = false;
			}
		} // End Hanging Scope

		{ // Event Bus Scope
			Components.eventBus.next();
		} // End Event Bus Scope

		{ // Compressor Support Scope
			if (Components.preferences.getBoolean("compressor_on", DefaultConfiguration.COMPRESSOR_ON)) {
				if (!Components.compressorSafety.get()) {
					Components.compressor.set(Relay.Value.kOn);
				} else {
					Components.compressor.set(Relay.Value.kOff);
				}
			}
		}// End Compressor Support Scope
	}

	private void resolution() {
		String resolution = Components.preferences.getString("camera_resolution", DefaultConfiguration.CAMERA_RESOLUTION);
		if (resolution.equalsIgnoreCase("480p")) {
			Components.camera.writeResolution(AxisCamera.ResolutionT.k640x480);
		} else if (resolution.equalsIgnoreCase("360p")) {
			Components.camera.writeResolution(AxisCamera.ResolutionT.k640x360);
		} else if (resolution.equalsIgnoreCase("240p")) {
			Components.camera.writeResolution(AxisCamera.ResolutionT.k320x240);
		} else if (resolution.equalsIgnoreCase("120p")) {
			Components.camera.writeResolution(AxisCamera.ResolutionT.k160x120);
		} else {
			Components.camera.writeResolution(AxisCamera.ResolutionT.k640x480);
		}
	}
}
