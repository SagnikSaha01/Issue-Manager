package edu.ncsu.csc216.issue_manager.model.manager;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;
/**
 * Class responsible for managing issues
 */
public class IssueManager {
	/**
	 * Loads the issues from a file
	 * @param fileName name of the file to read data
	 */
	public void loadIssuesFromFile(String fileName) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Creates a new issue list
	 */
	public void createNewIssueList() {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Saves the current issues to a file
	 * @param fileName file name where the issues will be saved 
	 */
	public void saveIssuesToFile(String fileName) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Gets the instance of the issue manager
	 * @return the issue manager instance
	 */
	public static IssueManager getInstance() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Gets the issue list as a 2 dimensional array
	 * @return a 2d array with the issues
	 */
	public Object[][] getIssueListAsArray() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Gets the issue with a specific id
	 * @param issueId the id of the issue 
	 * @return issue with the given id
	 */
	public Issue getIssueById(int issueId) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Gets the list of issues of a specific type 
	 * @param string the type of issues to retrieve
	 * @return an array with the specified issue type
	 */
	public Object[][] getIssueListAsArrayByIssueType(String string) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Executes the given command
	 * @param issueId the id of the issue
	 * @param c the command that is being executed
	 */
	public void executeCommand(int issueId, Command c) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Deletes an issue with a specified id
	 * @param issueId the issue to be deleted
	 */
	public void deleteIssueById(int issueId) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Adds a new issue to the list
	 * @param type type of issue
	 * @param summary summary of issue
	 * @param note any additional notes of the issue
	 */
	public void addIssueToList(IssueType type, String summary, String note) {
		// TODO Auto-generated method stub
		
	}
}
