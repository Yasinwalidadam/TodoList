package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Students {

	@Id
	private Long id;
	private String Name;
	private String Prenom;
	private String number;
	private String email;
	private String fomation;
	
	public Students(){}
	
	public Students(String name, String prenom, String number, String email, String fomation) {
		super();
		Name = name;
		Prenom = prenom;
		this.number = number;
		this.email = email;
		this.fomation = fomation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFomation() {
		return fomation;
	}

	public void setFomation(String fomation) {
		this.fomation = fomation;
	}

	

	@Override
	public String toString() {
		return "Students [id=" + id + ", Name=" + Name + ", Prenom=" + Prenom + ", number=" + number + ", email="
				+ email + ", fomation=" + fomation + "]";
	}
	
	
	
	
}
