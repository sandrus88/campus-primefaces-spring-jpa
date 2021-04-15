package org.sg.campus.bl.service;

import java.util.List;

import org.sg.campus.bl.domain.Student;

public interface StudentService {
	Student insert(Student student);

	Student getStudent(Integer id);

	Student update(Student student);

	List<Student> getAllStudents();

	List<Student> searchStudent(Student searchDto);

	boolean deleteStudent(Integer id);
}
