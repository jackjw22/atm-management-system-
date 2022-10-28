package com.qa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qa.dto.UserAccountDTO;
import com.qa.exception.PassNotFoundException;
import com.qa.exception.UserAlreadyExistsException;
import com.qa.exception.UserNotFoundException;
import com.qa.model.User;
import com.qa.repository.UserRepository;

@Service
public interface UserService {
	
	public List<User> getAllUsers();
	public User getUserByID(int userId) throws UserNotFoundException;
	public List<User> getUserByFirstName(String firstName);
	public List<User> getUserByLastName(String lastName);
	public List<User> getUserByFirstNameAndLastName(String firstName, String lastName);
	public List<User> getUserByEmail(String email);
	public List<User> getUserByAccountNumber(int accountNumber);
	public User addUser(User user) throws UserAlreadyExistsException;
	public User updateUserDetails(int userId, String email, String firstName, String secondName, String password, int accountNumber) throws UserNotFoundException;
	public User updateAccountNumber(int id, int accountNumber) throws UserNotFoundException;
	public List<User> getAllUserAccountDtos();
	public boolean deleteUser(int id) throws UserNotFoundException;
	public UserAccountDTO login(int id, String password) throws UserNotFoundException, PassNotFoundException;
	
	
	
	
}
	
	
		
		
	
	


