package org.usfirst.frc1923.utils;

import edu.wpi.first.wpilibj.Joystick;

/**
 * A modern joystick with built-in axial coalescors.
 * 
 * @author Aaron Weiss
 * @version 2.0
 */
public class EnjoyStick extends Joystick {
	private final Coalescor xCoalescor;
	private final Coalescor yCoalescor;
	private final Coalescor zCoalescor;

	/**
	 * Creates an <code>EnjoyStick</code>.
	 * 
	 * @param port
	 * 				the port of the joystick
	 */
	public EnjoyStick(int port) {
		super(port);
		this.xCoalescor = new Coalescor(this.getX());
		this.yCoalescor = new Coalescor(this.getY());
		this.zCoalescor = new Coalescor(this.getZ());
	}

	/**
	 * Creates an <code>EnjoyStick</code>.
	 * 
	 * @param port
	 * 				the port of the joystick
	 * @param epsilon
	 * 				the rate of change for the coalescors
	 */
	public EnjoyStick(int port, int epsilon) {
		super(port);
		this.xCoalescor = new Coalescor(this.getX(), epsilon);
		this.yCoalescor = new Coalescor(this.getY(), epsilon);
		this.zCoalescor = new Coalescor(this.getZ(), epsilon);
	}

	/**
	 * Gets the coalescor-controlled x-axis value.
	 * 
	 * @return the x-axis value
	 */
	public double getCoalescedX() {
		return this.xCoalescor.coalesce(this.getX());
	}

	/**
	 * Gets the coalescor-controlled y-axis value.
	 * 
	 * @return the y-axis value
	 */
	public double getCoalescedY() {
		return this.yCoalescor.coalesce(this.getY());
	}

	/**
	 * Gets the coalescor-controlled z-axis value.
	 * 
	 * @return the z-axis value
	 */
	public double getCoalescedZ() {
		return this.zCoalescor.coalesce(this.getZ());
	}

	/**
	 * Gets coalescor-controlled axial value.
	 * 
	 * @param axis
	 * 				the type of axis to get
	 * @return the value of the axis
	 */
	public double getAxis(Joystick.AxisType axis) {
		if (axis.value == Joystick.AxisType.kX.value)
			return this.xCoalescor.coalesce(super.getAxis(axis));
		else if (axis.value == Joystick.AxisType.kY.value)
			return this.yCoalescor.coalesce(super.getAxis(axis));
		else if (axis.value == Joystick.AxisType.kZ.value)
			return this.zCoalescor.coalesce(super.getAxis(axis));
		else
			return -2;
	}
}
