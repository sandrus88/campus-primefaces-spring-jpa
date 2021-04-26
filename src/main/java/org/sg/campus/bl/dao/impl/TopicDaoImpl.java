package org.sg.campus.bl.dao.impl;

import org.sg.campus.bl.dao.GenericDao;
import org.sg.campus.bl.dao.TopicDao;
import org.sg.campus.bl.domain.Topic;
import org.sg.campus.bl.entities.CourseEntity;
import org.sg.campus.bl.entities.TopicEntity;
import org.sg.campus.web.util.SGUtil;
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
//		TopicEntity topicEntity = entityManager.find(TopicEntity.class, id);
//		if (topicEntity != null) {
//			entityManager.remove(topicEntity);
//			return true;
//		}
//		return false;
		TopicEntity topicEntity = get(id);
		if (topicEntity == null) {
			return false;
		}

		if (topicEntity.getCourseId() != null) {
			CourseEntity courseEntity = entityManager.find(CourseEntity.class, topicEntity.getCourseId());
			if (courseEntity.getTopics().contains(topicEntity)) {
				courseEntity.removeTopic(topicEntity);
			}
		}
		entityManager.remove(topicEntity);
		return true;
	}

	@Override
	public List<TopicEntity> getAll() {
		List<TopicEntity> topics = entityManager.createQuery("from TopicEntity", TopicEntity.class).getResultList();
		return topics;
	}

	@Override
	public List<TopicEntity> searchTopic(Topic searchDto) {
		String sql = "select t from TopicEntity t ";
		sql += "where 1=1";
		if (searchDto.getId() != null) {
			sql += "and t.id = '" + searchDto.getId() + "'";
		}
		if (!SGUtil.isEmpty(searchDto.getName())) {
			sql += "and upper(t.name) like upper('%" + searchDto.getName() + "%')";
		}
		if (!SGUtil.isEmpty(searchDto.getDescription())) {
			sql += "and upper(t.description) like upper('%" + searchDto.getDescription() + "%')";
		}
		List<TopicEntity> topics = entityManager.createQuery(sql, TopicEntity.class).getResultList();
		return topics;
	}
	
	@Override
	public List<TopicEntity> getTopicsForCourseId(int courseId) {
		String sql = "select t from TopicEntity t ";
		sql += "where course_id = " + courseId;

		List<TopicEntity> topics = entityManager.createQuery(sql, TopicEntity.class).getResultList();
		return topics;
	}
}
