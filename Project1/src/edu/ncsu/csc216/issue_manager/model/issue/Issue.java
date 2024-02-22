package edu.ncsu.csc216.issue_manager.model.issue;

import java.util.ArrayList;

import edu.ncsu.csc216.issue_manager.model.command.Command;

public class Issue {
	public static final String CLOSED_NAME = "Closed";
	public static final String VERIFYING_NAME = "Verifying";
	public static final String NEW_NAME = "New";
	public static final String WORKING_NAME = "Working";
	public static final String CONFIRMED_NAME = "Confirmed";
	public static final String I_ENHANCEMENT = "Enhancement";
	public static final String I_BUG = "Bug";
	
	private int issueId;
	private String summary;
	private String owner;
	private boolean confirmed;
	private ArrayList<String> notes;
	
	
	
	
	public Issue(int issueId, IssueType issueType, String summary, String note) {
		this.issueId = issueId;
		
	}
	
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
