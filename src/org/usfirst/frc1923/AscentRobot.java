
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
	 * Everything using Jaguars should stay here temporarily
	 */

	Components components = new Components();

	JaguarGroup driveGroupLeft = new JaguarGroup(new Jaguar(1), new Jaguar(2));
	JaguarGroup driveGroupRight = new JaguarGroup(new Jaguar(3), new Jaguar(4));
	JaguarGroup shooterGroupLeft = new JaguarGroup(new Jaguar(5), new Jaguar(6));
	JaguarGroup shooterGroupRight = new JaguarGroup(new Jaguar(7), new Jaguar(8));
	
	MotorComponent motorComponent = new MotorComponent(1,1);
	ShooterGearbox shooterGearBox = new ShooterGearbox(0,100, 5, 0, 100, motorComponent);
	ShooterComponent shooter = new ShooterComponent(shooterGroupLeft, shooterGroupRight);
	
	DriveComponent drive = new DriveComponent(driveGroupLeft, driveGroupRight);
	DriveGearbox driveGearBox = new DriveGearbox(0, 100, 5, drive);
	
	HumanDriver driver = new HumanDriver(components);
	
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