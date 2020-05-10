package com.example.store.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.store.domain.User;
import com.example.store.repo.UserRepo;

@RequestMapping("/login")
@Controller
public class LoginController {

	@Autowired
	private UserRepo userRepo;
	
	@GetMapping
	public String view (){
		return "login";
	}
	
	
	@PostMapping
	public String Login (String userName, String password, Map<String, Object> model) {
		
		User user;
		
		if (userName != null && password != null) {
			
			user = userRepo.getByUsername(userName);
			if (user == null) {
				model.put("Error", "Пользователя не существует");
				return "login";
			}
			if (!user.getPassword().equals(password)) {
				model.put("Error", "Пароль не верный");
				return "login";
			}
			
			model.put("username", user.getUsername());
			model.put("Error", "1");
			
		}
		
		
		
		
		return "redirect:/index";
	}
	
}
