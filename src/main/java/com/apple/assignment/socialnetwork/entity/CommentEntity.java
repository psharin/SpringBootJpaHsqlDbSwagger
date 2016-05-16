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
 * Entity class to store comments information to DB.
 * 
 * @author sandhya_p
 *
 */

@Entity
@Table(name = "COMMENT")
public class CommentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Comment_ID", unique = true, nullable = false)
	private Long commentId;

	@Column(name = "COMMENT_DESC")
	private String commentDesc;

	@Column(name = "MSG_ID")
	private Long msgId;

	@Column(name = "COMMENTED_DATE", updatable = false)
	private Timestamp commentedDate;

	@Column(name = "COMMENTED_BY", updatable = false)
	private String commentedBy;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

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

	public Timestamp getCommentedDate() {
		return commentedDate;
	}

	public void setCommentedDate(Timestamp commentedDate) {
		this.commentedDate = commentedDate;
	}

	public String getCommentedBy() {
		return commentedBy;
	}

	public void setCommentedBy(String commentedBy) {
		this.commentedBy = commentedBy;
	}

}