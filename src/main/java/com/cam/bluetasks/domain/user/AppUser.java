package com.cam.bluetasks.domain.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "app_user")
public class AppUser {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@NotEmpty(message = "O nome de usuário é obrigatório")
	private String userName;
	
	@NotEmpty(message = "A senha de usuário é obrigatório")
	private String password;
	
	@NotEmpty(message = "O nome de exibição é obrigatório")
	private String displayName;

	public AppUser() {
	}

	public AppUser(String userName, String password, String displayName) {
		this.userName = userName;
		this.password = password;
		this.displayName = displayName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	

}
