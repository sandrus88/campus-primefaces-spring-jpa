package org.sg.campus.bl.entities;

import javax.persistence.*;

@Entity
@Table(name = "TOPIC")
public class TopicEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqTopic")
	@SequenceGenerator(name = "seqTopic", sequenceName = "SEQ_TOPIC", initialValue = 200, allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "COURSE_ID")
	private Integer courseId;

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "COURSE_ID")
//	private CourseEntity courseEntity;

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

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof TopicEntity)) {
			return false;
		}
		TopicEntity other = (TopicEntity) o;
		if (id != null && !id.equals(other.id)) {
			return false;
		}
		if (name != null && !name.equals(other.name)) {
			return false;
		}
		if (description != null && !description.equals(other.description)) {
			return false;
		}
		if (courseId != null && !courseId.equals(other.courseId)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = result + ((name == null) ? 0 : name.hashCode());
		result = result + ((description == null) ? 0 : description.hashCode());
		result = result + ((courseId == null) ? 0 : courseId.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id: " + id + ", name: " + name + ", description: " + description
				+ ", courseId: " + courseId + "]";
	}
}