package org.sg.campus.bl.service;

import java.util.List;

import org.sg.campus.bl.entities.TopicEntity;
import org.sg.campus.web.domain.Topic;

public interface TopicService {
	TopicEntity insert(TopicEntity topicEntity);
	TopicEntity get(Integer id);
	TopicEntity update(TopicEntity topicEntity);
	List<TopicEntity> getAll();
	boolean delete(Integer id);
	
	List<Topic> getAllTopics();
	
	List<Topic> searchTopic(Topic searchDto);
}
