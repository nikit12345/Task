package com.example.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.AuthenticationRequest;
import com.example.services.AuthService;

@RestController
@RequestMapping("signup")
public class SignUpController {
	
	@Autowired
	private AuthService authService;

	@Autowired
	public SignUpController(AuthService authService) {
		super();
		this.authService = authService;
	}
	

	@PostMapping
	public ResponseEntity<String> signUpUser(@RequestBody AuthenticationRequest request) {
	    boolean isUserCreated = authService.createUser(request);
	    if (isUserCreated) {
	        return ResponseEntity.status(HttpStatus.CREATED).body("successfully");
	    } else {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed");
	    }
	}


}
