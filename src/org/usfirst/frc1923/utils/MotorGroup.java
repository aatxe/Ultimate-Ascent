package org.usfirst.frc1923.utils;

import java.util.Vector;
import edu.wpi.first.wpilibj.SpeedController;
/**
 * A group of speed controllers treated as one motor
 * @author Pavan Hegde, Keshav Ramesh
 * @version 1.0
 * @since 1/26/13
 */
public class MotorGroup implements SpeedController {
	private final Vector vector = new Vector();
	/**
	 *  A constructor to add elements to the vector
	 * @param speedControllerOne The first speed controller
	 */
	public MotorGroup(SpeedController speedControllerOne) {
		vector.addElement(speedControllerOne);
	}
	/**
	 * A constructor to add the elements to the vector
	 * @param speedControllerOne The first speed controller
	 * @param speedControllerTwo The second speed controller
	 */
	public MotorGroup(SpeedController speedControllerOne, SpeedController speedControllerTwo) {
		vector.addElement(speedControllerOne);
		vector.addElement(speedControllerTwo);
	}
	/**
	 * A constructor to add elements to the vector
	 * @param speedControllerOne the first speed controller
	 * @param speedControllerTwo the second speed controller
	 * @param speedControllerThree the third speed controller
	 */
	public MotorGroup(SpeedController speedControllerOne, SpeedController speedControllerTwo, SpeedController speedControllerThree) {
		vector.addElement(speedControllerOne);
		vector.addElement(speedControllerTwo);
		vector.addElement(speedControllerThree);
	}
	/**
	 * Prints the vector element at 0 (which is a speed controller) on cmd
	 */
	public void pidWrite(double output) {
		System.out.println(((SpeedController) (vector.elementAt(0))).get());
	}
	/**
	 * @return the speed controller element at 0 in the vector
	 */
	public double get() {
		return ((SpeedController) (vector.elementAt(0))).get();
	}
	/**
	 * Sets the speed of the elements
	 * @param speed speed of the motor
	 * @param syncGroup the sync group
	 */
	public void set(double speed, byte syncGroup) {
		for (int i = 0; i < vector.size(); i++) {
			((SpeedController) (vector.elementAt(i))).set(speed, syncGroup);
		}
	}
	/**
	 * Sets the speed of the elements
	 * @param speed the speed of the elements
	 */
	public void set(double speed) {
		for (int i = 0; i < vector.size(); i++) {
			((SpeedController) (vector.elementAt(i))).set(speed);
		}
	}
	/**
	 * Disables each element
	 */
	public void disable() {
		for (int i = 0; i < vector.size(); i++) {
			((SpeedController) (vector.elementAt(i))).disable();
		}
	}

}
