package org.sg.campus.bl.service.impl;

import java.util.List;

import org.sg.campus.bl.assembler.CourseAssembler;
import org.sg.campus.bl.dao.CourseDao;
import org.sg.campus.bl.dao.TopicDao;
import org.sg.campus.bl.entities.CourseEntity;
import org.sg.campus.bl.entities.TopicEntity;
import org.sg.campus.bl.service.CourseService;
import org.sg.campus.web.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "courseService")
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
	public List<Course> getAllCourses() {
		List<CourseEntity> entityList = courseDao.getAll();
		List<Course> dtoList = CourseAssembler.getDTOList(entityList);
		return dtoList;
	}

	@Override
	public List<TopicEntity> getAllTopics() {
		return topicDao.getAll();
	}

	@Override
	public List<Course> searchCourse(Course searchDto) {
		List<CourseEntity> listEntities = courseDao.searchCourse(searchDto);
		List<Course> list = CourseAssembler.getDTOList(listEntities);
		return list;
	}
}
