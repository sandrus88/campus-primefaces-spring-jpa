package org.sg.campus.bl.service;

import java.util.List;

import org.sg.campus.bl.entities.CourseEntity;
import org.sg.campus.bl.entities.TopicEntity;
import org.sg.campus.web.domain.Course;

public interface CourseService {
    CourseEntity insert(CourseEntity courseEntity);

    CourseEntity get(Integer id);

    CourseEntity update(CourseEntity courseEntity);

    List<Course> getAllCourses();

    List<TopicEntity> getAllTopics();

    boolean delete(Integer id);
    
    List<Course> searchCourse(Course searchDto);
}
