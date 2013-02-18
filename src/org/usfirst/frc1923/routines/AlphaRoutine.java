package org.usfirst.frc1923.routines;

import org.usfirst.frc1923.Components;
import org.usfirst.frc1923.event.ShooterActuatorEvent;
import org.usfirst.frc1923.event.ShooterAngleControllerActivateEvent;
import org.usfirst.frc1923.event.ShooterStartEvent;
import org.usfirst.frc1923.event.ShooterStopEvent;
import org.usfirst.frc1923.utils.DefaultConfiguration;


/**
 * A basic autonomous routine - simply shoots frisbees.
 * 
 * @author  Aaron Weiss, Nihar Sidhu 
 * @version 1.0
 * @since 2/14/13
 */

public class AlphaRoutine extends AutonomousRoutine {
	protected void routine() throws InterruptedException {
		Components.shooterModbox.update(Components.preferences.getDouble("auton_shooter_speed", DefaultConfiguration.AUTON_SHOOTER_SPEED));
		Components.eventBus.push (new ShooterAngleControllerActivateEvent());
		Components.eventBus.push(new ShooterStartEvent());
		Thread.sleep(Components.preferences.getLong("auton_wait_time", DefaultConfiguration.AUTON_WAIT_TIME));
		Components.eventBus.push(new ShooterActuatorEvent(Components.preferences.getInt("auton_disque_count", DefaultConfiguration.AUTON_DISQUE_COUNT)));
		Thread.sleep(Components.preferences.getLong("auton_wait_time", DefaultConfiguration.AUTON_WAIT_TIME) / 2);
		Components.eventBus.push(new ShooterStopEvent());
	}
}
