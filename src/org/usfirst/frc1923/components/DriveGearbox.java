package org.usfirst.frc1923.components;

/**
 * The gearbox for controlling the drive train's speed.
 * @author Bhavish Yalamanchi, Aaron Weiss
 * @version 1.5
 * @since 1/27/13
 */
public class DriveGearbox {
	public double[] gears;
	private int gear = 0;
	private DriveComponent driveComponent;

	/**
	 * Creates a gearbox with the desired set of gears.
	 * @param gears an array of gear values
	 */
	public DriveGearbox(double[] gears) {
		this.gears = gears;
	}

	/**
	 * Creates a gearbox with a populated set of gears within the specific range.
	 * @param start the start of the range
	 * @param end the end of the range
	 * @param increment the desired increment
	 * @param driveComponent the desired <code>DriveComponent</code> to manage
	 */
	public DriveGearbox(int start, int end, int increment, DriveComponent driveComponent) {
		int length = ((end - start) / increment) + 1;
		this.gears = new double[length];
		for (int i = 0; i < length; i++) {
			gears[i] = (start + (i * increment)) / 100;
		}
		this.driveComponent = driveComponent;
	}

	/**
	 * Sets the desired gear to use.
	 * @param gear the value of the gear
	 */
	public void setGear(int gear) {
		if (gear != this.gear && gear < gears.length && gear > 0) {
			this.gear = gear;
			driveComponent.setMaxOutput(this.gears[gear]);
		}
	}

	/**
	 * Gets the current gear in use.
	 * @return the current drive gear
	 */
	public int getGear() {
		return this.gear;
	}

	/**
	 * Gears the drive system up by one.
	 */
	public void gearUp() {
		this.setGear(this.gear + 1);
	}

	/**
	 * Gears the drive system down by one.
	 */
	public void gearDown() {
		this.setGear(this.gear - 1);
	}
	
	/**
	 * Gets the current speed of the drive system.
	 * @return the current speed of the drive gear
	 */
	public double getSpeed() {
		return this.getSpeed(this.gear);
	}
	
	/**
	 * Gets the speed of the desired gear.
	 * @param gear the gear to check the speed of
	 * @return the speed of the specified gear
	 */
	public double getSpeed(int gear) {
		return this.gears[gear];
	}
}