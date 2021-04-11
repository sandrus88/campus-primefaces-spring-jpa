package org.sg.campus.bl.dao.impl;

import org.sg.campus.bl.dao.CourseDao;
import org.sg.campus.bl.dao.GenericDao;
import org.sg.campus.bl.entities.CourseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

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

}
