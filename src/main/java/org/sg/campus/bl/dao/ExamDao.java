package org.sg.campus.bl.dao;

import org.sg.campus.bl.entities.ExamEntity;

public interface ExamDao {
	ExamEntity insert(ExamEntity examEntity);
	ExamEntity get(Integer id);
	ExamEntity update(ExamEntity examEntity);
	boolean delete(Integer id);
}
