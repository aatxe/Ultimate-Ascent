package org.usfirst.frc1923;

import org.usfirst.frc1923.components.DriveComponent;
import org.usfirst.frc1923.components.ShooterComponent;
import org.usfirst.frc1923.utils.MotorGroup;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;


/**
 * A grouping of managed system components.
 * @author Aaron Weiss, Pavan Hegde, Bhavish Yalamanchi
 * @version 1.0
 * @since 1/12/13
 */
public final class Components {
	private static final SpeedController driveLeftOne = new Jaguar(1), driveLeftTwo = new Jaguar(2);
	private static final SpeedController driveRightOne = new Jaguar(3), driveRightTwo = new Jaguar(4);
	public static final MotorGroup driveGroupLeft = new MotorGroup(driveLeftOne, driveLeftTwo);
	public static final MotorGroup driveGroupRight = new MotorGroup(driveRightOne, driveRightTwo);
	public static final DriveComponent driveSystem = new DriveComponent(driveGroupLeft, driveGroupRight);
	private static final SpeedController shooterLeft = new Jaguar(5), shooterRight = new Jaguar(6);
	public static final MotorGroup shooterGroupLeft = new MotorGroup(shooterLeft);
	public static final MotorGroup shooterGroupRight = new MotorGroup(shooterRight);
	public static final ShooterComponent shooter = new ShooterComponent(shooterGroupLeft, shooterGroupRight);
}