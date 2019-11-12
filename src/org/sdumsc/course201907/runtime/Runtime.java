/**
 * @class: Runtime.java 
 * @extends: java.lang.Object
 * @author: Lagomoro <Yongrui Wang>
 * @submit: 2019/11/11
 * @description: The entrance of client.
 **/
package org.sdumsc.course201907.runtime;

import org.sdumsc.course201907.controller.UpdateController;
import org.sdumsc.course201907.ui.components.Window;

public class Runtime {
	
	public static void main(String[] args) {
		//新建窗口
		Window mainWindow = new Window(256, 398 + 15, "普通的计算器");
		//启动周期更新协程
		UpdateController.startUpdate(mainWindow);	
		//显示窗口
		mainWindow.active();
	}
	
}
