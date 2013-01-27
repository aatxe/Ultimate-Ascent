package org.usfirst.frc1923;

/**
 * The basic interface for system components.
 * @author Aaron Weiss, Bhavish Yalamanchi
 * @version 1.2
 * @since 1/8/13
 */
public interface Component {
	/**
	 * Gets the component's current state.
	 * @return the component's current state
	 */
	public int getState();
	
	/**
	 * Destroys the component, freeing up any used resources.
	 */
	public void destroy();
	
	/**
	 * A static class for abstracting away robot states.
	 * @author Aaron Weiss
	 * @version 1.0
	 * @since 1/8/13
	 */
	public final static class ComponentState {
		public final static int COMPONENT_OFF = 0;
		public final static int COMPONENT_ON = 1;
		public final static int COMPONENT_FORWARD = 2;
		public final static int COMPONENT_REVERSE = 3;
		public final static int COMPONENT_STOPPED = 4;
		public final static int COMPONENT_RESET = 5;
		public final static int COMPONENT_NEED_RESET = 6;
	}
}