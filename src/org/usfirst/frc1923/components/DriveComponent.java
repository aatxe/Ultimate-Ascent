package org.usfirst.frc1923.components;

import org.usfirst.frc1923.Component;
import org.usfirst.frc1923.utils.VictorGroup;

import edu.wpi.first.wpilibj.RobotDrive;

/**
 * A basic component for managing drive commands.
 * @author Aayush Sharma, N00beel Rangwala, Pavan Hegde
 * @version 1.0
 * @since 1/12/13
 */
public class DriveComponent implements Component {
	private int currentState = Component.ComponentState.COMPONENT_STOPPED;
	private RobotDrive roboDrive;
	
	public DriveComponent(VictorGroup leftGroup,VictorGroup rightGroup){
		roboDrive=new RobotDrive(leftGroup,rightGroup);
	}
	/**
	 * Drives the robot in one direction.
	 * @param outputMagnitude The forward component of the output magnitude to send to the motors.
	 * @param curve The rate of turn, constant for different forward speeds.
	 */
	public void drive(double outputMagnitude, double curve){
		roboDrive.drive(outputMagnitude, curve);
	}
	/**
	 * Configure the scaling factor for using RobotDrive 
	 * with motor controllers in a mode other than PercentVbus.
	 * @param maxOutput Multiplied with the output percentage computed by the drive functions.
	 */
	public void setMaxOutput(double maxOutput){
		roboDrive.setMaxOutput(maxOutput);
	}
	/**
	 * Enables safety of robot.
	 * @param enabled A boolean that tells whether or not safety is enabled.
	 */
	public void setSafety(boolean enabled){
		roboDrive.setSafetyEnabled(enabled);
	}
	/**
	 *   Configure the scaling factor for using RobotDrive 
	 *   with motor controllers in a mode other than PercentVbus.
	 */
	public void stopMotor(){
		roboDrive.stopMotor();
	}
	
	public int getState() {
		return this.currentState;
	}

	public void destroy() {
		roboDrive.free();
	}

	
}
