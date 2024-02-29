package edu.ncsu.csc216.issue_manager.model.command;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import edu.ncsu.csc216.issue_manager.model.command.Command.CommandValue;
import edu.ncsu.csc216.issue_manager.model.command.Command.Resolution;
/**
 * Tests the Command class
 */
public class CommandTest {
	/**
	 * Tests the getCommand method
	 */
	@Test
	public void testCommand() {
		Command testCommand = new Command(CommandValue.ASSIGN,"owner",Resolution.DUPLICATE,"Note for command");
		assertEquals(CommandValue.ASSIGN, testCommand.getCommand());
		assertEquals("owner",testCommand.getOwnerId());
		assertEquals(Resolution.DUPLICATE,testCommand.getResolution());
		assertEquals("Note for command",testCommand.getNote());
		
		Exception e = assertThrows(IllegalArgumentException.class,
				() -> new Command(null,"owner",Resolution.DUPLICATE,"Note for command"));
		assertEquals(e.getMessage(), "Invalid information.");
		e =  assertThrows(IllegalArgumentException.class,
				() -> new Command(CommandValue.ASSIGN,"",Resolution.DUPLICATE,"Note for command"));
		assertEquals(e.getMessage(), "Invalid information.");
		e = assertThrows(IllegalArgumentException.class,
					() -> new Command(CommandValue.RESOLVE,"owner",null,"Note for command"));
			assertEquals(e.getMessage(), "Invalid information.");
		e = assertThrows(IllegalArgumentException.class,
						() -> new Command(CommandValue.CONFIRM,"owner",Resolution.DUPLICATE,null));
				assertEquals(e.getMessage(), "Invalid information.");
		
				
	}
	
}
