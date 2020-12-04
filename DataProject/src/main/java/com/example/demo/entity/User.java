package com.example.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String name;
	@Column
	private String mail;
	@Column
	private String password;

	@OneToMany(mappedBy = "user")
	private List<Travel> travels;

	public User(String name, String mail, String password) {
		super();
		this.name = name;
		this.mail = mail;
		this.password = password;
	}

	public User() {

	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
