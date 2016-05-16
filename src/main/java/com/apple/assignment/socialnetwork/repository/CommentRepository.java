package com.apple.assignment.socialnetwork.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.apple.assignment.socialnetwork.entity.CommentEntity;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {

	@Query(value = "SELECT ce.commentedBy FROM CommentEntity ce where ce.msgId in (select me.msgId from MessageEntity me where me.postedBy=?1 )")
	public List<String> findAllUsers(final String postedBy);

	@Query(value = "SELECT ce.commentDesc FROM CommentEntity ce where ce.msgId in (select me.msgId from MessageEntity me where me.postedBy=?1 )")
	public List<String> findMyPosts(final String postedBy);

}
