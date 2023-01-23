package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashSet;
import java.util.Scanner;

import exceptions.TreeException;

public class WordTracker {
	MyBSTree<Word> tree = new MyBSTree<Word>();
	
	/**
	 * Function that serizlaize the tree to file location
	 * Precondition: File Path Exists
	 * Postcondition: Tree is serialized to file location
	 * @param filePath the path to the file to serialize
	 * @throws if File Path is not found 
	 */
	public void serialize(String filePath) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(filePath);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(tree);
		out.close();
		fileOut.close();
	}

	/**
	 * Function that parses a file at given location, and forms a tree
	 * Precondition: file exists
	 * Postcondition: Tree is created from file
	 * @param fileName path to the file to serialize
	 * @throws FileNotFoundException if file not found, TreeException if error occurs in tree
	 */
	public void parseFile(String fileName) throws FileNotFoundException, TreeException{
		File file = new File(fileName);
		Scanner lineReader = new Scanner(file);
		int lineNumber=1;
		while(lineReader.hasNextLine()) {
			String line = lineReader.nextLine().replaceAll("\\p{Punct}", "").toLowerCase();
			String[] wordArray = line.split("\\s+");
			for(String word : wordArray) {
				if(word.equals("")) {
					continue;
				}
				Word newEntry = new Word(word,new HashSet<WordOccurence>());
				if(tree.contains(newEntry)) {
					BSTreeNode<Word> wordNode = tree.search(newEntry);
					wordNode.getElement().addOccurence(new WordOccurence(fileName,lineNumber));
				}else {
					newEntry.addOccurence(new WordOccurence(fileName,lineNumber));
					tree.add(newEntry);
				}
			}
			lineNumber++;
		}
		lineReader.close();
	}
	/**
	 * Function that sets word trackers tree
	 * Postcondition: Tree is set to given tree
	 * @param tree The tree to replace word tracker's tree
	 */
	public void setTree(MyBSTree tree) {
		this.tree = tree;
	}
	/**
	 * Function that fetches word tracker's tree
	 * Postcondition: returns word tracker's tree
	 */
	public MyBSTree<Word> getTree(){
		return tree;
	}
	
}
