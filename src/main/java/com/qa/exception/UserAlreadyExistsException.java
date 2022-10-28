package com.qa.exception;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "User with this ID already exists")
public class UserAlreadyExistsException extends Exception {
	

}
