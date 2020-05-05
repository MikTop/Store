package com.example.store.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.store.domain.User;
import com.example.store.repo.UserRepo;

@Controller
public class MainController {
	
	@Autowired
    private UserRepo userRepo;

    @GetMapping("/greeting")
    public String greeting(
            @RequestParam(name="username", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        model.put("username", name);
        return "greeting";
    }

    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<User> users = userRepo.findAll();

        model.put("users", users);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String username, @RequestParam String email, @RequestParam String password, Map <String, Object> model) {
        User user = new User(username, email, password);

        userRepo.save(user);

        Iterable<User> users = userRepo.findAll();

        model.put("users", users);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String username, Map<String, Object> model) {
    	Iterable<User> users;

        if (username != null && !username.isEmpty()) {
            users = userRepo.findByUsername(username);
        } else {
            users = userRepo.findAll();
        }

        model.put("users", users);

        return "main";
    }

}
