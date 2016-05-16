package com.apple.assignment.socialnetwork.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MESSAGE class to store MessagesPosted information to DB.
 * 
 * @author sandhya_p
 *
 */
@Entity
@Table(name = "MESSAGE")
public class MessageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "MSG_ID", unique = true, nullable = false)
	private Long msgId;

	@Column(name = "MSG_DESC")
	private String msgDesc;

	@Column(name = "POSTED_DATE", updatable = false)
	private Timestamp postedDate;

	@Column(name = "POSTED_BY", updatable = false)
	private String postedBy;

	public Long getMsgId() {
		return msgId;
	}

	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}

	public String getMsgDesc() {
		return msgDesc;
	}

	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}

	public Timestamp getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(Timestamp postedDate) {
		this.postedDate = postedDate;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

}