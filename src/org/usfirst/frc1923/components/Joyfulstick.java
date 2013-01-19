package org.usfirst.frc1923.components;

import org.usfirst.frc1923.utils.Coalescor;

import edu.wpi.first.wpilibj.Joystick;

public class Joyfulstick extends Joystick {
	Coalescor coalescor = new Coalescor();
	public Joyfulstick(int port){
		super(port);
	}
	
	public Joyfulstick(int port, double epsilon){
		super(port);
		coalescor = new Coalescor(epsilon);
	}
	
	public Joyfulstick(int port, int numAxisTypes, int numButtonTypes) {
		super(port, numAxisTypes, numButtonTypes);
	}
	
	public Joyfulstick(int port, int numAxisTypes, int numButtonTypes, double epsilon) {
		super(port, numAxisTypes, numButtonTypes);
		coalescor = new Coalescor(epsilon);
	}
	
	public double getCoalescedX() {
		return coalescor.coalesce(super.getX());
	}

	public double getCoalescedY() {
		return coalescor.coalesce(super.getY());
	}
	
	public void setEpsilon(double epsilon) {
		coalescor.setEpsilon(epsilon);
	}
	
	public double getEpsilon(){
		return coalescor.getEpsilon();
	}

	public double getAxis(Joystick.AxisType axis) {
		return coalescor.coalesce(super.getAxis(axis));
	}

	public double getRawAxis(int axis) {
		return coalescor.coalesce(super.getRawAxis(axis));
	}
}
