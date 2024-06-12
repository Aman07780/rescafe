package com.springboot.web.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="userinfo")
public class Userinfo {

	    @Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Long id;
	 
		@NotEmpty(message = "Email may not be empty")
		@Email(message = "Email should be valid")
		private String email;
		@NotEmpty(message = "Password should not be empty")
		@Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters")
		@Column(name = "password")
		private String password;
	 
		@Column(name = "role")
		private String role;
	 
		@Column(name = "name")
		private String name;
	 
		@Column(name = "phone_number")
		private String phoneNumber;
	 
		public Long getId() {
			return id;
		}
	 
		public void setId(Long id) {
			this.id = id;
		}
	 
		public String getEmail() {
			return email;
		}
	 
		public void setEmail(String email) {
			this.email = email;
		}
	 
		public String getPassword() {
			return password;
		}
	 
		public void setPassword(String password) {
			this.password = password;
		}
	 
		public String getRole() {
			return role;
		}
	 
		public void setRole(String role) {
			this.role = role;
		}
	 
		public String getName() {
			return name;
		}
	 
		public void setName(String name) {
			this.name = name;
		}
	 
		public String getPhoneNumber() {
			return phoneNumber;
		}
	 
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
	 
		public Userinfo(Long id,
				@NotEmpty(message = "Email may not be empty") @Email(message = "Email should be valid") String email,
				@NotEmpty(message = "Password should not be empty") @Size(min = 8, max = 16, message = "Password must be between 8 and 16 characters") String password,
				String role, String name, String phoneNumber) {
			super();
			this.id = id;
			this.email = email;
			this.password = password;
			this.role = role;
			this.name = name;
			this.phoneNumber = phoneNumber;
		}
	 
		public Userinfo() {
			super();
			// TODO Auto-generated constructor stub
		}
}
