package org.usfirst.frc1923.utils;

import edu.wpi.first.wpilibj.Joystick;

/**
 * A representation of the XboxController wrapping <code>Joystick</code>.
 * 
 * @author Aaron Weiss
 * @version 1.0
 * @since 1/29/13
 */
public class XboxController {
	private Joystick xboxController;

	/**
	 * Creates the Xbox Controller with the desired port.
	 * 
	 * @param port
	 * 				the port the controller is inputed port
	 */
	public XboxController(int port) {
		xboxController = new Joystick(port);
	}

	/**
	 * Gets the state of the desired button.
	 * 
	 * @param inputButton 
	 * 				the desired button
	 * @return the state of the button (true = pressed, false = not pressed)
	 */
	public boolean getButton(XboxController.Button inputButton) {
		return xboxController.getRawButton(inputButton.value);
	}

	/**
	 * Gets the current Joystick
	 * 
	 * @return the Joystick object
	 */
	public Joystick getJoystick() {
		return xboxController;
	}

	/**
	 * Gets the axis of the sticks on the xbox controller.
	 * 
	 * @param stickNumber
	 * 				the desired stick number
	 * @param axisNumber
	 * 				the x or y axis
	 * @return the double of the raw axis.
	 */
	public double getAxis(int stickNumber, int axisNumber) {
		int axes[] = { 1, 2, 4, 5 };
		int fAxis = 0;
		if (stickNumber == 1 && axisNumber == 1) {
			fAxis = axes[0];
		} else if (stickNumber == 1 && axisNumber == 2) {
			fAxis = axes[1];
		} else if (stickNumber == 2 && axisNumber == 1) {
			fAxis = axes[2];
		} else if (stickNumber == 2 && axisNumber == 2) {
			fAxis = axes[3];
		} else {
			return -74;
		}
		return xboxController.getRawAxis(fAxis);
	}

	/**
	 * Gets the axis of the trigger.
	 * 
	 * @return the trigger's axis
	 */
	public double getTriggerAxis() {
		return xboxController.getRawAxis(3);
	}

	/**
	 * Gets the input of the directional pad.
	 * 
	 * @return the input from the DPad
	 */
	public double getDPad() {
		return xboxController.getRawAxis(6);
	}

	/**
	 * A representation of the buttons on the XboxController.
	 * 
	 * @author Aaron Weiss
	 * @version 1.0
	 * @since 1/29/13
	 */
	public static class Button {
		public final int value;
		public static final int kA_val = 1;
		public static final int kB_val = 2;
		public static final int kX_val = 3;
		public static final int kY_val = 4;
		public static final int kLB_val = 5;
		public static final int kRB_val = 6;
		public static final int kStart_val = 8;
		public static final int kBack_val = 7;
		public static final int kLeftClick_val = 9;
		public static final int kRightClick_val = 10;
		public static final Button A = new Button(kA_val);
		public static final Button B = new Button(kB_val);
		public static final Button X = new Button(kX_val);
		public static final Button Y = new Button(kY_val);
		public static final Button LB = new Button(kLB_val);
		public static final Button RB = new Button(kRB_val);
		public static final Button Start = new Button(kStart_val);
		public static final Button Back = new Button(kBack_val);
		public static final Button LeftClick = new Button(kLeftClick_val);
		public static final Button RightClick = new Button(kRightClick_val);

		/**
		 * Creates a new Button.
		 * 
		 * @param value
		 * 				the value of the button
		 */
		private Button(int value) {
			this.value = value;
		}
	}
}