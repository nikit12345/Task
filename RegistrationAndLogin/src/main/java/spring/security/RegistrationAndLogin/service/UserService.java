package spring.security.RegistrationAndLogin.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import spring.security.RegistrationAndLogin.dto.UserRegistrationDto;
import spring.security.RegistrationAndLogin.model.User;

public interface UserService extends UserDetailsService{
	
	
	
	User save(UserRegistrationDto dto);
	

}
