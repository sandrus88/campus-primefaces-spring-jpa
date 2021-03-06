package org.sg.campus.bl.service.impl;

import org.sg.campus.bl.dao.CourseDao;
import org.sg.campus.bl.dao.ExamDao;
import org.sg.campus.bl.dao.StudentDao;
import org.sg.campus.bl.entities.CourseEntity;
import org.sg.campus.bl.entities.ExamEntity;
import org.sg.campus.bl.entities.StudentEntity;
import org.sg.campus.bl.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "examService")
@Transactional
public class ExamServiceImpl implements ExamService {
	
	final private StudentDao studentDao;
    final private CourseDao courseDao;
    final private ExamDao examDao;

	@Autowired
	public ExamServiceImpl(StudentDao studentDao, CourseDao courseDao,  ExamDao examDao) {
		this.studentDao = studentDao;
		this.courseDao = courseDao;
		this.examDao = examDao;
	}

	public StudentEntity insertStudent(StudentEntity studentEntity) {
		return studentDao.insert(studentEntity);
	}

	public StudentEntity getStudent(Integer id) {
		return studentDao.get(id);
	}

	public StudentEntity updateStudent(StudentEntity studentEntity) {
		return studentDao.update(studentEntity);
	}

	public boolean deleteStudent(Integer id) {
		return studentDao.delete(id);
	}

	@Override
	public CourseEntity insertCourse(CourseEntity courseEntity) {
		return courseDao.insert(courseEntity);
	}

	@Override
	public CourseEntity getCourse(Integer id) {
		return courseDao.get(id);
	}

	@Override
	public CourseEntity updateCourse(CourseEntity courseEntity) {
		return courseDao.update(courseEntity);
	}

	@Override
	public boolean deleteCourse(Integer id) {
		return courseDao.delete(id);
	}

	@Override
	public List<StudentEntity> getAllStudents() {
		return studentDao.getAll();
	}

	@Override
	public List<CourseEntity> getAllCourses() {
		return courseDao.getAll();
	}

	@Override
	public List<ExamEntity> getAllExams() {
		return examDao.getAll();
	}
}
