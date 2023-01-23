package utilities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class LinePrinter {
	/**
	 * Display method will display the word, the file and line numbers containing that word.
	 * Precondition: Stack of type word exists 
	 * Postcondition: Displays the word, the file and line numbers containing that word. 
	 * @param Stack of element type word
	 */
	public void display(Iterator<Word> stack) {
		while(stack.hasNext()) {
			Word word = stack.next();
			ArrayList<String> filesOccured = word.getFilesOccured();
			for(String file : filesOccured) {
				System.out.print("Word: '"+word.getValue()+"' occured in "+ file + " at lines: ");
				for(int lineNumber : word.getLineNumbers(file)) {
					System.out.print(lineNumber + " ");
				}
				System.out.println();
			}
		}
	}

	/**
	 * Print method will write to the file the value of word,the file and line numbers containing that word.
	 * Precondition: Stack of type word exists 
	 * Postcondition: Writes to the file about word, the file and line numbers containing that word
	 * @param Stack of element type word and String filename
	 */
	
	public void print(Iterator<Word> stack, String fileName) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(fileName);
		while(stack.hasNext()) {
			String string="";
			Word word = stack.next();
			ArrayList<String> filesOccured = word.getFilesOccured();
			for(String file : filesOccured) {
				string+="Word: '"+word.getValue()+"' occured in "+ file + " at lines: ";
				for(int lineNumber : word.getLineNumbers(file)) {
					string+=lineNumber + " ";
				}
				writer.println(string);
			}
		}
		writer.close();
	}
}
