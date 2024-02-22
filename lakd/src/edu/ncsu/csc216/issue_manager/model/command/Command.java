package edu.ncsu.csc216.issue_manager.model.command;
/**
 * Class for Command objects which are responsible for leading to a transition
 */
import edu.ncsu.csc216.issue_manager.model.command.CommandValue;
public class Command {
	/**Id of the Owner*/
	private String ownerId;
	/**Note of a command*/
	private String note;
	/**Constant for a fixed Issue*/
	private final String R_FIXED = "Fixed";
	/**Constant for a duplicate Issue*/
	private final String R_DUPLICATE = "Duplicate";
	/**Constant for a WontFix Issue*/
	private final String R_WONTFIX = "WontFix";
	/**Constant for a WorksForMe Issue*/
	private final String R_WORKSFORME = "WorksForMe";
	/**
	 * Constructs a Command object
	 * @param c value for the command
	 * @param ownerId Id of the owner
	 * @param r
	 * @param note
	 */
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
}
