package org.sg.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.sg.test.util.EntityUtils.createStudent;
import static org.sg.test.util.EntityUtils.updateStudent;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.sg.campus.bl.domain.PaymentType;
import org.sg.campus.bl.domain.Student;
import org.sg.campus.bl.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentServiceTest extends AbstractSpringTest {

	private static Logger logger = LogManager.getLogger(StudentServiceTest.class);

	@Autowired
	private StudentService studentService;

	@Test
	public void test_getStudent() {
		// Given
		final Integer studentId = 21;

		// When
		Student student = studentService.getStudent(studentId);

		// Then
		assertNotNull(student);
		assertEquals(student.getName(), "Armela");
		assertEquals(student.getSurname(), "Xhaxho");
		assertEquals(student.getEmail(), "armelaxhaxho@hotmail.com");
		assertEquals(student.getJobTitle(), "Shop Assistant");
		assertEquals(student.getPaymentType(), PaymentType.UNKNOWN);
		assertEquals(student.getSex(), "F");
	}

	@Test
	public void test_getAllStudents() {
		// When
		List<Student> students = studentService.getAllStudents();

		// Then
		assertNotNull(students);
		assertEquals(20, students.size());
		assertEquals(new Integer(1), students.get(0).getId());
		assertEquals("Sandro", students.get(0).getName());
		assertEquals("Gargano", students.get(0).getSurname());
		assertEquals("sandrus88@hotmail.it", students.get(0).getEmail());
		assertEquals("Waiter", students.get(0).getJobTitle());
		assertEquals("M", students.get(0).getSex());
		assertEquals(PaymentType.OK, students.get(0).getPaymentType());
	}

	@Test
	public void test_getStudent_notPresent() {
		// Given
		final Integer studentId = -1;

		// When
		Student student = studentService.getStudent(studentId);

		// Then
		assertNull(student);
	}

	@Test
	public void test_searchAllStudents() {
		// Given
		Student searchBean = new Student();

		// When
		List<Student> students = studentService.searchStudent(searchBean);

		// Then
		assertEquals(20, students.size());
		assertEquals(new Integer(1), students.get(0).getId());
		assertEquals("Sandro", students.get(0).getName());
		assertEquals("Gargano", students.get(0).getSurname());
		assertEquals("sandrus88@hotmail.it", students.get(0).getEmail());
		assertEquals("Waiter", students.get(0).getJobTitle());
		assertEquals("M", students.get(0).getSex());
		assertEquals(PaymentType.OK, students.get(0).getPaymentType());
	}

	@Test
	public void test_searchStudents_fullMatch() {
		// Given
		Student searchBean = new Student();
		searchBean.setName("Sandro");
		searchBean.setSurname("Gargano");
		searchBean.setEmail("sandrus88@hotmail.it");
		searchBean.setJobTitle("Waiter");
		searchBean.setPaymentType(PaymentType.OK);
		searchBean.setSex("M");

		// When
		List<Student> list = studentService.searchStudent(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchStudents_fullSearch_partialMatch() {
		// Given
		Student searchBean = new Student();
		searchBean.setName("ndRO");
		searchBean.setSurname("rgANo");
		searchBean.setEmail("sandrus88@hotMAIL.it");
		searchBean.setJobTitle("Wait");
		searchBean.setPaymentType(PaymentType.OK);
		searchBean.setSex("M");

		// When
		List<Student> list = studentService.searchStudent(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchStudents_byName() {
		// Given
		Student searchBean = new Student();
		searchBean.setName("Sandro");

		// When
		List<Student> list = studentService.searchStudent(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchStudents_bySurname() {
		// Given
		Student searchBean = new Student();
		searchBean.setSurname("Xhaxho");
		
		// When
		List<Student> list = studentService.searchStudent(searchBean);

		// Then
		assertEquals(2, list.size());
	}

	@Test
	public void test_searchStudents_byEmail() {
		// Given
		Student searchBean = new Student();
		searchBean.setEmail("sandrus88@hotmail.it");

		// When
		List<Student> list = studentService.searchStudent(searchBean);

		// Then
		assertEquals(1, list.size());
	}

	@Test
	public void test_searchStudents_byJobTitle() {
		// Given
		Student searchBean = new Student();
		searchBean.setJobTitle("Job");

		// When
		List<Student> list = studentService.searchStudent(searchBean);

		// Then
		assertEquals(12, list.size());
	}

	@Test
	public void test_searchStudents_byPaymentType() {
		// Given
		Student searchBean = new Student();
		searchBean.setPaymentType(PaymentType.OK);
		// When
		List<Student> list = studentService.searchStudent(searchBean);
		// Then
		assertEquals(16, list.size());

		searchBean.setPaymentType(PaymentType.NOTOK);
		list = studentService.searchStudent(searchBean);
		assertEquals(2, list.size());

		searchBean.setPaymentType(PaymentType.UNKNOWN);
		list = studentService.searchStudent(searchBean);
		assertEquals(2, list.size());
	}

	@Test
	public void test_searchStudents_byGender() {
		// Given
		Student searchBean = new Student();
		searchBean.setSex("M");
		// When
		List<Student> list = studentService.searchStudent(searchBean);
		// Then
		assertEquals(16, list.size());

		searchBean.setSex("F");
		list = studentService.searchStudent(searchBean);
		assertEquals(4, list.size());
	}

	@Test
	public void test_insertStudent() {
		// Given
		Student student = createStudent();

		// When
		student = studentService.insert(student);
		Student studentDb = studentService.getStudent(student.getId());

		// Then
		assertEquals(studentDb, student);
	}

	@Test
	public void test_updateStudent() {
		// Given
		final Integer studentId = 22;

		// When
		Student student = studentService.getStudent(studentId);
		updateStudent(student);
		student = studentService.update(student);
		Student studentDb = studentService.getStudent(studentId);

		// Then
		assertEquals(studentDb, student);
	}

	@Test
	public void test_deleteStudent() {
		// Given
		final Integer studentId = 24;

		// When
		boolean deleting = studentService.deleteStudent(studentId);
		Student student = studentService.getStudent(studentId);

		// Then
		assertTrue(deleting);
		assertNull(student);
	}

	@Test
	public void test_deleteStudent_notPresent() {
		// Given
		final Integer studentId = -1;

		// When
		boolean deleting = studentService.deleteStudent(studentId);

		// Then
		assertFalse(deleting);
	}

	@Test
	public void test_student_integrationTest_CRUD() {
		// 1. insert a new student in DB
		Student student = createStudent();
		student = studentService.insert(student);
		assertNotNull(student.getId());

		// 2. get the student from DB
		Student studentDb = studentService.getStudent(student.getId());
		assertNotNull(studentDb);
		assertEquals(studentDb, student);

		// 3. Update the student in DB, and Get to check if updated correctly
		updateStudent(student);
		student = studentService.update(student);
		studentDb = studentService.getStudent(student.getId());
		assertEquals(studentDb, student);

		// 4. Delete the student from DB, and Get to check if deleted correctly
		boolean isRemoved = studentService.deleteStudent(student.getId());
		assertTrue(isRemoved);
		studentDb = studentService.getStudent(student.getId());
		assertNull(studentDb);
	}
}
