package edu.ncsu.csc216.issue_manager.model.issue;


import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.command.Command.CommandValue;
import edu.ncsu.csc216.issue_manager.model.command.Command.Resolution;

/**
 * Tests the Issue class
 */
public class IssueTest {
	/**
	 * Tests the creation of valid issue objects
	 */
	@Test
	public void testValidIssue() {
		ArrayList<String> notes = new ArrayList<String>();
		notes.add("Example note 1");
		Issue exampleIssue = new Issue(1, Issue.CONFIRMED_NAME, Issue.I_BUG, "Example bug", "owner", true, "", notes);
		
		assertEquals("owner", exampleIssue.getOwner());
		assertEquals(1, exampleIssue.getIssueId());
		assertEquals(Issue.CONFIRMED_NAME, exampleIssue.getStateName());
		assertEquals(Issue.I_BUG, exampleIssue.getIssueType());
		assertEquals("Example bug", exampleIssue.getSummary());
		assertTrue(exampleIssue.isConfirmed());
		assertNull(exampleIssue.getResolution());
		assertEquals(notes, exampleIssue.getNotes());
		
		exampleIssue = new Issue(1, Issue.VERIFYING_NAME, Issue.I_ENHANCEMENT, "Example bug", "owner", false, Command.R_FIXED, notes);
		assertEquals(Issue.VERIFYING_NAME, exampleIssue.getStateName());
		assertEquals(Issue.I_ENHANCEMENT, exampleIssue.getIssueType());
		assertEquals(Command.R_FIXED, exampleIssue.getResolution());
		exampleIssue = new Issue(1, Issue.WORKING_NAME, Issue.I_BUG, "Example bug", "owner", true, Command.R_WONTFIX, notes);
		assertEquals(Command.R_WONTFIX, exampleIssue.getResolution());
		assertEquals(Issue.WORKING_NAME, exampleIssue.getStateName());
		exampleIssue = new Issue(1, Issue.CLOSED_NAME, Issue.I_BUG, "Example bug", "owner", true, Command.R_FIXED, notes);
		assertEquals(Command.R_FIXED, exampleIssue.getResolution());
		assertEquals(Issue.CLOSED_NAME, exampleIssue.getStateName());
		
		
	}
	/**
	 * Tests the creation of invalid issues
	 */
	@Test
	public void testInvalidIssues() {
		
		ArrayList<String> notes = new ArrayList<String>();
		notes.add("Example note 1");
		Exception e = assertThrows(IllegalArgumentException.class,
					() -> new Issue(1, Issue.WORKING_NAME, Issue.I_BUG, "Example bug", "", true, Command.R_WORKSFORME, notes));
		assertEquals(e.getMessage(), "Issue cannot be created.");	
		e = assertThrows(IllegalArgumentException.class,
				() -> new Issue(1, Issue.VERIFYING_NAME, Issue.I_BUG, "Example bug", "owner", true, null, notes));
		assertEquals(e.getMessage(), "Issue cannot be created.");	
		e = assertThrows(IllegalArgumentException.class,
				() -> new Issue(1, Issue.CONFIRMED_NAME, Issue.I_ENHANCEMENT, "Example bug", "owner", true, "", notes));
		assertEquals(e.getMessage(), "Issue cannot be created.");	
		e = assertThrows(IllegalArgumentException.class,
				() -> new Issue(1, Issue.WORKING_NAME, Issue.I_BUG, "Example bug", "owner", false, Command.R_WORKSFORME, notes));
		assertEquals(e.getMessage(), "Issue cannot be created.");
		e = assertThrows(IllegalArgumentException.class,
				() -> new Issue(1, Issue.VERIFYING_NAME, Issue.I_BUG, "Example bug", "owner", false, Command.R_WORKSFORME, notes));
		assertEquals(e.getMessage(), "Issue cannot be created.");	
		e = assertThrows(IllegalArgumentException.class,
				() -> new Issue(1, Issue.CLOSED_NAME, Issue.I_BUG, "Example bug", "owner", false, null, notes));
		assertEquals(e.getMessage(), "Issue cannot be created.");
		e = assertThrows(IllegalArgumentException.class,
				() -> new Issue(1, Issue.WORKING_NAME, Issue.I_ENHANCEMENT, "Example bug", "owner", true, Command.R_DUPLICATE, notes));
		assertEquals(e.getMessage(), "Issue cannot be created.");
		e = assertThrows(IllegalArgumentException.class,
				() -> new Issue(-2, Issue.WORKING_NAME, Issue.I_BUG, "Example bug", "owner", false, Command.R_DUPLICATE, notes));
		assertEquals(e.getMessage(), "Issue cannot be created.");
		e = assertThrows(IllegalArgumentException.class,
				() -> new Issue(1, Issue.WORKING_NAME, Issue.I_BUG, "Example bug", null, false, Command.R_DUPLICATE, notes));
		assertEquals(e.getMessage(), "Issue cannot be created.");
		
		
		
	}
	/**
	 * Tests transitions between states
	 */
	@Test
	public void testTransitions() {
		ArrayList<String> notes = new ArrayList<String>();
		notes.add("Example note 1");
		Issue exampleIssue = new Issue(1, Issue.VERIFYING_NAME, Issue.I_ENHANCEMENT, "Example bug", "owner", false, Command.R_FIXED, notes);
		Command exampleCommand = new Command(CommandValue.VERIFY, "owner", Resolution.WONTFIX, "example note");
		exampleIssue.update(exampleCommand);
		assertEquals(Issue.CLOSED_NAME, exampleIssue.getStateName());
		
		exampleCommand = new Command(CommandValue.REOPEN, "owner", Resolution.WONTFIX, "example note");
		exampleIssue = new Issue(1, Issue.VERIFYING_NAME, Issue.I_ENHANCEMENT, "Example bug", "owner", false, Command.R_FIXED, notes);
		exampleIssue.update(exampleCommand);
		assertEquals(Issue.WORKING_NAME, exampleIssue.getStateName());
		
		exampleCommand = new Command(CommandValue.ASSIGN, "owner", Resolution.WONTFIX, "example note");
		exampleIssue = new Issue(1, Issue.NEW_NAME, Issue.I_ENHANCEMENT, "Example bug", "owner", false, Command.R_DUPLICATE, notes);
		exampleIssue.update(exampleCommand);
		assertEquals(Issue.WORKING_NAME, exampleIssue.getStateName());
		
		exampleCommand = new Command(CommandValue.CONFIRM, "owner", Resolution.WONTFIX, "example note");
		exampleIssue = new Issue(1, Issue.NEW_NAME, Issue.I_BUG, "Example bug", "owner", false, Command.R_DUPLICATE, notes);
		exampleIssue.update(exampleCommand);
		assertEquals(Issue.CONFIRMED_NAME, exampleIssue.getStateName());
		
		exampleCommand = new Command(CommandValue.RESOLVE, "owner", Resolution.WONTFIX, "example note");
		exampleIssue = new Issue(1, Issue.NEW_NAME, Issue.I_ENHANCEMENT, "Example bug", "owner", false, Command.R_DUPLICATE, notes);
		exampleIssue.update(exampleCommand);
		assertEquals(Issue.CLOSED_NAME, exampleIssue.getStateName());
		
		exampleCommand = new Command(CommandValue.REOPEN, "owner", Resolution.WORKSFORME, "example note");
		exampleIssue = new Issue(1, Issue.CLOSED_NAME, Issue.I_BUG, "Example bug", "owner", true, Command.R_DUPLICATE, notes);
		exampleIssue.update(exampleCommand);
		assertEquals(Issue.WORKING_NAME, exampleIssue.getStateName());
		
		exampleCommand = new Command(CommandValue.REOPEN, "", Resolution.WORKSFORME, "example note");
		exampleIssue = new Issue(1, Issue.CLOSED_NAME, Issue.I_BUG, "Example bug", "", true, Command.R_DUPLICATE, notes);
		exampleIssue.update(exampleCommand);
		assertEquals(Issue.CONFIRMED_NAME, exampleIssue.getStateName());
		
		exampleCommand = new Command(CommandValue.REOPEN, "", Resolution.WORKSFORME, "example note");
		exampleIssue = new Issue(1, Issue.CLOSED_NAME, Issue.I_BUG, "Example bug", "", false, Command.R_DUPLICATE, notes);
		exampleIssue.update(exampleCommand);
		assertEquals(Issue.NEW_NAME, exampleIssue.getStateName());
		
		exampleCommand = new Command(CommandValue.REOPEN, "owner", Resolution.WONTFIX, "example note");
		exampleIssue = new Issue(1, Issue.CLOSED_NAME, Issue.I_ENHANCEMENT, "Example bug", "owner", false, Command.R_DUPLICATE, notes);
		exampleIssue.update(exampleCommand);
		assertEquals(Issue.WORKING_NAME, exampleIssue.getStateName());
		
		exampleCommand = new Command(CommandValue.RESOLVE, "", Resolution.WONTFIX, "example note");
		exampleIssue = new Issue(1, Issue.CLOSED_NAME, Issue.I_ENHANCEMENT, "Example bug", "", false, Command.R_DUPLICATE, notes);
		exampleIssue.update(exampleCommand);
		assertEquals(Issue.NEW_NAME, exampleIssue.getStateName());
		
		exampleCommand = new Command(CommandValue.ASSIGN, "owner", Resolution.DUPLICATE, "example note");
		exampleIssue = new Issue(1, Issue.CONFIRMED_NAME, Issue.I_BUG, "Example bug", "owner", false, "", notes);
		exampleIssue.update(exampleCommand);
		assertEquals(Issue.WORKING_NAME, exampleIssue.getStateName());
		
		exampleCommand = new Command(CommandValue.REOPEN, "owner", Resolution.WONTFIX, "example note");
		exampleIssue = new Issue(1, Issue.CONFIRMED_NAME, Issue.I_BUG, "Example bug", "owner", false, "", notes);
		exampleIssue.update(exampleCommand);
		assertEquals(Issue.CLOSED_NAME, exampleIssue.getStateName());
		
		exampleCommand = new Command(CommandValue.RESOLVE, "owner", Resolution.FIXED, "example note");
		exampleIssue = new Issue(1, Issue.WORKING_NAME, Issue.I_BUG, "Example bug", "owner", true, Command.R_DUPLICATE, notes);
		exampleIssue.update(exampleCommand);
		assertEquals(Issue.VERIFYING_NAME, exampleIssue.getStateName());
		
		exampleCommand = new Command(CommandValue.REOPEN, "owner", Resolution.WONTFIX, "example note");
		exampleIssue = new Issue(1, Issue.WORKING_NAME, Issue.I_BUG, "Example bug", "owner", true, Command.R_DUPLICATE, notes);
		exampleIssue.update(exampleCommand);
		assertEquals(Issue.CLOSED_NAME, exampleIssue.getStateName());
		
		exampleCommand = new Command(CommandValue.REOPEN, "owner", Resolution.WORKSFORME, "example note");
		exampleIssue = new Issue(1, Issue.WORKING_NAME, Issue.I_BUG, "Example bug", "owner", true, Command.R_DUPLICATE, notes);
		exampleIssue.update(exampleCommand);
		assertEquals(Issue.CLOSED_NAME, exampleIssue.getStateName());
		
	}
}
