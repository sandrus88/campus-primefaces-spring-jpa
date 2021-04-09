package org.sg.campus.bl.service;

import org.sg.campus.bl.entities.CourseEntity;
import org.sg.campus.bl.entities.StudentEntity;

public interface ExamService {
	StudentEntity insertStudent(StudentEntity studentEntity);
	StudentEntity getStudent(Integer id);
	StudentEntity updateStudent(StudentEntity studentEntity);
	boolean deleteStudent(Integer id);
	CourseEntity insertCourse(CourseEntity courseEntity);
	CourseEntity getCourse(Integer id);
	CourseEntity updateCourse(CourseEntity courseEntity);
	boolean deleteCourse(Integer id);
}
