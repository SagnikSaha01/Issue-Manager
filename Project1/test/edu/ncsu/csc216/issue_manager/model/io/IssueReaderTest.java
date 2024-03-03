package edu.ncsu.csc216.issue_manager.model.io;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.issue_manager.model.issue.Issue;

/**
 * Tests for the IssueReader class
 */
public class IssueReaderTest {
	/**
	 * Testing the readIssuesFromFile method
	 */
	@Test
	public void testReadIssuesFromFile(){
		ArrayList<Issue> allIssues = new ArrayList<Issue>();
		
		allIssues = IssueReader.readIssuesFromFile("test-files/issue1.txt");
		
		assertEquals(5,allIssues.size());
		Issue firstIssue = allIssues.get(0);
		assertAll("Issue", 
				() -> assertEquals(1, firstIssue.getIssueId()), 
				() -> assertEquals(Issue.NEW_NAME, firstIssue.getStateName()),
				() -> assertEquals(Issue.I_ENHANCEMENT, firstIssue.getIssueType()), 
				() -> assertEquals("Issue description", firstIssue.getSummary()),
				() -> assertNull(firstIssue.getOwner()),
				() -> assertFalse(firstIssue.isConfirmed()));
	}
	
}

