package org.usfirst.frc1923.components;

public class ShooterGearBox {
	
	private double[] leftGears;
	private double[] rightGears;
	private int leftGear = 0;
	private int rightGear = 0;
	private DriveComponent drive;
	
	public ShooterGearBox(double[] leftGears, double[] rightGears, DriveComponent drive) {
		this.leftGears = leftGears;
		this.rightGears = rightGears;
	}
	
	public ShooterGearBox(int leftStart, int leftEnd, int increment, int rightStart, int rightEnd, DriveComponent drive) {
		int leftLength = ((leftEnd - leftStart) / increment) + 1;
		this.leftGears = new double[leftLength];
		for (int i = 0; i < leftLength; i++) {
			leftGears[i] = (leftStart + (i * increment)) / 100;
		}
		int rightLength = ((rightEnd - rightStart) / increment) + 1;
		this.rightGears = new double[rightLength];
		for (int i = 0; i < rightLength; i++) {
			rightGears[i] = (rightStart + (i * increment)) / 100;
		}
		this.drive = drive;
	}

	public int getLeftGear() {
		return leftGear;
	}

	public int getRightGear() {
		return rightGear;
	}
	
	public void setLeftGear(int leftGear) {
		if (leftGear != this.leftGear && leftGear < leftGears.length && leftGear > 0) {
			this.leftGear = leftGear;
			System.out.println("Shooter Left Gear changed to: " + leftGear);
		}
	}

	public void setRightGear(int rightGear) {
		if (rightGear != this.rightGear && rightGear < rightGears.length && rightGear > 0) {
			this.rightGear = rightGear;
			System.out.println("Shooter Right Gear changed to: " + rightGear);
		}
	}
	public int leftGearDown() {
		if (leftGear < (leftGears.length - 1)) {
			--leftGear;
			drive.setMaxOutput(leftGears[leftGear]);
			System.out.println("Shooter Left geared down to: " + leftGear);
		} else {
			System.out.println("Shooter Left cannot go any lower.");
		}
		return leftGear;
	}
	
	public int rightGearDown() {
		if (rightGear < (rightGears.length - 1)) {
			--rightGear;
			drive.setMaxOutput(rightGears[rightGear]);
			System.out.println("Shooter Right geared down to: " + rightGear);
		} else {
			System.out.println("Shooter Right cannot go any lower");
		}
		return rightGear;
	}
	
	public int leftGearUp() {
		if (leftGear < (leftGears.length - 1)) {
			++leftGear;
			drive.setMaxOutput(leftGears[leftGear]);

			System.out.println("Shooter Left geared up to: " + leftGear);
		} else {
			System.out.println("Shooter Left cannot go any higher.");
		}
		return leftGear;
	}
	
	public int rightGearUp() {
		if (rightGear < (rightGears.length - 1)) {
			++rightGear;
			drive.setMaxOutput(rightGears[leftGear]);
			System.out.println("Shooter Right geared up to: " + rightGear);
		} else {
			System.out.println("Shooter Right cannot go any higher.");
		}
		return rightGear;
	}
	
	public double getLeftSpeed() {
		return leftGears[leftGear];
	}
	
	public double getRightSpeed() {
		return rightGears[rightGear];
	}
	
	
}
