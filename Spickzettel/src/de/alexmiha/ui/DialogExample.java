package de.alexmiha.ui;

import javax.swing.JOptionPane;

public class DialogExample {

	public static void main(String[] args) {
		/* 	ERROR_MESSAGE
			INFORMATION_MESSAGE
			WARNING_MESSAGE
			QUESTION_MESSAGE
			PLAIN_MESSAGE
		 */
		JOptionPane.showMessageDialog(null, "Kekw", "Title", JOptionPane.ERROR_MESSAGE); // showMessageDialog(Component parent, object message)   -> parent -> element to freeze (null if none)
		JOptionPane.showConfirmDialog(null, "Kekw"); // showMessageDialog(Component parent, object message)   -> parent -> element to freeze (null if none)
	}
}
