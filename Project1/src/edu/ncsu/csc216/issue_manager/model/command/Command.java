package edu.ncsu.csc216.issue_manager.model.command;
/**
 * Class for the command object which is responsible for transitions between states
 */
public class Command {
	/** State of the command value */
	private CommandValue c;
	/** State of the resolution */
	private Resolution r;
	/** Id of owner of the issue */
	private String ownerId;
	/** Note of the issue */
	private String note;
	/** Constant for the fixed resolution */
	public static final String R_FIXED = "Fixed";
	/** Constant for the duplicate resolution */
	public static final String R_DUPLICATE = "Duplicate";
	/** Constant for the wont fix resolution */
	public static final String R_WONTFIX = "WontFix";
	/** Constant for the works for me resolution */
	public static final String R_WORKSFORME = "WorksForMe";
	/**
	 * Constructor for a command object
	 * @param c the command value
	 * @param ownerId the id of the owner
	 * @param r resolution state of the issue
	 * @param note note associated with the issue
	 */
	public Command(CommandValue c, String ownerId, Resolution r, String note) {
		if(c == null) {
			throw new IllegalArgumentException("Invalid information.");
		}
		if((c == CommandValue.ASSIGN) && (ownerId == null || ownerId.length() == 0)) {
			throw new IllegalArgumentException("Invalid information.");
		}
		if(c == CommandValue.RESOLVE && r == null) {
			throw new IllegalArgumentException("Invalid information.");
		}
		if(note == null || note.length() == 0) {
			throw new IllegalArgumentException("Invalid information.");
		}
		this.c = c;
		this.r = r;
		this.ownerId = ownerId;
		this.note = note;
	}
	/**
	 * Returns the value of the command
	 * @return the command value
	 */
	public CommandValue getCommand() {
		return c;
	}
	/**
	 * Returns the Id of the owner
	 * @return the owner Id
	 */
	public String getOwnerId() {
		return ownerId;
	}
	/**
	 * Returns the issue resolution
	 * @return the resolution
	 */
	public Resolution getResolution(){
		return r;
	}
	/**
	 * Returns the note associated with issue
	 * @return the issue note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * Represents the constants for the Issue states
	 */
	public enum Resolution { FIXED, DUPLICATE, WONTFIX, WORKSFORME }
	/**
	 * Represents the constant values possible for Commands
	 */
	public enum CommandValue { ASSIGN, CONFIRM, RESOLVE, VERIFY, REOPEN }

}
