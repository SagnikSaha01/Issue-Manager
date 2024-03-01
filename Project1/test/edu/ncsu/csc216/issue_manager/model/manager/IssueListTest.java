package edu.ncsu.csc216.issue_manager.model.manager;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;


/**
 * Tests the IssueList Class
 */
public class IssueListTest {
	/**
	 * Tests the IssueList method
	 */
	@Test
	public void testIssueList() {
		IssueList list = new IssueList();
		
		list.addIssue(IssueType.BUG, "summary", "note");
		assertEquals(1,list.getIssues().size());
		assertEquals(1,list.getIssueById(1).getIssueId());
		assertEquals("summary",list.getIssueById(1).getSummary());
		
		assertEquals(1,list.getIssuesByType(Issue.I_BUG).size());
		assertEquals(0,list.getIssuesByType(Issue.I_ENHANCEMENT).size());
	}
	
	
}
