package org.sg.campus.bl.service;

import org.sg.campus.bl.entities.CourseEntity;
import org.sg.campus.bl.entities.TopicEntity;

import java.util.List;

public interface CourseService {
    CourseEntity insert(CourseEntity courseEntity);

    CourseEntity get(Integer id);

    CourseEntity update(CourseEntity courseEntity);

    List<CourseEntity> getAllCourses();

    List<TopicEntity> getAllTopics();

    boolean delete(Integer id);
}
