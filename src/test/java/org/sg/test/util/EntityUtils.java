package org.sg.test.util;

import org.sg.campus.bl.domain.PaymentType;
import org.sg.campus.bl.domain.Student;
import org.sg.campus.bl.entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
//	
//	public static CourseEntity createCourse() {
//		CourseEntity courseEntity = new CourseEntity();
//		courseEntity.setName("newCourse");
//		courseEntity.setDescription("descriptionOfNewCourse");
//		return courseEntity;
//	}
//	
//	public static CourseEntity updateCourse(CourseEntity courseEntity) {
//		courseEntity.setName("updatedCourse");
//		courseEntity.setDescription("descriptionOfUpdatedCourse");
//		return courseEntity;
//	}
//	
//	public static TopicEntity createTopic(CourseEntity courseEntity) {
//		TopicEntity topicEntity = new TopicEntity();
//		topicEntity.setName("newTopic");
//		topicEntity.setDescription("descriptionOfNewTopic");
//		topicEntity.setCourseEntity(courseEntity);
//		courseEntity.addTopic(topicEntity);
//		return topicEntity;
//	}
//	
//	public static TopicEntity updateTopic(TopicEntity topicEntity) {
//		topicEntity.setName("updatedTopic");
//		topicEntity.setDescription("descriptionOfUpdatedTopic");
//		return topicEntity;
//	}
//
//	public static AddressEntity createAddress(Student student) {
//		AddressEntity addressEntity = new AddressEntity();
//		addressEntity.setStreet("newStreet");
//		addressEntity.setNr("newNumber");
//		addressEntity.setPostalCode(00000);
//		addressEntity.setCity("newCity");
//		addressEntity.setProvinceCode("NA");
//		addressEntity.setStudentEntity(student);
//		student.setAddressEntity(addressEntity);
//		return addressEntity;
//	}
//	
//	public static AddressEntity updateAddress(AddressEntity addressEntity) {
//		addressEntity.setStreet("updatedStreet");
//		addressEntity.setNr("updatedNumber");
//		addressEntity.setPostalCode(99999);
//		addressEntity.setCity("updatedCity");
//		addressEntity.setProvinceCode("UA");
//		return addressEntity;
//	}
//	
//	public static ExamEntity createExam(Student student, CourseEntity courseEntity) throws ParseException{
//		ExamEntity examEntity = new ExamEntity();
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		Date date = sdf.parse("01/01/2021");
//		
//		examEntity.setExamDate(date);
//		examEntity.setMark(18);
//		examEntity.setCourseEntity(courseEntity);
//		examEntity.setStudentEntity(student);
//		student.addExam(examEntity);
//		return examEntity;
//	}
//	
//	public static ExamEntity updateExam(ExamEntity examEntity) throws ParseException{
//		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//		Date date = sdf.parse("31/12/2021");
//		examEntity.setExamDate(date);
//		examEntity.setMark(30);
//		return examEntity;
//	}
}
