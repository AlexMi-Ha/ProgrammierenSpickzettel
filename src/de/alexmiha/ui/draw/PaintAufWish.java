package de.alexmiha.ui.draw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;

import de.alexmiha.util.RandomExample;

@SuppressWarnings("serial")
public class PaintAufWish extends JFrame implements MouseListener, MouseMotionListener {
	

	public static void main(String[] args) {
		new PaintAufWish();
	}
	
	private Graphics g;
	
	private int lastX, lastY;
	
	public PaintAufWish() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,1000);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		
		this.setVisible(true);
		this.g = this.getGraphics();
		//g.setClip(200, 200, 500, 500); // paint region setzen
		
		this.add(new PaintComponent());
		
	}
	
	private boolean buttonDown = false; 
	
	@Override
	public void mousePressed(MouseEvent e) {
		buttonDown = false;
		if(e.getButton() == MouseEvent.BUTTON1) {
			this.lastX = e.getX();
			this.lastY = e.getY();
			buttonDown = true;
		}else if(e.getButton() == MouseEvent.BUTTON3) {
			g.setColor(new Color(RandomExample.RandomWithRandom(0, 256), RandomExample.RandomWithRandom(0, 256), RandomExample.RandomWithRandom(0, 256)));
			
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if(!buttonDown)
			return;
		g.drawLine(lastX, lastY, e.getX(), e.getY());
		this.lastX = e.getX();
		this.lastY = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

}
