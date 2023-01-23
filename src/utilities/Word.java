package utilities;

import java.io.Serializable;
import java.util.Set;
import java.util.ArrayList;
/**
 * Class that stores a word
 */
public class Word implements Comparable<Word>, Serializable {
	private String value;
	private int frequency = 0;
	private Set<WordOccurence> set;
	
	//constructors
	
	public Word(){
		
	}

	public Word(String value, Set<WordOccurence> set){
		this.value = value;
		this.set = set;
	}
	
	//setters and getters
	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Set<WordOccurence> getOccurences() {
		return set;
	}

	public void setOccurences(Set<WordOccurence> set) {
		this.set = set;
	}

	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
	
	/**
	 * Function that adds occurence to the word
	 * Precondition: Word exists, occurence exists
	 * Postcondition: Occurence added, frequency updated
	 * @param WordOccurence Occurence of word in file and line number
	 */	
	public void addOccurence(WordOccurence word) {
		setFrequency(getFrequency() + 1);
		set.add(word);
	}
	
	//used to return a list of files which words occured
	/**
	 * Function that returns the files that the word occurs in
	 * Precondition: Word exists
	 * Postcondition: list of files in which the word occured in
	 */	
	public ArrayList<String> getFilesOccured(){
		ArrayList<String> filenames = new ArrayList<>();
		for(WordOccurence occurence : set) {
			if(!filenames.contains(occurence.getFileName())) {
				filenames.add(occurence.getFileName());
			}
		}
		return filenames;
	}
	/**
	 * Function that returns a list of line numbers pertaining to a file name where the word occurs 
	 * Precondition: File exists set of word occurences
	 * Postcondition: returns line numbers in arraylist
	 * @param file File to be processed
	 */	
	public ArrayList<Integer> getLineNumbers(String file) {
		ArrayList<Integer> linenumbers = new ArrayList<>();
		for(WordOccurence occurence : set) {
			if(!linenumbers.contains(occurence.getLineNumber()) && occurence.getFileName().equals(file)) {
				linenumbers.add(occurence.getLineNumber());
			}
		}
		return linenumbers;
	}
	
	//comparable method
	
	@Override
	public int compareTo(Word o) {
		return value.compareTo(o.getValue());
	}

}
