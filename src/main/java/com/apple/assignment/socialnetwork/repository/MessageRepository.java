package com.apple.assignment.socialnetwork.repository;

import org.springframework.data.repository.CrudRepository;

import com.apple.assignment.socialnetwork.entity.MessageEntity;

public interface MessageRepository extends CrudRepository<MessageEntity, Long> {

}
