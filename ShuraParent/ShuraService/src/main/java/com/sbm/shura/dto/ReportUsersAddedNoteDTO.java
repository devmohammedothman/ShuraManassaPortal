package com.sbm.shura.dto;

public class ReportUsersAddedNoteDTO {

	private String userName;
	private String currentCommittee;
	private String note;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCurrentCommittee() {
		return currentCommittee;
	}
	public void setCurrentCommittee(String currentCommittee) {
		this.currentCommittee = currentCommittee;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
