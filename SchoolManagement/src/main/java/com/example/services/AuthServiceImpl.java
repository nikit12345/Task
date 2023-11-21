package com.example.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.AuthenticationRequest;
import com.example.entity.User;
import com.example.repository.UserRepo;

@Service
public class AuthServiceImpl implements AuthService{
	
	@Autowired
	private UserRepo repo;
	
	private PasswordEncoder passwordEncoder;
	
	
	@Autowired
	public AuthServiceImpl(UserRepo repo, PasswordEncoder passwordEncoder) {
		super();
		this.repo = repo;
		this.passwordEncoder = passwordEncoder;
	}



	public boolean createUser(AuthenticationRequest request) {
		if(repo.existsByEmail(request.getEmail())) {
		return false;
	}
		User user = new User();
		BeanUtils.copyProperties(request, user);
		String encodePassword  = passwordEncoder.encode(request.getPassword());
		user.setPassword(encodePassword);
		repo.save(user);
		return true;
	}

}
