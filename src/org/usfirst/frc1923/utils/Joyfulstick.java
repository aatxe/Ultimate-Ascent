package org.usfirst.frc1923.utils;


import edu.wpi.first.wpilibj.Joystick;


/**
 * A <code>Joystick</code> with a built-in <code>Coalescor</code>.
 * @author Bhavish Yalamanchi, Aayush Sharma, Aaron Weiss
 * @version 1.0
 * @since 1/27/13
 */
public class Joyfulstick extends Joystick {
	private final Coalescor xCoalescor;
	private final Coalescor yCoalescor;
	
	/**
	 * Creates a <code>Joystick</code> with two default coalescors.
	 * @param port the port the joystick is connected to
	 */
	public Joyfulstick(int port){
		super(port);
		this.xCoalescor = new Coalescor();
		this.yCoalescor = new Coalescor();
	}
	
	/**
	 * Creates a <code>Joystick</code> with two coalescors with configured epsilon values.
	 * @param port the port the joystick is connected to
	 * @param epsilon the value of change for the coalescors
	 */
	public Joyfulstick(int port, double epsilon){
		super(port);
		this.xCoalescor = new Coalescor(epsilon);
		this.yCoalescor = new Coalescor(epsilon);
	}
	
	/**
	 * Creates a <code>Joystick</code> with two default coalescors.
	 * @param port the port the joystick is connected to
	 * @param numAxisTypes the number of axes that it has
	 * @param numButtonTypes the number of buttons that it has
	 */
	public Joyfulstick(int port, int numAxisTypes, int numButtonTypes) {
		super(port, numAxisTypes, numButtonTypes);
		this.xCoalescor = new Coalescor();
		this.yCoalescor = new Coalescor();
	}
	
	/**
	 * Creates a <code>Joystick</code> with two coalescors with configured epsilon values.
	 * @param port the port the joystick is connected to
	 * @param numAxisTypes the number of axes that it has
	 * @param numButtonTypes the number of buttons that it has
	 * @param epsilon the value of change for the coalescors
	 */
	public Joyfulstick(int port, int numAxisTypes, int numButtonTypes, double epsilon) {
		super(port, numAxisTypes, numButtonTypes);
		this.xCoalescor = new Coalescor(epsilon);
		this.yCoalescor = new Coalescor(epsilon);
	}
	
	/**
	 * Gets the coalesced value of the x-axis.
	 * @return the coalesced value of the x-axis
	 */
	public double getCoalescedX() {
		return this.xCoalescor.coalesce(super.getX());
	}

	/**
	 * Gets the coalesced value of the y-axis.
	 * @return the coalesced value of the y-axis
	 */
	public double getCoalescedY() {
		return this.yCoalescor.coalesce(super.getY());
	}
	
	/**
	 * Sets the rate of change for the coalescors.
	 * @param epsilon the value of change for the coalescors
	 */
	public void setEpsilon(double epsilon) {
		this.xCoalescor.setEpsilon(epsilon);
		this.yCoalescor.setEpsilon(epsilon);
	}
	
	/**
	 * Gets the current rate of change for the coalescors.
	 * @return the value of change for the coalescors
	 */
	public double getEpsilon(){
		return this.xCoalescor.getEpsilon();
	}

	/**
	 * Gets the current coalesced value of an axis.
	 * @param axis the type of the axis to get
	 * @return the coalesced value of the axis
	 */
	public double getAxis(Joystick.AxisType axis) {
		if (axis.value == Joystick.AxisType.kX.value) 
			return this.xCoalescor.coalesce(super.getAxis(axis));
		else if (axis.value == Joystick.AxisType.kY.value)
			return this.yCoalescor.coalesce(super.getAxis(axis));
		else
			return -2;
	}
}
