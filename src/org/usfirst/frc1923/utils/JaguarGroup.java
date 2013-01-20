package org.usfirst.frc1923.utils;

import java.util.Vector;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
/**
 * @author Bhavish Yalamanchi, Olu Olurade
 * @version 1.0
 * @since 1/19/13
*/
public class JaguarGroup implements SpeedController {
	private final Vector vector = new Vector();

	/**
	 * Creates a jaguar group with one initial jaguar.
	 * 
	 * @param jaguarOne
	 *            The first jaguar of the group.
	 */
	public JaguarGroup(Jaguar jaguarOne) {
		vector.addElement(jaguarOne);
	}

	/**
	 * Creates a jaguar group with two initial jaguars.
	 * 
	 * @param jaguarOne
	 *            The first jaguar of the group.
	 * @param jaguarTwo
	 *            The second jaguar of the group.
	 */
	public JaguarGroup(Jaguar jaguarOne, Jaguar jaguarTwo) {
		vector.addElement(jaguarOne);
		vector.addElement(jaguarTwo);
	}

	/**
	 * Creates jaguar group with three initial jaguars.
	 * 
	 * @param jaguarOne
	 *            The first jaguar of the group.
	 * @param jaguarTwo
	 *            The second jaguar of the group.
	 * @param jaguarThree
	 *            The third jaguar of the group.
	 */
	public JaguarGroup(Jaguar jaguarOne, Jaguar jaguarTwo, Jaguar jaguarThree) {
		vector.addElement(jaguarOne);
		vector.addElement(jaguarTwo);
		vector.addElement(jaguarThree);
	}

	public void pidWrite(double output) {
		System.out.println(((Jaguar) (vector.elementAt(0))).get());
	}

	public double get() {
		return ((Jaguar) (vector.elementAt(0))).get();
	}

	/**
	 * @deprecated
	 */
	public void set(double speed, byte syncGroup) {
		for (int i = 0; i < vector.size(); i++) {
			((Jaguar) (vector.elementAt(i))).set(speed, syncGroup);

		}

	}

	public void set(double speed) {
		for (int i = 0; i < vector.size(); i++) {
			((Jaguar) (vector.elementAt(i))).set(speed);

		}

	}

	public void disable() {
		for (int i = 0; i < vector.size(); i++) {
			((Jaguar) (vector.elementAt(i))).disable();
		}
	}
}
