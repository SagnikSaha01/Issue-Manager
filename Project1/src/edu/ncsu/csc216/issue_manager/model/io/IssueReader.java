package edu.ncsu.csc216.issue_manager.model.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import edu.ncsu.csc216.issue_manager.model.issue.Issue;
/**
 * Class for reading Issues from a file
 */
public class IssueReader {
	/**
	 * Reads the issues from a file and stores them in an array list
	 * @param fileName file from which the issues will be read from
	 * @return array list with the stored issues
	 */
	public static ArrayList<Issue> readIssuesFromFile(String fileName) {
		Scanner fileReader = null;
		try {
			fileReader = new Scanner(new FileInputStream(fileName));
		} catch (FileNotFoundException e) {	
			throw new IllegalArgumentException("Unable to load file");
		}  
 	    ArrayList<Issue> issues = new ArrayList<Issue>();
 	    String text = "";
 	    while (fileReader.hasNextLine()) { 
 	       text = text + fileReader.nextLine() + "\n";
 	    }
 	    Scanner issueDelimeter = new Scanner(text).useDelimiter("\\r?\\n?[*]");
 	    while(issueDelimeter.hasNextLine()) {
 	    	processIssue(issueDelimeter.nextLine());
 	    }
 	    //Return the ArrayList with all the courses we read!
 	    return issues;
	}
	/**
	 * Processes the issues from the file
	 * @param fileName file from which issues will be processed
	 * @return the issue that is processed
	 */
    private static Issue processIssue(String line) throws IllegalArgumentException{
    	Scanner in = new Scanner(line);
    	in.useDelimiter(",");
    	ArrayList<String> data = new ArrayList<>();
		while(in.hasNext()) {
			data.add(in.next());
		} 
		ArrayList<String> notes = new ArrayList<>();
		Issue newIssue = new Issue(Integer.parseInt(data.get(0)),data.get(1),data.get(2),data.get(3),data.get(4),Boolean.parseBoolean(data.get(5)),data.get(6),notes);
		
    	return null;
    }
}
