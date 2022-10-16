package de.alexmiha.ui.draw;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

@SuppressWarnings("serial")
public class PaintComponent extends JComponent {
	

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(70, 20, 10, 10); // x, y, width, height
		g.drawRect(10, 10, 100, 100); // x, y, width, height
		g.drawString("Was geht", 50, 50); // string, x, y
	}
	
}
