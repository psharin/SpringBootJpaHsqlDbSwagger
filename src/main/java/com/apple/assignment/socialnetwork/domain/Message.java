package com.apple.assignment.socialnetwork.domain;

/**
 * POJO class to store Messages information.
 * 
 * @author sandhya_p
 *
 */
public class Message {

	private Long msgId;

	private String msgDesc;

	private String postedBy;

	public String getMsgDesc() {
		return msgDesc;
	}

	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

}