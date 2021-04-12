package org.sg.campus.web.backing;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.sg.campus.bl.service.StudentService;
import org.sg.campus.web.beans.ApplicationBean;
import org.sg.campus.web.domain.PaymentType;
import org.sg.campus.web.domain.Student;

@ManagedBean
@SessionScoped
public class StudentController {

	@ManagedProperty(value = "#{applicationBean}")
	private ApplicationBean applicationBean;

	@ManagedProperty(value = "#{studentService}")
	private StudentService studentService;

	private String newName;
	private String newSurname;
	private String newEmail;
	private String newJobTitle;
	private PaymentType newPaymentType;
	private String newSex;

	private String searchName;
	private String searchSurname;
	private String searchEmail;
	private String searchJobTitle;
	private PaymentType searchPaymentType;
	private String searchSex;

	private List<Student> studentList = new ArrayList<>();
	private Student selectedStudent;

	@PostConstruct
	public void init() {
		selectedStudent = new Student();
		searchStudent();
		cleanDialogForm();
		cleanSearchForm();
	}

	public void addStudent() {
		Student student = new Student();
		student.setId(applicationBean.getNextInt());
		student.setName(newName);
		student.setSurname(newSurname);
		student.setEmail(newEmail);
		student.setJobTitle(newJobTitle);
		student.setPaymentType(newPaymentType);
		student.setSex(newSex);

		System.out.println("Added student: " + student);
		cleanDialogForm();
	}

	public void searchStudent() {
		Student searchDto = new Student(searchName, searchSurname, searchEmail, searchJobTitle, searchPaymentType, searchSex);
		studentList = studentService.searchStudent(searchDto);studentList = studentService.searchStudent(searchDto);
	}

	public void cleanDialogForm() {
		newName = null;
		newSurname = null;
		newEmail = null;
		newJobTitle = null;
		newPaymentType = null;
		newSex = null;
	}

	public void cleanSearchForm() {
		searchName = null;
		searchSurname = null;
		searchEmail = null;
		searchJobTitle = null;
		searchPaymentType = null;
		searchSex = null;
	}

	public String reset() {
		cleanDialogForm();
		return "/app/student/homeStudent.xhtml?faces-redirect=true";
	}

	public String backHome() {
		cleanDialogForm();
		return "/index.xhtml?faces-redirect=true";
	}

	public PaymentType[] getEnumValues() {
		PaymentType[] values = PaymentType.values();
		return values;
	}

	public String showPaymentType(PaymentType paymentType) {
		Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		ResourceBundle bundle = ResourceBundle.getBundle("messages.messages", locale);
		String label = "";
		if (paymentType != null) {
			label = bundle.getString("student.paymentType." + paymentType);
		}
		return label;
	}

	public void updateSelectedStudent(Student student) {
		selectedStudent = student;
		System.out.println("Going in edit mode for student: " + selectedStudent);
//		return "/app/student/editStudent.xhtml?faces-redirect=true";
	}

	public String updateStudent() {
		cleanDialogForm();
		System.out.println("Updated student: " + selectedStudent);
		return "/app/student/homeStudent.xhtml?faces-redirect=true";
	}

	public String viewStudent(Student student) {
		selectedStudent = student;
		System.out.println("View student: " + selectedStudent);
		return "/app/student/viewStudent.xhtml?faces-redirect=true";
	}

	public void deleteStudent(Student student) {
		studentList.remove(student);
		System.out.println("Deleted student: " + selectedStudent.getId());
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public void setNewSurname(String newSurname) {
		this.newSurname = newSurname;
	}

	public void setNewJobTitle(String newJobTitle) {
		this.newJobTitle = newJobTitle;
	}

	public void setNewSex(String newSex) {
		this.newSex = newSex;
	}

	public String getNewName() {
		return newName;
	}

	public String getNewSurname() {
		return newSurname;
	}

	public String getNewJobTitle() {
		return newJobTitle;
	}

	public String getNewSex() {
		return newSex;
	}

	public String getNewEmail() {
		return newEmail;
	}

	public void setNewEmail(String newEmail) {
		this.newEmail = newEmail;
	}

	public ApplicationBean getApplicationBean() {
		return applicationBean;
	}

	public void setApplicationBean(ApplicationBean applicationBean) {
		this.applicationBean = applicationBean;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	public void setSelectedStudent(Student selectedStudent) {
		this.selectedStudent = selectedStudent;
	}

	public Student getSelectedStudent() {
		return selectedStudent;
	}

	public PaymentType getNewPaymentType() {
		return newPaymentType;
	}

	public void setNewPaymentType(PaymentType newPaymentType) {
		this.newPaymentType = newPaymentType;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public String getSearchSurname() {
		return searchSurname;
	}

	public void setSearchSurname(String searchSurname) {
		this.searchSurname = searchSurname;
	}

	public String getSearchEmail() {
		return searchEmail;
	}

	public void setSearchEmail(String searchEmail) {
		this.searchEmail = searchEmail;
	}

	public String getSearchJobTitle() {
		return searchJobTitle;
	}

	public void setSearchJobTitle(String searchJobTitle) {
		this.searchJobTitle = searchJobTitle;
	}

	public PaymentType getSearchPaymentType() {
		return searchPaymentType;
	}

	public void setSearchPaymentType(PaymentType searchPaymentType) {
		this.searchPaymentType = searchPaymentType;
	}

	public String getSearchSex() {
		return searchSex;
	}

	public void setSearchSex(String searchSex) {
		this.searchSex = searchSex;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
}
