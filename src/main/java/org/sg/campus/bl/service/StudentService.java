package org.sg.campus.bl.service;

import org.sg.campus.bl.domain.Student;
import org.sg.campus.bl.entities.AddressEntity;
import org.sg.campus.bl.entities.StudentEntity;

import java.util.List;

public interface StudentService {
	Student insert(Student student);
	Student getStudent(Integer id);
	Student update(Student student);
	List<Student> getAllStudents();
	List<Student> searchStudent(Student searchDto);
	boolean deleteStudent(Integer id);
}
