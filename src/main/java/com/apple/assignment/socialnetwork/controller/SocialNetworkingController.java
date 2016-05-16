package com.apple.assignment.socialnetwork.controller;


import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apple.assignment.socialnetwork.domain.Comment;
import com.apple.assignment.socialnetwork.domain.Message;
import com.apple.assignment.socialnetwork.service.SocialNetworkingService;

/**
 * SocialNetworkingController which contains all Rest handler information
 * 
 * @author sandhya_p
 *
 */
@RestController
@RequestMapping("SocialNetworking")
public class SocialNetworkingController {

	@Autowired
	private SocialNetworkingService postService;

	/**
	 * Handles: Saves MessagePost to DataBase
	 * 
	 * @param Message
	 * @return
	 */
	@RequestMapping(value = "/messagePost", method = RequestMethod.PUT)
	public void savePost(@RequestBody final Message message) {
		postService.savePost(message);
	}

	/**
	 * 
	 * Handles: Delete the posted messages for the given Message id.
	 * 
	 * @param msgID
	 * @return
	 */
	@RequestMapping(value = "/messages/{msgID}", method = RequestMethod.DELETE)
	public void deleteAlert(@PathVariable final Long msgID) throws Exception {
		postService.deletePost(msgID);
	}

	/**
	 * Handles: Saves a Comment for Specific MessagePost
	 * 
	 * @param Comment
	 * @return
	 */

	@RequestMapping(value = "/post/comments", method = RequestMethod.PUT)
	public void saveComment(@RequestBody final Comment comment) {
		postService.saveComment(comment);
	}

	/**
	 * List all messages post's information
	 * 
	 * @param
	 * @return List<Message>
	 */

	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	public List<Message> getMessages() {
		return postService.getMessages();
	}

	/**
	 * Retrieves list of users commented for any of my post.
	 * 
	 * @param postedBy
	 * @return List<String>
	 */

	@RequestMapping(value = "/comments/users/{postedBy}", method = RequestMethod.GET)
	public List<String> getCommentedUsers(@PathVariable final String postedBy) {
		return postService.getCommentedUsers(postedBy);
	}

	/**
	 * Retrieves list of top ten popular words from all my posts.
	 * 
	 * @param postedBy
	 * @return Collection<Map.Entry<String, Integer>>
	 */

	@RequestMapping(value = "/comments/popularWords/{postedBy}", method = RequestMethod.GET)
	public Collection<Map.Entry<String, Integer>> getPopularWords(
			@PathVariable final String postedBy) {
		return postService.getPopularWords(postedBy);
	}
}