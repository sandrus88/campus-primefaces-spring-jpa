package org.sg.campus.bl.dao.impl;

import org.sg.campus.bl.dao.ExamDao;
import org.sg.campus.bl.dao.GenericDao;
import org.sg.campus.bl.entities.ExamEntity;
import org.springframework.stereotype.Repository;

@Repository
public class ExamDaoImpl extends GenericDao implements ExamDao{
	
	public ExamEntity insert(ExamEntity examEntity) {
		entityManager.getTransaction().begin();
		entityManager.persist(examEntity);
		entityManager.getTransaction().commit();
		return examEntity;
	}

	public ExamEntity get(Integer id) {
		ExamEntity examEntity = entityManager.find(ExamEntity.class, id);
		return examEntity;
	}

	public ExamEntity update(ExamEntity examEntity) {
		entityManager.getTransaction().begin();
		entityManager.persist(examEntity);
		entityManager.getTransaction().commit();
		return examEntity;
	}

	public boolean delete(Integer id) {
		ExamEntity examEntity = entityManager.find(ExamEntity.class, id);
		if (examEntity != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(examEntity);
			entityManager.getTransaction().commit();
			return true;
		}
		return false;
	}
}
