package edu.ncsu.csc216.issue_manager.model.manager;



import java.util.List;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.io.IssueReader;
import edu.ncsu.csc216.issue_manager.model.io.IssueWriter;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;
/**
 * Class responsible for managing issues
 */
public class IssueManager {
	
	private IssueList issueList;
	
	private static IssueManager singleton;
	
	public IssueManager() {
		createNewIssueList();
	}
	/**
	 * Loads the issues from a file
	 * @param fileName name of the file to read data 
	 */
	public void loadIssuesFromFile(String fileName) {
		try {
			issueList = new IssueList();
			issueList.addIssues(IssueReader.readIssuesFromFile(fileName));
		} catch (Exception e) {
			throw new IllegalArgumentException("Invalid input.");
		}
		
	}
	/**
	 * Creates a new issue list
	 */
	public void createNewIssueList() {
		issueList = new IssueList();
	}
	/**
	 * Saves the current issues to a file
	 * @param fileName file name where the issues will be saved 
	 */
	public void saveIssuesToFile(String fileName) {
		IssueWriter.writeIssuesToFile(fileName, issueList.getIssues());
		
	}
	/**
	 * Gets the instance of the issue manager
	 * @return the issue manager instance
	 */
	public static IssueManager getInstance() {
		 if (singleton == null) {
			singleton = new IssueManager();
		}
		return singleton;
	}
	/**
	 * Gets the issue list as a 2 dimensional array
	 * @return a 2d array with the issues
	 */
	public Object[][] getIssueListAsArray() {
		Object[][] output = new Object[issueList.getIssues().size()][4];
		for(int i = 0; i < issueList.getIssues().size(); i++) {
			Issue current = issueList.getIssues().get(i);
			output[i][0] = current.getIssueId();
			output[i][1] = current.getStateName();
			output[i][2] = current.getIssueType();
			output[i][3] = current.getSummary();
		}
		return output;
	}
	/**
	 * Gets the issue with a specific id
	 * @param issueId the id of the issue 
	 * @return issue with the given id
	 */
	public Issue getIssueById(int issueId) {
		return issueList.getIssueById(issueId);
	}
	/**
	 * Gets the list of issues of a specific type 
	 * @param string the type of issues to retrieve
	 * @return an array with the specified issue type
	 */
	public Object[][] getIssueListAsArrayByIssueType(String type) {
		List<Issue> byType = issueList.getIssuesByType(type);
		Object[][] output = new Object[byType.size()][4];
		for(int i = 0; i < byType.size(); i++) {
			Issue current = byType.get(i);
			output[i][0] = current.getIssueId();
			output[i][1] = current.getStateName();
			output[i][2] = current.getIssueType();
			output[i][3] = current.getSummary();
		}
		return output;
	}
	/**
	 * Executes the given command
	 * @param issueId the id of the issue
	 * @param c the command that is being executed
	 */
	public void executeCommand(int issueId, Command c) {
		issueList.executeCommand(issueId, c);
	}
	/**
	 * Deletes an issue with a specified id
	 * @param issueId the issue to be deleted
	 */
	public void deleteIssueById(int issueId) {
		issueList.deleteIssueById(issueId);
	}
	/**
	 * Adds a new issue to the list
	 * @param type type of issue
	 * @param summary summary of issue
	 * @param note any additional notes of the issue
	 */
	public void addIssueToList(IssueType type, String summary, String note) {
		issueList.addIssue(type,summary,note);
	}
	
}
