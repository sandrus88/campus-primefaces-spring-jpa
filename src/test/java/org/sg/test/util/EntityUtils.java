package org.sg.test.util;

import org.sg.campus.bl.domain.Course;
import org.sg.campus.bl.domain.PaymentType;
import org.sg.campus.bl.domain.Student;
import org.sg.campus.bl.domain.Topic;

public class EntityUtils {

	public static Student createStudent() {
		Student student = new Student();
		student.setName("newName");
		student.setSurname("newSurname");
		student.setJobTitle("newJob");
		student.setPaymentType(PaymentType.OK);
		student.setSex("M");
		return student;
	}

	public static Student updateStudent(Student student) {
		student.setName("updatedName");
		student.setSurname("updatedSurname");
		student.setEmail("updatedName-updatedSurname@hotmail.com");
		student.setJobTitle("updatedJJobTitle");
		student.setPaymentType(PaymentType.OK);
		student.setSex("M");
		return student;
	}
	
	public static Course createCourse() {
		Course course = new Course();
		course.setName("newCourse");
		course.setDescription("descriptionOfNewCourse");
		course.setEnabled(true);
		return course;
	}
	
	public static Course updateCourse(Course course) {
		course.setName("updatedCourse");
		course.setDescription("descriptionOfUpdatedCourse");
		course.setEnabled(false);
		return course;
	}
	
	public static Topic createTopic() {
		Topic topic = new Topic();
		topic.setName("newTopic");
		topic.setDescription("descriptionOfNewTopic");
		return topic;
	}
	
	public static Topic updateTopic(Topic topic) {
		topic.setName("updatedTopic");
		topic.setDescription("descriptionOfUpdatedTopic");
		return topic;
	}
}