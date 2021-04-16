package org.sg.campus.bl.service.impl;

import java.util.List;

import org.sg.campus.bl.assembler.CourseAssembler;
import org.sg.campus.bl.assembler.TopicAssembler;
import org.sg.campus.bl.dao.CourseDao;
import org.sg.campus.bl.dao.TopicDao;
import org.sg.campus.bl.domain.Course;
import org.sg.campus.bl.domain.Topic;
import org.sg.campus.bl.entities.CourseEntity;
import org.sg.campus.bl.entities.TopicEntity;
import org.sg.campus.bl.service.CourseService;
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

	public Course insert(Course course) {
		CourseEntity entity = CourseAssembler.getEntity(course);
		entity = courseDao.insert(entity);
		course = CourseAssembler.getDTO(entity);
		return course;
	}

	public Course getCourse(Integer id) {
		CourseEntity entity = courseDao.get(id);
		Course course = CourseAssembler.getDTO(entity);
		return course;
	}

	public Course update(Course course) {
		CourseEntity entity = CourseAssembler.getEntity(course);
		CourseEntity entityUp = courseDao.update(entity);
		course = CourseAssembler.getDTO(entityUp);
		return course;
	}

	public boolean deleteCourse(Integer id) {
		return courseDao.delete(id);
	}

	@Override
	public List<Course> getAllCourses() {
		List<CourseEntity> entityList = courseDao.getAll();
		List<Course> dtoList = CourseAssembler.getDTOList(entityList);
		return dtoList;
	}

	@Override
	public List<Course> searchCourse(Course searchDto) {
		List<CourseEntity> listEntities = courseDao.searchCourse(searchDto);
		List<Course> list = CourseAssembler.getDTOList(listEntities);
		return list;
	}
	
	@Override
	public List<Topic> getAllTopics() {
		List<TopicEntity> entityList = topicDao.getAll();
		List<Topic> dtoList = TopicAssembler.getDTOList(entityList);
		return dtoList;
	}

	@Override
	public List<Topic> getTopicsOfCourse(int courseId) {
		List<TopicEntity> entityList = courseDao.getTopicsForCourseId(courseId);
		List<Topic> dtoList = TopicAssembler.getDTOList(entityList);
		return dtoList;
	}
}
