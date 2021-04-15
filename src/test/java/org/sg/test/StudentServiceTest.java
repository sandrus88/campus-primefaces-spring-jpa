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
		// Given
		final Integer[] studentsId = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30 };

		// When
		List<Student> students = studentService.getAllStudents();

		// Then
		assertNotNull(students);
		assertEquals(students.size(), 20);
		assertEquals(students.get(0).getId(), studentsId[0]);
		assertEquals(students.get(19).getId(), studentsId[19]);
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
		List<Student> list = studentService.searchStudent(searchBean);

		// Then
		assertEquals(20, list.size());
	}

	@Test
	public void test_searchStudents_correctData() {
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
	public void test_searchStudents_modifiedData() {
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
		searchBean.setName("Student");

		// When
		List<Student> list = studentService.searchStudent(searchBean);

		// Then
		assertEquals(12, list.size());
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
		searchBean.setEmail(null);

		// When
		List<Student> list = studentService.searchStudent(searchBean);

		// Then
		assertEquals(15, list.size());
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
	public void test_searchStudents_byPaymentType_OK() {
		// Given
		Student searchBean = new Student();
		searchBean.setPaymentType(PaymentType.OK);

		// When
		List<Student> list = studentService.searchStudent(searchBean);

		// Then
		assertEquals(16, list.size());
	}

	@Test
	public void test_searchStudents_byPaymentType_NOTOK() {
		// Given
		Student searchBean = new Student();
		searchBean.setPaymentType(PaymentType.NOTOK);

		// When
		List<Student> list = studentService.searchStudent(searchBean);

		// Then
		assertEquals(2, list.size());
	}

	@Test
	public void test_searchStudents_byPaymentType_UNKNOWN() {
		// Given
		Student searchBean = new Student();
		searchBean.setPaymentType(PaymentType.UNKNOWN);

		// When
		List<Student> list = studentService.searchStudent(searchBean);

		// Then
		assertEquals(2, list.size());
	}

	@Test
	public void test_searchStudents_byGenderMale() {
		// Given
		Student searchBean = new Student();
		searchBean.setSex("M");

		// When
		List<Student> list = studentService.searchStudent(searchBean);

		// Then
		assertEquals(16, list.size());
	}

	@Test
	public void test_searchStudents_byGenderFemale() {
		// Given
		Student searchBean = new Student();
		searchBean.setSex("F");

		// When
		List<Student> list = studentService.searchStudent(searchBean);

		// Then
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
