package edu.ncsu.csc216.issue_manager.model.manager;

import java.util.ArrayList;
import java.util.List;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;
/**
 * Class responsible for managing the list of issues
 */
public class IssueList {
	private List<Issue> issues;
	/** Tracks what the next IssueId should be */
	private int counter;
	/**
	 * Constructor for the issue list object
	 */
	public IssueList() {
		issues = new ArrayList<>();
		counter = 1;
	}
	/**
	 * Adds an issue to the IssueList
	 * @param issueType whether it is a bug or enhancement
	 * @param summary summary of the issue
	 * @param note any additional notes for the issue
	 * @return the Id of the added issue
	 */
	public int addIssue(IssueType issueType, String summary, String note) {
		Issue current = new Issue(counter,issueType,summary,note);
		issues.add(current);
		counter++;
		return current.getIssueId();
	}
	/**
	 * Adds the first issue from the collection of issues
	 * @param issues total collection of issues 
	 */
	public void addIssues(List<Issue> issues) {
		for(Issue i : issues) {
			this.issues.add(i);
		}
	}
	/**
	 * Helps check for any duplicate issues that are already added
	 */
	private void addIssue() {
		
	}
	/**
	 * Returns all the issues in the form of a list
	 * @return a list of issues
	 */
	public List<Issue> getIssues(){
		return issues;
	}
	/**
	 * Returns the issue based on a given Id
	 * @param index Id of the issue that should be returned
	 * @return the issue with the given id
	 */
	public Issue getIssueById(int index) {
		for(Issue i : issues) {
			if(i.getIssueId() == index) {
				return i;
			}
		}
		return null;
	}
	/**
	 * Returns a list of issues of a certain type
	 * @param issueType the type of issue  
	 * @return list of issues that are only the given type
	 */
	public List<Issue> getIssuesByType(String issueType){
		List<Issue> output = new ArrayList<>();
		for(Issue i : issues) {
			if(i.getIssueType().equals(issueType)) {
				output.add(i);
			}
		}
		return output;
	}
	/**
	 * Executes a given command
	 * @param index id of the issue  
	 * @param c command to be executed
	 */
	public void executeCommand(int index, Command c) {
		for(Issue i : issues) {
			if(i.getIssueId() == index) {
				i.update(c);
			}
		}
	}
	/**
	 * Deletes an issue from the issue list 
	 * @param index the id of the issue that is being removed
	 */
	public void deleteIssueById(int index) {
		for(Issue i : issues) {
			if(i.getIssueId() == index) {
				issues.remove(i);
			}
		}
	}
}
