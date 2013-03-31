package org.usfirst.frc1923.utils;

import org.usfirst.frc1923.Components;

/**
 * A handler to gradually increase a value towards another value.
 * 
 * @author Aaron Weiss
 * @version 1.5
 * @since 2/9/13
 */
public class Coalescor {
	private double startingValue;
	private double epsilon;

	/**
	 * Creates a <code>Coalescor</code> with a starting value of zero.
	 */
	public Coalescor() {
		this(0);
	}

	/**
	 * Creates a <code>Coalescor</code> with the specified starting value.
	 * 
	 * @param startingValue
	 * 				the value to start at
	 */
	public Coalescor(double startingValue) {
		this(startingValue, Components.preferences.getDouble("epsilon", DefaultConfiguration.EPSILON));
	}

	/**
	 * Creates a <code>Coalescor</code> with the specified starting value, and epsilon value.
	 * 
	 * @param startingValue
	 * 				the value to start at
	 * @param epsilon
	 * 				the value of change
	 */
	public Coalescor(double startingValue, double epsilon) {
		this.startingValue = startingValue;
		this.epsilon = epsilon;
	}

	/**
	 * Coalesces the current value towards <code>n</code>.
	 * 
	 * @param n
	 * 				the value to coalesce towards
	 * @return the next step in coalescing
	 */
	public double coalesce(double n) {
		if (n > this.startingValue) {
			if (this.startingValue + this.epsilon > n) {
				this.startingValue = n;
			} else if (this.startingValue + this.epsilon < n) {
				this.startingValue += this.epsilon;
			}
		} else if (n < this.startingValue) {
			if (this.startingValue - this.epsilon < n) {
				this.startingValue = n;
			} else if (this.startingValue - this.epsilon > n) {
				this.startingValue -= this.epsilon;
			}
		}
		return (Math.floor(this.startingValue * 1000) / 1000);
	}

	/**
	 * Gets the current rate of change, or epsilon, of the coalescor.
	 * @return the current rate of change
	 */
	public double getEpsilon() {
		return this.epsilon;
	}

	/**
	 * Sets the rate of change, or epsilon, of the coalescor.
	 * @param epsilon
	 * 				the new, desired rate of change
	 */
	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}
}
