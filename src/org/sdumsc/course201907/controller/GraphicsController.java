/**
 * @class: GraphicsController.java 
 * @extends: java.lang.Object
 * @author: Lagomoro <Yongrui Wang>
 * @submit: 2019/11/11
 * @description: Storage colors.
 **/
package org.sdumsc.course201907.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class GraphicsController {
	
	public static final String DEFAULT_FONT = "Microsoft YaHei";
	public static final int DEFAULT_FONTSIZE = 18;
	
	public static final int SHADE_ALPHA = 60;
	
	public static final Color WARNING_COLOR = Color.RED;
	public static final Color HOVER_COLOR = new Color(235, 235, 235, 255);
	public static final Color DEFAULT_COLOR = Color.WHITE;
	public static final Color TOUCH_COLOR = new Color(210, 210, 210, 255);
	
	public static void setHint(Graphics2D graphics) {
		//��ֵ��ʾ�� = ȡ����9��
		graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);
		//Alpha��ֵ��ʾ�� = Alpha����㷨���Ӿ���������
		graphics.setRenderingHint(RenderingHints.KEY_ALPHA_INTERPOLATION, RenderingHints.VALUE_ALPHA_INTERPOLATION_QUALITY);
        //�������ʾ�� = �����ģʽ�����
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//�ı��������ʾ�� = �����ģʽ��LCD��ʾ��������ˮƽ����RGBȡֵ
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        //LCD �ı��Աȳ�����ʾ�� = �ı��Աȶȣ���
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_LCD_CONTRAST, 180);
		//����С�������ʾ�� = ��դ�������أ���
		graphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON );
		//������ʾ�� = ͼ���������Ӿ���������
		graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		//��ɫ������ʾ�� = ��ɫת�����Ӿ���������
		graphics.setRenderingHint(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
        //������ʾ�� = ɫ�ʶ���������
		graphics.setRenderingHint(RenderingHints.KEY_DITHERING, RenderingHints.VALUE_DITHER_ENABLE);
        //�ʻ��淶��������ʾ�� = ������״����Ⱦ��������
		graphics.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_PURE);
	}
	
	public static Font getDefaultFont() {
		return new Font(DEFAULT_FONT, Font.PLAIN, DEFAULT_FONTSIZE);
	}
	public static Font getDefaultFont(int size) {
		return new Font(DEFAULT_FONT, Font.PLAIN, size);
	}
	public static Font getDefaultFont(int hint, int size) {
		return new Font(DEFAULT_FONT, hint, size);
	}
	
}
