package com.register.user.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.register.user.error.ResourceEmailAlreadyRegisteredException;
import com.register.user.model.User;
import com.register.user.repository.UserRepository;

@RestController
@RequestMapping("users")
public class UserController {

	private final UserRepository userDAO; 
	
	@Autowired
	public  UserController(UserRepository userDAO) {
		this.userDAO = userDAO;
	}
	
	
	@GetMapping
	public ResponseEntity<?> listAll(Pageable pageable){
		return new ResponseEntity<>(userDAO.findAll(pageable),HttpStatus.OK); 
	}
	
	@PostMapping
	public ResponseEntity<?> save(@Valid @RequestBody User user){
		verifyIfEmailExists(user.getEmail());
		return new ResponseEntity<>(userDAO.save(user),HttpStatus.OK);
	}

	
	private void verifyIfEmailExists(String email){
		if (!userDAO.findByEmailIgnoreCaseContaining(email).isEmpty()) {
			throw new ResourceEmailAlreadyRegisteredException("E-mail já existente"); 
		}
	}
}
