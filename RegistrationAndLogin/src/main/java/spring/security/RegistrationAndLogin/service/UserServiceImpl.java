package spring.security.RegistrationAndLogin.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import spring.security.RegistrationAndLogin.dto.UserRegistrationDto;
import spring.security.RegistrationAndLogin.model.Role;
import spring.security.RegistrationAndLogin.model.User;
import spring.security.RegistrationAndLogin.repo.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository repo;
	
	
	public UserServiceImpl(UserRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public User save(UserRegistrationDto dto) {
		User user = new User(dto.getFirstname(), 
				             dto.getLastname(),
				              dto.getEmail(),
				              dto.getPassword(),Arrays.asList(new Role("USER")));
		
		return repo.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
