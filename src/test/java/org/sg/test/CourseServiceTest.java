package org.sg.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.sg.test.util.EntityUtils.createCourse;
import static org.sg.test.util.EntityUtils.updateCourse;

import java.util.List;

import org.junit.Test;
import org.sg.campus.bl.domain.Course;
import org.sg.campus.bl.domain.Topic;
import org.sg.campus.bl.service.CourseService;
import org.sg.campus.bl.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseServiceTest extends AbstractSpringTest {

	@Autowired
	private CourseService courseService;
	@Autowired
	private TopicService topicService;

	@Test
	public void test_getCourse_withoutTopics() {
		// Given
		final Integer courseId = 5;

		// When
		Course course = courseService.getCourse(courseId);

		// Then
		assertNotNull(course);
		assertEquals(course.getName(), "Javascript");
		assertEquals(course.getDescription(), "Concetti base di Javascript");
	}

	@Test
	public void test_getCourse_withTopics() {
		// Given
		final Integer courseId = 1;
		final Topic topic = new Topic(301, "Objects Oriented Paradigm",
				"OOPS concepts (Data Abstraction, Encapsulation, Inheritance, Polymorphism)", courseId);

		// When
		Course course = courseService.getCourse(courseId);

		// Then
		assertNotNull(course);
		assertNotNull(course.getTopics());
		assertEquals(5, course.getTopics().size());

		assertNotNull(course.getTopics().get(0));
		assertEquals(topic, course.getTopics().get(0));
	}

	@Test
	public void test_getAllCourses() {
		// Given
		final Integer[] topicsId = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

		// When
		List<Course> courses = courseService.getAllCourses();

		// Then
		assertNotNull(courses);
		assertEquals(courses.size(), 10);
		assertEquals(courses.get(0).getId(), topicsId[0]);
		assertEquals(courses.get(9).getId(), topicsId[9]);
	}

	@Test
	public void test_getCourse_notPresent() {
		// Given
		final Integer courseId = -1;

		// When
		Course course = courseService.getCourse(courseId);

		// Then
		assertNull(course);
	}

	@Test
	public void test_searchAllCourses() {
		// Given
		Course searchBean = new Course();

		// When
		List<Course> list = courseService.searchCourse(searchBean);

		// Then
		assertEquals(10, list.size());
	}

	@Test
	public void test_searchCourses_fullMatch() {
		// Given
		Course searchBean = new Course();
		searchBean.setId(1);
		searchBean.setName("Java");
		searchBean.setEnabled(true);

		// When
		List<Course> list = courseService.searchCourse(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchCourses_partialMatch() {
		// Given
		Course searchBean = new Course();
		searchBean.setName("Ja");

		// When
		List<Course> list = courseService.searchCourse(searchBean);

		// Then
		assertEquals(3, list.size());
	}

	@Test
	public void test_searchCourses_byName() {
		// Given
		Course searchBean = new Course();
		searchBean.setName("Computer Network");

		// When
		List<Course> list = courseService.searchCourse(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchCourses_byEnabled() {
		// Given
		Course searchBean = new Course();
		searchBean.setEnabled(false);
		// When
		List<Course> list = courseService.searchCourse(searchBean);
		// Then
		assertEquals(5, list.size());

		searchBean.setEnabled(true);
		list = courseService.searchCourse(searchBean);
		assertEquals(5, list.size());
	}

	@Test
	public void test_insertCourse() {
		// Given
		Course course = createCourse();

		// When
		course = courseService.insert(course);
		Course courseDb = courseService.getCourse(course.getId());

		// Then
		assertEquals(courseDb, course);
//      assertTrue(courseDb.getTopics().isEmpty());
	}

	@Test
	public void test_updateCourse() {
		// Given
		final Integer courseId = 1;

		// When
		Course course = courseService.getCourse(courseId);
		updateCourse(course);
		course = courseService.update(course);
		Course courseDb = courseService.getCourse(courseId);

		// Then
		assertEquals(courseDb, course);
		assertNotNull(courseDb.getTopics());
		assertEquals(5, courseDb.getTopics().size());
		assertEquals(new Integer(301), courseDb.getTopics().get(0).getId());
		assertEquals("Objects Oriented Paradigm", courseDb.getTopics().get(0).getName());
	}

	@Test
	public void test_updateCourse_addTopics() {
		// Given
		final Integer courseId = 10;
		Topic topic = topicService.getTopic(308);
		Topic topic2 = topicService.getTopic(309);
		Topic topic3 = topicService.getTopic(310);

		// When
		Course course = courseService.getCourse(courseId);
		course.addTopic(topic);
		course.addTopic(topic2);
		course.addTopic(topic3);
		course = courseService.update(course);
		Course courseDb = courseService.getCourse(courseId);

		// Then
		assertEquals(courseDb, course);
		assertNotNull(courseDb.getTopics());
		assertEquals(3, courseDb.getTopics().size());
	}
	
	@Test
	public void test_updateCourse_removeTopics() {
		// Given
		final Integer courseId = 1;
		Topic topic = new Topic(301, "Objects Oriented Paradigm", "OOPS concepts (Data Abstraction, Encapsulation, Inheritance, Polymorphism)", 1);
		
		// When
		Course course = courseService.getCourse(courseId);
		course.removeTopic(topic);
		course = courseService.update(course);
		Course courseDb = courseService.getCourse(courseId);
		
		// Then
		assertEquals(courseDb, course);
		assertNotNull(courseDb.getTopics());
		assertEquals(4, courseDb.getTopics().size());
	}

	@Test
	public void test_deleteCourse_withoutTopics() {
		// Given
		final Integer courseId = 9;

		// When
		boolean deleting = courseService.deleteCourse(courseId);
		Course course = courseService.getCourse(courseId);

		// Then
		assertTrue(deleting);
		assertNull(course);
	}

	@Test
	public void test_deleteCourse_withTopics_shouldRemoveCourseButNotTopics() {
		// Given
		final Integer courseId = 1;
		final Integer topicId = 301;

		// When
		boolean deleting = courseService.deleteCourse(courseId);
		Course course = courseService.getCourse(courseId);
		Topic topic = topicService.getTopic(topicId);

		// Then
		assertTrue(deleting);
		assertNull(course);
		assertNotNull(topic);
	}

	@Test
	public void test_deleteCourse_notPresent() {
		// Given
		final Integer courseId = -1;

		// When
		boolean deleting = courseService.deleteCourse(courseId);

		// Then
		assertFalse(deleting);
	}

	@Test
	public void test_course_integrationTest_CRUD() {
		// 1. insert a new course
		Course course = createCourse();
		course = courseService.insert(course);
		assertNotNull(course.getId());

		// 2. get the course from DB
		Course courseDb = courseService.getCourse(course.getId());
		assertNotNull(courseDb);
		assertEquals(courseDb, course);

		// 3. Update the course in DB, and Get to check if updated correctly
		updateCourse(course);
		course = courseService.update(course);
		courseDb = courseService.getCourse(course.getId());
		assertEquals(courseDb, course);

		// 4. Delete the course from DB, and Get to check if deleted correctly
		boolean isRemoved = courseService.deleteCourse(course.getId());
		assertTrue(isRemoved);
		courseDb = courseService.getCourse(course.getId());
		assertNull(courseDb);
	}
}
