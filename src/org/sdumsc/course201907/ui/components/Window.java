/**
 * @class: Window.java 
 * @extends: javax.swing.JFrame
 * @author: Lagomoro <Yongrui Wang>
 * @submit: 2019/11/11
 * @description: Window Class
 **/
package org.sdumsc.course201907.ui.components;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

import org.sdumsc.course201907.controller.CalculateController;
import org.sdumsc.course201907.controller.GraphicsController;
import org.sdumsc.course201907.ui.interfaces.Controllable;

@SuppressWarnings("serial")
public class Window extends JFrame implements Controllable, WindowListener{
	
	Button button;
	
	public Window(){
		super();
		this.initialize(200, 300, "Default");
	}
	
	public Window(String title){
		super();
		this.initialize(200, 300, title);
	}
	
	public Window(int width, int height, String title){
		super();
		this.initialize(width, height, title);
	}
		
	protected void initialize(int width, int height, String title){
		this.setTitle(title);
		this.setLayout(null);
		this.setResizable(false);
		
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		
		this.addWindowListener(this);
		
		this.create();
	}
	
	private void create() {
		int placeX = 10;
		int placeY = 10;
		int width = 50;
		int height = 50;
		int spaceX = 10;
		int spaceY = 10;
		
		width += 3*(width + spaceX);
		EditText text = new EditText(placeX + 0*(width + spaceX), placeY, width, height, "");
		text.setRadius(10);
		text.setShade(1);
		text.setFont(GraphicsController.getDefaultFont(24));
		CalculateController.setEditText(text);
		this.add(text);
		
		width = height;
		placeY += height + spaceY;
		this.add(this.getButton(placeX + 0*(width + spaceX), placeY, width, height, "("));
		this.add(this.getButton(placeX + 1*(width + spaceX), placeY, width, height, ")"));
		this.add(this.getButton(placeX + 2*(width + spaceX), placeY, width, height, "+"));
		this.add(this.getButton(placeX + 3*(width + spaceX), placeY, width, height, "-"));
		placeY += height + spaceY;
		this.add(this.getButton(placeX + 0*(width + spaceX), placeY, width, height, "7"));
		this.add(this.getButton(placeX + 1*(width + spaceX), placeY, width, height, "8"));
		this.add(this.getButton(placeX + 2*(width + spaceX), placeY, width, height, "9"));
		this.add(this.getButton(placeX + 3*(width + spaceX), placeY, width, height, "¡Á"));
		placeY += height + spaceY;
		this.add(this.getButton(placeX + 0*(width + spaceX), placeY, width, height, "4"));
		this.add(this.getButton(placeX + 1*(width + spaceX), placeY, width, height, "5"));
		this.add(this.getButton(placeX + 2*(width + spaceX), placeY, width, height, "6"));
		this.add(this.getButton(placeX + 3*(width + spaceX), placeY, width, height, "¡Â"));
		placeY += height + spaceY;
		this.add(this.getButton(placeX + 0*(width + spaceX), placeY, width, height, "1"));
		this.add(this.getButton(placeX + 1*(width + spaceX), placeY, width, height, "2"));
		this.add(this.getButton(placeX + 2*(width + spaceX), placeY, width, height, "3"));
		height += height + spaceY;
		this.add(this.getButton(placeX + 3*(width + spaceX), placeY, width, height, "="));
		height = width;
		placeY += height + spaceY;
		width += width + spaceX;
		this.add(this.getButton(placeX + 0*(width + spaceX), placeY, width, height, "0"));
		width = height;
		Button button = new Button(placeX + 2*(width + spaceX), placeY, width, height, "C") {
			@Override
			protected void clickEvent() {
				CalculateController.push("C");
				super.clickEvent();
			}
			@Override
			protected void longTouchEvent() {
				CalculateController.push("CE");
				super.clickEvent();
			}
		};
		button.setRadius(10);
		button.setShade(1);
		button.setFont(GraphicsController.getDefaultFont(24));
		this.add(button);
		
		placeY += height + spaceY;
		width = this.getSize().width;
		Label label = new Label(0, placeY, width, 14, "This is your label!");
		label.setFont(GraphicsController.getDefaultFont(10));
		label.setShade(1);
		CalculateController.setLabel(label);
		this.add(label);
	}
	
	private Button getButton(int x, int y, int width, int height, String text) {
		Button button = new Button(x, y, width, height, text) {
			@Override
			protected void clickEvent() {
				CalculateController.push(this.getText());
				super.clickEvent();
			}
		};
		button.setRadius(10);
		button.setShade(1);
		button.setFont(GraphicsController.getDefaultFont(24));
		return button;
	}

	public void active() {
		this.setVisible(true);
		this.refresh();
	}
	
	public void deactive() {
		this.setVisible(false);
	}
	
	@Override
	public void update() {}

	@Override
	public void refresh() {
		this.revalidate();
		this.repaint();
	}

	@Override
	public void windowOpened(WindowEvent e) {}

	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {}

	@Override
	public void windowIconified(WindowEvent e) {}

	@Override
	public void windowDeiconified(WindowEvent e) {}

	@Override
	public void windowActivated(WindowEvent e) {}

	@Override
	public void windowDeactivated(WindowEvent e) {}

}
