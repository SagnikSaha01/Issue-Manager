package edu.ncsu.csc216.issue_manager.model.manager;

import java.util.ArrayList;

import edu.ncsu.csc216.issue_manager.model.command.Command;
import edu.ncsu.csc216.issue_manager.model.issue.Issue;
import edu.ncsu.csc216.issue_manager.model.issue.Issue.IssueType;

public class IssueList {
	private int counter;
	
	public IssueList() {
		
	}
	
	public int addIssue(IssueType issueType,String summary,String note) {
		return 0;
	}
	
	public void addIssues(ArrayList<Issue> issues) {
		
	}
	private void addIssue() {
		
	}
	public ArrayList<Issue> getIssues(){
		return null;
	}
	public Issue getIssueById(int index) {
		return null;
	}
	public void executeCommand(int index, Command c) {
		
	}
	public void deleteIssueById(int index) {
		
	}
}
