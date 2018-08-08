package com.sbm.shura.dto;

import java.util.List;

public class PollProcessResultDto extends BaseDTO{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7388157749312036307L;
	
	
	private List<CommitteeMemberDTO> committeeMembers;
	
	private long processId;

	public List<CommitteeMemberDTO> getCommitteeMembers() {
		return committeeMembers;
	}

	public void setCommitteeMembers(List<CommitteeMemberDTO> committeeMembers) {
		this.committeeMembers = committeeMembers;
	}

	public long getProcessId() {
		return processId;
	}

	public void setProcessId(long processId) {
		this.processId = processId;
	}

}
