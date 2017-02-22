package com.dante.entity;

public class User extends IdEntity {

	private String name;
	private String age;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String toString() {
		return "User [name=" + name + ", age=" + age + ", email=" + email + ", id=" + id + "]";
	}

}
