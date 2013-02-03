package org.usfirst.frc1923;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/**
 * Tells the user the values of the variables
 * @author Keshav Ramesh, Aravind Koneru, Bhavish, Viren Sawant, Pavan Hegde
 * @version 1.0
 * @since 2/3/13
 */
public class Dashboard {
	//initializes everything
	public static void initialize() {
		SmartDashboard.putBoolean("LightStatus", false);
		SmartDashboard.putBoolean("Targeted", false);
		SmartDashboard.putDouble("RightShooterSpeed", 0);
		SmartDashboard.putDouble("LeftShooterSpeed", 0);
		SmartDashboard.putDouble("DriveTrainSpeed", 0);
	}
	
	/**
	 * Updates the Dashboard with the shooter speeds, drive speed, and tageting stuff.gg
	 */
	public void update(){
		SmartDashboard.putDouble("DriveTrainSpeed",Components.driveGears.getSpeed());
		SmartDashboard.putDouble("RightShooterSpeed", Components.shooterGears.getRightSpeed());
		SmartDashboard.putDouble("LeftShooterSpeed", Components.shooterGears.getLeftSpeed());
		//TODO Targeted and LightStatus
		
	}
	
}
