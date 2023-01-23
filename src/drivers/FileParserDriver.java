package drivers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import exceptions.TreeException;
import utilities.FilesPrinter;
import utilities.Iterator;
import utilities.LinePrinter;
import utilities.MyBSTree;
import utilities.OccurencePrinter;
import utilities.Word;
import utilities.WordOccurence;
import utilities.WordTracker;

public class FileParserDriver {

	public static void main(String args[]) {
		String fileName,outputType,outputFile;
		FileInputStream fileIn=null;
		ObjectInputStream in=null;
		MyBSTree<Word> tree =  new MyBSTree<Word>();
		try {
			fileIn = new FileInputStream("res/repository.ser");
			in = new ObjectInputStream(fileIn);
			tree=(MyBSTree<Word>) in.readObject();
			in.close();
			fileIn.close();
		}catch(Exception E) {
			
		}finally {
			try {
				fileIn.close();
				in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			if(args.length == 2) {
				fileName=args[0];
				outputType=args[1];
				if(outputType.toUpperCase().equals("-PF")) {
					WordTracker tracker = new WordTracker();
					tracker.setTree(tree);
					tracker.parseFile(fileName);
					tracker.serialize("res/repository.ser");
					Iterator<Word> inorderStack = tracker.getTree().inorderIterator();
					new FilesPrinter().display(inorderStack);
				}else if(outputType.toUpperCase().equals("-PL")) {
					WordTracker tracker = new WordTracker();
					tracker.setTree(tree);
					tracker.parseFile(fileName);
					tracker.serialize("res/repository.ser");
					Iterator<Word> inorderStack = tracker.getTree().inorderIterator();
					new LinePrinter().display(inorderStack);
				}else if(outputType.toUpperCase().equals("-PO")) {
					WordTracker tracker = new WordTracker();
					tracker.setTree(tree);
					tracker.parseFile(fileName);
					tracker.serialize("res/repository.ser");
					Iterator<Word> inorderStack = tracker.getTree().inorderIterator();
					new OccurencePrinter().display(inorderStack);
				}
			}else if(args.length ==3) {
				fileName=args[0];
				outputType=args[1];
				if(args[2].substring(0,2).toUpperCase().equals("-F")) {
					outputFile=args[2].substring(2).replaceAll("\"", "");
				}else {
					throw new Exception();
				}
				if(outputType.toUpperCase().equals("-PF")) {
					WordTracker tracker = new WordTracker();
					tracker.setTree(tree);
					tracker.parseFile(fileName);
					tracker.serialize("res/repository.ser");
					Iterator<Word> inorderStack = tracker.getTree().inorderIterator();
					new FilesPrinter().print(inorderStack,outputFile);
				}else if(outputType.toUpperCase().equals("-PL")) {
					WordTracker tracker = new WordTracker();
					tracker.setTree(tree);
					tracker.parseFile(fileName);
					tracker.serialize("res/repository.ser");
					Iterator<Word> inorderStack = tracker.getTree().inorderIterator();
					new LinePrinter().print(inorderStack,outputFile);
				}else if(outputType.toUpperCase().equals("-PO")) {
					WordTracker tracker = new WordTracker();
					tracker.setTree(tree);
					tracker.parseFile(fileName);
					tracker.serialize("res/repository.ser");
					Iterator<Word> inorderStack = tracker.getTree().inorderIterator();
					new OccurencePrinter().print(inorderStack,outputFile);
				}
			}
			else {
				throw new Exception();
			}
		}catch(Exception e) {
			System.out.println("An unkown error has occured");
			System.exit(-1);
		}
	}
}
