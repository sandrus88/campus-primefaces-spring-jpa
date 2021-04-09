package org.sg.campus.bl.dao;

import org.sg.campus.bl.entities.StudentEntity;

public interface StudentDao {
	StudentEntity insert(StudentEntity studentEntity);
	StudentEntity get(Integer id);
	StudentEntity update(StudentEntity studentEntity);
	boolean delete(Integer id);
}
