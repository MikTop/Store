package com.example.store.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.store.domain.User;





public interface UserRepo extends CrudRepository <User, Integer> {
	
	List<User> findByUsername (String username);
	
	User getByUsername (String username);

}
