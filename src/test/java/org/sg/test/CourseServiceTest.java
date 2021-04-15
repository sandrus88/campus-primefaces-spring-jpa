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
import org.sg.campus.bl.domain.PaymentType;
import org.sg.campus.bl.domain.Student;
import org.sg.campus.bl.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;

public class CourseServiceTest extends AbstractSpringTest {

    @Autowired
    private CourseService courseService;
    
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
		assertEquals(2, list.size());
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
        assertEquals(9999, list.size());
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
    public void test_deleteCourse() {
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
    public void test_deleteCourse_withTopics() {
        // delete only course, but not topics
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
    
    
//  @Test
//  public void test_getCourse_withTopics() {
//      // Given
//      final Integer courseId = 201;
//      
//      // When
//      Course course = courseService.get(courseId);
//      
//      // Then
//      assertNotNull(course.getTopics());
//      assertEquals(course.getTopics().get(0).getId(), Integer.valueOf(1));
//      assertEquals(course.getTopics().get(1).getId(), Integer.valueOf(2));
//      assertEquals(course.getTopics().get(2).getId(), Integer.valueOf(3));
//      assertEquals(course.getTopics().get(3).getId(), Integer.valueOf(4));
//      assertEquals(course.getTopics().get(4).getId(), Integer.valueOf(6));
//  }
  
//    
//    @Test
//    public void test_insertCourse_withTopics() {
//        // Given
//        Course course = createCourse();
//        TopicEntity topicEntity = createTopic(course);
//        
//        // When
//        courseService.insert(course);
//        Course courseDb = courseService.get(course.getId());
//        
//        // Then
//        assertNotNull(course.getTopicById(topicEntity.getId()));
//        assertEquals(courseDb, course);
//        assertNotNull(courseDb.getTopics());
//        assertEquals(courseDb.getTopics().size(), course.getTopics().size());
//    }
    
//    @Test
//    public void test_addTopic_forCourse() {
//        //Given
//        final Integer courseId = 208;
//        
//        //When
//        Course course = courseService.get(courseId);
//        TopicEntity topicEntity = createTopic(course);
//        course.addTopic(topicEntity);
//        courseService.update(course);
//        Course courseDb = courseService.get(courseId);
//        
//        //Then
//        assertNotNull(courseDb.getTopicById(topicEntity.getId()));
//        assertEquals(courseDb.getTopicById(topicEntity.getId()), topicEntity);
//    }
    
//    @Test
//    public void test_deleteTopic_forCourse() {
//        // Given
//        final Integer courseId = 206;
//        final Integer topicId = 15;
//        
//        // When
//        Course course = courseService.get(courseId);
//        course.removeTopicById(topicId);
//        courseService.update(course);
//        Course courseDb = courseService.get(courseId);
//        
//        // Then
//        assertNull(courseDb.getTopicById(topicId));
//    }
    
//    @Test
//    public void test_updateTopic_forCourse() {
//        //Given
//        final Integer courseId = 203;
//        final Integer topicId = 10;
//        
//        //When
//        Course course = courseService.get(courseId);
//        TopicEntity topicEntity = course.getTopicById(topicId);
//        updateTopic(topicEntity);
//        courseService.update(course);
//        Course courseDb = courseService.get(courseId);
//        
//        //Then
//        assertEquals(courseDb.getTopicById(topicId), topicEntity);
//    }
    
    
//    @Test
//    public void test_updateCourse_withTopics() {
//        //Given
//        final Integer courseId = 202;
//        
//        //When
//        Course course = courseService.get(courseId);
//        course = updateCourse(course);
//        courseService.update(course);
//        Course courseDb = courseService.get(courseId);
//        
//        //Then
//        assertEquals(2, course.getTopics().size());
//        assertEquals(courseDb, course);
//        assertEquals(2, courseDb.getTopics().size());
//        assertEquals(courseDb.getTopics().get(0), courseDb.getTopics().get(0));
//        assertEquals(courseDb.getTopics().get(1), courseDb.getTopics().get(1));
//    }
//    
    
//    @Test
//    public void test_deleteCourse_WithTopics() {
//        // Given
//        final Integer courseId = 204;
//        
//        // When
//        boolean deleting = courseService.delete(courseId);
//        Course course = courseService.get(courseId);
//        
//        // Then
//        assertTrue(deleting);
//        assertNull(course);
//    }
    
//    @Test
//    public void test_topic_integrationTest_CRUD() {
//        // 1. insert a new course
//        Course course = createCourse();
//        courseService.insert(course);
//        assertNotNull(course.getId());
//        
//        // 2. insert a new topic
//        TopicEntity topicEntity = createTopic(course);
//        courseService.update(course);
//        assertNotNull(topicEntity.getId());
//        
//        // 3. get the topic from DB
//        TopicEntity topicEntityDb = course.getTopicById(topicEntity.getId());
//        assertNotNull(topicEntityDb);
//        assertEquals(topicEntityDb, topicEntity);
//        
//        // 4. Update the topic in DB, and Get to check if updated correctly
//        updateTopic(topicEntity);
//        courseService.update(course);
//        topicEntityDb = course.getTopicById(topicEntity.getId());
//        assertEquals(topicEntityDb, topicEntity);
//        
//        // 5. Delete the topic from DB, and Get to check if deleted correctly
//        course.removeTopicById(topicEntity.getId());
//        courseService.update(course);
//        topicEntityDb = course.getTopicById(topicEntity.getId());
//        assertNull(topicEntityDb);
//    }

//    @Test
//    public void test_getAllTopics() {
//        // Given
//        final Integer[] topicsId = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22 };
//
//        // When
//        List<TopicEntity> topics = courseService.getAllTopics();
//
//        // Then
//        assertNotNull(topics);
//        assertEquals(topics.size(), 22);
//        assertEquals(topics.get(0).getId(), topicsId[0]);
//        assertEquals(topics.get(21).getId(), topicsId[21]);
//    }
}
