package org.usfirst.frc1923.components;
/**
 * A class for controlling the Shooter Gearbox.
 * @author Pavan Hegde
 * @version 1.0
 * @since 1/21/13
 */
public class ShooterGearbox {
	
	private double[] leftGearSet, rightGearSet;
	private int leftGearNum, rightGearNum;
	private MotorComponent motorComponent;
	
	/**
	 *  One of two constructors that set the above gear sets and motor component
	 * @param leftGearNum The gear number for the left gear
	 * @param rightGearNum The gear number for the right gear
	 * @param leftGearSet the Left gear set
	 * @param rightGearSet the right gear set
	 * @param motorComponent the motor component
	 */
	public ShooterGearbox(double[] leftGearSet, double[] rightGearSet, MotorComponent motorComponent) {
		this.rightGearSet = rightGearSet;
		this.leftGearSet = leftGearSet;
		this.motorComponent = motorComponent;
	}
	
	/**
	 *  The second of two constructors that set the gear sets
	 * @param leftStart The start of the range for the left
	 * @param leftEnd The end of the range for the left
	 * @param increment The increment used to set the difference.
	 * @param rightStart The end of the range for the right
	 * @param rightEnd The end of the range for the right
	 * @param motorComponent the motor component
	 */
	public ShooterGearbox(int leftStart, int leftEnd, int increment, int rightStart, int rightEnd, MotorComponent motorComponent) {
		int leftLength = ((leftEnd - leftStart) / increment) + 1;
		this.leftGearSet = new double[leftLength];
		for (int i = 0; i < leftLength; i++) {
			leftGearSet[i] = (leftStart + (i * increment)) / 100;
		}
		int rightLength = ((rightEnd - rightStart) / increment) + 1;
		this.rightGearSet = new double[rightLength];
		for (int i = 0; i < rightLength; i++) {
			rightGearSet[i] = (rightStart + (i * increment)) / 100;
		}
		this.motorComponent = motorComponent;
	}
	/**
	 *  Sets the left gear number
	 * @param leftGearNum The gear number for the left
	 */
	public void setLeftGear(int leftGearNum) {
		if (leftGearNum != this.leftGearNum && leftGearNum < leftGearSet.length && leftGearNum > 0) {
			this.leftGearNum = leftGearNum;	
			System.out.println("Shooter leftGear is changed to: " + this.leftGearNum);
		}	
	}
	/**
	 *  Sets the right gear number
	 * @param rightGearNum The gear number for the right
	 */
	public void setRightGear(int rightGearNum) {
		if (rightGearNum != this.rightGearNum && rightGearNum < rightGearSet.length && rightGearNum > 0) {
			this.rightGearNum = rightGearNum;	
			System.out.println("Shooter rightGear is changed to: " + this.rightGearNum);
		}
	}
	/**
	 * @return the left gear number
	 */
	public int getLeftGear() {
		return leftGearNum;
	}
	/**
	 * @return the right gear number
	 */
	public int getRightGear() {
		return rightGearNum;
	}
	/**
	 * Lowers right gear speed by one
	 * @return the new gear number for the right
	 */
	public int rightGearDown () {
		if (rightGearNum < (rightGearSet.length)) {
			--rightGearNum;
			this.motorComponent.set(rightGearSet[rightGearNum]);
		}
		else {
			System.out.println("Right Shooter can't slow down any lower.");
		}
		return rightGearNum;
	}
	/**
	 * Lowers left gear speed by 1
	 * @return the new left gear number.
	 */
	public int leftGearDown () {
		if (leftGearNum < (leftGearSet.length)) {
			--leftGearNum;
			this.motorComponent.set(leftGearSet[leftGearNum]);
			System.out.println("Left Shooter geared down to: " + leftGearNum);
		} else {
			System.out.println("Left Shooter can't slow down any lower.");
		}
		return leftGearNum;
	}
	/**
	 * Raises he right gear number by 1
	 * @return the new right gear number
	 */
	public int rightGearUp() {
		if (rightGearNum < (rightGearSet.length)) {
			++rightGearNum;
			this.motorComponent.set(rightGearSet[rightGearNum]);
			System.out.println("Right Shooter geared up to: " + rightGearNum);
		}
		else {
			System.out.println("Right Shooter can't speed up any more.");
		}
		return rightGearNum;
	}
	/**
	 * Raises the left gear number by 1
	 * @return the new left gear number
	 */
	public int leftGearUp() {
		if (leftGearNum < (leftGearSet.length)) {
			++leftGearNum;
			this.motorComponent.set(leftGearSet[leftGearNum]);
			System.out.println("Left Shooter geared up to: " + leftGearNum);
		}
		else {
			System.out.println("Left Shooter can't speed up any more.");
		}
		return leftGearNum;
	}
	/**
	 * @return Left gear speed
	 */
	public double getLeftSpeed() {
		return leftGearSet[leftGearNum];
	}
	/**
	 * @return Right gear speed
	 */
	public double getRightSpeed() {
		return rightGearSet[rightGearNum];
	}
}