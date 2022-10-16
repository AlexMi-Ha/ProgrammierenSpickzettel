package de.alexmiha.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UIExample {
	
	public static void main(String[] args) {
		new UIExample();
	}

	private JTextField tF1, tF2, tF3;
	
	private JFrame frame;
	
	public UIExample() {
		frame = new JFrame("Title");
		//frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		{
			JPanel pnl = new JPanel();
			int rows = 3, cols = 2, horizGap = 20, verticalGap = 20;
			pnl.setLayout(new GridLayout(rows, cols, horizGap, verticalGap));
			
			// -----------------------------------------------------
			
			pnl.add(tF1 = new JTextField());
			JButton btn1 = new JButton("Button 1");
			btn1.addActionListener(e -> {
				System.out.println("Button with lambda pressed");
				System.out.println(tF1.getText());
			});
			pnl.add(btn1);
			
			// -----------------------------------------------------
			
			pnl.add(tF2 = new JTextField());
			JButton btn2 = new JButton("Button 2");
			btn2.addActionListener(this::EventKekw);
			pnl.add(btn2);
			
			// -----------------------------------------------------
			
			pnl.add(tF3 = new JTextField());
			JButton btn3 = new JButton("Button 3");
			btn3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("Button with nested class pressed");
					System.out.println(tF3.getText());
				}
				
			});
			pnl.add(btn3);
			
			frame.add(pnl, BorderLayout.CENTER);
		}
		frame.pack();
		frame.setVisible(true);
	}
	
	public void EventKekw(ActionEvent e) {
		System.out.println("Button with class lambda pressed");
		System.out.println(tF2.getText());
	}
	
}
