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
		//�½�����
		Window mainWindow = new Window(256, 398 + 15, "��ͨ�ļ�����");
		//�������ڸ���Э��
		UpdateController.startUpdate(mainWindow);	
		//��ʾ����
		mainWindow.active();
	}
	
}
