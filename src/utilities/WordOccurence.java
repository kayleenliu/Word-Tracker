package utilities;

import java.io.Serializable;

public class WordOccurence implements Serializable {
	String fileName;
	int lineNumber;
	//Constructors
	
	public WordOccurence() {
		
	}
	public WordOccurence(String fileName,int lineNumber) {
		this.fileName = fileName;
		this.lineNumber = lineNumber;
	}
	
	//setters and getters
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}
	
	
}
