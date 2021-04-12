package org.sg.campus.bl.dao;

import java.util.List;

import org.sg.campus.bl.entities.TopicEntity;
import org.sg.campus.web.domain.Topic;

public interface TopicDao {
    TopicEntity insert(TopicEntity topicEntity);

    TopicEntity get(Integer id);

    TopicEntity update(TopicEntity topicEntity);

    List<TopicEntity> getAll();

    boolean delete(Integer id);
    
    List<TopicEntity> searchTopic(Topic searchDto);
}
