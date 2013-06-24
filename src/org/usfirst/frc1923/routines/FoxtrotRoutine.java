package org.usfirst.frc1923.routines;

import org.usfirst.frc1923.Components;
import org.usfirst.frc1923.event.AutonomousDriveEvent;
import org.usfirst.frc1923.event.ShooterActuatorEvent;
import org.usfirst.frc1923.event.ShooterStartEvent;
import org.usfirst.frc1923.event.ShooterStopEvent;
import org.usfirst.frc1923.event.TargetingEvent;
import org.usfirst.frc1923.utils.DefaultConfiguration;

/**
 * An Autonomous Routine -  drives forward, then target shoots. 
 * @author Pavan Hegde
 * @version 1.0
 * @since 2/16/13
 */
public class FoxtrotRoutine extends AutonomousRoutine {
	protected void routine() throws InterruptedException {
		Components.eventBus.push(new AutonomousDriveEvent(Components.preferences.getDouble("auton_drive_speed", DefaultConfiguration.AUTON_DRIVE_SPEED), Components.preferences.getDouble("auton_drive_distance", DefaultConfiguration.AUTON_DRIVE_DISTANCE)));
		try {
			Components.eventBus.push(new TargetingEvent());
		} catch (Exception e) {
			return;
		}
		Components.eventBus.push(new ShooterStartEvent());
		Thread.sleep(Components.preferences.getLong("auton_wait_time", DefaultConfiguration.AUTON_WAIT_TIME));
		Components.eventBus.push(new ShooterActuatorEvent(Components.preferences.getInt("auton_disque_count", DefaultConfiguration.AUTON_DISQUE_COUNT)));
		Thread.sleep(Components.preferences.getLong("auton_run_time", DefaultConfiguration.AUTON_RUN_TIME));
		Components.eventBus.push(new ShooterStopEvent());
	}
}
