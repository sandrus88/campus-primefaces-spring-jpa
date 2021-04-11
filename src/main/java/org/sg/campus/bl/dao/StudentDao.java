package org.sg.campus.bl.dao;

import org.sg.campus.bl.entities.StudentEntity;

import java.util.List;

public interface StudentDao {
    StudentEntity insert(StudentEntity studentEntity);

    StudentEntity get(Integer id);

    StudentEntity update(StudentEntity studentEntity);

    List<StudentEntity> getAll();

    boolean delete(Integer id);
}
