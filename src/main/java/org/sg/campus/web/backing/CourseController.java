package org.sg.campus.web.backing;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.sg.campus.bl.domain.Course;
import org.sg.campus.bl.domain.Topic;
import org.sg.campus.bl.service.CourseService;
import org.sg.campus.web.beans.ApplicationBean;

@ManagedBean
@SessionScoped
public class CourseController {

	@ManagedProperty(value = "#{applicationBean}")
	private ApplicationBean applicationBean;

	@ManagedProperty(value = "#{courseService}")
	private CourseService courseService;

	private List<Course> courseList = new ArrayList<>();
	private Course selectedCourse;

	private List<Topic> allTopics = new ArrayList<>();

	private String newName;
	private String newDescription;
	private Boolean newEnabled;
	
	private Integer searchId;
	private String searchName;
	private Boolean searchEnabled;

	@PostConstruct
	public void init() {
		selectedCourse = new Course();
		searchCourse();
		cleanDialogForm();
		cleanSearchForm();
	}

	public void searchCourse() {
		Course searchDto = new Course(searchId, searchName, searchEnabled);
		courseList = courseService.searchCourse(searchDto);
	}

	public void cleanDialogForm() {
		newName = null;
		newDescription = null;
		newEnabled = null;
	}

	public void cleanSearchForm() {
		searchId = null;
		searchName = null;
		searchEnabled = null;
	}

	public void addCourse() {
		Course course = new Course();
		course.setId(applicationBean.getNextInt());
		course.setName(newName);
		course.setDescription(newDescription);
		course.setEnabled(newEnabled);
		courseService.insert(course);
		cleanDialogForm();
		searchCourse();
	}

	public void updateSelectedCourse(Course course) {
		selectedCourse = course;
		courseService.update(selectedCourse);
		searchCourse();
	}

	public void deleteCourse(Course course) {
		courseService.deleteCourse(course.getId());
		searchCourse();
	}

	public void updateCourseTopics(Course course) {
		selectedCourse = course;
		List<Topic> checkedTopics = courseService.getTopicsOfCourse(course);
		for (int i = 0; i < allTopics.size(); i++) {
			final Topic topic = allTopics.get(i);
//			if (topic.isChecked()) {
//				checkedTopics.add(topic);
//			}
		}
		course.setTopics(checkedTopics);
		courseService.update(course);
		System.out.println("Topics selected for course id" + selectedCourse.getId() + ": " + checkedTopics);
	}

	public void viewTopics(Course course) {
		selectedCourse = course;
		List<Topic> checkedTopics = courseService.getTopicsOfCourse(selectedCourse);
		for (int i = 0; i < allTopics.size(); i++) {
			final Topic topic = allTopics.get(i);
			if (checkedTopics.contains(topic)) {
//				topic.setChecked(true);
			}
		}
//		getAllTopics();
		System.out.println("viewTopics: " + selectedCourse);
	}

	public int topicsNumber(Course course) {
		selectedCourse = course;
		int topics = selectedCourse.getTopics().size();
		return topics;
	}

	public void cleanAllTopics() {
		for (int i = 0; i < allTopics.size(); i++) {
			final Topic topic = allTopics.get(i);
//			topic.setChecked(false);
		}
	}

	public List<Topic> getAllTopics() {
		return allTopics = courseService.getAllTopics();
	}

	public String getNewName() {
		return newName;
	}

	public void setNewName(String newName) {
		this.newName = newName;
	}

	public String getNewDescription() {
		return newDescription;
	}

	public void setNewDescription(String newDescription) {
		this.newDescription = newDescription;
	}

	public Boolean isNewEnabled() {
		return newEnabled;
	}

	public void setNewEnabled(Boolean newEnabled) {
		this.newEnabled = newEnabled;
	}

	public void setApplicationBean(ApplicationBean applicationBean) {
		this.applicationBean = applicationBean;
	}

	public ApplicationBean getApplicationBean() {
		return applicationBean;
	}

	public List<Course> getCourseList() {
		return courseList;
	}

	public Course getSelectedCourse() {
		return selectedCourse;
	}

	public void setCourseList(List<Course> courseList) {
		this.courseList = courseList;
	}

	public void setSelectedCourse(Course selectedCourse) {
		this.selectedCourse = selectedCourse;
	}

	public void setAllTopics(List<Topic> allTopics) {
		this.allTopics = allTopics;
	}

	public Integer getSearchId() {
		return searchId;
	}

	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}

	public Boolean getSearchEnabled() {
		return searchEnabled;
	}

	public void setSearchEnabled(Boolean searchEnabled) {
		this.searchEnabled = searchEnabled;
	}

	public Boolean getNewEnabled() {
		return newEnabled;
	}

	public CourseService getCourseService() {
		return courseService;
	}

	public void setCourseService(CourseService courseService) {
		this.courseService = courseService;
	}
}
