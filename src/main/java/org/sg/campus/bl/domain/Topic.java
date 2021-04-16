package org.sg.campus.bl.domain;

public class Topic {
	private Integer id;
	private String name;
	private String description;

	private Integer courseId;
	
	public Topic(){
	}

    public Topic(Integer id, String name) {
		this();
    	this.id = id;
    	this.name = name;
    }

    public Topic(Integer id, String name, String description, Integer courseId) {
		this(id, name);
		this.description = description;
		this.courseId = courseId;
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
		if (!(o instanceof Topic)) {
			return false;
		}
		Topic other = (Topic) o;
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
		return this.getClass().getSimpleName() + " [id: " + id + ", name: " + name + ", description: " + description + ", courseId: " + courseId + "]";
	}
}
