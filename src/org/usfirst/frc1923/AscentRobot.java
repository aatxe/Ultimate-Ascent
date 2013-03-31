package org.usfirst.frc1923;

import org.usfirst.frc1923.event.DriveGearDownEvent;
import org.usfirst.frc1923.event.DriveGearUpEvent;
import org.usfirst.frc1923.event.HangingActivateEvent;
import org.usfirst.frc1923.event.HangingDeactivateEvent;
import org.usfirst.frc1923.event.RingLightToggleEvent;
import org.usfirst.frc1923.event.ShooterActuatorEvent;
import org.usfirst.frc1923.event.ShooterAngleControllerActivateEvent;
import org.usfirst.frc1923.event.ShooterAngleControllerDeactivateEvent;
import org.usfirst.frc1923.event.ShooterGearDownEvent;
import org.usfirst.frc1923.event.ShooterGearUpEvent;
import org.usfirst.frc1923.event.ShooterStartEvent;
import org.usfirst.frc1923.event.ShooterStopEvent;
import org.usfirst.frc1923.event.TargetingEvent;
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
import org.usfirst.frc1923.utils.XboxController;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.NIVisionException;
import org.usfirst.frc1923.utils.Dashboard;
<<<<<<< HEAD
=======
import org.usfirst.frc1923.utils.DashboardUpdater;
>>>>>>> Changes from Lenape.

/**
 * The core <code>IterativeRobot</code> for the Ultimate Ascent robot.
 * 
 * @author Aaron Weiss, Pavan Hegde 
 * @version 2.0
 * @since 2/9/13
 */
public class AscentRobot extends IterativeRobot {
	private AutonomousRoutine autonomousRoutine;
<<<<<<< HEAD
	private boolean[] justPressed = new boolean[14];
	private boolean[] triggers = new boolean[4];
	private boolean attachment = false;

	private boolean snakeDrive;
	private boolean shooterAlwaysOn;
	private boolean compressorOn;

=======
        private DashboardUpdater updater;
	private boolean[] justPressed = new boolean[14];
	private boolean[] triggers = new boolean[4];
	private boolean attachment = false;
        
        public XboxController xbc;
        
        private int autonShooterGear;
        private boolean snakeDrive;
        private boolean shooterAlwaysOn;
        private boolean compressorOn;
        
>>>>>>> Changes from Lenape.
	/**
	 * Initializes the robot.
	 */
	public void robotInit() {
<<<<<<< HEAD
		// Components.networkTable.putBoolean("~S A V E~", true);
		resolution();
		int pulseRate = Components.preferences.getInt("pulse_rate", DefaultConfiguration.PULSE_RATE);
		double gearRatio = Components.preferences.getDouble("gear_ratio", DefaultConfiguration.GEAR_RATIO);
		String alliance = Components.preferences.getString("alliance_color", DefaultConfiguration.ALLIANCE_COLOR);
		Components.driveEncoderLeft.setDistancePerPulse(pulseRate * gearRatio);
=======
            updater = new DashboardUpdater();
            xbc = Components.operatorController;
            // Components.networkTable.putBoolean("~S A V E~", true);
		//resolution();
		int pulseRate = Components.preferences.getInt("pulse_rate", DefaultConfiguration.PULSE_RATE);
		double gearRatio = Components.preferences.getDouble("gear_ratio", DefaultConfiguration.GEAR_RATIO);
		String alliance = Components.preferences.getString("alliance_color", DefaultConfiguration.ALLIANCE_COLOR);
                Components.driveEncoderLeft.setDistancePerPulse(pulseRate * gearRatio);
>>>>>>> Changes from Lenape.
		Components.driveEncoderRight.setDistancePerPulse(pulseRate * gearRatio);
		Components.driveEncoderLeft.reset();
		Components.driveEncoderRight.reset();
		Components.gyro.setSensitivity(Components.preferences.getDouble("gyro_sensitivity", DefaultConfiguration.GYRO_SENSITIVITY));
		Components.gyro.reset();
<<<<<<< HEAD
		this.compressorOn = Components.preferences.getBoolean("compressor_on", DefaultConfiguration.COMPRESSOR_ON);
		if (alliance.equals("red")) {
			Components.redAllianceUnderglow.set(Relay.Value.kOn);
			Components.blueAllianceUnderglow.set(Relay.Value.kOff);
		} else {
			Components.redAllianceUnderglow.set(Relay.Value.kOff);
			Components.blueAllianceUnderglow.set(Relay.Value.kOn);
		}
	}

