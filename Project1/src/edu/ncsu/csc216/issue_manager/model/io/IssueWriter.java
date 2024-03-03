package edu.ncsu.csc216.issue_manager.model.io;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import edu.ncsu.csc216.issue_manager.model.issue.Issue;
/**
 * Class for writing Issues to a file
 */
public class IssueWriter {
	/**
	 * Writes a list of issues and saves it onto a file
	 * @param fileName name of the file that stores the data
	 * @param issueList list of the issues that will be saved
	 */
	public static void writeIssuesToFile(String fileName, List<Issue> issueList) {
		
		try {
			System.out.println(fileName);
			PrintStream fileWriter = new PrintStream(new File(fileName));
			
			for (Issue i : issueList) {
				fileWriter.println(i.toString());
			}
			
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("Unable to save to file.");
		}
    	
    	
	}
}
