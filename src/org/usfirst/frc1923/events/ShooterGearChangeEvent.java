package org.usfirst.frc1923.events;

import org.usfirst.frc1923.components.ShooterGearbox;
/**
 *  An event for controlling a <code>ShooterGearbox</code>.
 * @author Pavan Hegde, Aaron Weiss
 * @version 1.0
 * @since 1/22/13
 */
public class ShooterGearChangeEvent {
	private ShooterGearbox shooterGearbox;
	private int leftGear, rightGear;
	/**
	 * A constructor to create the event
	 * @param gearNum The gear number that indicates left or right
	 * @param side the side of the gear set
	 * @param shooterGearbox the shooter gear box
	 */
	public ShooterGearChangeEvent(int gearNum, GearSide side, ShooterGearbox shooterGearbox) {
		this.shooterGearbox = shooterGearbox;
		if (side.value == GearSide.leftSide.value) {
			this.leftGear = gearNum;
			this.rightGear = -1;
		}
		else if(side.value == GearSide.rightSide.value) {
			this.leftGear = -1;
			this.rightGear = gearNum;
		}
		else {
			this.leftGear = -1;
			this.rightGear = -1;
		}
	}
	/**
	 *  Another constructor used to create the event.
	 * @param leftGear the left gear value
	 * @param rightGear the right gear value
	 * @param shooterGearbox the <code>ShooterGearbox</code>.
	 */
	public ShooterGearChangeEvent(int leftGear, int rightGear, ShooterGearbox shooterGearbox) {
		this.shooterGearbox = shooterGearbox;
		this.leftGear = leftGear;
		this.rightGear = rightGear;
	}
	/**
	 * Sets the left or right gear
	 */
	public void run() {
		if (this.leftGear != -1)
			shooterGearbox.setLeftGear(leftGear);
		if (this.rightGear != -1)
			shooterGearbox.setRightGear(rightGear);
	}
	/**
	 *  A class for the gear side
	 * @author Aaron Weiss, Pavan Hegde
	 *  @version 1.0
	 *  @since 1/22/13
	 */
	public static final class GearSide {
		private static final int kLeft_val = 1;
		private static final int kRight_val = 2;
		public static final GearSide leftSide = new GearSide(kLeft_val);
		public static final GearSide rightSide = new GearSide(kRight_val);
		
		public final int value;
		/**
		 * A constructor that sets the value
		 * @param value the value 
		 */
		public GearSide(int value) {
			this.value = value;
		}
		/**
		 * @return the value
		 */
		public int getValue() {
			return this.value;
		}
	}
}
