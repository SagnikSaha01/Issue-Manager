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
		} catch (Exception e) {	
			throw new IllegalArgumentException("Unable to load file");
		}  
 	    ArrayList<Issue> issues = new ArrayList<Issue>();
 	    String text = "";
 	    while (fileReader.hasNextLine()) { 
 	       text = text + fileReader.nextLine() + '\n';
 	    }
 	    text = text.substring(0,text.length()-1);
 	    Scanner issueDelimeter = new Scanner(text).useDelimiter("\\r?\\n?[*]");
 	    while(issueDelimeter.hasNextLine()) {
 	    	String issueLine = issueDelimeter.next();
 	    	issues.add(processIssue(issueLine));
 	    }
 	    
 	    return issues;
	}
	/**
	 * Processes the issues from the file
	 * @param fileName file from which issues will be processed
	 * @return the issue that is processed
	 */
    private static Issue processIssue(String line) throws IllegalArgumentException{
    	if(line.substring(0,1).equals("-")) {
    		throw new IllegalArgumentException("Issue cannot be created.");
    	}
    	Scanner in = new Scanner(line).useDelimiter("\r?\n?[-]");
    	String issueObject = in.next();
    	Scanner issueParse = new Scanner(issueObject).useDelimiter(",");
    	ArrayList<String> data = new ArrayList<>();
		while(issueParse.hasNext()) {
			data.add(issueParse.next());
		}
		if(data.size() == 6) {
			data.add("");
		}
		ArrayList<String> notes = new ArrayList<>();
		while(in.hasNext()) {
			notes.add(in.next());
		}
		Issue newIssue = new Issue(Integer.parseInt(data.get(0)),data.get(1),data.get(2),data.get(3),data.get(4),Boolean.parseBoolean(data.get(5)),data.get(6),notes);
    	return newIssue;
    }
}
