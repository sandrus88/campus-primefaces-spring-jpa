package org.sg.campus.bl.dao;

import org.sg.campus.bl.entities.TopicEntity;

public interface TopicDao {
	TopicEntity insert(TopicEntity topicEntity);
	TopicEntity get(Integer id);
	TopicEntity update(TopicEntity topicEntity);
	boolean delete(Integer id);
}
