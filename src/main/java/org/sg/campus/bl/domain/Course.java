package org.sg.campus.bl.domain;

import java.util.ArrayList;
import java.util.List;

public class Course {
	private Integer id;
	private String name;
	private String description;
	private Boolean enabled;
	private List<Topic> topics = new ArrayList<>();

	public Course() {

	}

	public Course(Integer id, String name, Boolean enabled) {
		this.id = id;
		this.name = name;
		this.enabled = enabled;
	}

	public void addTopic(Topic topic) {
		topics.add(topic);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof Course)) {
			return false;
		}
		Course other = (Course) o;
		if (id != null && !id.equals(other.id)) {
			return false;
		}
		if (name != null && !name.equals(other.name)) {
			return false;
		}
		if (description != null && !description.equals(other.description)) {
			return false;
		}
		if (enabled != null && !enabled.equals(other.enabled)) {
			return false;
		}
		if (topics != null && !topics.equals(other.topics)) {
			return false;
		}
		return true;
	}
	
	@Override
	public int hashCode() {
		int result = id;
		result = result + ((name == null) ? 0 : name.hashCode());
		result = result + ((description == null) ? 0 : description.hashCode());
		result = result + ((enabled == null) ? 0 : enabled.hashCode());
		result = result + ((topics == null) ? 0 : topics.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id: " + id + ", name: " + name + ", description: " + description
				+ ", enabled: " + enabled + ", topics: " + topics + "]";
	}
}
