package utilities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FilesPrinter {
	
	/**
	 * Display method will display the word and the files containing that word.
	 * Precondition: Stack of type word exists 
	 * Postcondition: Displays the word and the files containing that word.
	 * @param Stack of element type word
	 */
	public void display(Iterator<Word> stack) {
		while(stack.hasNext()) {
			Word word = stack.next();
			ArrayList<String> filesOccured = word.getFilesOccured();
			System.out.print("Word: '"+word.getValue()+"' occured in files: ");
			for(String file : filesOccured) {
				System.out.print(file+" ");
			}
			System.out.println();
		}
	}
	
	/**
	 * Print method will write to the file the word and the files containing that word.
	 * Precondition: Stack of type word exists 
	 * Postcondition: Writes to the file the value of word and the files containing that word.
	 * @param Stack of element type word and String filename
	 */
	public void print(Iterator<Word> stack, String fileName) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(fileName);
		while(stack.hasNext()) {
			String string ="";
			Word word = stack.next();
			ArrayList<String> filesOccured = word.getFilesOccured();
			string += "Word: '"+word.getValue()+"' occured in files: ";
			for(String file : filesOccured) {
				string += file+" ";
			}
			writer.println(string);
		}
		writer.close();
	}
}
