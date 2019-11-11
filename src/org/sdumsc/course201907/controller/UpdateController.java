/**
 * @class: UpdateController.java 
 * @extends: java.lang.Object
 * @author: Lagomoro <Yongrui Wang>
 * @submit: 2019/11/11
 * @description: Update thread.
 **/
package org.sdumsc.course201907.controller;

import org.sdumsc.course201907.ui.components.Window;
import org.sdumsc.course201907.ui.interfaces.Controllable;

public class UpdateController {
	
	/**
	 * @author Lagomoro <Yongrui Wang>
	 * @param Window window
	 * @description: Start window update.
	 */
    public static void startUpdate(Window window) {
    	new Thread() {
    		@Override
            public void run() {
    			try {
    				while(!isInterrupted()) {
        				window.triggerUpdate();
        				Thread.sleep(1000/Controllable.UPDATE_FREQUENCY_PER_SECOND);
        			}
    			} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}
    	}.start();
	}
    
	/**
	 * @author Lagomoro <Yongrui Wang>
	 * @param Window window
	 * @description: Refresh window.
	 */
    public static void refresh(Window window) {
    	window.triggerRefresh();
	}
	
}
