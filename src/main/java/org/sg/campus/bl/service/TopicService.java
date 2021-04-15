package org.sg.campus.bl.service;

import java.util.List;

import org.sg.campus.bl.domain.Topic;

public interface TopicService {
	Topic insert(Topic topic);

	Topic getTopic(Integer id);

	Topic update(Topic topic);

	List<Topic> getAllTopics();

	List<Topic> searchTopic(Topic searchDto);

	boolean deleteTopic(Integer id);
}
