package org.usfirst.frc1923.events;

import java.util.Stack;

/**
 * Events stored via stack.
 * 
 * @author Aayush Sharma, Sid Senthilkumar, Olu Olorode, Nabeel Rangwala
 * @version 1.0
 * @since 1/12/13
 */
public class EventBus {
	Stack stack;

	public EventBus() {
		stack = new Stack();
	}

	/**
	 * This adds an event to the stack.
	 * @param event the event added into the stack
	 */
	public void addEvent(Event event) {
		stack.push(event);
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
