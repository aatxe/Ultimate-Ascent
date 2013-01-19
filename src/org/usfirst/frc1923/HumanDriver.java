package org.usfirst.frc1923;

import org.usfirst.frc1923.components.DriveComponent;
import org.usfirst.frc1923.components.Joyfulstick;
import org.usfirst.frc1923.utils.Coalescor;
/**
 * Joysticks provide input to drive the robot
 * @author Aayush Sharma, Olu Olorode
 * @version 1.0
 * @since 1/19/12
 */
public class HumanDriver {

	Coalescor coalescer = new Coalescor();
	Joyfulstick left;
	Joyfulstick right;
	DriveComponent robotDrive;

	public HumanDriver(Joyfulstick left, Joyfulstick right,
			DriveComponent robotDrive) {
		this.left = left;
		this.right = right;
		this.robotDrive = robotDrive;
	}

	public void handleActiveDriving() {
		double leftY = left.getCoalescedY();
		double rightY = right.getCoalescedY();
		robotDrive.tankDrive(leftY, rightY);

	}
	public void stop(){
		robotDrive.destroy();
	}
}
