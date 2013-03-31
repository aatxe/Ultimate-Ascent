package org.usfirst.frc1923.routines;

import org.usfirst.frc1923.Components;
import org.usfirst.frc1923.event.AutonomousDriveEvent;
import org.usfirst.frc1923.event.ShooterActuatorEvent;
import org.usfirst.frc1923.event.ShooterStartEvent;
import org.usfirst.frc1923.event.ShooterStopEvent;
import org.usfirst.frc1923.event.TargetingEvent;
import org.usfirst.frc1923.utils.DefaultConfiguration;

/**
 *  An Autonomous Routine- Drives forward, target shoots, drives backward.
 * @author Pavan Hegde
 * @version 1.0
 * @since 2/16/13
 */
public class GammaRoutine extends AutonomousRoutine{
	protected void routine() throws InterruptedException {
		double speed = Components.preferences.getDouble("auton_drive_speed", DefaultConfiguration.AUTON_DRIVE_SPEED);
		double distance = Components.preferences.getDouble("auton_drive_distance", DefaultConfiguration.AUTON_DRIVE_DISTANCE);
		Components.eventBus.push(new AutonomousDriveEvent(speed, distance));
		try {
			Components.eventBus.push(new TargetingEvent());
		} catch (Exception e) {
			return;
		}
		Components.eventBus.push(new ShooterStartEvent());
<<<<<<< HEAD
		Thread.sleep(Components.preferences.getLong("auton_wait_time", DefaultConfiguration.AUTON_WAIT_TIME));
		Components.eventBus.push(new ShooterActuatorEvent(Components.preferences.getInt("auton_disque_count", DefaultConfiguration.AUTON_DISQUE_COUNT)));
=======
		Thread.sleep(Components.preferences.getLong("auton_run_time", DefaultConfiguration.AUTON_RUN_TIME));
                Components.eventBus.push(new ShooterActuatorEvent(Components.preferences.getInt("auton_disque_count", DefaultConfiguration.AUTON_DISQUE_COUNT)));
>>>>>>> Changes from Lenape.
		Thread.sleep((Components.preferences.getLong("shooter_pneumatic_time", (long) DefaultConfiguration.SHOOTER_PNEUMATIC_TIME) * Components.preferences.getInt("auton_disque_count", DefaultConfiguration.AUTON_DISQUE_COUNT) * 2));
		Components.eventBus.push(new ShooterStopEvent());
		Components.eventBus.push(new AutonomousDriveEvent(-speed, -Math.min(distance, 108)));
	}
}
