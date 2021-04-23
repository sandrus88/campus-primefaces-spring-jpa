package org.sg.campus.bl.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
public class CourseEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCourse")
	@SequenceGenerator(name="seqCourse", sequenceName = "SEQ_COURSE", initialValue = 200, allocationSize = 1)
    @Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "ACTIVE")
	private int enable;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "COURSE_ID")
	private List<TopicEntity> topics;

	public CourseEntity(){
		topics = new ArrayList<>();
	}
	
	public void addTopic(TopicEntity topicEntity) {
		topics.add(topicEntity);
	}
	
	public void removeTopic(TopicEntity topicEntity) {
		topics.remove(topicEntity);
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

	public int getEnable() {
		return enable;
	}

	public void setEnable(int enable) {
		this.enable = enable;
	}

	public void setTopics(List<TopicEntity> topics) {
		this.topics = topics;
	}

	public List<TopicEntity> getTopics() {
		return topics;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof CourseEntity)) {
			return false;
		}
		CourseEntity other = (CourseEntity) o;
		if (id != null && !id.equals(other.id)) {
			return false;
		}
		if (name != null && !name.equals(other.name)) {
			return false;
		}
		if (description != null && !description.equals(other.description)) {
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
		result = result + ((topics == null) ? 0 : topics.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id: " + id + ", name: " + name + ", description: " + description + ", enable: " + enable +
				", topics: " + topics + "]";
	}
}
