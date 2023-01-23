package utilities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class OccurencePrinter {
	
	/**
	 * Display method will display the word,file containing that word, and frequency of that word in the file
	 * Precondition: Stack of type word exists and is sent as parameter
	 * Postcondition: Displays the word, file containing the word, and number of times it is present 
	 * @param Stack of element type word
	 */
	public void display(Iterator<Word> stack) {
		while(stack.hasNext()) {
			Word word=stack.next();
			ArrayList<String> filesOccured = word.getFilesOccured();
			for(String file : filesOccured) {
				System.out.print("Word: '"+word.getValue()+"' occured in "+ file + " at lines: ");
				for(int lineNumber : word.getLineNumbers(file)) {
					System.out.print(lineNumber + " ");
				}
				System.out.println();
			}
			System.out.println("'"+word.getValue()+"' has occured "+word.getFrequency()+" times");
		}
	}
	
	/**
	 * Print method will write to the file the value of word,file containing that word, and frequency of that word in the file
	 * Precondition: Stack of type word exists and is sent as parameter with the name of file
	 * Postcondition: Writes to the file about word, file containing that word, and number of times it is present 
	 * @param Stack of element type word and String filename
	 */
	public void print(Iterator<Word> stack, String fileName) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(fileName);
		while(stack.hasNext()) {
			Word word=stack.next();
			ArrayList<String> filesOccured = word.getFilesOccured();
			for(String file : filesOccured) {
				String fileOutput="";
				fileOutput+=("Word: '"+word.getValue()+"' occured in "+ file + " at lines: ");
				for(int lineNumber : word.getLineNumbers(file)) {
					fileOutput+=(lineNumber + " ");
				}
				writer.println(fileOutput);
			}
			writer.println("'"+word.getValue()+"' has occured "+word.getFrequency()+" times");
		}
		writer.close();
	}
}
