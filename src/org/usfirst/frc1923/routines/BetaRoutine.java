package org.usfirst.frc1923.routines;

import org.usfirst.frc1923.Components;
import org.usfirst.frc1923.event.AutonomousDriveEvent;
import org.usfirst.frc1923.event.ShooterAngleControllerActivateEvent;
import org.usfirst.frc1923.event.ShooterActuatorEvent;
import org.usfirst.frc1923.event.ShooterStartEvent;
import org.usfirst.frc1923.event.ShooterStopEvent;
import org.usfirst.frc1923.utils.DefaultConfiguration;


/**
 * A basic autonomous routine - drive and then shoot.
 * 
 * @author  Aaron Weiss and Nihar Sidhu 
 * @version 1.0
 * @since 2/14/13
 */

public class BetaRoutine extends AutonomousRoutine {
	protected void routine() throws InterruptedException {
		double speed = Components.preferences.getDouble("auton_drive_speed", DefaultConfiguration.AUTON_DRIVE_SPEED);
		double distance = Components.preferences.getDouble("auton_drive_distance", DefaultConfiguration.AUTON_DRIVE_DISTANCE);
		Components.eventBus.push(new AutonomousDriveEvent(speed, distance));
		Components.eventBus.push(new ShooterAngleControllerActivateEvent());
		Components.shooterGearbox.setGear(Components.preferences.getInt("auton_shooter_gear", DefaultConfiguration.AUTON_SHOOTER_GEAR));
		Components.eventBus.push(new ShooterStartEvent());
		Thread.sleep(Components.preferences.getLong("auton_wait_time", DefaultConfiguration.AUTON_WAIT_TIME));
		Components.eventBus.push(new ShooterActuatorEvent(Components.preferences.getInt("auton_disque_count", DefaultConfiguration.AUTON_DISQUE_COUNT)));
		Thread.sleep(Components.preferences.getLong("auton_run_time", DefaultConfiguration.AUTON_RUN_TIME));
		Components.eventBus.push(new ShooterStopEvent());
	}
}
