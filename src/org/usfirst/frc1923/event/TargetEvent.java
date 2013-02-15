package org.usfirst.frc1923.event;

import org.usfirst.frc1923.Components;
import org.usfirst.frc1923.utils.Targeting;

import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.image.NIVisionException;

public class TargetEvent extends Event {
	private double turnAngle;
	private double distance;
	
	public TargetEvent() throws AxisCameraException, NIVisionException {
		super(true);
		Targeting.updateImage(Components.camera.getImage());
		this.turnAngle = Targeting.getTurnAngle(1, 1); //TODO Parameters
		this.distance = Targeting.getDistance(1, 1);
	}
	
	protected void event() {
		do {
			Components.driveSystem.drive(.8, .8 - turnAngle);
			try {
				Targeting.updateImage(Components.camera.getImage());
			} catch (AxisCameraException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NIVisionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.turnAngle = Targeting.getTurnAngle(1, 1); //TODO Parameters
			this.distance = Targeting.getDistance(1, 1);
		}while (turnAngle > 5);
	}
}
