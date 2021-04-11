package org.sg.campus.bl.dao.impl;

import org.sg.campus.bl.dao.ExamDao;
import org.sg.campus.bl.dao.GenericDao;
import org.sg.campus.bl.entities.ExamEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ExamDaoImpl extends GenericDao implements ExamDao {
	
	public ExamEntity insert(ExamEntity examEntity) {
		entityManager.persist(examEntity);
		return examEntity;
	}

	public ExamEntity get(Integer id) {
		ExamEntity examEntity = entityManager.find(ExamEntity.class, id);
		return examEntity;
	}

	public ExamEntity update(ExamEntity examEntity) {
		entityManager.merge(examEntity);
		return examEntity;
	}

	public boolean delete(Integer id) {
		ExamEntity examEntity = entityManager.find(ExamEntity.class, id);
		if (examEntity != null) {
			entityManager.remove(examEntity);
			return true;
		}
		return false;
	}

	@Override
	public List<ExamEntity> getAll() {
		List<ExamEntity> exams = entityManager.createQuery("from ExamEntity", ExamEntity.class).getResultList();
		return exams;
	}
}
