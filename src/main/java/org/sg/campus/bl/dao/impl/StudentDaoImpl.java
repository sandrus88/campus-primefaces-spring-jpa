package org.sg.campus.bl.dao.impl;

import org.sg.campus.bl.dao.GenericDao;
import org.sg.campus.bl.dao.StudentDao;
import org.sg.campus.bl.entities.StudentEntity;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDaoImpl extends GenericDao implements StudentDao {

	public StudentEntity insert(StudentEntity studentEntity) {
		entityManager.getTransaction().begin();
		entityManager.persist(studentEntity);
		entityManager.getTransaction().commit();
		return studentEntity;
	}

	public StudentEntity get(Integer id) {
		StudentEntity studentEntity = entityManager.find(StudentEntity.class, id);
		return studentEntity;
	}

	public StudentEntity update(StudentEntity studentEntity) {
		entityManager.getTransaction().begin();
		entityManager.persist(studentEntity);
		entityManager.getTransaction().commit();
		return studentEntity;
	}

	public boolean delete(Integer id) {
		StudentEntity studentEntity = entityManager.find(StudentEntity.class, id);
		if (studentEntity != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(studentEntity);
			entityManager.getTransaction().commit();
			return true;
		}
		return false;
	}
}
