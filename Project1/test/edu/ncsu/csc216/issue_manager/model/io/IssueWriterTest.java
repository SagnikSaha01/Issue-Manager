package edu.ncsu.csc216.issue_manager.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;


/**
 * Tests the Issue Writer class
 */
public class IssueWriterTest {
	/**
	 * Tests the writeIssuesToFile class
	 */
	@Test
	public void testwriteIssuesToFile() {
		
		
		
		ArrayList<Issue> issues = IssueReader.readIssuesFromFile("test-files/issue1.txt");
		
		Exception e = assertThrows(IllegalArgumentException.class,
				() -> IssueWriter.writeIssuesToFile("test-files/issue7.txt", issues));
				assertEquals(e.getMessage(),"Unable to save to file.");	
		checkFiles("test-files/issue_list.txt","test-files/issue1.txt");
		IssueWriter.writeIssuesToFile("test-files/issue_list.txt", issues);
		
	}
		/**
		 * Helper method to compare two files for the same contents
		 * @param expFile expected output
		 * @param actFile actual output
		 */
		private void checkFiles(String expFile, String actFile) {
			try (Scanner expScanner = new Scanner(new File(expFile));
				 Scanner actScanner = new Scanner(new File(actFile));) {
				
				while (expScanner.hasNextLine()) {
					assertEquals(expScanner.nextLine(), actScanner.nextLine());
				}
				
				expScanner.close();
				actScanner.close();
			} catch (IOException e) {
				fail("Error reading files.");
			}
		}
	
}
