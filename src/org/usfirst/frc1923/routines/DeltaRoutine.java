package org.usfirst.frc1923.routines;

import org.usfirst.frc1923.Components;
import org.usfirst.frc1923.event.ShooterActuatorEvent;
import org.usfirst.frc1923.event.ShooterAngleControllerActivateEvent;
import org.usfirst.frc1923.event.ShooterStartEvent;
import org.usfirst.frc1923.event.ShooterStopEvent;
import org.usfirst.frc1923.event.TargetingEvent;
import org.usfirst.frc1923.utils.DefaultConfiguration;

/**
 * An autonomous routine - automatic aiming and shots.
 * 
 * @author Nihar Sidhu, Aaron Weiss
 * @version 1.0
 * @since 2/15/13
 */

public class DeltaRoutine extends AutonomousRoutine {
	protected void routine() throws InterruptedException{
		try {
			Components.eventBus.push(new TargetingEvent());
		} catch (Exception e) {}
		Components.shooterGearbox.setGear(Components.preferences.getInt("auton_shooter_gear", DefaultConfiguration.AUTON_SHOOTER_GEAR));
		Components.eventBus.push(new ShooterAngleControllerActivateEvent());
		Components.eventBus.push(new ShooterStartEvent());
		Thread.sleep(Components.preferences.getLong("auton_wait_time", DefaultConfiguration.AUTON_WAIT_TIME));
		Components.eventBus.push(new ShooterActuatorEvent(Components.preferences.getInt("auton_disque_count", DefaultConfiguration.AUTON_DISQUE_COUNT)));
		Thread.sleep(Components.preferences.getLong("auton_run_time", DefaultConfiguration.AUTON_RUN_TIME));
		Components.eventBus.push(new ShooterStopEvent());
	}
}
