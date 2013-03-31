package org.usfirst.frc1923;

import org.usfirst.frc1923.systems.DriveSystem;
import org.usfirst.frc1923.systems.HangingSystem;
import org.usfirst.frc1923.systems.ShooterActuatorSystem;
import org.usfirst.frc1923.systems.ShooterAngleSystem;
import org.usfirst.frc1923.systems.ShooterSystem;
import org.usfirst.frc1923.systems.attachments.Gearbox;
import org.usfirst.frc1923.utils.EnjoyStick;
import org.usfirst.frc1923.utils.MotorGroup;
import org.usfirst.frc1923.utils.Preferences;
import org.usfirst.frc1923.utils.XboxController;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;

/**
 * A grouping of managed system components.
 * @author Aaron Weiss, Pavan Hegde, Bhavish Yalamanchi
 * @version 2.0
 * @since 2/9/13
 */
public class Components {
	// Java Setup
	// public static final NetworkTable networkTable = NetworkTable.getTable("midknight");

	public static final Preferences preferences = new Preferences();
	public static final EventBus eventBus = EventBus.getInstance();
	//	public static final AxisCamera camera = AxisCamera.getInstance();

	// Controllers
	public static final EnjoyStick leftDriveStick = new EnjoyStick(1);
	public static final EnjoyStick rightDriveStick = new EnjoyStick(2);
	public static final XboxController operatorController = new XboxController(3);

	// Victors (Speed Controllers)
	public static final Victor leftDriveOne = new Victor(3), leftDriveTwo = new Victor(4);
	public static final Victor rightDriveOne = new Victor(1), rightDriveTwo = new Victor(2);
	public static final Victor leftShooter = new Victor(5);
	public static final Victor rightShooter = new Victor(6);

	// Relays (Spikes)
	public static final Relay compressor = new Relay(7);
	public static final Relay ringLight = new Relay(8);
	public static final Relay redAllianceUnderglow = new Relay(1);
	public static final Relay blueAllianceUnderglow = new Relay(2);

	// Analog Inputs
	public static final Gyro gyro = new Gyro(1);

	// Digital Inputs
	public static final DigitalInput compressorSafety = new DigitalInput(1);
	public static final Encoder driveEncoderLeft = new Encoder(4, 5);
	public static final Encoder driveEncoderRight = new Encoder(2, 3);

	// Pneumatic Solenoids
	public static final Solenoid pneumaticActuatorOne = new Solenoid(1), pneumaticActuatorTwo = new Solenoid(7);
	public static final Solenoid shooterAngleControllerOne = new Solenoid(3), shooterAngleControllerTwo = new Solenoid(4);
	public static final Solenoid hangingControllerOne = new Solenoid(5), hangingControllerTwo = new Solenoid(6);

	// Motor Groups
	public static final MotorGroup leftDriveGroup = new MotorGroup(leftDriveOne, leftDriveTwo);
	public static final MotorGroup rightDriveGroup = new MotorGroup(rightDriveOne, rightDriveTwo);
	public static final MotorGroup leftShooterGroup = new MotorGroup(leftShooter);
	public static final MotorGroup rightShooterGroup = new MotorGroup(rightShooter);

	// Systems
	public static final DriveSystem driveSystem = new DriveSystem(leftDriveGroup, rightDriveGroup);
	public static final ShooterSystem shooterSystem = new ShooterSystem(leftShooterGroup, rightShooterGroup);
	public static final ShooterActuatorSystem shooterActuatorSystem = new ShooterActuatorSystem(pneumaticActuatorOne, pneumaticActuatorTwo);
	public static final ShooterAngleSystem shooterAngleSystem = new ShooterAngleSystem(shooterAngleControllerOne, shooterAngleControllerTwo);
	public static final HangingSystem hangingSystem = new HangingSystem(hangingControllerOne, hangingControllerTwo);

	// System Attachments
	public static final Gearbox driveGearbox = new Gearbox(new double[] { 0.85, 1.0 }, driveSystem);
	public static final Gearbox shooterGearbox = new Gearbox(0.6, 1.0, 0.05, shooterSystem);
}