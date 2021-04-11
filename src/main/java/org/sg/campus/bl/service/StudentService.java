package org.sg.campus.bl.service;

import org.sg.campus.bl.entities.AddressEntity;
import org.sg.campus.bl.entities.StudentEntity;

import java.util.List;

public interface StudentService {
	StudentEntity insert(StudentEntity studentEntity);
	StudentEntity getStudent(Integer id);
	StudentEntity update(StudentEntity studentEntity);
	List<StudentEntity> getAllStudents();
	boolean deleteStudent(Integer id);

	AddressEntity insert(AddressEntity addressEntity);
	AddressEntity get(AddressEntity addressEntity);
	AddressEntity update(AddressEntity addressEntity);
	List<AddressEntity> getAllAddresses();
	void delete(AddressEntity addressEntity);
	
}
