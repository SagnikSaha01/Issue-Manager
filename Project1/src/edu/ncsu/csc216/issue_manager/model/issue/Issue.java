package edu.ncsu.csc216.issue_manager.model.issue;

import java.util.ArrayList;

public class Issue {
	private int issueId;
	private String summary;
	private String owner;
	private boolean confirmed;
	private ArrayList<String> notes;
}
