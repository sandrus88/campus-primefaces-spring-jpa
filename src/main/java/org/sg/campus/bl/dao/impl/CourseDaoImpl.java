package org.sg.campus.bl.dao.impl;

import org.sg.campus.bl.dao.CourseDao;
import org.sg.campus.bl.dao.GenericDao;
import org.sg.campus.bl.entities.CourseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class CourseDaoImpl extends GenericDao implements CourseDao{

	@Override
	public CourseEntity insert(CourseEntity courseEntity) {
		entityManager.getTransaction().begin();
		entityManager.persist(courseEntity);
		entityManager.getTransaction().commit();
		return courseEntity;
	}

	@Override
	public CourseEntity get(Integer id) {
		CourseEntity courseEntity = entityManager.find(CourseEntity.class, id);
		return courseEntity;
	}

	@Override
	public CourseEntity update(CourseEntity courseEntity) {
		entityManager.getTransaction().begin();
		entityManager.persist(courseEntity);
		entityManager.getTransaction().commit();
		return courseEntity;
	}

	@Override
	public boolean delete(Integer id) {
		CourseEntity courseEntity = entityManager.find(CourseEntity.class, id);
		if (courseEntity != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(courseEntity);
			entityManager.getTransaction().commit();
			return true;
		}
		return false;
	}

}
