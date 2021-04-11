package org.sg.campus.bl.dao.impl;

import org.sg.campus.bl.dao.GenericDao;
import org.sg.campus.bl.dao.StudentDao;
import org.sg.campus.bl.entities.StudentEntity;
import org.sg.campus.web.domain.Student;
import org.sg.campus.web.util.SGUtil;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl extends GenericDao implements StudentDao {

	public StudentEntity insert(StudentEntity studentEntity) {
		entityManager.persist(studentEntity);
		return studentEntity;
	}

	public StudentEntity get(Integer id) {
		StudentEntity studentEntity = entityManager.find(StudentEntity.class, id);
		return studentEntity;
	}

	public StudentEntity update(StudentEntity studentEntity) {
		entityManager.merge(studentEntity);
		return studentEntity;
	}

	public boolean delete(Integer id) {
		StudentEntity studentEntity = entityManager.find(StudentEntity.class, id);
		if (studentEntity != null) {
			entityManager.remove(studentEntity);
			return true;
		}
		return false;
	}

	@Override
	public List<StudentEntity> getAll() {
		List<StudentEntity> students = entityManager.createQuery("from StudentEntity", StudentEntity.class).getResultList();
		return students;
	}

	@Override
	public List<StudentEntity> searchStudent(Student searchDto) {
		String sql = "select s from StudentEntity s ";
		sql += "where 1=1 ";
		if (!SGUtil.isEmpty(searchDto.getName())) {
			sql += "and s.name like('%" + searchDto.getName() + "%'";
		}
		// add other filters

		List<StudentEntity> students = entityManager.createQuery(sql, StudentEntity.class).getResultList();
		return students;
	}
}
