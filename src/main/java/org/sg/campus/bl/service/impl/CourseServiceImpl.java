package org.sg.campus.bl.service.impl;

import org.sg.campus.bl.dao.CourseDao;
import org.sg.campus.bl.entities.CourseEntity;
import org.sg.campus.bl.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDao courseDao;
	
//	@Autowired
//	public CourseServiceImpl(CourseDao courseDao) {
//		this.courseDao = courseDao;
//	}

	@Override
	public CourseEntity insert(CourseEntity courseEntity) {
		return courseDao.insert(courseEntity);
	}

	@Override
	public CourseEntity get(Integer id) {
		return courseDao.get(id);
	}

	@Override
	public CourseEntity update(CourseEntity courseEntity) {
		return courseDao.update(courseEntity);
	}

	@Override
	public boolean delete(Integer id) {
		return courseDao.delete(id);
	}
}
