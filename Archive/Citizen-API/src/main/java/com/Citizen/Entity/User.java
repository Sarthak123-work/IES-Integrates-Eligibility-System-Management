package com.Citizen.Entity;

import java.time.LocalDateTime;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.Citizen.Enums.Role;
import com.IES.Security.CustomerUserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;



@Entity
@Slf4j
@Table(name = "user")
public class User implements CustomerUserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "name", nullable = false, length = 100)
	@NotBlank(message = "Name is required")
	@Size(min = 2, max = 100, message = "Name must be 2-100 characters")
	private String name;

	@Column(name = "email", unique = true, nullable = false, length = 150)
	@Email(message = "Invalid email format")
	@NotBlank(message = "Email is required")
	private String email;

	@Column(name = "phno")
	@NotNull(message = "Phone number required")
	@Digits(integer = 10, fraction = 0, message = "Phone number must be 10 digits")
	private Long phno;

	@Column(name = "pwd", nullable = false)
	@NotBlank(message = "Password is required")
	@Size(min = 6, message = "Password must be at least 6 characters")
	private String pwd;

	@Column(name = "pwd_updated")
	private String pwdUpdated;

	@Enumerated(EnumType.STRING)
	@NotNull(message = "Role is required")
	@Column(name = "role", nullable = false, length = 20)
	private Role role;

	@CreationTimestamp
	@Column(name = "created_date", updatable = false)
	private LocalDateTime createdDate;

	@UpdateTimestamp
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	public Collection<? extends GrantedAuthority> getAuthorities() {
		log.debug("getAuthorities()");
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.name().toString());
		return Collections.singletonList(authority);
	}

	public boolean isAccountNonExpired() {
		log.debug("isAccountNonExpired()");
		return true;
	}

	public boolean isAccountNonLocked() {
		log.debug("isAccountNonLocked()");
		return true;
	}


	public boolean isCredentialsNonExpired() {
		log.debug("isCredentialsNonExpired()");
		return true;
	}


	public boolean isEnabled() {
		log.debug("isEnabled()");
		return true;
	}

	
	public String getPassword() {
		return this.pwd;
	}

	@Override
	public String getUsername() {
	    return this.email;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Long getPhno() {
		return phno;
	}

	public void setPhno(Long phno) {
		this.phno = phno;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwdUpdated() {
		return pwdUpdated;
	}

	public void setPwdUpdated(String pwdUpdated) {
		this.pwdUpdated = pwdUpdated;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public static org.slf4j.Logger getLog() {
		return log;
	}

}
