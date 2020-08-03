package com.example.store.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.store.repo.GoodsRepo;

@Controller
public class CatalogController {
	
	@Autowired
	private GoodsRepo goodsRepo; 
	
	@GetMapping("/catalog")
	public String catalog(Map<String, Object> model) {
		
		
		
		
		
		
		
		
		return "catalog";
	}

}
