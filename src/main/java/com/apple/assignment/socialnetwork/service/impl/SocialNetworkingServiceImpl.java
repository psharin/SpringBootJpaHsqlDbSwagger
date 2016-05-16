package com.apple.assignment.socialnetwork.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apple.assignment.socialnetwork.domain.Comment;
import com.apple.assignment.socialnetwork.domain.Message;
import com.apple.assignment.socialnetwork.entity.CommentEntity;
import com.apple.assignment.socialnetwork.entity.MessageEntity;
import com.apple.assignment.socialnetwork.repository.CommentRepository;
import com.apple.assignment.socialnetwork.repository.MessageRepository;
import com.apple.assignment.socialnetwork.service.SocialNetworkingService;

/**
 * SocialNetworkingServiceImpl to provide implementation for all
 * messages/comment Interface methods.
 * 
 * @author sandhya_p
 *
 */
@Service
public class SocialNetworkingServiceImpl implements SocialNetworkingService {

	private static final Logger logger = LoggerFactory
			.getLogger(SocialNetworkingServiceImpl.class);

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private MessageRepository messageRepository;

	/**
	 * Saves posted Message information to DB.
	 * 
	 * @param  Message
	 * @return 
	 */
	public void savePost(final Message message) {
		if (null != message) {
			MessageEntity entity = new MessageEntity();
			entity.setMsgDesc(message.getMsgDesc());
			entity.setPostedBy(message.getPostedBy());
			messageRepository.save(entity);
			logger.info("Posted Message information saved successfully");
		}
	}

	/**
	 * deletes Message information for provided messageId
	 * 
	 * @param  msgId
	 * @return 
	 */
	public void deletePost(final Long msgId) {
		try {
			messageRepository.delete(msgId);
			commentRepository.delete(msgId);
			logger.info("Posted Message deleted successfully");
		} catch (Exception e) {
			logger.info("No Messages to delete");
		}
	}

	/**
	 * Saves Comments information for provided messageId
	 * 
	 * @param Comment
	 * @return 
	 */
	public void saveComment(final Comment comment) {

		if (null != comment) {
			CommentEntity entity = new CommentEntity();
			entity.setCommentDesc(comment.getCommentDesc());
			entity.setCommentedBy(comment.getCommentedBy());
			entity.setMsgId(comment.getMsgId());
			commentRepository.save(entity);
			logger.info("Comments save successfully");
		}
	}

	/**
	 * Retrieves all PostedMessages information
	 * 
	 * @param 
	 * @return List<String>
	 */
	public List<Message> getMessages() {

		List<Message> msgList = new ArrayList<Message>();
		Iterable<MessageEntity> entityList = messageRepository.findAll();
		if (entityList != null) {
			entityList.forEach((k)->{
				Message msg = new Message();
				msg.setMsgId(k.getMsgId());
				msg.setMsgDesc(k.getMsgDesc());
				msg.setPostedBy(k.getPostedBy());
				msgList.add(msg);
			});
		}
		logger.info("Total Number of post messages --->"+msgList.size());
		return msgList;
	}

	/**
	 * Find out users information if any one commented on any of my posts.
	 * 
	 * @param postedBy
	 * @return List<String>
	 */
	public List<String> getCommentedUsers(final String postedBy) {

		List<String> userList = commentRepository.findAllUsers(postedBy);
		logger.info("Users list size is --->"+userList.size());
		return userList;
	}

	/**
	 * Find out most popular words from all my posts
	 * 
	 * @param postedBy
	 * @return Collection<Map.Entry<String,Integer>>
	 */
	@Override
	public Collection<Map.Entry<String, Integer>> getPopularWords(String postedBy) {
		List<String> postsList = commentRepository.findMyPosts(postedBy);
		List<String> wordList = new ArrayList<>();
		for (String str : postsList) {
			String words[] = str.split(" ");
			wordList.addAll(Arrays.asList(words));
		}
		logger.info(topOccurences(wordList, 10).toString());
		return topOccurences(wordList, 10);
	}

	/**
	 * Find out most occurrence words for given threshold value
	 * 
	 * @param words
	 * @param topThreshold
	 * @return
	 */
	private static Collection<Map.Entry<String, Integer>> topOccurences(List<String> words, int topThreshold) {
		Map<String, Integer> occurences = new HashMap<>();
		words.stream().forEach((word) -> {
			int count = 1;
			if (occurences.containsKey(word)) {
				count = occurences.get(word) + 1;
			}
			occurences.put(word, count);
		});

		List<Map.Entry<String, Integer>> entries = new LinkedList<>(occurences.entrySet());
		List<Map.Entry<String, Integer>> tops = new LinkedList<>();
		Comparator<Map.Entry<String, Integer>> valueComp = Comparator
				.comparing((Map.Entry<String, Integer> t) -> t.getValue());
		int topcount = 0;
		while (topcount < topThreshold && !entries.isEmpty()) {
			Map.Entry<String, Integer> max = Collections
					.max(entries, valueComp);
			tops.add(max);
			entries.remove(max);
			topcount++;
		}
		return tops;
	}

}
