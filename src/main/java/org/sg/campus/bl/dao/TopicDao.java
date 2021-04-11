package org.sg.campus.bl.dao;

import org.sg.campus.bl.entities.TopicEntity;

import java.util.List;

public interface TopicDao {
    TopicEntity insert(TopicEntity topicEntity);

    TopicEntity get(Integer id);

    TopicEntity update(TopicEntity topicEntity);

    List<TopicEntity> getAll();

    boolean delete(Integer id);
}
