package org.sg.campus.bl.service;

import java.util.List;

import org.sg.campus.bl.domain.Course;
import org.sg.campus.bl.domain.Topic;

public interface CourseService {
	Course insert(Course course);

	Course getCourse(Integer id);

	Course update(Course course);

	List<Course> getAllCourses();

	List<Course> searchCourse(Course searchDto);
	
	List<Topic> getAllTopics();

	boolean deleteCourse(Integer id);

	List<Topic> getTopicsOfCourse(Course course);
}
