package org.usfirst.frc1923.components;
/**
 * Contolls drive gear box
 * @author Bhavish Y. and Pavan Hegde
 * @version 1.0
 * @since 1/22/13
 */
public class DriveGearBox {

	public double[] gears;
	private int gear = 0;
	private DriveComponent drive;

	public DriveGearBox(double[] gears) {
		this.gears = gears;
	}

	public DriveGearBox(int start, int end, int increment, DriveComponent drive) {
		int length = ((end - start) / increment) + 1;
		this.gears = new double[length];
		for (int i = 0; i < length; i++) {
			gears[i] = (start + (i * increment)) / 100;
		}
		this.drive = drive;
	}

	public void setGear(int gear) {
		if (gear != this.gear && gear < gears.length && gear > 0) {
			this.gear = gear;
			System.out.println("Drive Gear changed to: " + gear);
		}
	}

	public int getGear() {
		return gear;
	}

	public int gearUp() {
		if (gear < (gears.length)) {
			++gear;
			drive.setMaxOutput(gears[gear]);
		}
		return gear;
	}

	public int gearDown() {
		if (gear < (gears.length)) {
			--gear;
			drive.setMaxOutput(gears[gear]);
		}
		return gear;
	}
	
	public double getSpeed() {
		return gears[gear];
	}
}