	/**
	 * Initializes the robot for disabled.
	 * Safely stops everything to prevent it from running upon restart.
	 */
	public void disabledInit() {
		resolution();
		Components.driveGearbox.setGear(0);
		Components.shooterGearbox.setGear(0);
		Components.driveSystem.stop();
		Components.shooterSystem.stop();
		Components.driveEncoderLeft.reset();
		Components.driveEncoderRight.reset();
		Components.gyro.reset();
	}

	/**
=======
                this.compressorOn = Components.preferences.getBoolean("compressor_on", DefaultConfiguration.COMPRESSOR_ON);
                if (alliance.equals("red")) {
                    Components.redAllianceUnderglow.set(Relay.Value.kOn);
                    Components.blueAllianceUnderglow.set(Relay.Value.kOff);
                } else {
                    Components.redAllianceUnderglow.set(Relay.Value.kOff);
                    Components.blueAllianceUnderglow.set(Relay.Value.kOn);
                }
	}

	/**
	 * Initializes the robot for disabled.
	 * Safely stops everything to prevent it from running upon restart.
	 */
	public void disabledInit() {
		//resolution();
		Components.driveGearbox.setGear(1);
		Components.shooterGearbox.setGear(Components.preferences.getInt("shooter_starting_gear", DefaultConfiguration.SHOOTER_STARTING_GEAR));
		Components.driveSystem.stop();
		Components.shooterSystem.stop();
		Components.driveEncoderLeft.reset();
		Components.driveEncoderRight.reset();
		Components.gyro.reset();
                updater.stop();
	}

	/**
>>>>>>> Changes from Lenape.
	 * Provides periodic functionality while disabled.
	 */
	public void disabledPeriodic() {
		// Nothing to see here.
	}

