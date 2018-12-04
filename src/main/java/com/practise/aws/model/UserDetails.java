package com.practise.aws.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class UserDetails {

	 @Id
	private String id;
	private String firstName;
	private String email;
	private String password;
	
	
		public UserDetails() {
	}

	public UserDetails(String id, String firstName, String email, String password) {
		this.id = id;
		this.firstName = firstName;
		this.email = email;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getemail() {
		return email;
	}

	public void setemail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return String.format("Customer[id=%s, firstName='%s', email='%s']", id, firstName, email);
	}
}