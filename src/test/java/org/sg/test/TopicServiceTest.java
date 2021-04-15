package org.sg.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.sg.test.util.EntityUtils.createTopic;
import static org.sg.test.util.EntityUtils.updateTopic;

import java.util.List;

import org.junit.Test;
import org.sg.campus.bl.domain.Topic;
import org.sg.campus.bl.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;

public class TopicServiceTest extends AbstractSpringTest {

    @Autowired
    private TopicService topicService;
    
    @Test
    public void test_getTopic() {
        // Given
        final Integer topicId = 301;
        
        // When
        Topic topic = topicService.getTopic(topicId);
        
        // Then
        assertNotNull(topic);
        assertEquals(topic.getName(), "Objects Oriented Paradigm");
        assertEquals(topic.getDescription(), "OOPS concepts (Data Abstraction, Encapsulation, Inheritance, Polymorphism)");
    }
    
    @Test
    public void test_getAllTopics() {
        // Given
        final Integer[] topicsId = { 301, 302, 303, 304, 305, 306, 307, 308, 309, 310, 311, 312, 313, 314, 315, 316, 317, 318, 319, 320, 321, 322 };

        // When
        List<Topic> courses = topicService.getAllTopics();

        // Then
        assertNotNull(courses);
        assertEquals(courses.size(), 22);
        assertEquals(courses.get(0).getId(), topicsId[0]);
        assertEquals(courses.get(21).getId(), topicsId[21]);
    }

    @Test
    public void test_getTopic_notPresent() {
        // Given
        final Integer topicId = -1;
        
        // When
        Topic topic = topicService.getTopic(topicId);
        
        // Then
        assertNull(topic);
    }
    
    @Test
	public void test_searchAllTopics() {
		// Given
    	Topic searchBean = new Topic();

		// When
		List<Topic> list = topicService.searchTopic(searchBean);

		// Then
		assertEquals(22, list.size());
	}

	@Test
	public void test_searchTopics_correctData() {
		// Given
		Topic searchBean = new Topic();
		searchBean.setName("String handling");

		// When
		List<Topic> list = topicService.searchTopic(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchTopics_modifiedData() {
		// Given
		Topic searchBean = new Topic();
		searchBean.setName("SerVLET");

		// When
		List<Topic> list = topicService.searchTopic(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchTopics_byName() {
		// Given
		Topic searchBean = new Topic();
		searchBean.setName("Basic math operations");

		// When
		List<Topic> list = topicService.searchTopic(searchBean);

		// Then
		assertEquals(1, list.size());
	}
    
    @Test
    public void test_insertTopic() {
        // Given
        Topic topic = createTopic();
        
        // When
        topic = topicService.insert(topic);
        Topic topicDb = topicService.getTopic(topic.getId());
        
        // Then
        assertEquals(topicDb, topic);
    }
    
    @Test
    public void test_updateTopic() {
        //Given
        final Integer topicId = 302;
        
        //When
        Topic topic = topicService.getTopic(topicId);
        updateTopic(topic);
        topic = topicService.update(topic);
        Topic topicDb = topicService.getTopic(topicId);
        
        //Then
        assertEquals(topicDb, topic);
    }
    
    @Test
    public void test_deleteTopic() {
        // Given
        final Integer topicId = 304;
        
        // When
        boolean deleting = topicService.deleteTopic(topicId);
        Topic topic = topicService.getTopic(topicId);
        
        // Then
        assertTrue(deleting);
        assertNull(topic);
    }
    
    @Test
    public void test_deleteTopic_notPresent() {
        // Given
        final Integer topicId = -1;
        
        // When
        boolean deleting = topicService.deleteTopic(topicId);
        
        // Then
        assertFalse(deleting);
    }
    
    @Test
    public void test_topic_integrationTest_CRUD() {
        // 1. insert a new topic
        Topic topic = createTopic();
        topic = topicService.insert(topic);
        assertNotNull(topic.getId());
        
        // 2. get the topic from DB
        Topic topicDb = topicService.getTopic(topic.getId());
        assertNotNull(topicDb);
        assertEquals(topicDb, topic);
        
        // 3. Update the topic in DB, and Get to check if updated correctly
        updateTopic(topic);
        topic = topicService.update(topic);
        topicDb = topicService.getTopic(topic.getId());
        assertEquals(topicDb, topic);
        
        // 4. Delete the topic from DB, and Get to check if deleted correctly
        boolean isRemoved = topicService.deleteTopic(topic.getId());
        assertTrue(isRemoved);
        topicDb = topicService.getTopic(topic.getId());
        assertNull(topicDb);
    }
}