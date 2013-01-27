package org.usfirst.frc1923.utils;

/**
 * A class to gradually increase a value to another value.
 * @author Bhavish Y., Aaron Weiss
 * @version 1.0
 * @since 1/27/13
 */
public class Coalescor {

	private double startValue;
	private double epsilon = 0.08;
	
	/**
	 * Creates a <code>Coalescor</code> by setting the start value to 0
	 */
	public Coalescor() {
		this.startValue = 0;
	}
	
	/**
	 * Creates a <code>Coalescor</code> by setting the start value to the desired value
	 * @param startValue the desired start value
	 */
	public Coalescor(double startValue) {
		this.startValue = startValue;
	}
	
	/**
	 * Increase the start value by <code>epsilon</code>.
	 * @param x a double
	 * @return a double?
	 */
	public double coalesce(double x) {
		if (x > startValue) {
			if (startValue + epsilon > x) {
				startValue = x;
			} else if (startValue + epsilon < x) {
				startValue = startValue + epsilon;
			}
		} else if (x < startValue) {
			if (startValue - epsilon < x) {
				startValue = x;
			} else if (startValue - epsilon > x) {
				startValue = startValue - epsilon;
			}
		}
		return (Math.floor(this.startValue * 1000) / 1000);
	}
	
	/**
	 * Gets the epsilon
	 * @return the epsilon
	 */
	public double getEpsilon() {
		return epsilon;
	}

	/**
	 * Sets the epsilon
	 * @param epsilon the desired epsilon.
	 */
	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}
}
