package com.IES.DTO;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class changePassDTO {

	@Column(name = "email", unique = true, nullable = false, length = 150)
	@Email(message = "Invalid email format")
	@NotBlank(message = "Email is required")
	private String email;
	
	@Column(name = "pwd", nullable = false)
    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String pwd;

	@Column(name = "pwd_updated")
	private String pwdUpdated;

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwdUpdated() {
		return pwdUpdated;
	}

	public void setPwdUpdated(String pwdUpdated) {
		this.pwdUpdated = pwdUpdated;
	}

	@Override
	public String toString() {
		return "changePassDTO [email=" + email + ", pwd=" + pwd + ", pwdUpdated=" + pwdUpdated + "]";
	}
	
	

}
