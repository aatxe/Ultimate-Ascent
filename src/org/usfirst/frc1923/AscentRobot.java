
package org.usfirst.frc1923;

import org.usfirst.frc1923.components.DriveComponent;
import org.usfirst.frc1923.components.DriveGearbox;
import org.usfirst.frc1923.components.Joyfulstick;
import org.usfirst.frc1923.components.MotorComponent;
import org.usfirst.frc1923.components.ShooterComponent;
import org.usfirst.frc1923.components.ShooterGearbox;
import org.usfirst.frc1923.components.XboxController;
import org.usfirst.frc1923.utils.JaguarGroup;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;

/**
 * The core <code>IterativeRobot</code> for the Ultimate Ascent robot.
 * 
 * @author Aaron Weiss, Bhavish Yalamanchi
 * @version 1.0.1
 * @since 1/8/13
 */
public class AscentRobot extends IterativeRobot {
	/**
	 * Most of this should me moved to Components.java
	 */
	Joyfulstick left = new Joyfulstick(1);
	Joyfulstick right = new Joyfulstick(2);
	Jaguar one = new Jaguar(1);
	Jaguar two = new Jaguar(2);
	Jaguar three = new Jaguar(3);
	Jaguar four = new Jaguar(4);
	Jaguar five = new Jaguar(5);
	Jaguar six = new Jaguar(6);
	Jaguar seven = new Jaguar(7);
	Jaguar eight = new Jaguar(8);
	JaguarGroup driveGroupLeft = new JaguarGroup(one, two);
	JaguarGroup driveGroupRight = new JaguarGroup(three, four);
	JaguarGroup shooterGroupLeft = new JaguarGroup(five, six);
	JaguarGroup shooterGroupRight = new JaguarGroup(seven, eight);
	MotorComponent motorComponent = new MotorComponent(1,1);
	ShooterGearbox shooterGearBox = new ShooterGearbox(0,100, 5, 0, 100, motorComponent);
	DriveComponent drive = new DriveComponent(driveGroupLeft, driveGroupRight);
	DriveGearbox driveGearBox = new DriveGearbox(0, 100, 5, drive);
	XboxController operator = new XboxController(3);
	ShooterComponent shooter = new ShooterComponent(shooterGroupLeft, shooterGroupRight);
	HumanDriver driver = new HumanDriver(left, right, drive, driveGearBox, operator, shooterGearBox, shooter);

	public void robotInit() {
		new Thread(new Runnable() {
			public void run() {
				while (true) {
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {}
				}
			}
		}).start();
	}

	public void disabledInit() {
		// TODO: this
	}

	public void autonomousInit() {
		// TODO: this
	}

	public void teleopInit() {
		
		System.out.println("Robot Enabled:: Tele-Operated Mode Initialized");
		//Does some more stuff, other classes required
	}

	public void disabledPeriodic() {
		// TODO: this
	}

	public void autonomousPeriodic() {
		// TODO: this
	}

	public void teleopPeriodic() {
		driver.handlePassiveOperating();
	}

	public void disabledContinuous() {
		// TODO: this
	}

	public void autonomousContinuous() {
		// TODO: this
	}

	public void teleopContinuous() {
		driver.handleActiveDriving();
		driver.handleActiveOperating();
		//must also run shooter, class needed
	}
}