package org.sg.campus.bl.dao;

import java.util.List;

import org.sg.campus.bl.domain.Topic;
import org.sg.campus.bl.entities.TopicEntity;

public interface TopicDao {
    TopicEntity insert(TopicEntity topicEntity);

    TopicEntity get(Integer id);

    TopicEntity update(TopicEntity topicEntity);

    List<TopicEntity> getAll();

    boolean delete(Integer id);
    
    List<TopicEntity> searchTopic(Topic searchDto);
    
    List<TopicEntity> getTopicsForCourseId(int courseId);
}
