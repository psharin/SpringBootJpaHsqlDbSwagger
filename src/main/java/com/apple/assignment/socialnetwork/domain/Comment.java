package com.apple.assignment.socialnetwork.domain;

/**
 * POJO class to store comments information.
 * 
 * @author sandhya_p
 *
 */
public class Comment {

	private String commentDesc;

	private Long msgId;

	private String commentedBy;

	public String getCommentDesc() {
		return commentDesc;
	}

	public void setCommentDesc(String commentDesc) {
		this.commentDesc = commentDesc;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public String getCommentedBy() {
		return commentedBy;
	}

	public void setCommentedBy(String commentedBy) {
		this.commentedBy = commentedBy;
	}

}