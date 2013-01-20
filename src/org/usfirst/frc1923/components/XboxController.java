package org.usfirst.frc1923.components;

import edu.wpi.first.wpilibj.Joystick;

/**
 * @author Olu Olorode, Nihar Sidhu, Nabeel Rangwala, Pavan Hegde, Bhavish Yalamanchi
 * @version 1.0
 * @since 1/14/13
 */
public class XboxController {

	private Joystick joystick;

	public XboxController(int port) {
		joystick = new Joystick(port);
	}

	/**
	 * Returns value of desired Axis input
	 * 
	 * @param stickNumber
	 *            the desired Stick Number
	 * @param axisNumber
	 *            the desired Axis Number
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
	 * 
	 * @param inputButton
	 *            Indicates type of button to read.
	 * @return The state if the button
	 */
	public boolean getButton(XboxController.Button inputButton) {
		return joystick.getRawButton(inputButton.value);

	}

	/**
	 * Gets Joystick Object
	 * 
	 * @return the joystick object
	 */
	public Joystick getJoystick() {
		return this.joystick;

	}

	/**
	 * Gets the TriggerAxis
	 * 
	 * @return TriggerAxis
	 */
	public double getTriggerAxis() {
		return joystick.getRawAxis(3);

	}

	/**
	 * Gets DPad object
	 * 
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
		 * Constructor for Button class that sets value to value.
		 * 
		 * @param value
		 *            Button Value
		 */
		private Button(int value) {
			this.value = value;
		}

	}

}
