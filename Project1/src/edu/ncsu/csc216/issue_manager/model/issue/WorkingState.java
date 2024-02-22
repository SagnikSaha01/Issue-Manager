package edu.ncsu.csc216.issue_manager.model.issue;

import edu.ncsu.csc216.issue_manager.model.command.Command;
/**
 * Class that represents the Working state of Issue Manager
 */
public class WorkingState implements IssueState{
	/**
	 * Updates the current state based on given command
	 * @param c command that is responsible for updating the state
	 */
	@Override
	public void updateState(Command c) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Returns the name of the State
	 * @return state name
	 */
	@Override
	public String getStateName() {
		// TODO Auto-generated method stub
		return null;
	}

}
