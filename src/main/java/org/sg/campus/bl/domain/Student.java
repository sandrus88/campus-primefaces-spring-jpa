package org.sg.campus.bl.domain;

public class Student {

	public static final String SEX_M = "M";
	public static final String SEX_F = "F";

	private Integer id;
	private String name;
	private String surname;
	private String email;
	private String jobTitle;
	private PaymentType paymentType;
	private String sex;

	public Student() {

	}

	public Student(String name, String surname, String email, String jobTitle, PaymentType paymentType, String sex) {
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.jobTitle = jobTitle;
		this.paymentType = paymentType;
		this.sex = sex;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public String getSex() {
		return sex;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null) {
			return false;
		}
		if (!(o instanceof Student)) {
			return false;
		}
		Student other = (Student) o;
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
		return this.getClass().getSimpleName() + " [id: " + id + ", name: " + name + ", surname: " + surname
				+ ", email: " + email + ", job title: " + jobTitle + ", paymentType: " + paymentType + ", sex: " + sex
				+ "]";
	}
}
