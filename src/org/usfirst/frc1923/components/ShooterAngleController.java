package org.usfirst.frc1923.components;
/**
 *  Controls the angle of the shooter
 * @author Pavan Hegde, Nabeel Rangwala
 * @version 1.0
 * @since 1/26/13
 */
public class ShooterAngleController extends MotorComponent {
	private XboxController xbox;
	
	/**
	 * A constructor to create the ShooterAngleController
	 * @param channel the desired digital channel
	 * @param port the desired port
	 */
	public ShooterAngleController(int channel, int port) {
		super(channel);
		xbox = new XboxController(port);
	}
	
	/**
	 * A constructor to create the ShooterAngleController
	 * @param moduleNumber the desired digital module number
	 * @param channel the desired digital channel
	 * @param port the desired port
	 */
	public ShooterAngleController(int moduleNumber, int channel, int port) {
		super(moduleNumber, channel);
		xbox = new XboxController(port);
	}
	
	/**
	 * @return the desired speed determined by the left joystick
	 */
	public int getXboxLeftJoystick() {
		return (int)(xbox.getAxis(1, 1));
	}
	
	/**
	 *  Sets motor to move forward
	 * @param speed the specified rate
	 */
	public void up(int speed) {
		forward(speed);
	}
	
	/**
	 * Sets motor to move in reverse
	 * @param speed the specified rate
	 */
	public void down(int speed) {
		reverse(speed);
	}
}
