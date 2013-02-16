package org.usfirst.frc1923.routines;

import org.usfirst.frc1923.Components;
import org.usfirst.frc1923.event.AutonomousDriveEvent;
import org.usfirst.frc1923.event.ShooterActuatorEvent;
import org.usfirst.frc1923.event.ShooterStartEvent;
import org.usfirst.frc1923.event.ShooterStopEvent;
import org.usfirst.frc1923.event.TargetingEvent;
import org.usfirst.frc1923.utils.DefaultConfiguration;

/**
 * An Autonomous Period- Shooting with target, then Driving (backwards)
 * 
 * @author Pavan Hegde
 * @version 1.0
 * @since 2/16/13
 */
public class EchoRoutine extends AutonomousRoutine {
	protected void routine() throws InterruptedException {
		try {
			Components.eventBus.push(new TargetingEvent());
		}catch (Exception e) {
			return;
		}
		Components.shooterGearbox.setGear(Components.preferences.getInt("auton_shooter_gear", DefaultConfiguration.AUTON_SHOOTER_GEAR));
		Components.eventBus.push(new ShooterStartEvent());
		Thread.sleep(Components.preferences.getLong("auton_wait_time", DefaultConfiguration.AUTON_WAIT_TIME));
		Components.eventBus.push(new ShooterActuatorEvent(Components.preferences.getInt("auton_diques_count", DefaultConfiguration.AUTON_DISQUE_COUNT)));
		Thread.sleep(Components.preferences.getLong("auton_wait_time", DefaultConfiguration.AUTON_WAIT_TIME));
		Components.eventBus.push(new ShooterStopEvent());
		double speed = Components.preferences.getDouble("auton_drive_speed", DefaultConfiguration.AUTON_DRIVE_SPEED);
		double distance = Components.preferences.getDouble("auton_drive_distance", DefaultConfiguration.AUTON_DRIVE_DISTANCE);
		Components.eventBus.push(new AutonomousDriveEvent(-speed, -Math.min(distance, 108)));
	}
}
