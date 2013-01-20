package org.usfirst.frc1923;

import org.usfirst.frc1923.components.DriveComponent;
import org.usfirst.frc1923.components.DriveGearbox;
import org.usfirst.frc1923.components.Joyfulstick;
import org.usfirst.frc1923.components.MotorComponent;
import org.usfirst.frc1923.components.PneumaticComponent;
import org.usfirst.frc1923.components.ShooterComponent;
import org.usfirst.frc1923.components.ShooterGearbox;
import org.usfirst.frc1923.components.XboxController;
import org.usfirst.frc1923.utils.Coalescor;
import org.usfirst.frc1923.utils.JaguarGroup;
import org.usfirst.frc1923.utils.VictorGroup;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Victor;

/**
 * A grouping of managed system components.
 * @author Aaron Weiss
 * @version 1.0
 * @since 1/12/13
 */
public final class Components {
	public static final Coalescor coalescer = new Coalescor();
	public static final Joyfulstick leftStick = new Joyfulstick(1);
	public static final Joyfulstick rightStick = new Joyfulstick(2);
	public static final Compressor compressor = new Compressor(12, 0);
	public static final DriveComponent robotDrive = new DriveComponent(new VictorGroup(new Victor(1), new Victor(3)), new VictorGroup(new Victor(2), new Victor(4)));
	public static final DriveGearbox driveGearbox = new DriveGearbox(new double[]{0.5, 0.8, 1.0});
	public static final XboxController operator = new XboxController(3);
	public static final ShooterGearbox shooterGearbox = new ShooterGearbox(0,100, 5, 0, 100, new MotorComponent(0));
	public static final ShooterComponent shooter = new ShooterComponent(new JaguarGroup(new Jaguar(1),new Jaguar(2)), new JaguarGroup(new Jaguar(3), new Jaguar(4)));
	public static final PneumaticComponent solenoid = new PneumaticComponent(1,2);
}
