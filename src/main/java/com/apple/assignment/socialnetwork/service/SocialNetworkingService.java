package com.apple.assignment.socialnetwork.service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.apple.assignment.socialnetwork.domain.Comment;
import com.apple.assignment.socialnetwork.domain.Message;

/**
 * SocialNetworkingService Interface having all Service methods.
 * 
 * @author sandhya_p
 *
 */
public interface SocialNetworkingService {

	/** Method to save messagePost information */
	public void savePost(final Message message);

	/** Method to delete Message post information */
	public void deletePost(final Long postId);

	/** Method to save post related comments */
	public void saveComment(final Comment comment);

	/** Method to read all messages */
	public List<Message> getMessages();

	/** Method to retrieve user information for any of my post */
	public List<String> getCommentedUsers(final String postedBy);

	/** Method to find out popular top 10 words from all my posts */
	public Collection<Map.Entry<String, Integer>> getPopularWords(
			final String postedBy);

}