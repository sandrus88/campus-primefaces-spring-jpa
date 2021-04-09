package org.sg.campus.bl.dao.impl;

import org.sg.campus.bl.dao.GenericDao;
import org.sg.campus.bl.dao.TopicDao;
import org.sg.campus.bl.entities.TopicEntity;
import org.springframework.stereotype.Repository;

@Repository
public class TopicDaoImpl extends GenericDao implements TopicDao{

	@Override
	public TopicEntity insert(TopicEntity topicEntity) {
		entityManager.getTransaction().begin();
		entityManager.persist(topicEntity);
		entityManager.getTransaction().commit();
		return topicEntity;
	}

	@Override
	public TopicEntity get(Integer id) {
		TopicEntity topicEntity = entityManager.find(TopicEntity.class, id);
		return topicEntity;
	}

	@Override
	public TopicEntity update(TopicEntity topicEntity) {
		entityManager.getTransaction().begin();
		entityManager.persist(topicEntity);
		entityManager.getTransaction().commit();
		return topicEntity;
	}

	@Override
	public boolean delete(Integer id) {
		TopicEntity topicEntity = entityManager.find(TopicEntity.class, id);
		if (topicEntity != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(topicEntity);
			entityManager.getTransaction().commit();
			return true;
		}
		return false;
	}

}
