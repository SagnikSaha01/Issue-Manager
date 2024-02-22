package edu.ncsu.csc216.issue_manager.model.issue;

import edu.ncsu.csc216.issue_manager.model.command.Command;
/**
 * Interface responsible for managing all the issue states
 */
public interface IssueState {
	/**
	 * Updates the current state based on given command
	 * @param c command that is responsible for updating the state
	 */
	void updateState(Command c);
	/**
	 * Returns the name of the State
	 * @return state name
	 */
	String getStateName();
}
