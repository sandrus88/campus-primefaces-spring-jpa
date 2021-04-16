package org.sg.campus.bl.dao.impl;

import java.util.List;

import org.sg.campus.bl.dao.CourseDao;
import org.sg.campus.bl.dao.GenericDao;
import org.sg.campus.bl.domain.Course;
import org.sg.campus.bl.entities.CourseEntity;
import org.sg.campus.bl.entities.TopicEntity;
import org.sg.campus.web.util.SGUtil;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl extends GenericDao implements CourseDao {

	@Override
	public CourseEntity insert(CourseEntity courseEntity) {
		entityManager.persist(courseEntity);
		return courseEntity;
	}

	@Override
	public CourseEntity get(Integer id) {
		CourseEntity courseEntity = entityManager.find(CourseEntity.class, id);
		return courseEntity;
	}

	@Override
	public CourseEntity update(CourseEntity courseEntity) {
		entityManager.merge(courseEntity);
		return courseEntity;
	}

	@Override
	public boolean delete(Integer id) {
		CourseEntity courseEntity = entityManager.find(CourseEntity.class, id);
		if (courseEntity != null) {
			entityManager.remove(courseEntity);
			return true;
		}
		return false;
	}
	
	@Override
	public List<CourseEntity> getAll() {
		List<CourseEntity> courses = entityManager.createQuery("from CourseEntity", CourseEntity.class).getResultList();
		return courses;
	}

	@Override
	public List<CourseEntity> searchCourse(Course searchDto) {
		String sql = "select c from CourseEntity c ";
		sql += "where 1=1";
		if (searchDto.getId() != null) {
			sql += "and c.id = '" + searchDto.getId() + "'";
		}
		if (!SGUtil.isEmpty(searchDto.getName())) {
			sql += "and upper(c.name) like upper('%" + searchDto.getName() + "%')";
		}
		if (!SGUtil.isEmpty(searchDto.getDescription())) {
			sql += "and upper(c.description) like upper('%" + searchDto.getDescription() + "%')";
		}
		if(searchDto.getEnabled() != null) {
			sql += "and c.enabled = '" + searchDto.getEnabled() + "'";
		}
		List<CourseEntity> courses = entityManager.createQuery(sql, CourseEntity.class).getResultList();
		return courses;
	}
	
	@Override
	public List<TopicEntity> getTopicsForCourse(Course courseDto) {
		String sql = "select t from TopicEntity t ";
		sql += "where course_id = " + courseDto.getId();

		List<TopicEntity> topics = entityManager.createQuery(sql, TopicEntity.class).getResultList();
		return topics;
	}	
}
