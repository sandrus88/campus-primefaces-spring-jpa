package org.sg.campus.bl.service;

import java.util.List;

import org.sg.campus.bl.domain.Course;

public interface CourseService {
	Course insert(Course course);

	Course getCourse(Integer id);

	Course update(Course course);

	List<Course> getAllCourses();

	List<Course> searchCourse(Course searchDto);

	boolean deleteCourse(Integer id);
}
