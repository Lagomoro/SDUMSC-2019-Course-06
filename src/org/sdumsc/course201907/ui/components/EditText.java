/**
 * @class: EditText.java 
 * @extends: javax.swing.JTextField
 * @author: Lagomoro <Yongrui Wang>
 * @submit: 2019/11/11
 * @description: Superclass EditText of textFields
 **/
package org.sdumsc.course201907.ui.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.sdumsc.course201907.controller.GraphicsController;
import org.sdumsc.course201907.ui.interfaces.Controllable;


@SuppressWarnings("serial")
public class EditText extends JTextField implements Controllable{

	private int radius = 0;
	private int shade = 0;
	private int padding = 0;
	
	public EditText(){
		super();
		this.initialize(0, 0, 50, 50, "Default");
	}
	
	public EditText(int x, int y, int width, int height, String text) {
		super();
		this.initialize(x, y, width, height, text);
	}

	protected void initialize(int x, int y, int width, int height, String text) {
		this.setOpaque(false);
		this.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
		this.setHorizontalAlignment(SwingConstants.RIGHT);
		this.setBackground(GraphicsController.DEFAULT_COLOR);
        
		this.setBounds(x, y, width, height);
        this.setText(text);
        
		this.refresh();
	}
	
	@Override
	public void update() {
		
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
	
	public void setPadding(int padding) {
		this.padding = padding;
		this.resetBorder();
	}
	
	public void resetBorder() {
		int border = this.radius + this.shade + this.padding;
		this.setBorder(BorderFactory.createEmptyBorder(border, border, border, border));
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
	
}
