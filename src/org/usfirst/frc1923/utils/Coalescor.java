package org.usfirst.frc1923.utils;

public class Coalescor {

	private double startValue;
	private double epsilon = 0.08;
	
	public Coalescor() {
		this.startValue = 0;
	}
	
	public Coalescor(double startValue) {
		this.startValue = startValue;
	}
	
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

	public double getEpsilon() {
		return epsilon;
	}

	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}
}
