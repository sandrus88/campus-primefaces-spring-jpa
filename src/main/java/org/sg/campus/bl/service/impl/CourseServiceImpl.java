package org.sg.campus.bl.service.impl;

import org.sg.campus.bl.dao.CourseDao;
import org.sg.campus.bl.dao.TopicDao;
import org.sg.campus.bl.entities.CourseEntity;
import org.sg.campus.bl.entities.TopicEntity;
import org.sg.campus.bl.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

	final private CourseDao courseDao;
	final private TopicDao topicDao;

	@Autowired
	public CourseServiceImpl(CourseDao courseDao, TopicDao topicDao) {
		this.courseDao = courseDao;
		this.topicDao = topicDao;
	}

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

	@Override
	public List<CourseEntity> getAllCourses() {
		return courseDao.getAll();
	}

	@Override
	public List<TopicEntity> getAllTopics() {
		return topicDao.getAll();
	}
}
