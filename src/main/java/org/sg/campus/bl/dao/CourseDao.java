package org.sg.campus.bl.dao;

import org.sg.campus.bl.entities.CourseEntity;

public interface CourseDao {
		CourseEntity insert(CourseEntity courseEntity);
		CourseEntity get(Integer id);
		CourseEntity update(CourseEntity courseEntity);
		boolean delete(Integer id);
	}
