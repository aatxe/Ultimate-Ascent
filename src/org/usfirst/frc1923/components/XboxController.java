package org.usfirst.frc1923.components;

import edu.wpi.first.wpilibj.Joystick;

/**
 * A class to represent the Xbox Controller
 * @author Olu Olorode, Nihar Sidhu, Nabeel Rangwala, Pavan Hegde, Bhavish Yalamanchi
 * @version 1.1
 * @since 1/27/13
 */
public class XboxController {

	private Joystick joystick;

	public XboxController(int port) {
		joystick = new Joystick(port);
	}

	/**
	 * Gets the value of desired Axis input depending on the distance the stick is from the origin.
	 * @param stickNumber the desired Stick Number
	 * @param axisNumber the desired Axis Number
	 * @return the value of the Axis
	 */
	public double getAxis(int stickNumber, int axisNumber) {
		if (stickNumber == 1 && axisNumber == 1) {
			return joystick.getRawAxis(1);
		}
		else if( stickNumber == 1 && axisNumber == 2) {
			return joystick.getRawAxis(2);
		}
		else if (stickNumber == 2 && axisNumber == 1) {
			return joystick.getRawAxis(3);
		}
		else if( stickNumber == 2 && axisNumber == 2) {
			return joystick.getRawAxis(4);
		}
		else {
			return -69;
		}
	}

	/**
	 * Gets the button based on the enumerated type.
	 * @param inputButton the desired button to read.
	 * @return The state of the button
	 */
	public boolean getButton(XboxController.Button inputButton) {
		return joystick.getRawButton(inputButton.value);

	}

	/**
	 * Gets <code>Joystick</code> Object
	 * @return the <code>Joystick</code> object
	 */
	public Joystick getJoystick() {
		return this.joystick;

	}

	/**
	 * Gets the raw axis of the trigger
	 * @return the raw axis of the trigger
	 */
	public double getTriggerAxis() {
		return joystick.getRawAxis(3);
	}

	/**
	 * Gets DPad object
	 * @return the DPad info
	 */
	public double getDPad() {
		return this.getDPad();
	}
	
	public static class Button {
		public final static int kA_val = 1;
		public final static int kB_val = 2;
		public final static int kX_val = 3;
		public final static int kY_val = 4;
		public final static int kLb_val = 5;
		public final static int kRb_val = 6;
		public final static int kBack_val = 7;
		public final static int kStart_val = 8;
		public final static int kRightClick_val = 9;
		public final static int kLeftClick_val = 10;

		public final static Button A = new Button(kA_val);
		public final static Button B = new Button(kB_val);
		public final static Button X = new Button(kX_val);
		public final static Button Y = new Button(kY_val);
		public final static Button RB = new Button(kRb_val);
		public final static Button LB = new Button(kLb_val);
		public final static Button Back = new Button(kBack_val);
		public final static Button Start = new Button(kStart_val);
		public final static Button RightClick = new Button(kRightClick_val);
		public final static Button LeftClick = new Button(kLeftClick_val);

		public final int value;

		/**
		 * Creates the button with the value.
		 * @param value Button Value
		 */
		private Button(int value) {
			this.value = value;
		}

	}

}
