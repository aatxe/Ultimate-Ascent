package org.usfirst.frc1923.utils;

import java.util.Vector;

import edu.wpi.first.wpilibj.SpeedController;

/**
 * A <code>SpeedController</code> that combines multiple motors.
 * 
 * @author Aaron Weiss
 * @verson 2.0
 * @since 2/9/13
 */
public class MotorGroup implements SpeedController {
	private Vector motors = new Vector();
	
	/**
	 * Creates a group with one <code>SpeedController</code>.
	 * @param controllerOne
	 * 				the first <code>SpeedController</code>
	 */
	public MotorGroup(SpeedController controllerOne) {
		this(controllerOne, null);
	}
	
	/**
	 * Creates a group with two <code>SpeedController</code>.
	 * @param controllerOne
	 * 				the first <code>SpeedController</code>
	 * @param controllerTwo
	 * 				the second <code>SpeedController</code>
	 */
	public MotorGroup(SpeedController controllerOne, SpeedController controllerTwo) {
		this(controllerOne, controllerTwo, null);
	}

	/**
	 * Creates a group with three <code>SpeedController</code>.
	 * @param controllerOne
	 * 				the first <code>SpeedController</code>
	 * @param controllerTwo
	 * 				the second <code>SpeedController</code>
	 * @param controllerThree
	 * 				the third <code>SpeedController</code>
	 */
	public MotorGroup(SpeedController controllerOne, SpeedController controllerTwo, SpeedController controllerThree) {
		if (controllerOne != null)
			motors.addElement(controllerOne);
		if (controllerTwo != null)
			motors.addElement(controllerTwo);
		if (controllerThree != null)
			motors.addElement(controllerThree);
	}

	public void pidWrite(double output) {
		for (int i = 0; i < this.motors.size(); i++) {
			((SpeedController) (this.motors.elementAt(i))).pidWrite(output);
		}
	}

	public double get() {
		return ((SpeedController) this.motors.elementAt(0)).get();
	}

	public void set(double speed, byte syncGroup) {
		for (int i = 0; i < this.motors.size(); i++) {
			((SpeedController) this.motors.elementAt(i)).set(speed, syncGroup);
		}
	}

	public void set(double speed) {
		for (int i = 0; i < this.motors.size(); i++) {
			((SpeedController) this.motors.elementAt(i)).set(speed);
		}
	}
	
	public void disable() {
		for (int i = 0; i < this.motors.size(); i++) {
			((SpeedController) this.motors.elementAt(i)).disable();
		}
	}
}
