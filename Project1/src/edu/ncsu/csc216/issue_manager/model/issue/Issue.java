package edu.ncsu.csc216.issue_manager.model.issue;

import java.util.ArrayList;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.command.Command.CommandValue;
import edu.ncsu.csc216.issue_manager.model.command.Command.Resolution;
/**
 * Class for managing and modifying Issue objects 
 */
public class Issue {
	private NewState newState = new NewState();
	
	private ConfirmedState confirmedState = new ConfirmedState();
	
	private ClosedState closedState = new ClosedState();
	
	private VerifyingState verifyingState = new VerifyingState();
	
	private WorkingState workingState = new WorkingState();
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
	
	private IssueType issueType;
	
	private IssueState state;
	
	private Resolution resolution;
	
	/**
	 * Constructor for an issue object
	 * @param issueId the id of the issue
	 * @param issueType whether it is a bug or enhancement
	 * @param summary summary of the issue
	 * @param note any notes associated with the issue
	 */
	public Issue(int issueId, IssueType issueType, String summary, String note) {
		setIssueId(issueId);
		if(issueType == IssueType.BUG || issueType == IssueType.ENHANCEMENT) {
			this.issueType = issueType;
		} else { 
			throw new IllegalArgumentException("Issue cannot be created.");
		}
		setSummary(summary);
		setState("New");
		this.notes = new ArrayList<String>();
		addNote(note);
		
	}
	/**
	 * Alternative constructor for an issue object
	 * @param issueId Id of the issue
	 * @param state current state of the issue
	 * @param issueType whether it is a bug or enhancement
	 * @param summary summary of the issue
	 * @param owner assigned owner of the issue
	 * @param confirmed if the issue was confirmed or not
	 * @param resolution resolution state of the issue
	 * @param notes any additional notes for the issue
	 */
	public Issue(int issueId, String state, String issueType, String summary, String owner, boolean confirmed, String resolution, ArrayList<String> notes) {
		if(state.equals(WORKING_NAME) || state.equals(VERIFYING_NAME)) {
			if(owner == null || owner.length() == 0) {
				 throw new IllegalArgumentException("Issue cannot be created.");
			}
		}
		if(state.equals(VERIFYING_NAME) && (resolution == null || resolution.length() == 0) ) {
			 throw new IllegalArgumentException("Issue cannot be created.");
		}
		if(issueType.equals(I_ENHANCEMENT) && state.equals(CONFIRMED_NAME)) {
			 throw new IllegalArgumentException("Issue cannot be created.");
		}
		if(issueType.equals(I_BUG) && state.equals(WORKING_NAME) && confirmed == false) {
			 throw new IllegalArgumentException("Issue cannot be created.");
		}
		if(state.equals(VERIFYING_NAME) && issueType.equals(I_BUG) && !resolution.equals(Command.R_FIXED)) {
			 throw new IllegalArgumentException("Issue cannot be created.");
		}
		if(state.equals(CLOSED_NAME) && (resolution == null || resolution.length() == 0)) {
			 throw new IllegalArgumentException("Issue cannot be created.");
		}
		if(issueType.equals(I_ENHANCEMENT) && confirmed) {
			 throw new IllegalArgumentException("Issue cannot be created.");
		}
		setIssueId(issueId);
		setOwner(owner);
		setIssueType(issueType);
		setNotes(notes);
		setSummary(summary);
		setState(state);
		setConfirmed(confirmed);
		setResolution(resolution);
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
		if(issueId < 1) {
			throw new IllegalArgumentException("Issue cannot be created");
		}
		this.issueId = issueId;
	}
	/**
	 * Sets the state of the issue
	 * @param state the state to be set
	 */
	private void setState(String state) {
		if(state.equals(CLOSED_NAME)) {
			this.state = closedState;
		}else if (state.equals(CONFIRMED_NAME)) {
			this.state = confirmedState;
		}else if(state.equals(NEW_NAME)) {
			this.state = newState;
		}else if(state.equals(VERIFYING_NAME)) {
			this.state = verifyingState;
		}else if(state.equals(WORKING_NAME)) {
			this.state = workingState;
		}else {
			throw new IllegalArgumentException("Issue cannot be created.");
		}
	}
	/**
	 * Sets the type of issue
	 * @param issueType the type of issue to be set
	 */
	private void setIssueType(String issueType) {
		 if(issueType.equals(I_ENHANCEMENT)) {
			 this.issueType = IssueType.ENHANCEMENT;
		 }else if(issueType.equals(I_BUG)) {
			 this.issueType = IssueType.BUG;
		 }else {
			 throw new IllegalArgumentException("Issue cannot be created.");
		 }
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
		if(resolution.length() == 0) {
			this.resolution = null;
		}else if(resolution.equals(Command.R_FIXED)) {
			this.resolution = Resolution.FIXED;
		}else if(resolution.equals(Command.R_DUPLICATE)) {
			this.resolution = Resolution.DUPLICATE;
		}else if(resolution.equals(Command.R_WONTFIX)) {
			this.resolution = Resolution.WONTFIX;
		}else if(resolution.equals(Command.R_WORKSFORME)) {
			this.resolution = Resolution.WORKSFORME;
		}else {
			throw new IllegalArgumentException("Issue cannot be created.");
		}
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
		if(summary == null || summary.length() == 0) {
			throw new IllegalArgumentException("Issue cannot be created."); 
		}
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
	 * @throws IllegalArgumentException if owner is null or empty
	 */
	private void setOwner(String owner) {
		if(owner == null) {
			throw new IllegalArgumentException("Issue cannot be created");
		} else if (owner.length() == 0) {
			this.owner = null;
		} else {
		this.owner = owner;
		}
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
		if(notes == null || notes.size() == 0) {
			throw new IllegalArgumentException("Issue cannot be created");
		}
		this.notes = notes;
	}
	/**
	 * Returns the type of the issue
	 * @return enhancement or bug based on the type 
	 */
	public String getIssueType() {
		if(issueType.equals(issueType.BUG)) {
			return I_BUG;
		}else {
			return I_ENHANCEMENT;
		}
	}
	/**
	 * Returns if the issue is confirmed or not
	 * @return true or false based on if the issue is confirmed or not
	 */
	public boolean isConfirmed() {
		return confirmed;
	}
	/**
	 * Returns the resolution of the issue
	 * @return the resolution
	 */
	public String getResolution() {
		if(resolution == null) {
			return null;
		} else if(resolution.equals(Resolution.DUPLICATE)) {
			return Command.R_DUPLICATE;
		} else if(resolution.equals(Resolution.FIXED)) {
			return Command.R_FIXED;
		}else if(resolution.equals(Resolution.WONTFIX)) {
			return Command.R_WONTFIX;
		}else if(resolution.equals(Resolution.WORKSFORME)) {
			return Command.R_WORKSFORME;
		} else {
			return null;
		}
	}
	/**
	 * Returns the name of the state
	 * @return state name
	 */
	public String getStateName() {
		return state.getStateName();
	}
	/**
	 * Returns the note of an issue
	 * @return the issue note
	 */
	public String getNotesString() {
		String out = "";
		for(String s : notes) {
			out = out + "-" + s + "\n";
		}
		return out;
	}
	/**
	 * Updates an issue
	 * @param c command that helps update the issue
	 */
	public void update(Command c) {
		state.updateState(c);
	}
	private void addNote(String note) {
		if(note == null || note.length() == 0) {
			throw new IllegalArgumentException("Issue cannot be created.");
		}
		notes.add("[" + this.state.getStateName() + "] " + note);
	}
	public String toString() {
		String out = "*";
		out = out + Integer.toString(issueId) + "," + state.getStateName() + "," + issueType.toString() + "," + summary + "," + owner + "," + confirmed + ",";
		if(resolution == null) {
			out = out + "";
		} else {
			out = out + resolution.toString();
		}
		for(String note : notes) {
			out = out + "\n-" + note;
		}
		return out;
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
		public class VerifyingState implements IssueState {

			/**
			 * Updates the current state based on given command
			 * @param c command that is responsible for updating the state
			 */
			public void updateState(Command c) {
				if(c.getCommand().equals(CommandValue.VERIFY)) {
					setState(CLOSED_NAME);
					addNote(c.getNote());
				}else if(c.getCommand().equals(CommandValue.REOPEN)) {
					setState(WORKING_NAME);
					setResolution("");
					addNote(c.getNote());
					
				} else {
					throw new UnsupportedOperationException("Invalid information.");
				}
				
			}
			/**
			 * Returns the name of the State
			 * @return state name
			 */
			public String getStateName() {
				// TODO Auto-generated method stub
				return VERIFYING_NAME;
			}
		}
		/**
		 * Class that represents the Working state of Issue Manager
		 */
		public class WorkingState implements IssueState {
			/**
			 * Updates the current state based on given command
			 * @param c command that is responsible for updating the state
			 */
			public void updateState(Command c) {
				if(c.getResolution() == null) {
					throw new UnsupportedOperationException("Invalid information.");
				}
				if(c.getCommand().equals(CommandValue.RESOLVE) && c.getResolution().equals(resolution.FIXED)) {
					setState(VERIFYING_NAME);
					setResolution(Command.R_FIXED);
					addNote(c.getNote());
				} else {
					if(c.getResolution().equals(Resolution.DUPLICATE) || c.getResolution().equals(Resolution.WONTFIX)) {
						if(c.getResolution().equals(Resolution.DUPLICATE)) { setResolution(Command.R_DUPLICATE); }
						if(c.getResolution().equals(Resolution.WONTFIX)) { setResolution(Command.R_WONTFIX); }
						setState(CLOSED_NAME);
						addNote(c.getNote());
					} else if(c.getResolution().equals(Resolution.WORKSFORME) && issueType == IssueType.BUG) {
						setState(CLOSED_NAME);
						setResolution(Command.R_WORKSFORME);
						addNote(c.getNote());
					} else {
						throw new UnsupportedOperationException("Invalid information.");
					}
				} 
			}
			/**
			 * Returns the name of the State
			 * @return state name
			 */
			public String getStateName() {
				// TODO Auto-generated method stub
				return WORKING_NAME;
			}

		}
		/**
		 * Class that represents the New state of Issue Manager
		 */
		public class NewState implements IssueState {
			/**
			 * Updates the current state based on given command
			 * @param c command that is responsible for updating the state
			 */
			public void updateState(Command c) {
				if(c.getCommand().equals(CommandValue.ASSIGN) && issueType.equals(IssueType.ENHANCEMENT)) {
					setOwner(c.getOwnerId());
					setState(WORKING_NAME);
					addNote(c.getNote());
					
				} else if(c.getCommand().equals(CommandValue.CONFIRM) && issueType == IssueType.BUG) {
					setState(CONFIRMED_NAME);
					setConfirmed(true);
					addNote(c.getNote());
				} else if(c.getCommand().equals(CommandValue.RESOLVE)) {
					if(c.getResolution().equals(Resolution.WORKSFORME) || c.getResolution().equals(Resolution.FIXED)) {
						throw new UnsupportedOperationException("Invalid information."); 
					} else {
					setState(CLOSED_NAME);
					addNote(c.getNote());
					resolution = c.getResolution();
					}
				} else {
					throw new UnsupportedOperationException("Invalid information.");
				}
			}
			/**
			 * Returns the name of the State
			 * @return state name
			 */
			public String getStateName() {
				return NEW_NAME;
			}

		}
		/**
		 * Class that represents the Confirmed state of Issue Manager
		 */
		public class ConfirmedState implements IssueState {

			/**
			 * Updates the current state based on given command
			 * @param c command that is responsible for updating the state
			 */

			public void updateState(Command c) {
			
				if(c.getCommand().equals(CommandValue.ASSIGN)) {
					setOwner(c.getOwnerId());
					setState(WORKING_NAME);
					addNote(c.getNote());
					
				} else if(c.getResolution() != null && c.getResolution().equals(Resolution.WONTFIX)) {
					setState(CLOSED_NAME);
					setResolution(Command.R_WONTFIX);
					addNote(c.getNote());
					
				} else {
					throw new UnsupportedOperationException("Invalid information.");
				}
			}
			/**
			 * Returns the name of the State
			 * @return state name
			 */
			public String getStateName() {
				// TODO Auto-generated method stub
				return CONFIRMED_NAME;
			}
		}
		/**
		 * Class that represents the Closed state of the Issue Manager
		 */
		public class ClosedState implements IssueState {
			/**
			 * Updates the current state based on given command
			 * @param c command that is responsible for updating the state
			 */
			public void updateState(Command c) {
				if(c.getCommand().equals(CommandValue.REOPEN)) {
					resolution = null;
					if(issueType.equals(IssueType.ENHANCEMENT) && getOwner() != null) {
						setState(WORKING_NAME);
						addNote(c.getNote());
						
					} else if(issueType.equals(IssueType.BUG)) {
						
						if(isConfirmed() && getOwner() != null) {
							setState(WORKING_NAME);
							addNote(c.getNote());
							
						}else if(isConfirmed() && getOwner() == null) {
							setState(CONFIRMED_NAME);
							addNote(c.getNote());
							
						}else if(getOwner() == null || !isConfirmed()) {
							setState(NEW_NAME);
							addNote(c.getNote());
						} 
					} else if(getOwner() == null) {
						setState(NEW_NAME);
						addNote(c.getNote());
					}
					
				} else if(getOwner() == null){
					setState(NEW_NAME);
					addNote(c.getNote());
				} else {
					throw new UnsupportedOperationException("Invalid information.");
				}
				
				
			}
			/**
			 * Returns the name of the State
			 * @return state name
			 */
			public String getStateName() {
				// TODO Auto-generated method stub
				return CLOSED_NAME;
			}
		}
		/**
		 * Represents the constant values for the types of issues
		 */
		public enum IssueType { ENHANCEMENT, BUG }
		

		
	
}
