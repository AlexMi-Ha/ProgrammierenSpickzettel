package de.alexmiha;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class SnatChatWindow implements SnatChatFrontend {

	private JFrame frame;
	private ChatMessagesComponent messages;
	private JTextField txtMsg;
	
	private SnatChatRoom room;
	private Account account;
	
	public SnatChatWindow(SnatChatRoom room, Account acc) {
		this.room = room;
		this.account = acc;		
		generateView();
	}
	
	private void generateView() {
		frame = new JFrame(account.getName() + " (" + room.getRoomName() + ")");
		
		{
			JLabel lblName = new JLabel(account.getName());
			lblName.setForeground(account.getColor());
			frame.add(lblName, BorderLayout.NORTH);
		}
		
		messages = new ChatMessagesComponent();
		frame.add(messages, BorderLayout.CENTER);
		
		{
			JPanel pnlUI = new JPanel();
			pnlUI.setLayout(new GridLayout(2,1));
			
			JPanel pnlButtons = new JPanel();
			pnlButtons.setLayout(new GridLayout(1,3));
			JRadioButton btnAvailable = new JRadioButton("Available");
			btnAvailable.setSelected(account.getState() == State.AVAILABLE);
			btnAvailable.addActionListener(e -> updateState(State.AVAILABLE));

			JRadioButton btnAway = new JRadioButton("Away");
			btnAway.setSelected(account.getState() == State.AWAY);
			btnAway.addActionListener(e -> updateState(State.AWAY));
			
			JRadioButton btnDnD = new JRadioButton("Do not disturb");
			btnDnD.setSelected(account.getState() == State.DND);
			btnDnD.addActionListener(e -> updateState(State.DND));
			
			ButtonGroup group = new ButtonGroup();
			group.add(btnAvailable);
			group.add(btnAway);
			group.add(btnDnD);
			
			pnlButtons.add(btnAvailable);
			pnlButtons.add(btnAway);
			pnlButtons.add(btnDnD);
			pnlUI.add(pnlButtons);
			
			JPanel pnlInput = new JPanel();
			pnlInput.add(txtMsg = new JTextField());
			txtMsg.setColumns(30);
			JButton btnSend = new JButton("Send");
			btnSend.addActionListener(this::send);
			txtMsg.addActionListener(this::send);
			pnlInput.add(btnSend);
			
			pnlUI.add(pnlInput);
			
			frame.add(pnlUI, BorderLayout.SOUTH);
		}
		
		frame.setSize(500, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void updateState(State state) {
		this.account.setState(state);
		this.room.sendMessage("State of user '" 
				+ account.getName() + "' is now '"
				+ account.getState().label + "'");
	}
	
	private void send(ActionEvent e) {
		if(txtMsg.getText().isEmpty()) {
			JOptionPane.showMessageDialog(frame, 
					"Dear " + account.getName() 
					+ ", please enter a message",
					
					"Warning!", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		Message msg = new Message(txtMsg.getText(), account);
		room.sendMessage(msg);
		txtMsg.setText("");
	}
	
	@Override
	public void receiveMessage(Message msg) {
		DeletableLabel txt = new DeletableLabel(msg.getAccount().getName() + ": " + msg.getText(), messages, 30);
		txt.setForeground(msg.getAccount().getColor());
		this.messages.add(txt);
	}

	@Override
	public void receiveMessage(String text) {
		DeletableLabel txt = new DeletableLabel(text, messages, 30);
		txt.setForeground(Color.GRAY);
		this.messages.add(txt);
	}

	@Override
	public Account getAccount() {
		return account;
	}
}
