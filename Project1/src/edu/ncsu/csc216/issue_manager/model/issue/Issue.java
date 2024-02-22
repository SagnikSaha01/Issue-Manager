package edu.ncsu.csc216.issue_manager.model.issue;

import java.util.ArrayList;

import edu.ncsu.csc216.issue_manager.model.command.Command;
/**
 * Class for managing and modifying Issue objects 
 */
public class Issue {
	/** Constant for the closed state */
	public static final String CLOSED_NAME = "Closed";
	/** Constant for the verifying state */
	public static final String VERIFYING_NAME = "Verifying";
	/** Constant for the new state */
	public static final String NEW_NAME = "New";
	/** Constant for the working state */
	public static final String WORKING_NAME = "Working";
	/** Constant for the confirmed state */
	public static final String CONFIRMED_NAME = "Confirmed";
	/** Constant for the enhancement issue type */
	public static final String I_ENHANCEMENT = "Enhancement";
	/** Constant for the bug issue type */
	public static final String I_BUG = "Bug";
	/** The id of a given issue */
	private int issueId;
	/** Summary of an issue */
	private String summary;
	/** Owner of an issue */
	private String owner;
	/** Whether the issue is confirmed or not*/
	private boolean confirmed;
	/** List of notes in an array list */
	private ArrayList<String> notes;
	/**
	 * Constructor for an issue object
	 * @param issueId the id of the issue
	 * @param issueType whether it is a bug or enhancement
	 * @param summary summary of the issue
	 * @param note any notes associated with the issue
	 */
	public Issue(int issueId, IssueType issueType, String summary, String note) {
		this.issueId = issueId;
		
	}
	/**
	 * 
	 * @param issueId
	 * @param state
	 * @param issueType
	 * @param summary
	 * @param owner
	 * @param confirmed
	 * @param resolution
	 * @param notes
	 */
	public Issue(int issueId, String state, String issueType, String summary, String owner, boolean confirmed, String resolution, ArrayList<String>notes) {
		this.issueId = issueId;
	}

	/**
	 * @return the issueId
	 */
	public int getIssueId() {
		return issueId;
	}

	/**
	 * @param issueId the issueId to set
	 */
	private void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	private void setState(String state) {
		
	}
	private void setIssueType(String issueType) {
		
	}
	private void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	private void setResolution(String resolution) {
		
	}
	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	private void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	private void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * @return the notes
	 */
	public ArrayList<String> getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	private void setNotes(ArrayList<String> notes) {
		this.notes = notes;
	}
	public String getIssueType() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isConfirmed() {
		// TODO Auto-generated method stub
		return true;
	}

	public String getResolution() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getStateName() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getNotesString() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void update(Command c) {
		
	}

	/**
		 * Interface for states in the Issue State Pattern.  All 
		 * concrete issue states must implement the IssueState interface.
		 * The IssueState interface should be a private interface of the 
		 * Issue class.
		 * 
		 * @author Dr. Sarah Heckman (sarah_heckman@ncsu.edu) 
		 */
		private interface IssueState {
			
			/**
			 * Update the Issue based on the given Command.
			 * An UnsupportedOperationException is throw if the Command
			 * is not a valid action for the given state.  
			 * @param command Command describing the action that will update the Issue's
			 * state.
			 * @throws UnsupportedOperationException if the Command is not a valid action
			 * for the given state.
			 */
			void updateState(Command command);
			
			/**
			 * Returns the name of the current state as a String.
			 * @return the name of the current state as a String.
			 */
			String getStateName();

		}
		public enum IssueType {ENHANCEMENT, BUG}
		

		
	
}
