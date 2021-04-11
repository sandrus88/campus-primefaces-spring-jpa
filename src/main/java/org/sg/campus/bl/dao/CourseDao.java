package org.sg.campus.bl.dao;

import org.sg.campus.bl.entities.CourseEntity;

import java.util.List;

public interface CourseDao {
    CourseEntity insert(CourseEntity courseEntity);

    CourseEntity get(Integer id);

    CourseEntity update(CourseEntity courseEntity);

    List<CourseEntity> getAll();

    boolean delete(Integer id);
}
