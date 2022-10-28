package com.qa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "Accounts")

public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private int id;
	
	
	@Column(name = "account_number")
	@NotNull
	@Pattern(regexp = "^[0-9]*", message = "Invalid account number. Account number can only contain digits.")
	@Size(min = 8, max = 8, message = "Invalid account number. Account number must be 8 Digits with no decimal spaces")
	private int accountNumber;
	
	
	@Column(name = "account_balance")
	@NotNull
	@Pattern(regexp = "^[0-9]*", message = "Invalid Balance. Account balance can only contain digits and decimal digits.")
	@Size(min = 0, max = 50, message = "Account Balance must be between 0 and 50 characters, and no more than 15 decimal digits")
	private double balance;
	
	
	@Column(name = "accountHolder_name")
	@NotNull
	@Pattern(regexp = "/^[a-z ,.'-]+$/i", message = "Invalid name. Names can only contain Letters(A-Z), and select special characters. Please enter a valid name.")
	@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters. ")
	private String accountHolder;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public long getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}


	public String getAccountHolder() {
		return accountHolder;
	}


	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	
	

}
