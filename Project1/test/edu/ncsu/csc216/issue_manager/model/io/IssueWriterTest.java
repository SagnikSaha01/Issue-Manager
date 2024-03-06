package edu.ncsu.csc216.issue_manager.model.io;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.issue_manager.model.manager.IssueManager;


/**
 * Tests the Issue Writer class
 */
public class IssueWriterTest {
	/**
	 * Tests the writeIssuesToFile class
	 */
	@Test
	public void testwriteIssuesToFile() {
		IssueManager m = new IssueManager();
		assertDoesNotThrow(() -> m.loadIssuesFromFile("test-files/issue1.txt"));
		assertDoesNotThrow(() -> m.saveIssuesToFile("test-files/issue_list.txt"));
	}
	
}
