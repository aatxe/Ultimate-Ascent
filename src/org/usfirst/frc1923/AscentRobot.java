package org.usfirst.frc1923;

import org.usfirst.frc1923.components.DriveComponent;
import org.usfirst.frc1923.components.Joyfulstick;
import org.usfirst.frc1923.utils.VictorGroup;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Victor;

/**
 * The core <code>IterativeRobot</code> for the Ultimate Ascent robot.
 * @author Aaron Weiss, Bhavish Yalamanchi
 * @version 1.0
 * @since 1/8/13
 */
public class AscentRobot extends IterativeRobot {
	Joyfulstick left = new Joyfulstick(1);
	Joyfulstick right = new Joyfulstick(2);
	Victor one = new Victor(0);
	Victor two = new Victor(0);
	Victor three = new Victor(0);
	Victor four = new Victor(0);
	VictorGroup groupLeft = new VictorGroup(one, two);
	VictorGroup groupRight = new VictorGroup(three, four);
	DriveComponent drive = new DriveComponent(groupLeft, groupRight);
	HumanDriver driver = new HumanDriver(left, right, drive);
    public void robotInit() {
    	// TODO: this
    }
    
    public void disabledInit() {
    	// TODO: this
    }
    
    public void autonomousInit() {
    	// TODO: this
    }
    
    public void teleopInit() {
    	// TODO: this
    	
    
    }
    
    public void disabledPeriodic() {
    	// TODO: this
    }
    
    public void autonomousPeriodic() {
    	// TODO: this
    }

    public void teleopPeriodic() {
    	// TODO: this
    }
    
    public void disabledContinuous() {
    	// TODO: this
    }
    
    public void autonomousContinuous() {
    	// TODO: this
    }
    
    public void teleopContinuous() {
    	// TODO: this
    }
}