package org.usfirst.frc1923;

import org.usfirst.frc1923.components.DriveComponent;
import org.usfirst.frc1923.components.DriveGearbox;
import org.usfirst.frc1923.components.PneumaticComponent;
import org.usfirst.frc1923.components.ShooterComponent;
import org.usfirst.frc1923.components.ShooterGearbox;
import org.usfirst.frc1923.utils.Configuration;
import org.usfirst.frc1923.utils.Joyfulstick;
import org.usfirst.frc1923.utils.MotorGroup;
import org.usfirst.frc1923.utils.XboxController;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;


/**
 * A grouping of managed system components.
 * @author Aaron Weiss, Pavan Hegde, Bhavish Yalamanchi
 * @version 1.3
 * @since 1/12/13
 */
public final class Components {
	private static final SpeedController driveLeftOne = new Victor(1), driveLeftTwo = new Victor(2);
	private static final SpeedController driveRightOne = new Victor(3), driveRightTwo = new Victor(4);
	public static final SpeedController shooterAngleController = new Victor(9);
	public static final MotorGroup shooterAngleGroup = new MotorGroup(shooterAngleController);
	public static final MotorGroup driveGroupLeft = new MotorGroup(driveLeftOne, driveLeftTwo);
	public static final MotorGroup driveGroupRight = new MotorGroup(driveRightOne, driveRightTwo);
	public static final DriveComponent driveSystem = new DriveComponent(driveGroupLeft, driveGroupRight);
	public static final DriveGearbox driveGears = new DriveGearbox(Configuration.DRIVE_GEARS, driveSystem);
	private static final SpeedController shooterLeftOne = new Victor(5), shooterLeftTwo = new Victor(6);
	private static final SpeedController shooterRightOne = new Victor(7), shooterRightTwo = new Victor(8);
	public static final MotorGroup shooterGroupLeft = new MotorGroup(shooterLeftOne, shooterLeftTwo);
	public static final MotorGroup shooterGroupRight = new MotorGroup(shooterRightOne, shooterRightTwo);
	public static final ShooterComponent shooter = new ShooterComponent(shooterGroupLeft, shooterGroupRight);
	public static final ShooterGearbox shooterGears = new ShooterGearbox(Configuration.SHOOTER_GEARS_LEFT, Configuration.SHOOTER_GEARS_RIGHT, shooter);
	public static final PneumaticComponent pistonShooterFeeder = new PneumaticComponent(2); 
	public static final Joyfulstick leftDriveStick = new Joyfulstick(1, Configuration.EPSILON);
	public static final Joyfulstick rightDriveStick = new Joyfulstick(2, (Configuration.EXPERIMENTAL_DRIVE) ? 0.001 : Configuration.EPSILON);
	public static final XboxController controller = new XboxController(3);
}