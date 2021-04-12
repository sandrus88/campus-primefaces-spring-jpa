package org.sg.campus.bl.dao.impl;

import org.sg.campus.bl.dao.GenericDao;
import org.sg.campus.bl.dao.TopicDao;
import org.sg.campus.bl.entities.TopicEntity;
import org.sg.campus.web.domain.Topic;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TopicDaoImpl extends GenericDao implements TopicDao {

	@Override
	public TopicEntity insert(TopicEntity topicEntity) {
		entityManager.persist(topicEntity);
		return topicEntity;
	}

	@Override
	public TopicEntity get(Integer id) {
		TopicEntity topicEntity = entityManager.find(TopicEntity.class, id);
		return topicEntity;
	}

	@Override
	public TopicEntity update(TopicEntity topicEntity) {
		entityManager.merge(topicEntity);
		return topicEntity;
	}

	@Override
	public boolean delete(Integer id) {
		TopicEntity topicEntity = entityManager.find(TopicEntity.class, id);
		if (topicEntity != null) {
			entityManager.remove(topicEntity);
			return true;
		}
		return false;
	}

	@Override
	public List<TopicEntity> getAll() {
		List<TopicEntity> topics = entityManager.createQuery("from TopicEntity", TopicEntity.class).getResultList();
		return topics;
	}

	@Override
	public List<TopicEntity> searchTopic(Topic searchDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
