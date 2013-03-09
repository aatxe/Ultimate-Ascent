/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc1923.utils;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc1923.Components;

/**
 *
 * @author frc1923
 */
public class Dashboard {
    public static void update() {
        SmartDashboard.putNumber("shooter_speed", Components.shooterGearbox.getSpeed());
        SmartDashboard.putNumber("shooter_gear", Components.shooterGearbox.getGear());
    }
}
