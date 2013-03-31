package org.usfirst.frc1923.routines;

import org.usfirst.frc1923.Components;
import org.usfirst.frc1923.event.AutonomousDriveEvent;
import org.usfirst.frc1923.event.AutonomousTurnEvent;
import org.usfirst.frc1923.event.ShooterActuatorEvent;
import org.usfirst.frc1923.event.ShooterStartEvent;
import org.usfirst.frc1923.event.ShooterStopEvent;
import org.usfirst.frc1923.event.TargetingEvent;
import org.usfirst.frc1923.utils.DefaultConfiguration;
import org.usfirst.frc1923.utils.MidknightTargetingComputer;

/**
 * An Autonomous Routine - Look at "HotelRoutine" in "Midknight Inventors: Autonomous Playbook"
 * @author Pavan Hegde
 * @version 1.0
 * @since 2/16/13
 */
public class HotelRoutine extends AutonomousRoutine{
	protected void routine() throws InterruptedException {
		double speed = Components.preferences.getDouble("auton_drive_speed", DefaultConfiguration.AUTON_DRIVE_SPEED);
		double distanceOne = Components.preferences.getDouble("auton_hotel_distance1", DefaultConfiguration.AUTON_HOTEL_DISTANCE1);
		double distanceTwo = Components.preferences.getDouble("auton_hotel_distance2", DefaultConfiguration.AUTON_HOTEL_DISTANCE2);
		double distanceThree = Components.preferences.getDouble("auton_hotel_distance3", DefaultConfiguration.AUTON_HOTEL_DISTANCE3);
		double compAngle = 0;
		Components.eventBus.push(new AutonomousDriveEvent(speed, distanceOne));
		try{
			Components.eventBus.push(new TargetingEvent());
		} catch(Exception e) {
			return;
		}
		compAngle = 90 - MidknightTargetingComputer.getTurnAngle();
		Components.eventBus.push(new ShooterStartEvent());
		Thread.sleep(Components.preferences.getLong("auton_wait_time", DefaultConfiguration.AUTON_WAIT_TIME));
		Components.eventBus.push(new ShooterActuatorEvent(Components.preferences.getInt("auton_disque_count", DefaultConfiguration.AUTON_DISQUE_COUNT)));
		Thread.sleep((Components.preferences.getLong("shooter_pneumatic_time", (long) DefaultConfiguration.SHOOTER_PNEUMATIC_TIME) * Components.preferences.getInt("auton_disque_count", DefaultConfiguration.AUTON_DISQUE_COUNT) * 2));
		Components.eventBus.push(new ShooterStopEvent());
		Components.eventBus.push(new AutonomousTurnEvent(Components.preferences.getDouble("auton_drive_speed", DefaultConfiguration.AUTON_DRIVE_SPEED), compAngle));
		Components.eventBus.push(new AutonomousDriveEvent(speed, distanceTwo));
		Components.eventBus.push(new AutonomousTurnEvent(Components.preferences.getDouble("auton_drive_speed", DefaultConfiguration.AUTON_DRIVE_SPEED), -90));
		Components.eventBus.push(new AutonomousDriveEvent(-speed, -Math.min(distanceThree, 108)));
	}
}
