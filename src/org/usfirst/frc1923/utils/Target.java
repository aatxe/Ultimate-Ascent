package org.usfirst.frc1923.utils;

/**
 * A target for the <code>MidknightTargetingComputer</code>.
 * 
 * @author Aaron Weiss, Aravind Koneru
 * @version 1.0
 * @since 2/14/13
 */
public class Target {
	public final int x, y;
	public final int width, height;
	
	/**
	 * Creates a target.
	 * @param x
	 * 			the x-coordinate of the center
	 * @param y
	 * 			the y-coordinate of the center
	 * @param width
	 * 			the width of the target
	 * @param height
	 * 			the height of the target
	 */
	public Target(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	/**
	 * @return the x-coordinate of the center
	 */
	public int getX() {
		return x;
	}

	/**
	 * @return the y-coordinate of the center
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the width of the target
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @return the height of the target
	 */
	public int getHeight() {
		return height;
	}
}
