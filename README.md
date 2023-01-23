# Word Tracker

@Author: Scott Normore, Bryan Meyer, Gao Liu, Saksham Ohri.

The project has four packages drivers, tests, utilities and 
exceptions. The utilities package contains ADTs and implementations of BSTree which is used in WordTracker
to read text files and collects and stores all the unique words it finds in those files.The BST will be 
able to store information from multiple text files. It will also keep track of each occurrence of a word 
in a file and the line on which it was found in that file. This information will be stored in a list for 
each word object stored in the BST. The program will also produce output, specified by the user at command
line, to generate reports using a variety of iterators built into the BST.

To run, use these commands from command line in the directory of the jar file.

Example 1 <br>
java -jar WordTracker.jar "filepath" -PO <br>
Example 2 <br>
java -jar WordTracker.jar "filepath" -PL -F"filepath"
