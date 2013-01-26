package org.usfirst.frc1923.components;

import org.usfirst.frc1923.utils.JaguarGroup;

public class ShooterComponent {
	private JaguarGroup left;
	private JaguarGroup right;
	private boolean shooterRunning = false;
	
	public ShooterComponent(JaguarGroup left, JaguarGroup right) {
		this.left = left;
		this.right = right;
	}
	
	public void runLeft(double leftSpeed) {
		left.set(-Math.abs(leftSpeed));
		shooterRunning = true;
	}
	
	public void runRight(double rightSpeed) {
		right.set(-Math.abs(rightSpeed));
		shooterRunning = true;
	}
	
	public void stop() {
		left.disable();
		right.disable();
		shooterRunning = false;
	}
	
	public boolean isShooterRunning() {
		return shooterRunning;
	}
}