package edu.ncsu.csc216.issue_manager.model.issue;

import java.util.ArrayList;

public class Issue {
	private int issueId;
	private String summary;
	private String owner;
	private boolean confirmed;
	private ArrayList<String> notes;
	
	//public final String NEW_NAME = "New";
	
	
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
	
}
