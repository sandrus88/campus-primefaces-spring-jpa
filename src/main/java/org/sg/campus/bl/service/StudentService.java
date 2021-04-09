package org.sg.campus.bl.service;

import org.sg.campus.bl.entities.AddressEntity;
import org.sg.campus.bl.entities.StudentEntity;

public interface StudentService {
	StudentEntity insert(StudentEntity studentEntity);
	StudentEntity getStudent(Integer id);
	StudentEntity update(StudentEntity studentEntity);
	boolean deleteStudent(Integer id);
	AddressEntity insert(AddressEntity addressEntity);
	AddressEntity get(AddressEntity addressEntity);
	AddressEntity update(AddressEntity addressEntity);
	void delete(AddressEntity addressEntity);
	
}
