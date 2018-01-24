package com.example.pojo;

/**
 * @author olena.viliuzhanina
 *
 */
public class Employee {

	private Long id;
	private String name;
	private String email;
	private String department;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String toString() {
		return "Employee [name=" + name + ", email=" + ", department" + department;		
	}
}
