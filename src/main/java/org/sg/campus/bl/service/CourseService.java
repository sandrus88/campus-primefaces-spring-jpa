package org.sg.campus.bl.service;

import org.sg.campus.bl.entities.CourseEntity;

public interface CourseService {
	CourseEntity insert(CourseEntity courseEntity);
	CourseEntity get(Integer id);
	CourseEntity update(CourseEntity courseEntity);
	boolean delete(Integer id);
}
