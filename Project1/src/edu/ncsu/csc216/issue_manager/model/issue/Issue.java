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
	 * Alternative constructor for an issue obejct
	 * @param issueId Id of the issue
	 * @param state current state of the issue
	 * @param issueType whether it is a bug or enhancement
	 * @param summary summary of the issue
	 * @param owner assigned owner of the issue
	 * @param confirmed if the issue was confirmed or not
	 * @param resolution resolution state of the issue
	 * @param notes any additional notes for the issue
	 */
	public Issue(int issueId, String state, String issueType, String summary, String owner, boolean confirmed, String resolution, ArrayList<String>notes) {
		this.issueId = issueId;
	}

	/**
	 * Returns the id of the issue
	 * @return the issueId
	 */
	public int getIssueId() {
		return issueId;
	}

	/**
	 * Sets the Id of the issue
	 * @param issueId the issueId to set
	 */
	private void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	/**
	 * Sets the state of the issue
	 * @param state the state to be set
	 */
	private void setState(String state) {
		
	}
	/**
	 * Sets the type of issue
	 * @param issueType the type of issue to be set
	 */
	private void setIssueType(String issueType) {
		
	}
	/**
	 * Sets if the issue is confirmed
	 * @param confirmed sets whether the issue is confirmed or not
	 */
	private void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}
	/**
	 * Sets the resolution of the issue
	 * @param resolution the resolution to be set
	 */
	private void setResolution(String resolution) {
		
	}
	/**
	 * Returns the issue summary
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * Sets the summary of the issue
	 * @param summary the summary to set
	 */
	private void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * Returns the issue owner
	 * @return the owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * Sets the owner of the issue
	 * @param owner the owner to set
	 */
	private void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * Returns all of the issue notes
	 * @return the notes
	 */
	public ArrayList<String> getNotes() {
		return notes;
	}

	/**
	 * Sets the notes to the issue
	 * @param notes the notes to set
	 */
	private void setNotes(ArrayList<String> notes) {
		this.notes = notes;
	}
	/**
	 * Returns the type of the issue
	 * @return enhancement or bug based on the type 
	 */
	public String getIssueType() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Returns if the issue is confirmed or not
	 * @return true or false based on if the issue is confirmed or not
	 */
	public boolean isConfirmed() {
		// TODO Auto-generated method stub
		return true;
	}
	/**
	 * Returns the resolution of the issue
	 * @return the resolution
	 */
	public String getResolution() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Returns the name of the state
	 * @return state name
	 */
	public String getStateName() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Returns the note of an issue
	 * @return the issue note
	 */
	public String getNotesString() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Updates an issue
	 * @param c command that helps update the issue
	 */
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
		/**
		 * Class that represents the Verifying state of the Issue Manager 
		 */
		public class VerifyingState{

			/**
			 * Updates the current state based on given command
			 * @param c command that is responsible for updating the state
			 */
			public void updateState(Command c) {
				// TODO Auto-generated method stub
				
			}
			/**
			 * Returns the name of the State
			 * @return state name
			 */
			public String getStateName() {
				// TODO Auto-generated method stub
				return null;
			}
		}
		/**
		 * Class that represents the Working state of Issue Manager
		 */
		public class WorkingState{
			/**
			 * Updates the current state based on given command
			 * @param c command that is responsible for updating the state
			 */
			public void updateState(Command c) {
				// TODO Auto-generated method stub
				
			}
			/**
			 * Returns the name of the State
			 * @return state name
			 */
			public String getStateName() {
				// TODO Auto-generated method stub
				return null;
			}

		}
		/**
		 * Class that represents the New state of Issue Manager
		 */
		public class NewState {
			/**
			 * Updates the current state based on given command
			 * @param c command that is responsible for updating the state
			 */
			public void updateState(Command c) {
				// TODO Auto-generated method stub
				
			}
			/**
			 * Returns the name of the State
			 * @return state name
			 */
			public String getStateName() {
				// TODO Auto-generated method stub
				return null;
			}

		}
		/**
		 * Class that represents the Confirmed state of Issue Manager
		 */
		public class ConfirmedState{

			/**
			 * Updates the current state based on given command
			 * @param c command that is responsible for updating the state
			 */

			public void updateState(Command c) {
				// TODO Auto-generated method stub
				
			}
			/**
			 * Returns the name of the State
			 * @return state name
			 */
			public String getStateName() {
				// TODO Auto-generated method stub
				return null;
			}
		}
		/**
		 * Class that represents the Closed state of the Issue Manager
		 */
		public class ClosedState{
			/**
			 * Updates the current state based on given command
			 * @param c command that is responsible for updating the state
			 */
			public void updateState(Command c) {
				// TODO Auto-generated method stub
				
			}
			/**
			 * Returns the name of the State
			 * @return state name
			 */
			public String getStateName() {
				// TODO Auto-generated method stub
				return null;
			}
		}
		/**
		 * Represents the constant values for the types of issues
		 */
		public enum IssueType { ENHANCEMENT, BUG }
		

		
	
}
