package org.usfirst.frc1923.utils;

import edu.wpi.first.wpilibj.Utility;

/**
 *
 * @author frc1923
 */
public class DashboardUpdater implements Runnable {
	private static final long update_time = 5 / (60 * 1000000);
	private long last_update;
	private boolean run = false;

	public DashboardUpdater() {
		last_update = Utility.getFPGATime();
	}

	public void run() {
		run = true;
		while (run) {
			if (Utility.getFPGATime() - last_update > update_time) {
				// Dashboard.update();
				last_update = Utility.getFPGATime();
			}
		}
	}

	public void stop() {
		run = false;
	}
}
