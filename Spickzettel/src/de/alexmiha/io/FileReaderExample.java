package de.alexmiha.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class FileReaderExample {
	
	public static void ReadWithNio(final String filename) {
		try {
			List<String> lines = Files.readAllLines(new File(filename).toPath());
			lines.forEach(System.out::println);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void ReadWithFileReader(final String filename) {
		File file = new File(filename);
		try(FileReader f = new FileReader(file)) {
			int c;
			while((c = f.read()) != -1) {
				System.out.print((char)c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ReadWithBufferedReader(final String filename) {
		try(BufferedReader r = new BufferedReader(new FileReader(filename))) {
			while(r.ready()) {
				System.out.println(r.readLine());
				// if(line.isEmpty() || line == null) break;
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ReadWithScanner(final String filename) {
		try(Scanner sc = new Scanner(new FileReader(filename))) { // Scanner stream könnte auch System.in sein
			while(sc.hasNext()) {
				System.out.println(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
