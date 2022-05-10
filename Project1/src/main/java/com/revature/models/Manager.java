package com.revature.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="managers")
public class Manager {

	@Id
	@Column(name="manager_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int managerId;
	
	@Column(name="user_name", unique=true, nullable=false)
	private String userName;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="first_name", nullable=false)
	private String firstName;
	
	@Column(name="last_name", nullable=false)
	private String lastName;
	
	@Column(name="email", unique=true, nullable=false)
	private String email;

	public Manager() {
		super();
	}

	public Manager(String userName, String password, String firstName, String lastName, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Manager(int employeeId, String userName, String password, String firstName, String lastName, String email) {
		super();
		this.managerId = employeeId;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public int getEmployeeId() {
		return managerId;
	}

	public void setEmployeeId(int employeeId) {
		this.managerId = employeeId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Manager [employeeId=" + managerId + ", userName=" + userName + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, managerId, firstName, lastName, password, userName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manager other = (Manager) obj;
		return Objects.equals(email, other.email) && managerId == other.managerId
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(password, other.password) && Objects.equals(userName, other.userName);
	}
	
	
}
