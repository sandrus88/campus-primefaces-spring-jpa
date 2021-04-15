package org.sg.campus.bl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "STUDENT")
public class StudentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqStudent")
	@SequenceGenerator(name = "seqStudent", sequenceName = "SEQ_STUDENT", initialValue = 200, allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "SURNAME")
	private String surname;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "JOB_TITLE")
	private String jobTitle;
	@Column(name = "PAYMENT_TYPE")
	private String paymentType;
	@Column(name = "SEX")
	private String sex;

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

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof StudentEntity)) {
			return false;
		}
		StudentEntity other = (StudentEntity) o;
		if (id != null && !id.equals(other.id)) {
			return false;
		}
		if (name != null && !name.equals(other.name)) {
			return false;
		}
		if (surname != null && !surname.equals(other.surname)) {
			return false;
		}
		if (email != null && !email.equals(other.email)) {
			return false;
		}
		if (jobTitle != null && !jobTitle.equals(other.jobTitle)) {
			return false;
		}
		if (paymentType != null && !paymentType.equals(other.paymentType)) {
			return false;
		}
		if (sex != null && !sex.equals(other.sex)) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = id;
		result = result + ((name == null) ? 0 : name.hashCode());
		result = result + ((surname == null) ? 0 : surname.hashCode());
		result = result + ((email == null) ? 0 : email.hashCode());
		result = result + ((jobTitle == null) ? 0 : jobTitle.hashCode());
		result = result + ((paymentType == null) ? 0 : paymentType.hashCode());
		result = result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " [id: " + id + ", name: " + name + ", surname: " + surname + ", email: " + email + ", job title: " + jobTitle
				+ ", paymentType: " + paymentType + ", sex: " + sex + "]";
	}
}
