package org.usfirst.frc1923.components;
/**
 * @author Bhavish Yalamanchi
 * @version 1.0
 * @since 1/19/13
 */
public class ShooterGearbox {
	
	private double[] leftGears;
	private double[] rightGears;
	private int leftGear = 0;
	private int rightGear = 0;
	private MotorComponent motor;
	
	public ShooterGearbox(double[] leftGears, double[] rightGears, MotorComponent motor) {
		this.leftGears = leftGears;
		this.rightGears = rightGears;
		this.motor = motor;
	}
	
	public ShooterGearbox(int leftStart, int leftEnd, int increment, int rightStart, int rightEnd, MotorComponent motor) {
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
		this.motor = motor;
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
			motor.set(leftGears[leftGear]);
			System.out.println("Shooter Left geared down to: " + leftGear);
		} else {
			System.out.println("Shooter Left cannot go any lower.");
		}
		return leftGear;
	}
	
	public int rightGearDown() {
		if (rightGear < (rightGears.length - 1)) {
			--rightGear;
			motor.set(rightGears[rightGear]);
			System.out.println("Shooter Right geared down to: " + rightGear);
		} else {
			System.out.println("Shooter Right cannot go any lower");
		}
		return rightGear;
	}
	
	public int leftGearUp() {
		if (leftGear < (leftGears.length - 1)) {
			++leftGear;
			motor.set(leftGears[leftGear]);

			System.out.println("Shooter Left geared up to: " + leftGear);
		} else {
			System.out.println("Shooter Left cannot go any higher.");
		}
		return leftGear;
	}
	
	public int rightGearUp() {
		if (rightGear < (rightGears.length - 1)) {
			++rightGear;
			motor.set(rightGears[leftGear]);
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
