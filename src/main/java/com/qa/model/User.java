package com.qa.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.*;

import javax.validation.constraints.*;


@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity 
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	@Column(name = "user_email")
	@NotNull
	@Pattern(regexp = "	^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message = "Invalid email. Please enter a valid email.")
	@Size(min = 10, max = 30, message = "Email must be between 10 and 30 characters. ")
	private String email;
	
    @Column(name = "first_name")
    @NotNull
    @Pattern(regexp = "^[A-Za-z]*", message = "Invalid name. Names can only contain Letters(A-Z). Please enter a valid name.")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters. ")
	private String firstName;
    
    @Column(name = "last_name")
    @NotNull
    @Pattern(regexp = "^[A-Za-z]*", message = "Invalid name. Names can only contain Letters(A-Z). Please enter a valid name.")
    @Size(min = 2, max = 32, message = "Name must be between 2 and 32 characters. ")
	private String lastName;
    
    @Column(name = "user_password")
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9]*$", message = "Invalid password. Password can only contain Letters(A-Z) and Numbers(0-9). Please enter a valid Password.")
    @Size(min = 6, max = 32, message = "Password must be between 6 and 32 characters. ")
	private String password;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "Account_number")
	private int accountNumber;
	
	

	public User(String email, String firstName, String lastName, String password, int accountNumber) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.accountNumber = accountNumber;
	}

	public long getId() {
		return userId;
	}

	public void setId(int id) {
		this.userId = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Account getAccountHolder() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
