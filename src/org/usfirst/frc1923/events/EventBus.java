package org.usfirst.frc1923.events;

import java.util.Stack;

/**
 * A class to store events via <code>Stack</code>
 * @author Aayush Sharma, Sid Senthilkumar, Olu Olorode, Nabeel Rangwala
 * @version 1.1
 * @since 1/27/13
 */
public class EventBus {
	private Stack stack;

	public EventBus() {
		this.stack = new Stack();
	}

	/**
	 * Adds an event to the stack.
	 * @param event the event added into the stack
	 */
	public void addEvent(Event event) {
		this.stack.push(event);
	}

	/**
	 * Peeks at the first event in the stack.
	 * @return the first event
	 */
	public Event peek() {
		return ((Event) (stack.peek()));
	}

	/**
	 * Removes first event of stack and runs it.
	 */
	public void next() {
		((Event) (stack.pop())).run();
	}

	/**
	 * Removes all the events and runs all of them.
	 */
	public void runAll() {
		for (int i = 0; i < stack.size(); i++)
			((Event) (stack.pop())).run();
	}

	/**
	 * Empties the stack
	 */
	public void destroy() {
		stack.empty();
	}
	
}
