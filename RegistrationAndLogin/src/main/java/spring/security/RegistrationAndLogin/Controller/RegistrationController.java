package spring.security.RegistrationAndLogin.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.security.RegistrationAndLogin.dto.UserRegistrationDto;
import spring.security.RegistrationAndLogin.service.UserService;
import spring.security.RegistrationAndLogin.service.UserServiceImpl;


@RestController
@RequestMapping("/registration")
public class RegistrationController {
	
	private UserServiceImpl service;

	public RegistrationController(UserService service) {
		super();
		this.service = (UserServiceImpl) service;
	}
	
	@ModelAttribute("user")
	public UserRegistrationDto userRegistrationDto() {
		return new UserRegistrationDto();
	}
	
	@GetMapping
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new UserRegistrationDto());
		return "registration";
	}
	
	@PostMapping("/save")
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDto dto) {
		 service.save(dto);
		 return "redirect:/registration?success";
		
	}

}
