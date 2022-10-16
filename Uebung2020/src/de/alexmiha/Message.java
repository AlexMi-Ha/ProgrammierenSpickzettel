package de.alexmiha;

public class Message {

	private String text;
	private Account account;
	
	public Message(String text, Account account) {
		this.text = text;
		this.account = account;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
