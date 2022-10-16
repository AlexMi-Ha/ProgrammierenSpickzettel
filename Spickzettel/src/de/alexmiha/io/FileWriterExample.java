package de.alexmiha.io;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class FileWriterExample {
	
	public static void WriteWithNio(final String filename, final String[] content, final boolean appendMode) {
	try {
		if(appendMode)
			Files.write(new File(filename).toPath(), Arrays.asList(content), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		else
			Files.write(new File(filename).toPath(), Arrays.asList(content));
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	
	public static void WriteWithFileWriter(final String filename, final String content, final boolean appendMode) {
		File file = new File(filename);
		try(FileWriter f = new FileWriter(file, appendMode)) {  // FileWriter(FILE, APPEND_MODE<True/False>)   -> AppendMode: an die Datei anhängen oder überschreiben
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
