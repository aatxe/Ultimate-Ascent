package org.usfirst.frc1923.utils;

import java.util.Vector;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;

/**
 * A group of victors treated as one speed controller.
 * 
 * @author Olu Olorode, Aayush Sharma, Nabeel Rangwala
 * @version 1.0
 * @since 1/12/13
 */
public class VictorGroup implements SpeedController {
	private final Vector vector = new Vector();

	/**
	 * Creates a victor group with one initial victor.
	 * 
	 * @param victorOne
	 *            The first victor of the group.
	 */
	public VictorGroup(Victor victorOne) {
		vector.addElement(victorOne);
	}

	/**
	 * Creates a victor group with two initial victors.
	 * 
	 * @param victorOne
	 *            The first victor of the group.
	 * @param victorTwo
	 *            The second victor of the group.
	 */
	public VictorGroup(Victor victorOne, Victor victorTwo) {
		vector.addElement(victorOne);
		vector.addElement(victorTwo);
	}

	/**
	 * Creates victor group with three initial victors.
	 * 
	 * @param victorOne
	 *            The first victor of the group.
	 * @param victorTwo
	 *            The second victor of the group.
	 * @param victorThree
	 *            The third victor of the group.
	 */
	public VictorGroup(Victor victorOne, Victor victorTwo, Victor victorThree) {
		vector.addElement(victorOne);
		vector.addElement(victorTwo);
		vector.addElement(victorThree);
	}

	public void pidWrite(double output) {
		System.out.println(((Victor) (vector.elementAt(0))).get());
	}

	public double get() {
		return ((Victor) (vector.elementAt(0))).get();
	}

	/**
	 * @deprecated
	 */
	public void set(double speed, byte syncGroup) {
		for (int i = 0; i < vector.size(); i++) {
			((Victor) (vector.elementAt(i))).set(speed, syncGroup);

		}

	}

	public void set(double speed) {
		for (int i = 0; i < vector.size(); i++) {
			((Victor) (vector.elementAt(i))).set(speed);

		}

	}

	public void disable() {
		for (int i = 0; i < vector.size(); i++) {
			((Victor) (vector.elementAt(i))).disable();
		}
	}
}
