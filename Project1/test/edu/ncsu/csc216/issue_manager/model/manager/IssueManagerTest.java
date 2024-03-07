package edu.ncsu.csc216.issue_manager.model.manager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;
/**
 * Testing the IssueManager class
 */
public class IssueManagerTest {
	/**
	 * Tests the loadIssuesFromFile method
	 */
	@Test
	public void testIssueManager() {
		IssueManager manager = IssueManager.getInstance();
		
		manager.loadIssuesFromFile("test-files/issue1.txt");
		
		assertEquals(1, manager.getIssueById(1).getIssueId());
		
		
		assertEquals("Issue description", manager.getIssueById(3).getSummary());
		
		Object[][] testArray = manager.getIssueListAsArray();
		assertEquals(1, testArray[0][0]);
		assertEquals(Issue.NEW_NAME, testArray[0][1]);
		assertEquals(Issue.I_ENHANCEMENT, testArray[0][2]);
		assertEquals("Issue description", testArray[0][3]);
		testArray = manager.getIssueListAsArrayByIssueType(Issue.I_BUG);
		assertEquals(2, testArray.length);
		assertEquals(Issue.CONFIRMED_NAME, testArray[0][1]);
		assertEquals(Issue.I_BUG, testArray[0][2]);
		assertEquals("Issue description", testArray[0][3]);

		manager = new IssueManager();
		manager.addIssueToList(IssueType.BUG, "summary", "note");
		manager.deleteIssueById(1);
		assertEquals(0,manager.getIssueListAsArray().length);
		
				
	}
	
}
