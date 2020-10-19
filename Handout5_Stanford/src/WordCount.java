
/*
 * File: WordCount.java
 * --------------------
 * Counts the characters, words, and lines in a file.
 */
import acm.program.*;
import java.io.*;

public class WordCount extends ConsoleProgram {

	public void run() {

		String line;
		// Initializing counters
		int countWord = 0;
		int countLines = 0;
		int countChars = 0;

		
		BufferedReader reader = openFileReader("File: ");
	
		// Reading line by line from the
		// file until a null is returned
		try {
		while ((line = reader.readLine()) != null) {
			
				countChars += line.length();
				String[] wordList = line.split("( )|(')");
				countWord += wordList.length;
				String[] sentenceList = line.split("\n");
				countLines += sentenceList.length;
			}

			reader.close();
		}
			catch (IOException ex) {
			println("An Exception has occurred");
			
		}

		println("Lines = " + countLines);
		println("Words = " + countWord);
		println("Chars = " + countChars);


	}

	private BufferedReader openFileReader(String prompt) {
		BufferedReader reader = null;
		while (reader == null) {
			String name = readLine(prompt);
			try {
				reader = new BufferedReader(new FileReader(name));
			} catch (IOException ex) {
				println("Can't open that file.");
			}
		}
		return reader;
	}
}