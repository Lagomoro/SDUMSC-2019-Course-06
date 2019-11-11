/**
 * @class: Button.java 
 * @extends: javax.swing.JButton
 * @author: Lagomoro <Yongrui Wang>
 * @submit: 2019/11/11
 * @description: Superclass Button of buttons
 **/
package org.sdumsc.course201907.ui.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;

import org.sdumsc.course201907.controller.GraphicsController;
import org.sdumsc.course201907.ui.interfaces.Controllable;

@SuppressWarnings("serial")
public class Button extends JButton implements Controllable, MouseListener{
	
	private int radius = 0;
	private int shade = 0;
	
	private boolean clicked = false;
	private boolean moveIn = false;
	private int clickTime = -1;
	
	public Button(){
		super();
		this.initialize(0, 0, 50, 50, "Default");
	}
	
	public Button(int x, int y, int width, int height, String text) {
		super();
		this.initialize(x, y, width, height, text);
	}

	protected void initialize(int x, int y, int width, int height, String text) {
		this.setOpaque(false);
		this.setFocusPainted(false);
        this.setBorderPainted(false);
        this.setBorder(null);
        this.setContentAreaFilled(false);
        this.setBackground(GraphicsController.DEFAULT_COLOR);
        
        this.setBounds(x, y, width, height);
        this.setText(text);
        
        this.addMouseListener(this);
        this.refresh();
	}
	
	@Override
	public void update() {
		if(this.clickTime >= 0) {
			this.clickTime ++;
			if(this.clickTime > Controllable.UPDATE_FREQUENCY_PER_SECOND/2) {
				this.longTouchEvent();
			}
		}
	}
	
	@Override
	public void refresh() {
		this.revalidate();
		this.repaint();
	}
	
	public void setRadius(int radius) {
		this.radius = radius;
		this.resetBorder();
	}
	
	public void setShade(int shade) {
		int delta = shade - this.shade;
		this.setBounds(this.getX() - delta, this.getY() - delta, this.getWidth() + delta*2, this.getHeight() + delta * 2);
		this.shade = shade;
		this.resetBorder();
	}
	
	public void resetBorder() {
		int border = this.radius + this.shade;
		this.setBorder(BorderFactory.createEmptyBorder(0, border, 0, border));
	}
	
	@Override
    protected void paintComponent(Graphics g) {
		Graphics2D graphics = (Graphics2D) g;
		GraphicsController.setHint(graphics);
		this.paint(graphics);
        super.paintComponent(g);
    }

	protected void paint(Graphics2D graphics) {
		this.paintShade(graphics);
		this.paintBackground(graphics);
	}
	
	protected void paintShade(Graphics2D graphics) {
		int i = 0;
		if(this.shade != 0) {
			graphics.setColor(new Color(0, 0, 0, GraphicsController.SHADE_ALPHA / this.shade));
			for(i = 0;i < this.shade;i++) {
				graphics.fillRoundRect(i, i, this.getWidth() - i*2, this.getHeight() - i*2, (this.radius + this.shade - i) * 2, (this.radius + this.shade - i) * 2);
			}
		}
	}
	
	protected void paintBackground(Graphics2D graphics) {
		graphics.setColor(this.getBackground());
		graphics.fillRoundRect(this.shade, this.shade, this.getWidth() - this.shade * 2, this.getHeight() - this.shade * 2, this.radius * 2, this.radius * 2);
	}

	@Override
	public void mouseClicked(MouseEvent e) {}

	protected void clickEvent() {}
	protected void longTouchEvent() {}

	@Override
	public void mousePressed(MouseEvent e) {
		this.clicked = true;
		this.clickTime = 0;
		this.setBackground(GraphicsController.TOUCH_COLOR);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.clicked = false;
		this.clickTime = -1;
		if(!this.moveIn) {
			this.setBackground(GraphicsController.DEFAULT_COLOR);
		}else {
			this.clickEvent();
			this.setBackground(GraphicsController.HOVER_COLOR);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.moveIn = true;
		this.setBackground(GraphicsController.HOVER_COLOR);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.moveIn = false;
		if(!this.clicked) {
			this.setBackground(GraphicsController.DEFAULT_COLOR);
		}
	}
	
}
