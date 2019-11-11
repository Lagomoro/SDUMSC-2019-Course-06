/**
 * @class: Controllable.java 
 * @extends: java.lang.Object
 * @author: Lagomoro <Yongrui Wang>
 * @submit: 2019/11/11
 * @description: Let the Components can be control.
 **/
package org.sdumsc.course201907.ui.interfaces;

import java.awt.Component;

import org.sdumsc.course201907.ui.components.Window;

public interface Controllable {
	
	/**
	 * @author Lagomoro <Yongrui Wang>
	 * @description: Update frequency per second.
	 */
	public static final int UPDATE_FREQUENCY_PER_SECOND = 60;
	
	/**
	 * @author Lagomoro <Yongrui Wang>
	 * @see UPDATE_FREQUENCY_PER_SECOND
	 * @description: Life cycle update event, triggers at a frequency after the component started.
	 */
	default void triggerUpdate() {
		this.update();
		if(this instanceof Window) {
			for (Component c: ((Window)this).getContentPane().getComponents()) {
				if(c instanceof Controllable) {
					((Controllable) c).triggerUpdate();
				}
			}
		}
	}
	
	abstract void update();
	
	/**
	 * @author Lagomoro <Yongrui Wang>
	 * @description: Life cycle refresh event, triggers in need after the component started.
	 */
	default void triggerRefresh() {
		this.refresh();
		if(this instanceof Window) {
			for (Component c: ((Window)this).getContentPane().getComponents()) {
				if(c instanceof Controllable) {
					((Controllable) c).triggerRefresh();
				}
			}
		}
	}
	
	abstract void refresh();
	
}
