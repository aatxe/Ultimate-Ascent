package org.usfirst.frc1923.components;

import org.usfirst.frc1923.utils.JaguarGroup;

public class ShooterComponent {
	private JaguarGroup left;
	private JaguarGroup right;
	private boolean shooterRunning;
	
	public ShooterComponent(JaguarGroup left, JaguarGroup right) {
		this.left = left;
		this.right = right;
	}
	
	public void runLeft(double leftSpeed) {
		left.set(-Math.abs(leftSpeed));
	}
	
	public void runRight(double rightSpeed) {
		right.set(-Math.abs(rightSpeed));
	}
	
	public void stop() {
		left.disable();
		right.disable();
	}
	
	public boolean isShooterRunning() {
		return shooterRunning;
	}
}
