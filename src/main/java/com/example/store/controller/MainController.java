package com.example.store.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.store.domain.User;
import com.example.store.repo.UserRepo;

@Controller
public class MainController {
	
	@Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String greeting() {
            
        return "index";
    }

    @GetMapping("/aboutUs")
    public String main(Map<String, Object> model) {
        Iterable<User> users = userRepo.findAll();

        model.put("users", users);

        return "aboutUs";
    }

    @PostMapping("/aboutUs")
    public String add(@RequestParam String username, @RequestParam String email, @RequestParam String password, Model model) {
        User user = new User(username, email, password);

        userRepo.save(user);

        Iterable<User> users = userRepo.findAll();

        model.addAttribute("users", users);

        return "aboutUs";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String username, Model model) {
    	Iterable<User> users;

        if (username != null && !username.isEmpty()) {
            users = userRepo.findByUsername(username);
        } else {
            users = userRepo.findAll();
        }

        model.addAttribute("users", users);

        return "aboutUs";
    }

}
