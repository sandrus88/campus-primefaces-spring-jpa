package org.sg.campus.bl.dao;

import java.util.List;

import org.sg.campus.bl.domain.Course;
import org.sg.campus.bl.entities.CourseEntity;
import org.sg.campus.bl.entities.TopicEntity;

public interface CourseDao {
    CourseEntity insert(CourseEntity courseEntity);

    CourseEntity get(Integer id);

    CourseEntity update(CourseEntity courseEntity);

    List<CourseEntity> getAll();

    boolean delete(Integer id);
    
    List<CourseEntity> searchCourse(Course searchDto);
}
