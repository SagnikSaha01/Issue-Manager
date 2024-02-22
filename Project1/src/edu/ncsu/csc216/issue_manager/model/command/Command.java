package edu.ncsu.csc216.issue_manager.model.command;

public class Command {
	private String ownerId;
	private String note;
	
	public Command(CommandValue c, String ownerId, Resolution r, String note) {
		this.ownerId = ownerId;
		this.note = note;
	}
	
	public CommandValue getCommand() {
		return null;
	}
	
	public String getOwnerId() {
		return ownerId;
	}
	
	public Resolution getResolution(){
		return null;
	}
	
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
