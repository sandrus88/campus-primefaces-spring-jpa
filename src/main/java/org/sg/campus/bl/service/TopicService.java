package org.sg.campus.bl.service;

import org.sg.campus.bl.entities.TopicEntity;

public interface TopicService {
	TopicEntity insert(TopicEntity topicEntity);
	TopicEntity get(Integer id);
	TopicEntity update(TopicEntity topicEntity);
	boolean delete(Integer id);
}
