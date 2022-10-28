package com.qa.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.model.User;

@Repository
@Transactional

public interface UserRepository extends JpaRepository<User, Integer> {
	
	
	//find user by first name
	List<User> findByFirstName(String firstName);
	
	//find user by last name
	List<User> findByLastName(String lastName);
	
	//find by first and last name 
	List<User> findByFirstAndLastName(String firstName, String lastName);
	
	//find user by email
	List<User> findByEmail(String email);
	
	//find user by account number
	List<User> findByAccountNumber(int accountNumber);
	
	//find user by id 
	List<User> findByUserId(Integer userId);
	
	//update user details 
	@Modifying
	@Query("update User c set c.firstName = :firstName, c.lastName = :lastName, c.email = :email, c.password = :password where c.userId = :userID")
	int updateUserDetails(int id, String firstName, String lastName, String email, String password);
	
	//update account number
	@Modifying
	@Query("update User c set c.accountNumber = :accountNumber where c.userId = :userID")
	int updateUserAccountNumber(int id, int accountNumber);
	
	
	
	
	
	
	

}