	/**
	 * Launches the desired autonomous routine.
	 */
	public void autonomousInit() {
<<<<<<< HEAD
		this.snakeDrive = Components.preferences.getBoolean("experimental_drive", DefaultConfiguration.EXPERIMENTAL_DRIVE);
		this.shooterAlwaysOn = Components.preferences.getBoolean("shooter_always_on", DefaultConfiguration.SHOOTER_ALWAYS_ON);
		int autonProgram = Components.preferences.getInt("auton_program", DefaultConfiguration.AUTON_PROGRAM);

		switch (autonProgram) {
		case 1:

			autonomousRoutine = new AlphaRoutine();
=======
	this.autonShooterGear = Components.preferences.getInt("auton_shooter_gear", DefaultConfiguration.AUTON_SHOOTER_GEAR);
        this.snakeDrive = Components.preferences.getBoolean("experimental_drive", DefaultConfiguration.EXPERIMENTAL_DRIVE);
        this.shooterAlwaysOn = Components.preferences.getBoolean("shooter_always_on", DefaultConfiguration.SHOOTER_ALWAYS_ON);
        int autonProgram = Components.preferences.getInt("auton_program", DefaultConfiguration.AUTON_PROGRAM);
            
            switch (autonProgram) {
		case 1:
	
                    autonomousRoutine = new AlphaRoutine();
>>>>>>> Changes from Lenape.
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
<<<<<<< HEAD
			autonomousRoutine.start();
=======
                    autonomousRoutine.start();
>>>>>>> Changes from Lenape.
	}

	/**
	 * Provides periodic autonomous functionality.
	 */
	public void autonomousPeriodic() {
<<<<<<< HEAD
=======
//            dog.feed();
>>>>>>> Changes from Lenape.
		Components.eventBus.next();
	}

	/**
	 * Initializes the robot for teleop.
	 */
	public void teleopInit() {
		attachment = Components.preferences.getBoolean("experimental_drive_attachment", DefaultConfiguration.EXPERIMENTAL_DRIVE_ATTACHMENT);
		Components.driveGearbox.setGear(0);
<<<<<<< HEAD
		Components.shooterGearbox.setGear(0);
	}
=======
		Components.shooterGearbox.setGear(Components.preferences.getInt("shooter_starting_gear", DefaultConfiguration.SHOOTER_STARTING_GEAR));
                new Thread(updater).start();
        }
>>>>>>> Changes from Lenape.

	/**
	 * Provides periodic tele-operated functionality.
	 */
        double forwardMagnitude;
        double curvature;
	public void teleopPeriodic() {
<<<<<<< HEAD
		{ // Driving Scope
			// Direct Driving Controls
			if (this.snakeDrive) {
				double forwardMagnitude = -Components.leftDriveStick.getCoalescedY();
				double curvature = Components.rightDriveStick.getCoalescedX();
=======
            { // Driving Scope
			// Direct Driving Controls
			if (this.snakeDrive) {
				forwardMagnitude = -Components.leftDriveStick.getCoalescedY();
				curvature = Components.rightDriveStick.getCoalescedX();
>>>>>>> Changes from Lenape.
				double attachment = Components.rightDriveStick.getCoalescedZ();
				if (this.attachment && Math.abs(attachment) > 0.1) {
					Components.driveSystem.drive(-attachment, attachment, false);
				} else if (curvature < -0.1) { // Turning left
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

		{ // Shooter Scope
<<<<<<< HEAD
			XboxController xbc = Components.operatorController;
=======
>>>>>>> Changes from Lenape.

			// Right Bumper (RB) -- Gear up
			if (xbc.getButton(XboxController.Button.RB) && !justPressed[XboxController.Button.RB.value]) {
				Components.eventBus.push(new ShooterGearUpEvent());
				justPressed[XboxController.Button.RB.value] = true;
			} else if (!xbc.getButton(XboxController.Button.RB)) {
				justPressed[XboxController.Button.RB.value] = false;
			}

			// Left Bumper (LB) -- Gear down
			if (xbc.getButton(XboxController.Button.LB) && !justPressed[XboxController.Button.LB.value]) {
				Components.eventBus.push(new ShooterGearDownEvent());
				justPressed[XboxController.Button.LB.value] = true;
			} else if (!xbc.getButton(XboxController.Button.LB)) {
				justPressed[XboxController.Button.LB.value] = false;
			}

			// A Button -- Fire shooter (1 disque)
			if (xbc.getButton(XboxController.Button.A) && !justPressed[XboxController.Button.A.value]) {
				Components.eventBus.push(new ShooterActuatorEvent());
                                justPressed[XboxController.Button.A.value] = true;
			} else if (!xbc.getButton(XboxController.Button.A)) {
				justPressed[XboxController.Button.A.value] = false;
			}

			// B Button -- Fire shooter (2 disques)
			if (xbc.getButton(XboxController.Button.B) && !justPressed[XboxController.Button.B.value]) {
				Components.eventBus.push(new ShooterActuatorEvent(2));
				justPressed[XboxController.Button.B.value] = true;
			} else if (!xbc.getButton(XboxController.Button.B)) {
				justPressed[XboxController.Button.B.value] = false;
			}

			// Y Button -- Fire shooter (3 disques)
			if (xbc.getButton(XboxController.Button.Y) && !justPressed[XboxController.Button.Y.value]) {
<<<<<<< HEAD
				Components.eventBus.push(new ShooterActuatorEvent(3));
=======
				Components.eventBus.push(new ShooterActuatorEvent(8));
>>>>>>> Changes from Lenape.
				justPressed[XboxController.Button.Y.value] = true;
			} else if (!xbc.getButton(XboxController.Button.Y)) {
				justPressed[XboxController.Button.Y.value] = false;
			}

			// X Button -- Fire shooter (4 disques)
			if (xbc.getButton(XboxController.Button.X) && !justPressed[XboxController.Button.X.value]) {
				Components.eventBus.push(new ShooterActuatorEvent(4));
				justPressed[XboxController.Button.X.value] = true;
			} else if (!xbc.getButton(XboxController.Button.X)) {
				justPressed[XboxController.Button.X.value] = false;
			}

			// Left Thumb Click -- Auto-aiming
			if (xbc.getButton(XboxController.Button.LeftClick) && !justPressed[XboxController.Button.LeftClick.value]) {
				try {
					Components.eventBus.push(new TargetingEvent());
				} catch (AxisCameraException e) {
					e.printStackTrace();
				} catch (NIVisionException e) {
					e.printStackTrace();
				}
				justPressed[XboxController.Button.LeftClick.value] = true;
			} else if (!xbc.getButton(XboxController.Button.LeftClick)) {
				justPressed[XboxController.Button.LeftClick.value] = false;
			}

			// Right Thumb Click -- Ring Light
			if (xbc.getButton(XboxController.Button.RightClick) && !justPressed[XboxController.Button.RightClick.value]) {
				Components.eventBus.push(new RingLightToggleEvent());
				justPressed[XboxController.Button.RightClick.value] = true;
			} else if (!xbc.getButton(XboxController.Button.RightClick)) {
				justPressed[XboxController.Button.RightClick.value] = false;
			}

			// Shooter state control options
			if (!this.shooterAlwaysOn) {
				// Back -- Stop shooter
				if (xbc.getButton(XboxController.Button.Back) && !justPressed[XboxController.Button.Back.value]) {
					Components.eventBus.push(new ShooterStopEvent());
					justPressed[XboxController.Button.Back.value] = true;
				} else if (!xbc.getButton(XboxController.Button.Back)) {
					justPressed[XboxController.Button.Back.value] = false;
				}

				// Start -- Start shooter
				if (xbc.getButton(XboxController.Button.Start) && !justPressed[XboxController.Button.Start.value]) {
					Components.eventBus.push(new ShooterStartEvent());
					justPressed[XboxController.Button.Start.value] = true;
				} else if (!xbc.getButton(XboxController.Button.Start)) {
					justPressed[XboxController.Button.Start.value] = false;
				}
			} else {
				Components.shooterSystem.set(-1);
			}
		} // End Shooter Scope

		{ // Shooter Angle Scope
<<<<<<< HEAD
			XboxController xbc = Components.operatorController;
=======
>>>>>>> Changes from Lenape.
			if (xbc.getTriggerAxis() > 0.1 && !this.triggers[2]) {
				Components.eventBus.push(new ShooterAngleControllerActivateEvent());
				this.triggers[2] = true;
			} else if (xbc.getTriggerAxis() < -0.1 && !this.triggers[2]) {
				Components.eventBus.push(new ShooterAngleControllerDeactivateEvent());
				this.triggers[2] = true;
			} else if (xbc.getTriggerAxis() < 0.1 && xbc.getTriggerAxis() > -0.1) {
				this.triggers[2] = false;
			}
		} // End Shooter Angle Scope
<<<<<<< HEAD

		{ // Hanging Scope
			XboxController xbc = Components.operatorController;
=======
		
		{ // Hanging Scope
>>>>>>> Changes from Lenape.
			if (xbc.getDPad() > 0.1 && !this.triggers[3]) {
				Components.eventBus.push(new HangingDeactivateEvent());
				this.triggers[3] = true;
			} else if (xbc.getDPad() < -0.1 && !this.triggers[3]) {
				Components.eventBus.push(new HangingActivateEvent());
				this.triggers[3] = true;
			} else if (xbc.getDPad() < 0.1 && xbc.getDPad() > -0.1) {
				this.triggers[3] = false;
			}
		} // End Hanging Scope

		{ // Event Bus Scope
			Components.eventBus.next();
<<<<<<< HEAD
			Dashboard.update();
=======
                        Components.eventBus.clean();
                        System.gc(); // garbage collect now, please?
>>>>>>> Changes from Lenape.
		} // End Event Bus Scope

		{ // Compressor Support Scope
			if (this.compressorOn) {
				if (!Components.compressorSafety.get()) {
					Components.compressor.set(Relay.Value.kOn);
				} else {
					Components.compressor.set(Relay.Value.kOff);
				}
			}
		} // End Compressor Support Scope
	}

	private void resolution() {
<<<<<<< HEAD
		String resolution = Components.preferences.getString("camera_resolution", DefaultConfiguration.CAMERA_RESOLUTION);
=======
		/*String resolution = Components.preferences.getString("camera_resolution", DefaultConfiguration.CAMERA_RESOLUTION);
>>>>>>> Changes from Lenape.
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
<<<<<<< HEAD
		Components.camera.writeCompression(Components.preferences.getInt("camera_compression", DefaultConfiguration.CAMERA_COMPRESSION));
		Components.camera.writeMaxFPS(Components.preferences.getInt("camera_framerate", DefaultConfiguration.CAMERA_FRAMERATE));
	}
=======
                Components.camera.writeCompression(Components.preferences.getInt("camera_compression", DefaultConfiguration.CAMERA_COMPRESSION));
                Components.camera.writeMaxFPS(Components.preferences.getInt("camera_framerate", DefaultConfiguration.CAMERA_FRAMERATE));
                */
        }
>>>>>>> Changes from Lenape.
}
