package com.qa.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import com.qa.dto.UserAccountDTO;
import com.qa.exception.PassNotFoundException;
import com.qa.exception.UserAlreadyExistsException;
import com.qa.exception.UserNotFoundException;
import com.qa.model.User;
import com.qa.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	ModelMapper modelMapper;

	@Override
	public List<User> getAllUsers() {
		
		return this.userRepository.findAll();
	}

	@Override
	public User getUserByID(int userId) throws UserNotFoundException {
		
		Optional<User> optionalUserFoundByID = userRepository.findById(userId);
		if (!optionalUserFoundByID.isPresent()) {
			throw new UserNotFoundException();
		}
		return optionalUserFoundByID.get();
		
	}

	@Override
	public List<User> getUserByFirstName(String firstName) {
		
		return this.userRepository.findByFirstName(firstName);
	}

	@Override
	public List<User> getUserByLastName(String lastName) {
		
		return this.userRepository.findByLastName(lastName);
	}

	@Override
	public List<User> getUserByFirstNameAndLastName(String firstName, String lastName) {
		
		return this.userRepository.findByFirstAndLastName(firstName, lastName);
	}

	@Override
	public List<User> getUserByEmail(String email) {
		
		return this.userRepository.findByEmail(email);
	}

	@Override
	public List<User> getUserByAccountNumber(int accountNumber) {
		
		return this.userRepository.findByAccountNumber(accountNumber);
	}

	@Override
	public User addUser(User user) throws UserAlreadyExistsException {
		
		Optional<User> optionalUserFoundByID = this.userRepository.findByUserId(userId);
		
		
		if (!optionalUserFoundByID.isPresent()) {
			throw new UserAlreadyExistsException();
		}
		
		return this.userRepository.save(user);
	}

	@Override
	public User updateUserDetails(int userId, String email, String firstName, String secondName, String password,
			int accountNumber) throws UserNotFoundException {
		
		User updatedUser = null;
		
		Optional<User> optionalUserFoundByID = this.userRepository.findById(userId);
		
		if (!optionalUserFoundByID.isPresent()) {
			throw new UserNotFoundException();
		}
		else {
			int rows = this.userRepository.updateUserDetails(userId, firstName, firstName, email, password);
			if (rows > 0) {
				updatedUser = this.userRepository.findById(userId).get();
			}
		}
		return updatedUser;
	}

	@Override
	public User updateAccountNumber(int userId, int accountNumber) throws UserNotFoundException {
		
		User updatedUser = null;
		
		Optional<User> optionalUserFoundByID = this.userRepository.findById(userId);
		
		if (!optionalUserFoundByID.isPresent()) {
			throw new UserNotFoundException();
		}
		else {
			int rows = this.userRepository.updateUserAccountNumber(userId, accountNumber);
			if (rows > 0) {
				updatedUser = this.userRepository.findById(userId).get();
			}
			
		}
		
		return updatedUser;
				
				
	}

	@Override
	public List<User> getAllUserAccountDtos() {
		
		List<User> userList = this.userRepository.findAll();
		List<UserAccountDTO> userDTOList = new ArrayList<>();
		
		userList.forEach(user -> {UserAccountDto userAccountDto = UserDto.builder().id(user.
		}
		
		return null;
	}

	@Override
	public boolean deleteUser(int id) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserAccountDTO login(int id, String password) throws UserNotFoundException, PassNotFoundException {
		User user;
		Optional<User> userFoundByIDOptional = this.userRepository.findById(id);
		
		if (!userFoundByIDOptional.isPresent()) {
			throw new UserNotFoundException();
		}else {
			user = userFoundByIDOptional.get();
			if(user.getId() == id && user.getPassword().equals(password)) {
				System.out.println("Logged in.");
			}else {
				throw new PassNotFoundException();
			}
		}
		return mapToUserAccountDto(user);
	}
	

}
