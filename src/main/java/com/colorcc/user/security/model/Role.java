package com.colorcc.user.security.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Role {

	private int id;
	private String role;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
