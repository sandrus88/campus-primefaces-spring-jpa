package org.sg.campus.bl.service.impl;

import java.util.List;

import org.sg.campus.bl.assembler.StudentAssembler;
import org.sg.campus.bl.dao.StudentDao;
import org.sg.campus.bl.domain.Student;
import org.sg.campus.bl.entities.StudentEntity;
import org.sg.campus.bl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "studentService")
@Transactional
public class StudentServiceImpl implements StudentService {
	
	final private StudentDao studentDao;
	
	@Autowired
	public StudentServiceImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public Student insert(Student student) {
		StudentEntity entity = StudentAssembler.getEntity(student);
		entity = studentDao.insert(entity);
		student = StudentAssembler.getDTO(entity);
		return student;
	}

	public Student getStudent(Integer id) {
		StudentEntity entity = studentDao.get(id);
		Student student = StudentAssembler.getDTO(entity);
		return student;
	}

	public Student update(Student student) {
		StudentEntity entity = StudentAssembler.getEntity(student);
		StudentEntity entityUp = studentDao.update(entity);
		student = StudentAssembler.getDTO(entityUp);
		return student;
	}

	public boolean deleteStudent(Integer id) {
		return studentDao.delete(id);
	}

	@Override
	public List<Student> getAllStudents() {
		List<StudentEntity> entityList = studentDao.getAll();
		List<Student> dtoList = StudentAssembler.getDTOList(entityList);
		return dtoList;
	}

	@Override
	public List<Student> searchStudent(Student searchDto) {
		List<StudentEntity> listEntities = studentDao.searchStudent(searchDto);
		List<Student> list = StudentAssembler.getDTOList(listEntities);
		return list;
	}
}
