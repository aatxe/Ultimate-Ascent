package org.usfirst.frc1923.events;

import org.usfirst.frc1923.components.DriveComponent;
/**
 * An event to handle the tankDrive
 * @author Pavan Hegde, Nabeel Rangwala
 * @version 1.0
 * @since 1/26/13
 */
public class DriveControlEvent implements Event {
	private DriveComponent drive;
	private double leftMag, rightMag;
	/**
	 *  A constructor to create the event
	 * @param left the left magnitude
	 * @param right the right magnitude
	 */
	public DriveControlEvent(double left, double right) {
		this.leftMag = left;
		this.rightMag = right;
	}
	/**
	 * Drives the robot via respective magnitudes
	 */
	public void run() {
		drive.tankDrive(leftMag, rightMag);
	}
	/**
	 *  Destroys the drive component
	 */
	public void reset() {
		drive.destroy();
	}
}
