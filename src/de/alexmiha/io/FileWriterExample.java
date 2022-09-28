package de.alexmiha.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

	
	public static void WriteWithFileWriter(final String filename, final String content) {
		File file = new File(filename);
		try(FileWriter f = new FileWriter(file, true)) {  // FileWriter(FILE, APPEND_MODE<True/False>)   -> AppendMode: an die Datei anhängen oder überschreiben
			f.write(content + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static boolean MakeDirectory(final String filename) {
		File dir = new File(filename);
		boolean result = dir.mkdir(); // nur den Ordner erstellen
		result = dir.mkdirs(); // den kompletten Pfad zum Ordner + den Ordner erstellen
		
		return result; // True wenn der Ordner (oder alle Ordner) richtig erstellt wurden
	}
	
	public static void DeleteFile(final String filename) {
		File file = new File(filename);
		file.delete();
	}
	
	
}
