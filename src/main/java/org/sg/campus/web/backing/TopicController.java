package org.sg.campus.web.backing;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import org.sg.campus.bl.domain.Course;
import org.sg.campus.bl.domain.Topic;
import org.sg.campus.bl.service.TopicService;
import org.sg.campus.web.beans.ApplicationBean;
import org.sg.campus.web.util.SGUtil;

@ManagedBean
@SessionScoped
public class TopicController {

	@ManagedProperty(value = "#{applicationBean}")
	private ApplicationBean applicationBean;
	
	@ManagedProperty(value = "#{topicService}")
	private TopicService topicService;
	
	private List<Topic> topicList = new ArrayList<Topic>();
	private Topic selectedTopic;

	private String newName;
	private String newDescription;
	
	private Integer searchId;
	private String searchName;

	@PostConstruct
	public void init() {
		selectedTopic = new Topic();
		searchTopic();
		cleanDialogForm();
		cleanSearchForm();
	}
	
	public void searchTopic() {
		Topic searchDto = new Topic(searchId, searchName);
		topicList = topicService.searchTopic(searchDto);
	}

	public void cleanDialogForm() {
		newName = null;
		newDescription = null;
	}

	public void cleanSearchForm() {
		searchId = null;
		searchName = null;
	}

	public void addTopic() {
		Topic topic = new Topic();
		topic.setId(applicationBean.getNextInt());
		topic.setName(newName);
		topic.setDescription(newDescription);
		topicService.insert(topic);
		cleanDialogForm();
		searchTopic();
	}
	
	public void updateSelectedTopic(Topic topic) {
		selectedTopic = topic;
		topicService.update(selectedTopic);
		searchTopic();
	}

	public void deleteTopic(Topic topic) {
		topicService.deleteTopic(topic.getId());
		searchTopic();
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

	public ApplicationBean getApplicationBean() {
		return applicationBean;
	}

	public void setApplicationBean(ApplicationBean applicationBean) {
		this.applicationBean = applicationBean;
	}

	public List<Topic> getTopicList() {
		return topicList;
	}

	public Topic getSelectedTopic() {
		return selectedTopic;
	}

	public void setTopicList(List<Topic> topicList) {
		this.topicList = topicList;
	}

	public void setSelectedTopic(Topic selectedTopic) {
		this.selectedTopic = selectedTopic;
	}

	public String getSearchName() {
		return searchName;
	}

	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	
	public Integer getSearchId() {
		return searchId;
	}

	public void setSearchId(Integer searchId) {
		this.searchId = searchId;
	}

	public TopicService getTopicService() {
		return topicService;
	}

	public void setTopicService(TopicService topicService) {
		this.topicService = topicService;
	}
}
