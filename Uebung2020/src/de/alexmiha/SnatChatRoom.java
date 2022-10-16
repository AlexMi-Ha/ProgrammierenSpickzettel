package de.alexmiha;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class SnatChatRoom {
	
	private String roomName;
	private List<SnatChatFrontend> listeners;
	
	public SnatChatRoom(String roomName) {
		this.roomName = roomName;
		this.listeners = new ArrayList<SnatChatFrontend>();
	}
	
	public String getRoomName() {
		return roomName;
	}
	
	public void register(SnatChatFrontend s) {
		this.listeners.add(s);
		List<String> log = getLog();
		log.forEach(e -> s.receiveMessage(e));
	}
	
	public void unregister(SnatChatFrontend s) {
		this.listeners.remove(s);
	}
	
	public void sendMessage(Message msg) {
		listeners.forEach(e -> e.receiveMessage(msg));
		log(msg.getAccount().getName() + ": " + msg.getText());
	}
	
	public void sendMessage(String text) {
		listeners.forEach(e -> e.receiveMessage(text));
		log(text);
	}
	
	private void log(String message) {
		File file = new File(roomName + ".txt");
		try(FileWriter f = new FileWriter(file, true)) {
			f.write(rot13(message) + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private List<String> getLog() {
		try {
			List<String> lines = Files.readAllLines(new File(roomName + ".txt").toPath());
			List<String> lastLog = new ArrayList<String>();
			for(int i = lines.size() - 10 >= 0 ? lines.size() - 10 : 0; i < lines.size(); ++i) {
				lastLog.add(rot13(lines.get(i)));
			}
			return lastLog;
		} catch (IOException e) {
			System.out.println("No log file to read");
		}
		return new ArrayList<String>();
	}
	
	public static String rot13(String message) {
		char[] letters = message.toCharArray();
		String crypt = "";
		for(char c : letters) {
			if(c < 'A' || c > 'z') {
				crypt += c;
				continue;
			}
			if(c >= 'A' && c <= 'M' || c >= 'a' && c <= 'm')
				c += 13;
			else
				c -= 13;
			crypt += c;
		}
		
		return crypt;
	}

}
